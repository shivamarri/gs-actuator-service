package hello;

import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import model.WeatherByCity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method=RequestMethod.GET, path = "/getWeather")
    public @ResponseBody
    WeatherByCity sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        URI url = UriComponentsBuilder.fromHttpUrl("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=439d4b804bc8187953eb36d2a8c26a02").build().toUri();

        ResponseEntity<WeatherByCity> result = restTemplate.exchange(url, HttpMethod.GET, entity, WeatherByCity.class);
        System.out.println("Weather api return"+  result.getStatusCode());
        System.out.println("Weather api return"+  result.toString());
        return result.getBody();
    }

}
