package Codigo;

/**
 * Representa el asiento del bus
 */

public class Asiento {

    private int precio;
    private int numeroAsiento;
    private TipoAsiento type;
    private boolean select;
    private boolean comprado;

    /**
     *
     * @param numeroAsiento numero del asiento
     * @param type tipo de asiento
     */
    public Asiento(int numeroAsiento, TipoAsiento type) {
        this.numeroAsiento = numeroAsiento;
        this.type=type;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public TipoAsiento getType() {
        return type;
    }

    public String TipoAsiento() {
        return null;
    }

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