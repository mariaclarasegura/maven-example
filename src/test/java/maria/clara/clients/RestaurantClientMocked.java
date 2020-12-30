package maria.clara.clients;

import com.fasterxml.jackson.databind.JsonMappingException;
import maria.clara.dto.DetailDto;
import maria.clara.dto.RestaurantDto;

import java.io.IOException;
import java.util.ArrayList;

public class RestaurantClientMocked implements RestaurantClient{

    @Override
    public ArrayList<RestaurantDto> getRestaurant() throws IOException, JsonMappingException {
        ArrayList<String> specialization = new ArrayList<String>();
        specialization.add("savory");
        specialization.add("sweet");
        DetailDto detailDto = new DetailDto("New York", 4, specialization);

        RestaurantDto restaurant1 = new RestaurantDto("1", "Eleven Madison Park", detailDto);

        ArrayList<RestaurantDto> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant1);

        return restaurantList;
    }
}
