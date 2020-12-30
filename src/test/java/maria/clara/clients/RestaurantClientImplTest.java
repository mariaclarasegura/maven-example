package maria.clara.clients;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantClientImplTest {

    @Test
    public void getRestaurantFromValidRequest() throws IOException {
        RestaurantClientImpl restaurantClientImpl = new RestaurantClientImpl();

        assertDoesNotThrow(() -> {
            restaurantClientImpl.getRestaurant();
        });
    }
}