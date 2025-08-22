package com.helix.gpo.projects_service.util;

import com.helix.gpo.projects_service.entity.Project;
import com.helix.gpo.projects_service.entity.ProjectTag;
import com.helix.gpo.projects_service.payload.TagDto;
import com.helix.gpo.projects_service.payload.website.WebsiteProjectDto;

import java.util.List;

public class WebsiteProjectMapper {

    public static WebsiteProjectDto mapToWebsiteProjectDto(Project project, String imageUrl) {
        return WebsiteProjectDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .imageUrl(imageUrl)
                .showOnWebsite(project.getShowOnWebsite())
                .tags(mapProjectTags(project))
                .build();
    }

    private static List<TagDto> mapProjectTags(Project project) {
        return project.getProjectTags().stream().map(WebsiteProjectMapper::mapProjectTag).toList();
    }

    private static TagDto mapProjectTag(ProjectTag projectTag) {
        return TagDto.builder()
                .value(projectTag.getValue())
                .color(projectTag.getColor())
                .build();
    }

}
