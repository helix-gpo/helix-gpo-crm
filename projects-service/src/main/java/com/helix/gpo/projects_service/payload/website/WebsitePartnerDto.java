package com.helix.gpo.projects_service.payload.website;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebsitePartnerDto {

    private Long id;
    private String name;
    private String job;
    private WebsiteCompanyDto websiteCompanyDto;

}
