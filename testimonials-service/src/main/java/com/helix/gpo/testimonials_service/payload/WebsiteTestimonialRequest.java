package com.helix.gpo.testimonials_service.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteTestimonialRequest {

    private TestimonialDtoRequest testimonialDtoRequest;
    private String authTokenValue;

}
