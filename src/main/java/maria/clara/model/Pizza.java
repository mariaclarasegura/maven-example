package maria.clara.model;

public class Pizza  extends ConsumibleSalado{
    private int porciones;

    public int getPorciones() {
        return porciones;
    }

    public void setPorciones(int porciones) {
        this.porciones = porciones;
    }

    public Pizza(int porciones, double precio, String sabor) {
        this.porciones = porciones;
        this.precio=precio;
        this.sabor=sabor;
    }
}
