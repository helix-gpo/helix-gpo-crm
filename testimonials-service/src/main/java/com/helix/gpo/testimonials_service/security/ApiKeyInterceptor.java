package com.helix.gpo.testimonials_service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ApiKeyInterceptor implements ClientHttpRequestInterceptor {

    private final WebsiteApiKeyConfig websiteApiKeyConfig;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add(websiteApiKeyConfig.getWebsiteApiKeyHeader(), websiteApiKeyConfig.getWebsiteApiKey());
        return execution.execute(request, body);
    }

}
