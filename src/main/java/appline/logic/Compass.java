package appline.logic;

public class Compass {

    private String northEast;
    private String southEast;
    private String southWest;
    private String northWest;

    public Compass() {
        super();
    }

    public Compass(String northEast, String southEast, String southWest, String northWest) {
        this.northEast = northEast;
        this.southEast = southEast;
        this.southWest = southWest;
        this.northWest = northWest;
    }

    public String getNorthEast() {
        return northEast;
    }

    public void setNorthEast(String northEast) {
        this.northEast = northEast;
    }

    public String getSouthEast() {
        return southEast;
    }

    public void setSouthEast(String southEast) {
        this.southEast = southEast;
    }

    public String getSouthWest() {
        return southWest;
    }

    public void setSouthWest(String southWest) {
        this.southWest = southWest;
    }

    public String getNorthWest() {
        return northWest;
    }

    public void setNorthWest(String northWest) {
        this.northWest = northWest;
    }
}