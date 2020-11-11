package maria.clara.model;

public class Cake extends SweetEdible {
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public Cake(double weight, double price, String flavor) {
        this.weight = weight;
        this.price = price;
        this.flavor = flavor;
    }
}
