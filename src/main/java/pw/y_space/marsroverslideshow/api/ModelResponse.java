package pw.y_space.marsroverslideshow.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModelResponse {
    List<ModelPhoto> photos = new ArrayList<>();
    Integer sol;

    public List<ModelPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<ModelPhoto> photos) {
        this.photos = photos;
    }

    public Integer getSol() {
        return sol;
    }

    public void setSol(Integer sol) {
        this.sol = sol;
    }

    public void shufflePhotos() {
        Collections.shuffle(photos);
    }
    @Override
    public String toString() {
        return "modelResponse{" +
                "photos=" + photos +
                '}';
    }
}
