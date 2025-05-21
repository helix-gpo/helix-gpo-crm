package com.helix.gpo.testimonials_service.util;

import com.helix.gpo.testimonials_service.entity.Testimonial;
import com.helix.gpo.testimonials_service.payload.ProjectDto;
import com.helix.gpo.testimonials_service.payload.TestimonialDtoRequest;
import com.helix.gpo.testimonials_service.payload.TestimonialDtoResponse;

public class TestimonialMapper {

    public static TestimonialDtoResponse mapToTestimonialDto(Testimonial testimonial, ProjectDto projectDto) {
        return TestimonialDtoResponse.builder()
                .id(testimonial.getId())
                .title(testimonial.getTitle())
                .description(testimonial.getDescription())
                .result(testimonial.getResult())
                .projectName(projectDto.getName())
                .partnerName(projectDto.getPartnerDto().getName())
                .companyName(projectDto.getPartnerDto().getCompanyDto().getName())
                .build();
    }

    public static Testimonial mapToTestimonial(TestimonialDtoRequest testimonialDtoRequest, String imageUrl) {
        return Testimonial.builder()
                .title(testimonialDtoRequest.getTitle())
                .description(testimonialDtoRequest.getDescription())
                .result(testimonialDtoRequest.getResult())
                .showOnWebsite(testimonialDtoRequest.getShowOnWebsite())
                .imageUrl(imageUrl)
                .projectId(testimonialDtoRequest.getProjectId())
                .build();
    }

}
