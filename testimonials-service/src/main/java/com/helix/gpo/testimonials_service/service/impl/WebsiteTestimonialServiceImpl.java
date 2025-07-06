package com.helix.gpo.testimonials_service.service.impl;

import com.helix.gpo.testimonials_service.client.CompanyClient;
import com.helix.gpo.testimonials_service.client.ProjectClient;
import com.helix.gpo.testimonials_service.entity.Testimonial;
import com.helix.gpo.testimonials_service.exception.types.InvalidAuthTokenException;
import com.helix.gpo.testimonials_service.exception.types.TestimonialAlreadyExistsException;
import com.helix.gpo.testimonials_service.payload.*;
import com.helix.gpo.testimonials_service.payload.WebsiteTestimonialRequest;
import com.helix.gpo.testimonials_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.testimonials_service.repository.TestimonialRepository;
import com.helix.gpo.testimonials_service.service.WebsiteTestimonialService;
import com.helix.gpo.testimonials_service.util.Constants;
import com.helix.gpo.testimonials_service.util.TestimonialMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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

    @Transactional
    @Override
    public TestimonialDtoResponse addTestimonial(WebsiteTestimonialRequest websiteTestimonialRequest, MultipartFile image) {
        TestimonialDtoRequest testimonialDtoRequest = websiteTestimonialRequest.getTestimonialDtoRequest();
        validateRequestAuthToken(websiteTestimonialRequest.getAuthTokenValue());
        checkIfTestimonialAlreadyExistsForProject(testimonialDtoRequest);

        String imageUrl = getImageUrl(testimonialDtoRequest);
        if (!image.isEmpty()) {
            saveTestimonialImage(image);
        }

        Testimonial testimonial = TestimonialMapper.mapToTestimonial(websiteTestimonialRequest.getTestimonialDtoRequest(), imageUrl);
        testimonial.setCreationDate(LocalDate.now());
        testimonial.setLastUpdate(LocalDate.now());
        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        TestimonialDtoResponse finalTestimonial = TestimonialMapper.mapToTestimonialDto(savedTestimonial);
        WebsiteProjectDto websiteProjectDto = getWebsiteProjectFromProjectService(savedTestimonial.getProjectId());
        finalTestimonial.setWebsiteProjectDto(websiteProjectDto);

        if (companyClient.invalidateAuthToken(websiteTestimonialRequest.getAuthTokenValue())) {
            throw new InvalidAuthTokenException("Invalidating token was not successful!");
        }

        return finalTestimonial;
    }

    private void validateRequestAuthToken(String authTokenValue) {
        if (!companyClient.validateAuthToken(authTokenValue)) {
            throw new InvalidAuthTokenException("Invalid auth token!");
        }
    }

    private void checkIfTestimonialAlreadyExistsForProject(TestimonialDtoRequest testimonialDtoRequest) {
        Long projectId = testimonialDtoRequest.getProjectId();
        Optional<Testimonial> optionalTestimonial = testimonialRepository.findByProjectId(projectId);
        if (optionalTestimonial.isPresent()) {
            throw new TestimonialAlreadyExistsException(projectId);
        }
    }

    @Override
    public List<TestimonialDtoResponse> getAllWebsiteTestimonials() {
        List<Testimonial> websiteTestimonials = testimonialRepository.findAllByShowOnWebsite(true);
        return websiteTestimonials.stream()
                .map(testimonial -> {
                    TestimonialDtoResponse testimonialDto = TestimonialMapper.mapToTestimonialDto(testimonial);
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

    // helper methods
    private void saveTestimonialImage(MultipartFile image) {
        // todo: save image on server
    }

    private String getImageUrl(TestimonialDtoRequest testimonialDtoRequest) {
        String filename = testimonialDtoRequest.getProjectId() + "_" + testimonialDtoRequest.getTitle() + ".png";
        return Constants.TESTIMONIALS_SERVER_PATH + filename;
    }

    private WebsiteProjectDto getWebsiteProjectFromProjectService(Long projectId) {
        return projectClient.getWebsiteProject(projectId);
    }

}
