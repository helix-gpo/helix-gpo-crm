package com.helix.gpo.company_service.config;

import com.helix.gpo.company_service.client.ProjectClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.net.http.HttpClient;
import java.time.Duration;

@Configuration
public class RestClientConfig {

    @Value("${project.service.base-url}")
    private String projectServiceBaseUrl;

    @Bean
    public ProjectClient projectClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(projectServiceBaseUrl)
                .requestFactory(getJdkClientRequestFactory())
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServerProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServerProxyFactory.createClient(ProjectClient.class);
    }

    private JdkClientHttpRequestFactory getJdkClientRequestFactory() {
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        return new JdkClientHttpRequestFactory(httpClient);
    }

}
