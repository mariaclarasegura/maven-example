package maria.clara.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.javalin.Javalin;
import maria.clara.Server;
import maria.clara.model.Edible;
import maria.clara.services.InventoryService;
import maria.clara.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private InventoryService inventario = new InventoryService();

    public InventoryController() throws JsonProcessingException {
        Javalin app = Server.getApp();
        app.get("/hamburguesa", ctx -> ctx.result(String.valueOf(inventario.obtainInventory("Hamburguesa"))));
        app.get("/listado/:consumible", ctx -> {
                    String param = ctx.pathParam("consumible");
                    ArrayList<Edible> listado = inventario.obtainList(param);
                    ctx.result(JsonUtils.toJson(listado));
                }
        );
        app.get("/listado", ctx -> {
                    List<Edible> listado = inventario.obtainList();
                    ctx.result(JsonUtils.toJson(listado));
                }
        );
    }


}
