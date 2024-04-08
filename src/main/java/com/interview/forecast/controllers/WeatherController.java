package  com.interview.forecast.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    @GetMapping("/forecastlist/{city}")
    public Object getCityWeatherInfo(@PathVariable String city) {
        String uri = "https://api.tomorrow.io/v4/weather/forecast?location=" + city + "&apikey=q01u3w688ZDOaJKdPQ8EpUY5PkAUkeKk";
        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri, Object.class);
        return result;
    }
}
