package com.helix.gpo.testimonials_service.payload.website;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsiteProjectDto {

    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private byte[] image;
    private WebsitePartnerDto websitePartnerDto;

}
