package com.helix.gpo.company_service.service.impl;

import com.helix.gpo.company_service.entity.Partner;
import com.helix.gpo.company_service.payload.website.WebsiteCompanyDto;
import com.helix.gpo.company_service.payload.website.WebsitePartnerDto;
import com.helix.gpo.company_service.repository.PartnerRepository;
import com.helix.gpo.company_service.service.WebsiteService;
import com.helix.gpo.company_service.util.WebsiteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebsiteServiceImpl implements WebsiteService {

    private final PartnerRepository partnerRepository;

    @Override
    public WebsitePartnerDto getWebsitePartnerWithCompanyInfo(Long partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(
                () -> new RuntimeException("Partner not found with ID: " + partnerId)
        );

        WebsitePartnerDto websitePartnerDto = WebsiteMapper.mapToWebsitePartnerDto(partner);
        WebsiteCompanyDto websiteCompanyDto = WebsiteMapper.mapToWebsiteCompanyDto(partner.getCompany());
        websitePartnerDto.setWebsiteCompanyDto(websiteCompanyDto);

        return websitePartnerDto;
    }

}
