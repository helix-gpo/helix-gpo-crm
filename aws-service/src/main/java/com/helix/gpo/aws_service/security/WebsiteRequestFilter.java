package com.helix.gpo.aws_service.security;

import com.helix.gpo.aws_service.exception.types.InvalidApiKeyException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class WebsiteRequestFilter extends OncePerRequestFilter {

    private final WebsiteApiKeyConfig websiteApiKeyConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();

        if (path.startsWith("/api/v1/website/testimonials")) {
            String apiKey = request.getHeader(websiteApiKeyConfig.getWebsiteApiKeyHeader());

            if (apiKey == null || !apiKey.equals(websiteApiKeyConfig.getWebsiteApiKey())) {
                throw new InvalidApiKeyException("Invalid API Key!");
            }
        }

        filterChain.doFilter(request, response);
    }

}
