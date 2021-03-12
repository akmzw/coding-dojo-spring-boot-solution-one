package com.karolgruszczynski.assigment.spring;

import com.karolgruszczynski.assigment.spring.data.WeatherRepository;
import com.karolgruszczynski.assigment.spring.openweather.OpenWeatherService;
import com.karolgruszczynski.assigment.spring.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private WeatherRepository weatherRepository;

    @Bean
    public OpenWeatherService openWeatherService() {
        return new OpenWeatherService(openWeatherApiUrl, restTemplate());
    }

    @Bean
    public WeatherService weatherService() {
        return new WeatherService(weatherRepository, openWeatherService());
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
