package com.helix.gpo.testimonials_service.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface CompanyClient {

    @PostExchange(value = "/api/v1/auth-token/{authTokenValue}/validate")
    Boolean validateAuthToken(@PathVariable(name = "authTokenValue") String authTokenValue);

    @PostExchange(value = "/api/v1/auth-token/{authTokenValue}/invalidate")
    Boolean invalidateAuthToken(@PathVariable(name = "authTokenValue") String authTokenValue);

    @GetExchange(value = "/api/v1/auth-token/{authTokenValue}/project")
    Long getProjectIdByAuthTokenValue(@PathVariable(name = "authTokenValue") String authTokenValue);

}
