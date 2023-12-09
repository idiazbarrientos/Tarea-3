package Codigo;

abstract public class Asiento {

    private int precio;
    private int numeroAsiento;
    private TipoAsiento type;
    private boolean select;
    private boolean comprado;

    public Asiento(int numeroAsiento, TipoAsiento type) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public TipoAsiento getType() {
        return type;
    }

    public abstract String TipoAsiento();

    public void select() {
        if (!comprado) {
            select = true;
        }
    }
    public void deselect(){
        select = false;
    }
    void comprar(){
        this.comprado = true;
        this.select = false;
    }
    public boolean isSelect(){
        return select;
    }
    public boolean isComprado(){
        return comprado;
    }
}