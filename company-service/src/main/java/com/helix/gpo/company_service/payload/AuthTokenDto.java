package com.helix.gpo.company_service.payload;

import com.helix.gpo.company_service.payload.website.WebsiteProjectDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthTokenDto {

    private Long id;
    private String value;
    private Boolean valid;
    private Boolean used;
    private WebsiteProjectDto websiteProjectDto;

}
