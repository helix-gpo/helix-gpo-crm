package com.helix.gpo.testimonials_service.security;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class WebsiteApiKeyConfig {

    @Value("${website.security.api-key-header}")
    private String websiteApiKeyHeader;

    @Value("${website.security.api-key}")
    private String websiteApiKey;

}
