package maria.clara;

import io.javalin.Javalin;

public final class Server {
    private static Javalin app = Javalin.create().start(7000);

    public static Javalin getApp() {
        return app;
    }
}
