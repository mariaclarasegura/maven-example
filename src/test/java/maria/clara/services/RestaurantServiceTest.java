package maria.clara.services;

import com.fasterxml.jackson.databind.JsonMappingException;
import maria.clara.clients.RestaurantClient;
import maria.clara.clients.RestaurantClientImpl;
import maria.clara.clients.RestaurantClientMocked;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import maria.clara.dto.RestaurantDto;
import maria.clara.dto.RestaurantResponseDto;
import maria.clara.exceptions.HttpRequestFailureException;
import maria.clara.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;

public class RestaurantServiceTest {

    @Mock
    RestaurantClientImpl client;

    @Test
    public void getRestaurantListOrderedTest() throws IOException {
        RestaurantService restaurantServiceForTest = new RestaurantService(new RestaurantClientMocked());
        ArrayList<RestaurantResponseDto> restaurantResponseDtoListForTest = new ArrayList<>();

        restaurantServiceForTest.getRestaurantListOrdered();
    }

    @Test
    public void getRestaurantListOrderedTestWithEmptyList() throws IOException {
        when(client.getRestaurant()).thenReturn(new ArrayList<RestaurantDto>());
        RestaurantService restaurantServiceForTest = new RestaurantService(client);

        restaurantServiceForTest.getRestaurantListOrdered();
    }



}
