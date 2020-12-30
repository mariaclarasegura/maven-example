package maria.clara.services;

import com.fasterxml.jackson.databind.JsonMappingException;
import maria.clara.clients.RestaurantClient;
import maria.clara.dto.RestaurantDto;
import maria.clara.dto.RestaurantResponseDto;
import maria.clara.exceptions.HttpRequestFailureException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.javalin.Javalin.log;

public class RestaurantService {

    private RestaurantClient restaurantClient;

    public RestaurantService(RestaurantClient client) {
        this.restaurantClient = client;
    }

    public List<RestaurantResponseDto> getRestaurantListOrdered() throws IOException, JsonMappingException {
        List<RestaurantResponseDto> listOfRestaurantsOrdered = getRestaurants();

        Collections.sort(getRestaurants(), new Comparator<RestaurantResponseDto>() {
            @Override
            public int compare(RestaurantResponseDto o2, RestaurantResponseDto o1) {
                return Integer.valueOf(o2.getRating()).compareTo(o1.getRating());
            }
        });

     /* --- With lambda expressions

        listOfRestaurantsOrdered = response
               .stream()
               .map(item -> new RestaurantResponseDto(item.getName(), item.getDetail().getLocation(), item.getDetail().getRating(), item.getDetail().getSpecialization()))
               .sorted((o2, o1) -> Integer.valueOf(o2.getRating()).compareTo(o1.getRating()))
               .collect(Collectors.toList());
     */
        return listOfRestaurantsOrdered;
    }

    public List<RestaurantResponseDto> findRestaurantsBySpecialization(String edible) throws IOException, JsonMappingException {
        List<RestaurantResponseDto> savoryEdibleRestaurants = getRestaurantListOrdered()
                .stream()
                .filter(restaurantResponseDto -> restaurantResponseDto.getSpecialization().contains(edible))
                .collect(Collectors.toList());

        return savoryEdibleRestaurants;
    }

    private List<RestaurantResponseDto> getRestaurants() throws IOException, JsonMappingException {
        List<RestaurantResponseDto> listOfRestaurant = new ArrayList<>();
        try {
            ArrayList<RestaurantDto> response = restaurantClient.getRestaurant();

            for (RestaurantDto item : response) {
                listOfRestaurant.add(
                        new RestaurantResponseDto(item.getName(), item.getDetail().getLocation(), item.getDetail().getRating(), item.getDetail().getSpecialization())
                );
            }
        } catch (NullPointerException nullPointerException) {
            HttpRequestFailureException exception = new HttpRequestFailureException("API's request failed");
            log.warn(exception.getMessage(), exception);
            throw exception;
        }
        return listOfRestaurant;
    }

}
