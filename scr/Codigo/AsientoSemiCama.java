package Codigo;

abstract public class AsientoSemiCama extends Asiento{
    private  int precio;
    private  int numeroAsiento;
    public AsientoSemiCama(int numeroAsiento){
        super(numeroAsiento);
        precio=10000;
        this.numeroAsiento = numeroAsiento;
    }
    public String TipoAsiento(){
        return "ASIENTO SEMICAMA";
    }
}
