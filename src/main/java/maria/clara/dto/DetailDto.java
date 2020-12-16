package maria.clara.dto;

import java.util.ArrayList;

public class DetailDto {
    private String location;
    private int rating;
    private ArrayList<String> specialization;

    public DetailDto(String location, int rating, ArrayList<String> specialization) {
        this.location = location;
        this.rating = rating;
        this.specialization = specialization;
    }

    public DetailDto() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<String> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(ArrayList<String> specialization) {
        this.specialization = specialization;
    }


}
