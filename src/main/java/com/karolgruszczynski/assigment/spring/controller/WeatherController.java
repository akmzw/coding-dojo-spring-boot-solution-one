package com.karolgruszczynski.assigment.spring.controller;

import com.karolgruszczynski.assigment.spring.services.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class WeatherController {
    private static Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ResponseEntity<String> weather(@NotNull @Valid @RequestParam String city) {
        LOGGER.trace("Reqested weather for '{}' ", city);

        return weatherService.fetchWeatherForCityAndSave(city);
    }

}
