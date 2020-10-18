package maria.clara.model;

public class Hamburguesa extends ConsumibleSalado {
    private boolean celiaco;
    private boolean diabetico;
    private boolean integral;

    public boolean isCeliaco() {
        return celiaco;
    }

    public void setCeliaco(boolean celiaco) {
        this.celiaco = celiaco;
    }

    public boolean isDiabetico() {
        return diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        this.diabetico = diabetico;
    }

    public boolean isIntegral() {
        return integral;
    }

    public void setIntegral(boolean integral) {
        this.integral = integral;
    }

    public Hamburguesa(boolean celiaco, boolean diabetico, boolean integral, double precio, String sabor) {
        this.celiaco = celiaco;
        this.diabetico = diabetico;
        this.integral = integral;
        this.precio=precio;
        this.sabor=sabor;
    }
}
