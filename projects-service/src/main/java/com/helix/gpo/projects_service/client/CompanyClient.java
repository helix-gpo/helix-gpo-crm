package com.helix.gpo.projects_service.client;

import com.helix.gpo.projects_service.payload.website.WebsitePartnerDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface CompanyClient {

    @GetExchange(value = "/api/v1/companies/website/partners/{partnerId}")
    WebsitePartnerDto getWebsitePartner(@PathVariable(name = "partnerId") Long partnerId);

}
