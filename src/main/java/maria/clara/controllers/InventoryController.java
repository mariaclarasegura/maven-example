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
    private InventoryService inventory = new InventoryService();

    public InventoryController() throws JsonProcessingException {
        Javalin app = Server.getApp();
        String basePath = "/cocinandoConEmma";
        app.get(basePath + "/list/:edible", ctx -> {
                    String param = ctx.pathParam("edible");
                    ArrayList<Edible> list = inventory.obtainList(param);
                    ctx.result(JsonUtils.toJson(list));
                }
        );
        app.get(basePath + "/list", ctx -> {
                    List<Edible> list = inventory.obtainList();
                    ctx.result(JsonUtils.toJson(list));
                }
        );
    }


}
