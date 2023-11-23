package Codigo;

abstract public class AsientoCama extends Asiento{
    private int precio;
    private int numeroAsiento;
    public AsientoCama(int numeroAsiento){
        super(numeroAsiento);
        precio=20000;
        this.numeroAsiento = numeroAsiento;
    }
    public String TipoAsiento(){
        return "ASIENTO CAMA";
    }
}
