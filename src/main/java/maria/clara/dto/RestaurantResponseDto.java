package maria.clara.dto;

import java.util.ArrayList;

public class RestaurantResponseDto {

    private String name;
    private String location;
    private int rating;
    private ArrayList<String> specialization;

    public RestaurantResponseDto(String name, String location, int rating, ArrayList<String> specialization) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
