package maria.clara.servicios;

import maria.clara.database.BaseDeDato;
import maria.clara.model.Consumible;

import java.util.List;

public class ServicioInventario {
    private BaseDeDato baseDeDato = new BaseDeDato();

    public int obtenerInventario(String consumible) {
        List<Consumible> listadoParaServicio = baseDeDato.getListadoDeProductos();
        int contador = 0;
        for (Consumible alimento : listadoParaServicio) {
            if (alimento.getClass().getSimpleName().equals(consumible)) {
                contador++;
            }
        }
        return contador;
    }
}
