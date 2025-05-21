package com.helix.gpo.testimonials_service.service.impl;

import com.helix.gpo.testimonials_service.entity.Testimonial;
import com.helix.gpo.testimonials_service.payload.*;
import com.helix.gpo.testimonials_service.repository.TestimonialRepository;
import com.helix.gpo.testimonials_service.service.TestimonialService;
import com.helix.gpo.testimonials_service.util.TestimonialMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;

    @Transactional
    @Override
    public TestimonialDtoResponse addTestimonial(WebsiteTestimonialRequest websiteTestimonialRequest, MultipartFile image) {
        validateRequestAuthToken(websiteTestimonialRequest.getAuthTokenValue());
        checkForServerErrorsAndDataMismatches();

        // todo: 1) save image (if exists) to file server

        String imageUrl = getImageUrl(image);
        Testimonial testimonial = TestimonialMapper.mapToTestimonial(websiteTestimonialRequest.getTestimonialDtoRequest(), imageUrl);
        Testimonial savedTestimonial = testimonialRepository.save(testimonial);

        // todo: 2) get project from project service (replace method with project rest client)
        ProjectDto projectDto = getProjectDtoFromService();
        return TestimonialMapper.mapToTestimonialDto(savedTestimonial, projectDto);
    }

    private void validateRequestAuthToken(String authTokenValue) {
        // todo: 1) check if auth token is valid
        // todo: 2) check for auth token data mismatches
    }

    private void checkForServerErrorsAndDataMismatches() {
        // todo: 1) check if testimonial for project and customer already exists
    }

    @Override
    public List<TestimonialDtoResponse> getAllWebsiteTestimonials() {
        List<Testimonial> websiteTestimonials = testimonialRepository.findAllByShowOnWebsite(true);
        return websiteTestimonials.stream()
                .map(testimonial -> {
                    ProjectDto projectDto = getProjectDtoFromService(); // todo: replace with project rest client
                    TestimonialDtoResponse testimonialDto = TestimonialMapper.mapToTestimonialDto(testimonial, projectDto);
                    byte[] image = getTestimonialImage(testimonial.getImageUrl());
                    testimonialDto.setImage(image);
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

    // todo: method will be replaced with project rest client
    private ProjectDto getProjectDtoFromService() {
        CompanyDto companyDto = CompanyDto.builder()
                .id(1L)
                .name("Company XYZ")
                .build();

        PartnerDto partnerDto = PartnerDto.builder()
                .id(1L)
                .name("Konrad Weiß")
                .job("Digital Marketing")
                .companyDto(companyDto)
                .build();

        return ProjectDto.builder()
                .id(1L)
                .name("Project XYZ")
                .partnerDto(partnerDto)
                .build();
    }

}
