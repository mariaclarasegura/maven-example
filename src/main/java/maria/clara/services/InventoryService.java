package maria.clara.services;

import maria.clara.database.Database;
import maria.clara.model.Consumible;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private Database database = new Database();

    public int obtenerInventario(String consumible) {
        List<Consumible> listadoParaServicio = database.getListadoDeProductos();
        int contador = 0;
        for (Consumible alimento : listadoParaServicio) {
            if (alimento.getClass().getSimpleName().equals(consumible)) {
                contador++;
            }
        }
        return contador;
    }

    public ArrayList<Consumible> obtenerListado(String consumible) {
        List<Consumible> listadoParaServicio = database.getListadoDeProductos();
        ArrayList<Consumible> consumibleElegido = new ArrayList<>();
        for (Consumible alimento : listadoParaServicio) {
            if (alimento.getClass().getSimpleName().equals(consumible)) {
                consumibleElegido.add(alimento);
            }
        }
        return consumibleElegido;
    }


    public List<Consumible> obtenerListado() {
        return database.getListadoDeProductos();
    }
}