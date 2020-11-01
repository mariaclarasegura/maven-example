package maria.clara;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import maria.clara.model.Consumible;
import maria.clara.servicios.ServicioInventario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        ServicioInventario inventario = new ServicioInventario();
        Javalin app = Javalin.create().start(7000);

        app.get("/hamburguesa", ctx -> ctx.result(String.valueOf(inventario.obtenerInventario("Hamburguesa"))));
        app.get("/listado/:consumible", ctx -> {
                    String param = ctx.pathParam("consumible");
                    ArrayList<Consumible> listado = inventario.obtenerListado(param);
                    ctx.result(objectMapper.writeValueAsString(listado));
                }
        );
    }
}


