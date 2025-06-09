package com.helix.gpo.company_service.controller;

import com.helix.gpo.company_service.payload.website.WebsitePartnerDto;
import com.helix.gpo.company_service.service.WebsiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/website/partners")
@RequiredArgsConstructor
public class WebsiteController {

    private final WebsiteService websiteService;

    @GetMapping(value = "/{partnerId}")
    public ResponseEntity<WebsitePartnerDto> getWebsitePartner(@PathVariable(name = "partnerId") Long partnerId) {
        return new ResponseEntity<>(websiteService.getWebsitePartnerWithCompanyInfo(partnerId), HttpStatus.OK);
    }

}
