package maria.clara.dto;

import java.io.Serializable;

public class RestaurantDto implements Serializable {

    private String id;
    private String name;
    private DetailDto detail;

    public RestaurantDto(String id, String name, DetailDto detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
    }

    public RestaurantDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DetailDto getDetail() {
        return detail;
    }

    public void setDetail(DetailDto detail) {
        this.detail = detail;
    }

}