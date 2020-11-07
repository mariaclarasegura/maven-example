package maria.clara.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.javalin.Javalin;
import maria.clara.Server;
import maria.clara.model.Consumible;
import maria.clara.services.InventoryService;
import maria.clara.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

public class InventoryController {
    private InventoryService inventario = new InventoryService();

    public InventoryController() throws JsonProcessingException {
        Javalin app = Server.getApp();
        app.get("/hamburguesa", ctx -> ctx.result(String.valueOf(inventario.obtenerInventario("Hamburguesa"))));
        app.get("/listado/:consumible", ctx -> {
                    String param = ctx.pathParam("consumible");
                    ArrayList<Consumible> listado = inventario.obtenerListado(param);
                    ctx.result(JsonUtils.toJson(listado));
                }
        );
        app.get("/listado", ctx -> {
                    List<Consumible> listado = inventario.obtenerListado();
                    ctx.result(JsonUtils.toJson(listado));
                }
        );
    }


}
