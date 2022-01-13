package fr.lernejo.prediction;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PredictionController {
    private final TemperatureService temperatureService;
    private final double oneDaysMillisec = 86400000;

    public PredictionController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @GetMapping(value = "/api/temperature")
    public Prediction GetTemp(@RequestParam String country) {
        List<Temperature> listTemperature = new ArrayList<Temperature>();
        listTemperature.add(
            new Temperature(
                new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime() - oneDaysMillisec)
            ,temperatureService.getTemperature(country)));
        listTemperature.add(
            new Temperature(
                new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime() - (oneDaysMillisec * 2))
            ,temperatureService.getTemperature(country)));

        return new Prediction(country, listTemperature);
    }
}
