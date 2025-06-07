package com.helix.gpo.company_service.util;

import com.helix.gpo.company_service.entity.Company;
import com.helix.gpo.company_service.entity.Partner;
import com.helix.gpo.company_service.payload.website.WebsiteCompanyDto;
import com.helix.gpo.company_service.payload.website.WebsitePartnerDto;

public class WebsiteMapper {

    public static WebsitePartnerDto mapToWebsitePartnerDto(Partner partner) {
        return WebsitePartnerDto.builder()
                .id(partner.getId())
                .name(partner.getName())
                .job(partner.getJob())
                .build();
    }

    public static WebsiteCompanyDto mapToWebsiteCompanyDto(Company company) {
        return WebsiteCompanyDto.builder()
                .id(company.getId())
                .name(company.getName())
                .build();
    }

}
