package maria.clara.services;

import maria.clara.clients.RestaurantClient;
import maria.clara.dto.RestaurantResponseDto;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {

    private RestaurantClient restaurantClient = new RestaurantClient();

    // transformar ese response
    // No duplicar código => pd: te explicaré para que se usa -...-

    public ArrayList<RestaurantResponseDto> getRestaurants() {
        return null;
    }

    public ArrayList<RestaurantResponseDto> findRestaurantsBySpecialization(String specialization) {
        return null;
    }

}
