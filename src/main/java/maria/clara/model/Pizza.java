package maria.clara.model;

public class Pizza extends SavoryEdible {
    private int numberOfPortions;

    public int getNumberOfPortions() {
        return numberOfPortions;
    }

    public void setNumberOfPortions(int numberOfPortions) {
        this.numberOfPortions = numberOfPortions;
    }

    public Pizza(int numberOfPortions, double price, String flavor) {
        this.numberOfPortions = numberOfPortions;
        this.price = price;
        this.flavor = flavor;
    }
}
