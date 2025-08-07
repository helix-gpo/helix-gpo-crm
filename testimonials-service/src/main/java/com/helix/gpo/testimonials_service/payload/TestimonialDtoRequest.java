package com.helix.gpo.testimonials_service.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialDtoRequest {

    private Long id;
    private String title;
    private String description;
    private Integer result;
    private Boolean showOnWebsite;

}
