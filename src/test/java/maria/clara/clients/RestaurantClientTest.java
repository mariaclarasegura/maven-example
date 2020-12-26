package maria.clara.clients;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantClientTest {

    @Test
    public void getRestaurantFromValidRequest() throws IOException {
        RestaurantClient restaurantClient = new RestaurantClient();

        assertDoesNotThrow(() -> {
            restaurantClient.getRestaurant();
        });
    }
}