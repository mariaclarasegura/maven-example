package maria.clara.clients;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantClientTest {

    @Test
    public void getRestaurantFromValidRequest() {
        RestaurantClient restaurantClient = new RestaurantClient();

        assertDoesNotThrow(() -> {
            restaurantClient.getRestaurant();
        });
    }
}