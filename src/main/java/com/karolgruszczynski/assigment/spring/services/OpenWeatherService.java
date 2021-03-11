package com.karolgruszczynski.assigment.spring.services;


import com.karolgruszczynski.assigment.spring.services.openweatherapi.OpenWeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherService {
    private final String apiUrl;
    private final String apiKey;
    private final RestTemplate restTemplate;

    public OpenWeatherService(String apiUrl, String apiKey, RestTemplate restTemplate1) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.restTemplate = restTemplate1;
    }


    public OpenWeatherResponse fetchWeather(String city) {

        ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(apiUrl, OpenWeatherResponse.class, city);

        return response.getBody();
    }
}
