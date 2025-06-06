package com.helix.gpo.projects_service.service.impl;

import com.helix.gpo.projects_service.entity.Project;
import com.helix.gpo.projects_service.payload.website.WebsiteCompanyDto;
import com.helix.gpo.projects_service.payload.website.WebsitePartnerDto;
import com.helix.gpo.projects_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.projects_service.repository.ProjectRepository;
import com.helix.gpo.projects_service.service.WebsiteProjectService;
import com.helix.gpo.projects_service.util.ProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebsiteProjectServiceImpl implements WebsiteProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public List<WebsiteProjectDto> getAllWebsiteProjects() {
        List<Project> websiteProjects = projectRepository.findAllByShowOnWebsite(true);
        return websiteProjects.stream()
                .map(project -> {
                    WebsiteProjectDto websiteProjectDto = ProjectMapper.mapToWebsiteProjectDto(project);
                    websiteProjectDto.setImage(getImageFromServer(project));
                    websiteProjectDto.setWebsitePartnerDto(getWebsitePartnerFromCompanyService(project));
                    return websiteProjectDto;
                })
                .toList();
    }

    private byte[] getImageFromServer(Project project) {
        return new byte[]{};
    }

    private WebsitePartnerDto getWebsitePartnerFromCompanyService(Project project) {
        WebsiteCompanyDto websiteCompanyDto = WebsiteCompanyDto.builder()
                .id(1L)
                .name("Michael Breuer Steuerberatung")
                .build();
        return WebsitePartnerDto.builder()
                .id(1L)
                .name("Michael Breuer")
                .job("Steuerberater")
                .websiteCompanyDto(websiteCompanyDto)
                .build();
    }

}
