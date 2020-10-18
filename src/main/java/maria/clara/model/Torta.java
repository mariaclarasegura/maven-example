package maria.clara.model;

public class Torta extends ConsumibleDulce {
    private double peso;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


    public Torta(double peso, double precio, String sabor) {
        this.peso = peso;
        this.precio = precio;
        this.sabor = sabor;
    }
}
