package com.helix.gpo.testimonials_service.payload;

import lombok.*;

import java.time.LocalDate;

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
    private LocalDate creationDate;
    private LocalDate lastUpdate;
    private Boolean showOnWebsite;

}
