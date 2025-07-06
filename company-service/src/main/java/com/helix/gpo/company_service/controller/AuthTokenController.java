package com.helix.gpo.company_service.controller;

import com.helix.gpo.company_service.payload.AuthTokenDto;
import com.helix.gpo.company_service.payload.website.WebsiteProjectDto;
import com.helix.gpo.company_service.service.AuthTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth-token")
@RequiredArgsConstructor
public class AuthTokenController {

    private final AuthTokenService authTokenService;

    @PostMapping
    public ResponseEntity<AuthTokenDto> initTestimonialProcess(@RequestBody WebsiteProjectDto websiteProjectDto) {
        return new ResponseEntity<>(authTokenService.initTestimonialProcess(websiteProjectDto), HttpStatus.CREATED);
    }

    @PostMapping(value = "/{authTokenValue}/validate")
    public ResponseEntity<Boolean> validateAuthToken(@PathVariable(name = "authTokenValue") String authTokenValue) {
        return new ResponseEntity<>(authTokenService.validateAuthToken(authTokenValue), HttpStatus.OK);
    }

    @PostMapping(value = "/{authTokenValue}/invalidate")
    public ResponseEntity<Boolean> invalidateAuthToken(@PathVariable(name = "authTokenValue") String authTokenValue) {
        return new ResponseEntity<>(authTokenService.invalidateAuthToken(authTokenValue), HttpStatus.OK);
    }

}
