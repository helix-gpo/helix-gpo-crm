package com.helix.gpo.testimonials_service.service.impl;

import com.helix.gpo.testimonials_service.client.CompanyClient;
import com.helix.gpo.testimonials_service.client.ProjectClient;
import com.helix.gpo.testimonials_service.entity.Testimonial;
import com.helix.gpo.testimonials_service.payload.*;
import com.helix.gpo.testimonials_service.payload.WebsiteTestimonialRequest;
import com.helix.gpo.testimonials_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.testimonials_service.repository.TestimonialRepository;
import com.helix.gpo.testimonials_service.service.WebsiteTestimonialService;
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
        validateRequestAuthToken(websiteTestimonialRequest.getAuthTokenValue());
        checkIfTestimonialAlreadyExistsForProject(websiteTestimonialRequest.getTestimonialDtoRequest());

        // todo: 1) save image (if exists) to file server

        String imageUrl = getImageUrl(image);
        Testimonial testimonial = TestimonialMapper.mapToTestimonial(websiteTestimonialRequest.getTestimonialDtoRequest(), imageUrl);
        testimonial.setCreationDate(LocalDate.now());
        testimonial.setLastUpdate(LocalDate.now());
        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        TestimonialDtoResponse finalTestimonial = TestimonialMapper.mapToTestimonialDto(savedTestimonial);
        WebsiteProjectDto websiteProjectDto = getWebsiteProjectFromProjectService(savedTestimonial.getProjectId());
        finalTestimonial.setWebsiteProjectDto(websiteProjectDto);
        return finalTestimonial;
    }

    private void validateRequestAuthToken(String authTokenValue) {
        if (!companyClient.validateAuthToken(authTokenValue)) {
            throw new RuntimeException("auth token invalid!");
        }
    }

    private void checkIfTestimonialAlreadyExistsForProject(TestimonialDtoRequest testimonialDtoRequest) {
        Optional<Testimonial> optionalTestimonial = testimonialRepository.findByProjectId(testimonialDtoRequest.getProjectId());
        if (optionalTestimonial.isPresent()) {
            throw new RuntimeException("A testimonial for this project does already exist!");
        }
    }

    @Override
    public List<TestimonialDtoResponse> getAllWebsiteTestimonials() {
        List<Testimonial> websiteTestimonials = testimonialRepository.findAllByShowOnWebsite(true);
        return websiteTestimonials.stream()
                .map(testimonial -> {
                    TestimonialDtoResponse testimonialDto = TestimonialMapper.mapToTestimonialDto(testimonial);
                    testimonialDto.setImage(getTestimonialImage(testimonial.getImageUrl()));
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
    private String getImageUrl(MultipartFile image) {
        // todo: 1) create url string for image url ('p_' + customer id + customer name + project name)
        return image != null ? image.getOriginalFilename() : "";
    }

    private byte[] getTestimonialImage(String imageUrl) {
        // todo: 1) get image from server
        return null;
    }

    private WebsiteProjectDto getWebsiteProjectFromProjectService(Long projectId) {
        return projectClient.getWebsiteProject(projectId);
    }

}
