package Codigo;

abstract public class Asiento {

    private int precio;
    private int numeroAsiento;
    private TipoAsiento type;

    public Asiento(int numeroAsiento, TipoAsiento type) {
        this.numeroAsiento = numeroAsiento;
    }
    public int getNumeroAsiento(){
        return numeroAsiento;
    }
    public TipoAsiento getType(){
        return type;
    }
    public abstract String TipoAsiento();
}
