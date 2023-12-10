package Codigo;

/**
 * Representa el bus de un viaje
 */

public abstract class Bus {
    int id;
    String dia;
    String mes;
    String anho;
    String hora;

    String origen;

    String destino;

    /**
     *
     * @param id numero de bus
     * @param dia dia de viaje del bus
     * @param mes mes de viaje del bus
     * @param anho año de viaje del bus
     * @param hora hora de salida del bus
     * @param origen de donde sale el bus
     * @param destino a donde llega el bus
     */
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
    public String getDia(){
        return dia;
    }
    public String getMes(){
        return mes;
    }
    public String getAnho(){
        return anho;
    }
    public String getHora(){
        return hora;
    }
    public String getOrigen(){
        return origen;
    }
    public String getDestino(){
        return destino;
    }
    public abstract String tipoBus();
}
