package com.helix.gpo.projects_service.service.impl;

import com.helix.gpo.projects_service.client.AwsClient;
import com.helix.gpo.projects_service.client.CompanyClient;
import com.helix.gpo.projects_service.entity.Project;
import com.helix.gpo.projects_service.exception.types.ProjectNotFoundException;
import com.helix.gpo.projects_service.payload.website.WebsitePartnerDto;
import com.helix.gpo.projects_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.projects_service.repository.ProjectRepository;
import com.helix.gpo.projects_service.service.WebsiteProjectService;
import com.helix.gpo.projects_service.util.WebsiteProjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebsiteProjectServiceImpl implements WebsiteProjectService {

    private final ProjectRepository projectRepository;
    private final CompanyClient client;
    private final AwsClient awsClient;

    @Value("${aws.bucket}")
    private String awsBucket;

    @Override
    public List<WebsiteProjectDto> getAllWebsiteProjects() {
        List<Project> websiteProjects = projectRepository.findAllByShowOnWebsite(true);
        return websiteProjects.stream()
                .map(project -> {
                    String imageUrl = project.getImageUrl().isEmpty()
                            ? project.getImageUrl()
                            : getPresignedUrl(project.getImageUrl(), project.getContentType());
                    WebsiteProjectDto websiteProjectDto = WebsiteProjectMapper.mapToWebsiteProjectDto(project, imageUrl);
                    websiteProjectDto.setWebsitePartnerDto(getWebsitePartnerFromCompanyService(project));
                    return websiteProjectDto;
                })
                .toList();
    }

    @Override
    public WebsiteProjectDto getWebsiteProject(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new ProjectNotFoundException(projectId)
        );

        String imageUrl = project.getImageUrl().isEmpty()
                ? project.getImageUrl()
                : getPresignedUrl(project.getImageUrl(), project.getContentType());
        WebsiteProjectDto websiteProjectDto = WebsiteProjectMapper.mapToWebsiteProjectDto(project, imageUrl);
        websiteProjectDto.setWebsitePartnerDto(getWebsitePartnerFromCompanyService(project));

        return websiteProjectDto;
    }

    private WebsitePartnerDto getWebsitePartnerFromCompanyService(Project project) {
        return client.getWebsitePartner(project.getPartnerId());
    }

    private String getPresignedUrl(String key, String contentType) {
        return awsClient.generatePresignedUrl(awsBucket, key, contentType);
    }

}
