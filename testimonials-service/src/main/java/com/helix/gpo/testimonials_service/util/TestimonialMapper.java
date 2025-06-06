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
                .creationDate(testimonial.getCreationDate())
                .lastUpdate(testimonial.getLastUpdate())
                .showOnWebsite(testimonial.getShowOnWebsite())
                .build();
    }

    public static Testimonial mapToTestimonial(TestimonialDtoRequest testimonialDtoRequest, String imageUrl) {
        return Testimonial.builder()
                .title(testimonialDtoRequest.getTitle())
                .description(testimonialDtoRequest.getDescription())
                .result(testimonialDtoRequest.getResult())
                .imageUrl(imageUrl)
                .showOnWebsite(testimonialDtoRequest.getShowOnWebsite())
                .projectId(testimonialDtoRequest.getProjectId())
                .build();
    }

}
