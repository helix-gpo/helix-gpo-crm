package com.helix.gpo.company_service.service.impl;

import com.helix.gpo.company_service.client.ProjectClient;
import com.helix.gpo.company_service.entity.AuthToken;
import com.helix.gpo.company_service.entity.Partner;
import com.helix.gpo.company_service.exception.types.ResourceNotFoundException;
import com.helix.gpo.company_service.payload.AuthTokenDto;
import com.helix.gpo.company_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.company_service.repository.AuthTokenRepository;
import com.helix.gpo.company_service.repository.PartnerRepository;
import com.helix.gpo.company_service.service.AuthTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthTokenServiceImpl implements AuthTokenService {

    private final AuthTokenRepository authTokenRepository;
    private final PartnerRepository partnerRepository;
    private final ProjectClient projectClient;

    @Override
    public AuthTokenDto initTestimonialProcess(WebsiteProjectDto websiteProjectDto) {
        Long partnerId = websiteProjectDto.getWebsitePartnerDto().getId();
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(
                () -> new ResourceNotFoundException("", partnerId.toString(), "Partner")
        );

        AuthToken authToken = AuthToken.builder()
                .valid(true)
                .used(false)
                .partner(partner)
                .projectId(websiteProjectDto.getId())
                .build();
        String authTokenValue = createAuthTokenValue(websiteProjectDto.getTitle());
        authToken.setValue(authTokenValue);

        AuthToken savedAuthToken = authTokenRepository.save(authToken);
        sendTokenMailToProjectPartner(savedAuthToken);
        return AuthTokenDto.builder()
                .id(savedAuthToken.getId())
                .value(savedAuthToken.getValue())
                .valid(true)
                .used(false)
                .websiteProjectDto(websiteProjectDto)
                .build();
    }

    private String createAuthTokenValue(String projectTitle) {
        String authTokenValue = projectTitle + "_" + UUID.randomUUID();
        return encodeToBase64(authTokenValue);
    }

    private void sendTokenMailToProjectPartner(AuthToken authToken) {
        String decodedTokenValue = decodeFromBase64(authToken.getValue());
        // todo: send email with decoded token value
    }

    @Override
    public Boolean validateAuthToken(String authTokenValue) {
        AuthToken authToken = authTokenRepository.findByValue(encodeToBase64(authTokenValue)).orElse(null);
        if (authToken == null) {
            return false;
        }

        Partner partner = authToken.getPartner();
        Boolean related = validateProjectPartnerRelation(partner.getId(), authToken);
        return authToken.getValid() && !authToken.getUsed() && related;
    }

    private Boolean validateProjectPartnerRelation(Long partnerId, AuthToken authToken) {
        WebsiteProjectDto websiteProjectDto = projectClient.getWebsiteProject(authToken.getProjectId());
        return partnerId.equals(websiteProjectDto.getWebsitePartnerDto().getId());
    }

    @Override
    public Boolean invalidateAuthToken(String authTokenValue) {
        AuthToken authToken = authTokenRepository.findByValue(encodeToBase64(authTokenValue)).orElse(null);
        if (authToken == null) {
            return false;
        }

        authToken.setUsed(true);
        authToken.setValid(false);
        authTokenRepository.save(authToken);

        return true;
    }

    @Override
    public Long getProjectIdByAuthTokenValue(String authTokenValue) {
        AuthToken authToken = authTokenRepository.findByValue(encodeToBase64(authTokenValue)).orElseThrow(
                () -> new ResourceNotFoundException("", authTokenValue, "Authentifizierungs-Token")
        );
        return authToken.getProjectId();
    }

    private String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    private String decodeFromBase64(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

}
