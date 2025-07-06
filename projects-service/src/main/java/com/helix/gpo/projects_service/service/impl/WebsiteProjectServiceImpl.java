package com.helix.gpo.projects_service.service.impl;

import com.helix.gpo.projects_service.client.CompanyClient;
import com.helix.gpo.projects_service.entity.Project;
import com.helix.gpo.projects_service.payload.website.WebsitePartnerDto;
import com.helix.gpo.projects_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.projects_service.repository.ProjectRepository;
import com.helix.gpo.projects_service.service.WebsiteProjectService;
import com.helix.gpo.projects_service.util.WebsiteProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebsiteProjectServiceImpl implements WebsiteProjectService {

    private final ProjectRepository projectRepository;
    private final CompanyClient client;

    @Override
    public List<WebsiteProjectDto> getAllWebsiteProjects() {
        List<Project> websiteProjects = projectRepository.findAllByShowOnWebsite(true);
        return websiteProjects.stream()
                .map(project -> {
                    WebsiteProjectDto websiteProjectDto = WebsiteProjectMapper.mapToWebsiteProjectDto(project);
                    websiteProjectDto.setWebsitePartnerDto(getWebsitePartnerFromCompanyService(project));
                    return websiteProjectDto;
                })
                .toList();
    }

    @Override
    public WebsiteProjectDto getWebsiteProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new RuntimeException("Project not found with ID: " + projectId)
        );

        WebsiteProjectDto websiteProjectDto = WebsiteProjectMapper.mapToWebsiteProjectDto(project);
        websiteProjectDto.setWebsitePartnerDto(getWebsitePartnerFromCompanyService(project));

        return websiteProjectDto;
    }

    private WebsitePartnerDto getWebsitePartnerFromCompanyService(Project project) {
        return client.getWebsitePartner(project.getPartnerId());
    }

}
