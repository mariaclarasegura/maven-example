package maria.clara.services;

import maria.clara.clients.RestaurantClient;
import maria.clara.dto.RestaurantResponseDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantService {

    private RestaurantClient restaurantClient = new RestaurantClient();

    public RestaurantService() throws IOException {
    }

    // transformar ese response
    // No duplicar código => pd: te explicaré para que se usa -...-

    private ArrayList<RestaurantResponseDto> listOfRestaurantsOrdered = new ArrayList<RestaurantResponseDto>();

    public ArrayList<RestaurantResponseDto> getRestaurants() {
        Collections.sort(listOfRestaurantsOrdered, new Comparator<RestaurantResponseDto>() {
            @Override
            public int compare(RestaurantResponseDto o2, RestaurantResponseDto o1) {
                return Integer.valueOf(o2.getRating()).compareTo(o1.getRating());
            }
        });
        return listOfRestaurantsOrdered;
    }

    public List<RestaurantResponseDto> findSavorySpecializedRestaurants() {
        List<RestaurantResponseDto> savoryEdibleRestaurants = listOfRestaurantsOrdered.stream().filter(restaurantResponseDto -> restaurantResponseDto.getSpecialization().contains("savory")).collect(Collectors.toList());
        return savoryEdibleRestaurants;
    }

    public List<RestaurantResponseDto> findSweetSpecializedRestaurants() {

        List<RestaurantResponseDto> sweetEdibleRestaurants = listOfRestaurantsOrdered.stream().filter(restaurantResponseDto -> restaurantResponseDto.getSpecialization().contains("sweet")).collect(Collectors.toList());
        return sweetEdibleRestaurants;
    }

}
