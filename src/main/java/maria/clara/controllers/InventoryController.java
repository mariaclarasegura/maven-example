package maria.clara.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.javalin.Javalin;
import maria.clara.Server;
import maria.clara.exceptions.UnexistentStockException;
import maria.clara.model.Edible;
import maria.clara.services.InventoryService;
import maria.clara.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private InventoryService inventory = new InventoryService();
    private Logger log = LoggerFactory.getLogger(InventoryController.class);

    public InventoryController() throws JsonProcessingException {
        Javalin app = Server.getApp();
        String basePath = "/cocinandoConEmma";

        app.get(basePath + "/list/:edible", ctx -> {
                    String param = ctx.pathParam("edible");

                    try {
                        ArrayList<Edible> list = inventory.obtainList(param);
                        ctx.result(JsonUtils.toJson(list));
                    } catch (UnexistentStockException stockException) {
                        log.warn(stockException.getMessage(), stockException);
                        ctx.result("No hay datos");
                    }
                }
        );

        app.get(basePath + "/list", ctx ->

                {
                    List<Edible> list = inventory.obtainList();
                    ctx.result(JsonUtils.toJson(list));
                }
        );
    }
}
