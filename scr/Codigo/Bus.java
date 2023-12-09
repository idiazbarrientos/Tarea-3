package Codigo;


public abstract class Bus {
    int id;
    String dia;
    String mes;
    String anho;
    String hora;

    String origen;

    String destino;

    public Bus(int id, String dia, String mes, String anho, String hora, String origen, String destino){
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
        this.hora = hora;
        this.origen = origen;
        this.destino = destino;
    }
    public int getid(){
        return id;
    }
    public abstract String tipoBus();
}
