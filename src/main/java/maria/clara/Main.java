package maria.clara;

import io.javalin.Javalin;
import maria.clara.servicios.ServicioInventario;

public class Main {
    public static void main(String[] args) {
        ServicioInventario inventario = new ServicioInventario();
        Javalin app = Javalin.create().start(7000);
        app.get("/hamburguesa", ctx -> ctx.result(String.valueOf(inventario.obtenerInventario("Hamburguesa"))));
    }
}


