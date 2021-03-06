package maria.clara.services;

import maria.clara.database.Database;
import maria.clara.exceptions.UnexistentStockException;
import maria.clara.model.Edible;

import java.util.ArrayList;
import java.util.List;

public class InventoryService {
    private Database database = new Database();

    public int obtainInventory(String edible) {
        List<Edible> listForService = database.getEdiblesList();
        int counter = 0;
        for (Edible meal : listForService) {
            if (meal.getClass().getSimpleName().equals(edible)) {
                counter++;
            }
        }
        return counter;
    }

    public ArrayList<Edible> obtainList(String edible) throws UnexistentStockException {
        List<Edible> listForService = database.getEdiblesList();
        ArrayList<Edible> chosenEdible = new ArrayList<>();
        for (Edible meal : listForService) {
            if (meal.getClass().getSimpleName().equals(edible)) {
                chosenEdible.add(meal);
            }
        }
        if (chosenEdible.isEmpty()) {
            UnexistentStockException error  = new UnexistentStockException("No hay datos");
            throw error;
        } else {
            return chosenEdible;
        }
    }

    public List<Edible> obtainList() {
        return database.getEdiblesList();
    }
}