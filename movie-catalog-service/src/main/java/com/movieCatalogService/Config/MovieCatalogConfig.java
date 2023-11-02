package com.movieCatalogService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MovieCatalogConfig {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();

    }
    @Bean
    public WebClient.Builder getWebclientBuilder(){
        return WebClient.builder() ;
    }
}
