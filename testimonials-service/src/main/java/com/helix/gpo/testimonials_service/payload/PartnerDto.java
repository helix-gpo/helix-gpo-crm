package com.helix.gpo.testimonials_service.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerDto {

    private Long id;
    private String name;
    private String job;
    private CompanyDto companyDto;

}
