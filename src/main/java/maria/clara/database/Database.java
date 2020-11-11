package maria.clara.database;

import maria.clara.model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Edible> ediblesList = new ArrayList<Edible>();

    public Database() {
        ediblesList.add(new Hamburguer(true, true, true, 100, "Hongos"));
        ediblesList.add(new Hamburguer(false, false, false, 100, "Porotos"));
        ediblesList.add(new Hamburguer(false, true, false, 100, "Avena"));
        ediblesList.add(new Cake(0.5, 600, "Chocolate"));
        ediblesList.add(new Muffin(true, true, true, 50, "Chocolate"));
        ediblesList.add(new Muffin(true, true, true, 50, "Vainilla"));
        ediblesList.add(new Muffin(false, false, false, 50, "Frutilla"));
        ediblesList.add(new Pizza(8, 400, "Muzzarella"));
        ediblesList.add(new Pizza(6, 300, "Capresse"));
    }

    public List<Edible> getEdiblesList() {
        return ediblesList;
    }

    public void setEdiblesList(List<Edible> ediblesList) {
        this.ediblesList = ediblesList;
    }
}
