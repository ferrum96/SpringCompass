package appline.contoller;

import appline.logic.Compass;
import appline.logic.CompassModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    private static final CompassModel compassModel = CompassModel.getInstance();

    @PostMapping(value = "/setCompass", consumes = "application/json")
    public void setCompass(@RequestBody Compass compass) {
        compassModel.setCompass(0, compass);
    }

    @GetMapping(value = "/getSides", produces = "application/json")
    public Compass getSides() {
        return compassModel.getCompass();
    }

    @GetMapping(value = "/getSide", produces = "application/json")
    public Map<String, String> getSide(@RequestBody Map<String, Integer> degree) {
        return compassModel.getSide(degree.get("Degree"));
    }

}
