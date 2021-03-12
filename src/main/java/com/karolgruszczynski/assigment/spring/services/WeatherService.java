package com.karolgruszczynski.assigment.spring.services;

import com.karolgruszczynski.assigment.spring.data.WeatherEntity;
import com.karolgruszczynski.assigment.spring.data.WeatherRepository;
import com.karolgruszczynski.assigment.spring.openweather.OpenWeatherService;
import com.karolgruszczynski.assigment.spring.openweather.api.OpenWeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WeatherService {
    private static Logger LOGGER = LoggerFactory.getLogger(WeatherService.class);

    private final WeatherRepository weatherRepository;
    private final OpenWeatherService openWeatherService;

    public WeatherService(WeatherRepository weatherRepository, OpenWeatherService openWeatherService) {
        this.weatherRepository = weatherRepository;
        this.openWeatherService = openWeatherService;
    }

    public ResponseEntity<String> fetchWeatherForCityAndSave(String city) {
      //TODO: Improve error handling
        try {
            LOGGER.trace("Fetching weather for '{}' ", city);
            OpenWeatherResponse openWeatherResponse = openWeatherService.fetchWeather(city);
            LOGGER.trace("Received weather for '{} : {} ' ", city, openWeatherResponse);

            WeatherEntity weather = new WeatherEntity();
            weather.setTemperature(openWeatherResponse.getMain().getTemp());
            weather.setCity(city);
            weather.setCountry(openWeatherResponse.getSys().getCountry());
            LOGGER.trace("Saving weather to database ");
            weatherRepository.save(weather);
            LOGGER.trace("Weather saved ");
            return new ResponseEntity<String>("Ok", HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error("Error processing request", e.getMessage());
            return new ResponseEntity<String>("Error", HttpStatus.OK);
        }

    }
}
