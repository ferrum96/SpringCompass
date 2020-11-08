package appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CompassModel implements Serializable {

    private static final CompassModel instance = new CompassModel();
    private final Map<Integer, Compass> model;

    public CompassModel() {
        model = new HashMap<Integer, Compass>();
        model.put(0,new Compass("0-89", "90-179", "180-269", "270-359"));
    }

    public static CompassModel getInstance() {
        return instance;
    }

    public void setCompass(int id, Compass compass) {
        model.put(id, compass);
    }

    public Compass getCompass() {
        return model.get(0);
    }

    public Map<String, String> getSide(int degree) {

        int northEastRangeValue1 = Integer.parseInt(getCompass().getNorthEast().split("-")[0]);
        int northEastRangeValue2 = Integer.parseInt(getCompass().getNorthEast().split("-")[1]);
        int northWestRangeValue1 = Integer.parseInt(getCompass().getNorthWest().split("-")[0]);
        int northWestRangeValue2 = Integer.parseInt(getCompass().getNorthWest().split("-")[1]);
        int southWestRangeValue1 = Integer.parseInt(getCompass().getSouthWest().split("-")[0]);
        int southWestRangeValue2 = Integer.parseInt(getCompass().getSouthWest().split("-")[1]);
        int southEastRangeValue1 = Integer.parseInt(getCompass().getSouthEast().split("-")[0]);
        int southEastRangeValue2 = Integer.parseInt(getCompass().getSouthEast().split("-")[1]);

        Map<String, String> side = new HashMap<>();

        if (degree > northEastRangeValue1 && degree <= northEastRangeValue2) {
            side.put("Side", "North-East");
        } else if (normalize360(degree) == normalize360(northEastRangeValue1)) {
            side.put("Side", "North");
        } else if (degree > southEastRangeValue1 && degree <= southEastRangeValue2) {
            side.put("Side", "South-East");
        } else if (normalize360(degree) == normalize360(southEastRangeValue1)) {
            side.put("Side", "East");
        } else if (degree > southWestRangeValue1 && degree <= southWestRangeValue2) {
            side.put("Side", "South-West");
        } else if (normalize360(degree) == normalize360(southWestRangeValue1)) {
            side.put("Side", "South");
        } else if (degree > northWestRangeValue1 && degree <= northWestRangeValue2) {
            side.put("Side", "North-west");
        } else if (normalize360(degree) == normalize360(northWestRangeValue1)) {
            side.put("Side", "West");
        }
        return side;
    }

    public static int normalize180(int angle) {
        if (angle == 180) {
            return angle;
        }
        angle = (angle + 180) % 360;
        if (angle < 0) {
            angle = angle + 360;
        }
        return angle - 180;
    }

    public static int normalize360(int angle) {
        angle = angle % 360;
        if (angle < 0) {
            angle = angle + 360;
        }
        return angle;
    }
}
