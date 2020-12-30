package maria.clara.clients;

import com.fasterxml.jackson.databind.JsonMappingException;
import maria.clara.dto.RestaurantDto;

import java.io.IOException;
import java.util.ArrayList;

public interface RestaurantClient {

    public ArrayList<RestaurantDto> getRestaurant() throws IOException, JsonMappingException;

}
