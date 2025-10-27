package com.helix.gpo.testimonials_service.payload.website;

import com.helix.gpo.testimonials_service.payload.TagDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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
    private List<TagDto> tags;

}
