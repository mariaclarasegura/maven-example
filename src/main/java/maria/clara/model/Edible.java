package maria.clara.model;

public abstract class Edible {
    protected String typeOfEdible = getClass().getSimpleName();
    protected double price;
    protected String flavor;

    public String getTypeOfEdible() {
        return typeOfEdible;
    }

    public void setTypeOfEdible(String typeOfEdible) {
        this.typeOfEdible = typeOfEdible;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
