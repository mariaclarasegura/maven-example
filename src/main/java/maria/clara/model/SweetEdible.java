package maria.clara.model;

public abstract class SweetEdible extends Edible {
    protected String typeOfMeal = "Sweet";

    public String getTypeOfMeal() {
        return typeOfMeal;
    }

    public void setTypeOfMeal(String typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }
}
