package com.helix.gpo.testimonials_service.service.impl;

import com.helix.gpo.testimonials_service.client.AwsClient;
import com.helix.gpo.testimonials_service.client.CompanyClient;
import com.helix.gpo.testimonials_service.client.ProjectClient;
import com.helix.gpo.testimonials_service.entity.Testimonial;
import com.helix.gpo.testimonials_service.exception.types.InvalidAuthTokenException;
import com.helix.gpo.testimonials_service.exception.types.TestimonialAlreadyExistsException;
import com.helix.gpo.testimonials_service.payload.TestimonialDtoResponse;
import com.helix.gpo.testimonials_service.payload.WebsiteTestimonialRequest;
import com.helix.gpo.testimonials_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.testimonials_service.repository.TestimonialRepository;
import com.helix.gpo.testimonials_service.service.WebsiteTestimonialService;
import com.helix.gpo.testimonials_service.util.TestimonialMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WebsiteTestimonialServiceImpl implements WebsiteTestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final ProjectClient projectClient;
    private final CompanyClient companyClient;
    private final AwsClient awsClient;

    @Value("${aws.bucket}")
    private String awsBucket;

    @Transactional
    @Override
    public TestimonialDtoResponse addTestimonial(WebsiteTestimonialRequest websiteTestimonialRequest, MultipartFile image) {
        String authTokenValue = websiteTestimonialRequest.getAuthTokenValue();

        validateRequestAuthToken(authTokenValue);
        checkIfTestimonialAlreadyExistsForProject(authTokenValue);

        String imageUrl = "";
        Long projectId = companyClient.getProjectIdByAuthTokenValue(authTokenValue);

        if (image != null) {
            imageUrl = saveTestimonialImage(image, projectId);
        }

        Testimonial testimonial = TestimonialMapper.mapToTestimonial(websiteTestimonialRequest.getTestimonialDtoRequest(), imageUrl);
        testimonial.setContentType(image == null ?  null : image.getContentType());
        testimonial.setProjectId(projectId);
        testimonial.setCreationDate(LocalDate.now());
        testimonial.setLastUpdate(LocalDate.now());
        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        String newImageUrl = savedTestimonial.getImageUrl().isEmpty()
                ? savedTestimonial.getImageUrl()
                : getPresignedUrl(savedTestimonial.getImageUrl(), savedTestimonial.getContentType());
        TestimonialDtoResponse finalTestimonial = TestimonialMapper.mapToTestimonialDto(savedTestimonial, newImageUrl);
        WebsiteProjectDto websiteProjectDto = getWebsiteProjectFromProjectService(savedTestimonial.getProjectId());
        finalTestimonial.setWebsiteProjectDto(websiteProjectDto);

        invalidateAuthToken(websiteTestimonialRequest.getAuthTokenValue());

        return finalTestimonial;
    }

    private void validateRequestAuthToken(String authTokenValue) {
        if (!companyClient.validateAuthToken(authTokenValue)) {
            throw new InvalidAuthTokenException("Invalid auth token!");
        }
    }

    private void checkIfTestimonialAlreadyExistsForProject(String authTokenValue) {
        Long projectId = companyClient.getProjectIdByAuthTokenValue(authTokenValue);
        Optional<Testimonial> optionalTestimonial = testimonialRepository.findByProjectId(projectId);
        if (optionalTestimonial.isPresent()) {
            throw new TestimonialAlreadyExistsException(projectId);
        }
    }

    private void invalidateAuthToken(String authTokenValue) {
        if (!companyClient.invalidateAuthToken(authTokenValue)) {
            throw new InvalidAuthTokenException("Invalidating token was not successful!");
        }
    }

    @Override
    public List<TestimonialDtoResponse> getAllWebsiteTestimonials() {
        List<Testimonial> websiteTestimonials = testimonialRepository.findAllByShowOnWebsite(true);
        return websiteTestimonials.stream()
                .map(testimonial -> {
                    String imageUrl = testimonial.getImageUrl().isEmpty()
                            ? testimonial.getImageUrl()
                            : getPresignedUrl(testimonial.getImageUrl(), testimonial.getContentType());
                    TestimonialDtoResponse testimonialDto = TestimonialMapper.mapToTestimonialDto(testimonial, imageUrl);
                    testimonialDto.setWebsiteProjectDto(getWebsiteProjectFromProjectService(testimonial.getProjectId()));
                    return testimonialDto;
                })
                .toList();
    }

    @Override
    public BigDecimal getTestimonialsResultAverage() {
        List<Testimonial> websiteTestimonials = testimonialRepository.findAll();
        double average = websiteTestimonials.stream()
                .mapToInt(Testimonial::getResult)
                .average()
                .orElse(0.0);
        return BigDecimal.valueOf(average);
    }

    private String saveTestimonialImage(MultipartFile image, Long projectId) {
        String originalFilename = image.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String key = projectId + "." + extension;
        return awsClient.uploadImage(awsBucket, image, key);
    }

    private WebsiteProjectDto getWebsiteProjectFromProjectService(Long projectId) {
        return projectClient.getWebsiteProject(projectId);
    }

    private String getPresignedUrl(String key, String contentType) {
        return awsClient.generatePresignedUrl(awsBucket, key, contentType);
    }

}
