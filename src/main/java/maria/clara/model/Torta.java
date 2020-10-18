package maria.clara.model;

public class Torta extends ConsumibleDulce {
    private int peso;
    private boolean dulce;
    private boolean salado;

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isDulce() {
        return dulce;
    }

    public void setDulce(boolean dulce) {
        this.dulce = dulce;
    }

    public boolean isSalado() {
        return salado;
    }

    public void setSalado(boolean salado) {
        this.salado = salado;
    }
}
