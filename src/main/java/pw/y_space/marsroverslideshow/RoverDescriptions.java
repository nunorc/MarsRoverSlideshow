package pw.y_space.marsroverslideshow;

import java.util.HashMap;

public class RoverDescriptions {
    private static final HashMap<String, String> roverDescs = new HashMap<>();

    static {
        roverDescs.put("curiosity", "Curiosity is a car-sized rover designed by NASA to explore Mars and landed inside Gale crater on Aug 6, 2012.");
        roverDescs.put("spirit", "Spirit is one of the two rovers launched in 2003 by NASA to explore Mars and landed inside Gustav crater on Jan 4, 2004.");
        roverDescs.put("opportunity", "Opportunity is one of the two rovers launched in 2003 by NASA to explore Mars, landed in Meridiani Planum on Jan 25, 2004.");
    }

    public static String roverDescription(String rover) {
        String roverDesc = "Not found";

        if (roverDescs.containsKey(rover)) {
            roverDesc = roverDescs.get(rover);
        }

        return roverDesc;
    }
}
