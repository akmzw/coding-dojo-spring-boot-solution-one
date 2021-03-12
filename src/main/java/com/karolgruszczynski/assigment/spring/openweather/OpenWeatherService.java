package com.karolgruszczynski.assigment.spring.openweather;


import com.karolgruszczynski.assigment.spring.openweather.api.OpenWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherService {
    private static Logger Logger = LoggerFactory.getLogger(OpenWeatherService.class);

    private final String apiUrl;
    private final RestTemplate restTemplate;

    public OpenWeatherService(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }


    public OpenWeatherResponse fetchWeather(String city) {

        ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(apiUrl, OpenWeatherResponse.class, city);
        return response.getBody();
    }
}
