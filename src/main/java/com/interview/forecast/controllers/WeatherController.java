package  com.interview.forecast.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    @GetMapping("/forecastlist")
    public String getCityWeatherInfo(String city) {
        String uri = "https://api.tomorrow.io/v4/weather/forecast?location=42.3478,-71.0466&apikey=q01u3w688ZDOaJKdPQ8EpUY5PkAUkeKk"
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, Object.class);
        return result;
    }
}
