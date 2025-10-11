package com.helix.gpo.projects_service.controller;

import com.helix.gpo.projects_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.projects_service.service.WebsiteProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/projects/website")
@RequiredArgsConstructor
public class WebsiteProjectController {

    private final WebsiteProjectService websiteProjectService;

    @GetMapping
    public ResponseEntity<List<WebsiteProjectDto>> getAllWebsiteProjects() {
        return new ResponseEntity<>(websiteProjectService.getAllWebsiteProjects(), HttpStatus.OK);
    }

    @GetMapping(value = "/{projectId}")
    public ResponseEntity<WebsiteProjectDto> getWebsiteProject(@PathVariable(name = "projectId") Long projectId) {
        return new ResponseEntity<>(websiteProjectService.getWebsiteProject(projectId), HttpStatus.OK);
    }

}
