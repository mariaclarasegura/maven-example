package maria.clara.database;

import maria.clara.model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Consumible> listadoDeProductos = new ArrayList<Consumible>();

    public Database() {
        listadoDeProductos.add(new Hamburguesa(true, true, true, 100, "Hongos"));
        listadoDeProductos.add(new Hamburguesa(false, false, false, 100, "Porotos"));
        listadoDeProductos.add(new Hamburguesa(false, true, false, 100, "Avena"));
        listadoDeProductos.add(new Torta(0.5, 600, "Chocolate"));
        listadoDeProductos.add(new Muffin(true, true, true, 50, "Chocolate"));
        listadoDeProductos.add(new Muffin(true, true, true, 50, "Vainilla"));
        listadoDeProductos.add(new Muffin(false, false, false, 50, "Frutilla"));
        listadoDeProductos.add(new Pizza(8, 400, "Muzzarella"));
        listadoDeProductos.add(new Pizza(6, 300, "Capresse"));
    }

    public List<Consumible> getListadoDeProductos() {
        return listadoDeProductos;
    }

    public void setListadoDeProductos(List<Consumible> listadoDeProductos) {
        this.listadoDeProductos = listadoDeProductos;
    }
}
