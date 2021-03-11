package com.karolgruszczynski.assigment.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Value("${config.openWeather.url}")
    private String openWeatherApiUrl;
    @Value("${config.openWeather.apiKey}")
    private String openWeatherApiKey;


    @Bean
    public openWeather


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
