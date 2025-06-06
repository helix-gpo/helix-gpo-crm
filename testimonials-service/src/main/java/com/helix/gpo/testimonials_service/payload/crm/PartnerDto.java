package com.helix.gpo.testimonials_service.payload.crm;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartnerDto {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String job;
    private CompanyDto companyDto;

}
