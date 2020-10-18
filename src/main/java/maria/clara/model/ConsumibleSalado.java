package maria.clara.model;

public abstract class ConsumibleSalado extends Consumible{
    protected String tipoDeComida="Salado";

    public String getTipoDeComida() {
        return tipoDeComida;
    }

    public void setTipoDeComida(String tipoDeComida) {
        this.tipoDeComida = tipoDeComida;
    }
}
