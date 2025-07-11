package com.helix.gpo.testimonials_service.payload;

import com.helix.gpo.testimonials_service.payload.website.WebsiteProjectDto;
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
    private String imageUrl;
    private LocalDate creationDate;
    private LocalDate lastUpdate;
    private Boolean showOnWebsite;
    private WebsiteProjectDto websiteProjectDto;

}
