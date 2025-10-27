package com.helix.gpo.testimonials_service.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface CompanyClient {

    @PostExchange(value = "/api/v1/companies/auth-token/validate")
    Boolean validateAuthToken(@RequestParam(name = "authTokenValue") String authTokenValue);

    @PostExchange(value = "/api/v1/companies/auth-token/invalidate")
    Boolean invalidateAuthToken(@RequestParam(name = "authTokenValue") String authTokenValue);

    @GetExchange(value = "/api/v1/companies/auth-token/project")
    Long getProjectIdByAuthTokenValue(@RequestParam(name = "authTokenValue") String authTokenValue);

}
