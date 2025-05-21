package com.helix.gpo.testimonials_service.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestimonialDtoResponse {

    private Long id;
    private String title;
    private String description;
    private Integer result;
    private byte[] image;
    private String customerName;
    private String partnerName;
    private String projectName;

}
