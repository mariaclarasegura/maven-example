package maria.clara.model;

public abstract class ConsumibleDulce extends Consumible{
    protected String tipoDeComida="Dulce";

    public String getTipoDeComida() {
        return tipoDeComida;
    }

    public void setTipoDeComida(String tipoDeComida) {
        this.tipoDeComida = tipoDeComida;
    }
}
