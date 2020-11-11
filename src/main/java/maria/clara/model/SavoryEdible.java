package maria.clara.model;

public abstract class SavoryEdible extends Edible {
    protected String typeOfMeal = "Savory";

    public String getTypeOfMeal() {
        return typeOfMeal;
    }

    public void setTypeOfMeal(String typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }
}
