package pw.y_space.marsroverslideshow.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelPhoto {
    private Long id;
    private Integer sol;
    private ModelCamera camera;

    @JsonProperty("img_src")
    private String imgSrc;

    @JsonProperty("earth_date")
    private String earthDate;
    private ModelRover rover;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public ModelCamera getCamera() {
        return camera;
    }

    public void setCamera(ModelCamera camera) {
        this.camera = camera;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }

    public ModelRover getRover() {
        return rover;
    }

    public void setRover(ModelRover rover) {
        this.rover = rover;
    }
}
