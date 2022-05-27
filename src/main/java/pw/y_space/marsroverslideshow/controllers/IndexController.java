package pw.y_space.marsroverslideshow.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pw.y_space.marsroverslideshow.RoverDescriptions;
import pw.y_space.marsroverslideshow.api.ModelResponse;
import pw.y_space.marsroverslideshow.api.WebService;

@Controller
public class IndexController {
    @Autowired
    private WebService webService;
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/")
    public String getRoot(ModelMap model,
                          @RequestParam(defaultValue = "curiosity") String rover,
                          @RequestParam(defaultValue = "0") String sol) {
        ModelResponse modelData = webService.getData(rover.toLowerCase(), Integer.parseInt(sol));
        modelData.shufflePhotos();

        String earthDate = "--";
        if (modelData.getPhotos().size() > 0){
            earthDate = modelData.getPhotos().get(0).getEarthDate();
        }

        String roverDesc = RoverDescriptions.roverDescription(rover);

        model.put("modelData", modelData);
        model.put("rover", rover);
        model.put("sol", modelData.getSol());
        model.put("earthDate", earthDate);
        model.put("roverDesc", roverDesc);

        logger.info("Proc rover " + rover + " for sol " + modelData.getSol() + " earth on " + earthDate);
        logger.info("Got " + modelData.getPhotos().size() + " photos");

        return "index";
    }
}
