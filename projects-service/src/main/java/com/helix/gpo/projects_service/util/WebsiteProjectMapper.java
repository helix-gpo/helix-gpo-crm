package com.helix.gpo.projects_service.util;

import com.helix.gpo.projects_service.entity.Project;
import com.helix.gpo.projects_service.payload.website.WebsiteProjectDto;

public class WebsiteProjectMapper {

    public static WebsiteProjectDto mapToWebsiteProjectDto(Project project) {
        return WebsiteProjectDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .showOnWebsite(project.getShowOnWebsite())
                .build();
    }

}
