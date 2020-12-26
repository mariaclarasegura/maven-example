package maria.clara.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.javalin.Javalin;
import maria.clara.Server;
import maria.clara.dto.RestaurantResponseDto;
import maria.clara.exceptions.EdibleNotFoundException;
import maria.clara.exceptions.UnexistentStockException;
import maria.clara.services.RestaurantService;
import maria.clara.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RestaurantListController implements Serializable {

    private Logger log = LoggerFactory.getLogger(RestaurantListController.class);
    private RestaurantService restaurantService = new RestaurantService();

    public RestaurantListController() throws IOException {
        Javalin app = Server.getApp();
        String basePath = "/cocinandoConEmma";

        app.get(basePath + "/restaurants", ctx ->
                {
                    ArrayList<RestaurantResponseDto> response = restaurantService.getRestaurantListOrdered();
                    try {
                        ctx.result(JsonUtils.toJson(response));
                    } catch (UnexistentStockException stockException) {
                        log.warn(stockException.getMessage(), stockException);
                        ctx.result("No hay datos");
                    }
                }
        );

        app.get(basePath + "/restaurants", ctx -> {
                    String param = ctx.pathParam("edible");

                    try {
                        if (param != "sweet" && param != "savory") {
                            throw new EdibleNotFoundException("Edible " + param + " not exists ");
                        }

                        List<RestaurantResponseDto> response = restaurantService.findRestaurantsBySpecialization(param);
                        ctx.result(JsonUtils.toJson(response));
                    } catch (UnexistentStockException stockException) {
                        log.warn(stockException.getMessage(), stockException);
                        ctx.result("No hay datos");
                    } catch (EdibleNotFoundException exception) {
                        log.warn(exception.getMessage(), exception);
                        ctx.result("No existe ese sabor");
                    }
                }
        );
    }
}


