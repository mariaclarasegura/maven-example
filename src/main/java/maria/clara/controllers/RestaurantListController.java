package maria.clara.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import io.javalin.Javalin;
import maria.clara.Server;
import maria.clara.dto.RestaurantDto;
import maria.clara.dto.RestaurantResponseDto;
import maria.clara.exceptions.UnexistentStockException;
import maria.clara.services.RestaurantService;
import maria.clara.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestaurantListController implements Serializable {

    private Logger log = LoggerFactory.getLogger(RestaurantListController.class);
    private RestaurantService restaurantService = new RestaurantService();

    public RestaurantListController() {
        Javalin app = Server.getApp();
        String basePath = "/cocinandoConEmma";

        app.get(basePath + "/restaurants", ctx ->
                {
                    ArrayList<RestaurantResponseDto> response = restaurantService.getRestaurants();
                    try {
                        ctx.result(JsonUtils.toJson(response));
                    } catch (UnexistentStockException stockException) {
                        log.warn(stockException.getMessage(), stockException);
                        ctx.result("No hay datos");
                    }
                }
        );

        app.get(basePath + "/restaurants", ctx ->

                {
                    String param = ctx.pathParam("edible");
                    ArrayList<RestaurantResponseDto> response = restaurantService.findRestaurantsBySpecialization(param);

                    try {
                        ctx.result(JsonUtils.toJson(response));
                    } catch (UnexistentStockException stockException) {
                        log.warn(stockException.getMessage(), stockException);
                        ctx.result("No hay datos");
                    }
                }
        );
    }
}


