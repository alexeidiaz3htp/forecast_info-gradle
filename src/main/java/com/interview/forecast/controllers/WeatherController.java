package  com.interview.forecast.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class WeatherController {

    @GetMapping("/forecastlist/{city}")
    public Object getCityWeatherInfo(@PathVariable String city) {
        String uri = "https://api.tomorrow.io/v4/weather/forecast?location=" + city.toUpperCase().trim() + "&apikey=q01u3w688ZDOaJKdPQ8EpUY5PkAUkeKk";
        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri, Object.class);
        return result;
    }

    @GetMapping("/forecastlist")
    public Map<String, Object> getCityWeatherInfo() {
        String[] cities ={ 
            "miami",
            "new york",
            "la habana"
        };
        Map<String, Object> citiesForecast = new HashMap<String, Object>(); 
        RestTemplate restTemplate = new RestTemplate();

        for (String cities : city) {
            String uri = "https://api.tomorrow.io/v4/weather/forecast?location=" + city + "&apikey=q01u3w688ZDOaJKdPQ8EpUY5PkAUkeKk";
            Object result = restTemplate.getForObject(uri, Object.class);
            citiesForecast.put(city, result);
        }
        
        return citiesForecast;
    }
}
