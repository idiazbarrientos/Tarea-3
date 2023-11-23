package Codigo;

abstract public class Asiento {
    private int precio;
    private int numeroAsiento;

    public Asiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    public abstract String TipoAsiento();
}
