package com.helix.gpo.company_service.service;

import com.helix.gpo.company_service.payload.website.WebsitePartnerDto;

public interface WebsiteService {

    WebsitePartnerDto getWebsitePartnerWithCompanyInfo(Long partnerId);

}
