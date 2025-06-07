package com.helix.gpo.company_service.service;

import com.helix.gpo.company_service.payload.AuthTokenDto;
import com.helix.gpo.company_service.payload.website.WebsiteProjectDto;

public interface AuthTokenService {

    AuthTokenDto initTestimonialProcess(WebsiteProjectDto websiteProjectDto);

    Boolean validateAuthToken(String authTokenValue);

}
