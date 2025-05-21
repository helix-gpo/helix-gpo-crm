package com.helix.gpo.testimonials_service.util;

import com.helix.gpo.testimonials_service.entity.Testimonial;
import com.helix.gpo.testimonials_service.payload.TestimonialDtoRequest;
import com.helix.gpo.testimonials_service.payload.TestimonialDtoResponse;

public class TestimonialMapper {

    public static TestimonialDtoResponse mapToTestimonialDto(Testimonial testimonial) {
        return TestimonialDtoResponse.builder()
                .id(testimonial.getId())
                .title(testimonial.getTitle())
                .description(testimonial.getDescription())
                .result(testimonial.getResult())
                .customerId(testimonial.getCustomerId())
                .projectId(testimonial.getProjectId())
                .build();
    }

    public static Testimonial mapToTestimonial(TestimonialDtoRequest testimonialDtoRequest, String imageUrl) {
        return Testimonial.builder()
                .title(testimonialDtoRequest.getTitle())
                .description(testimonialDtoRequest.getDescription())
                .result(testimonialDtoRequest.getResult())
                .showOnWebsite(testimonialDtoRequest.getShowOnWebsite())
                .imageUrl(imageUrl)
                .customerId(testimonialDtoRequest.getCustomerId())
                .projectId(testimonialDtoRequest.getProjectId())
                .build();
    }

    // todo: create mapper - Testimonial to TestimonialDto

}
