package maria.clara;

import maria.clara.controllers.InventoryController;
import maria.clara.controllers.RestaurantListController;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        new InventoryController();
        new RestaurantListController();
    }
}


