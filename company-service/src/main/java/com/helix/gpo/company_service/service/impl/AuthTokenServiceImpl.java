package com.helix.gpo.company_service.service.impl;

import com.helix.gpo.company_service.entity.AuthToken;
import com.helix.gpo.company_service.entity.Partner;
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

    // todo: move to secured service later on!
    @Override
    public AuthTokenDto initTestimonialProcess(WebsiteProjectDto websiteProjectDto) {
        Long partnerId = websiteProjectDto.getWebsitePartnerDto().getId();
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(
                () -> new RuntimeException("Partner does not exist with ID: " + partnerId)
        );

        AuthToken authToken = AuthToken.builder()
                .valid(true)
                .used(false)
                .partner(partner)
                .build();
        String authTokenValue = createAuthTokenValue();
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

    private String createAuthTokenValue() {
        String authTokenValue = UUID.randomUUID().toString();
        return encodeToBase64(authTokenValue);
    }

    private void sendTokenMailToProjectPartner(AuthToken authToken) {
        String decodedTokenValue = decodeFromBase64(authToken.getValue());
        // todo: send email with decoded token value
    }

    @Override
    public Boolean validateAuthToken(String authTokenValue) {
        AuthToken authToken = authTokenRepository.findByValue(encodeToBase64(authTokenValue)).orElseThrow(
                () -> new RuntimeException("Auth token does not exist for this value!")
        );

        // todo: secure by validating project!

        Partner partner = authToken.getPartner();
        return authToken.getValid() && !authToken.getUsed() && partner != null;
    }

    private String encodeToBase64(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes());
    }

    private String decodeFromBase64(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

}
