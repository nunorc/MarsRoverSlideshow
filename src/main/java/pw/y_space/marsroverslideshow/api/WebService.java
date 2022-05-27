package pw.y_space.marsroverslideshow.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class WebService {
    public static final String BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers";
    public static final String API_KEY = "DEMO_KEY";

    private static final HashMap<String, Integer> maxSols = new HashMap<>();

    static {
        maxSols.put("curiosity", 3483);
        maxSols.put("spirit", 2208);
        maxSols.put("opportunity", 5111);
    }

    private String buildUrl(String rover, Integer sol) {
        return String.format("%s/%s/photos?sol=%d&api_key=%s",BASE_URL, rover, sol, API_KEY);
    }

    public ModelResponse getData(String rover, Integer sol) {
        if (sol < 1) {
            sol = ThreadLocalRandom.current().nextInt(1, maxSols.get(rover) + 1);
        }

        RestTemplate rt = new RestTemplate();
        ResponseEntity<ModelResponse> response = rt.getForEntity(buildUrl(rover, sol), ModelResponse.class);

        ModelResponse result = response.getBody();
        result.setSol(sol);

        return result;
    }
}
