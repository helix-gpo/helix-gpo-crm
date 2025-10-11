package com.helix.gpo.company_service.client;

import com.helix.gpo.company_service.payload.website.WebsiteProjectDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface ProjectClient {

    @GetExchange(value = "/api/v1/projects/website/{projectId}")
    WebsiteProjectDto getWebsiteProject(@PathVariable(name = "projectId") Long projectId);

}
