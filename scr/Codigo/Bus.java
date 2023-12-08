package Codigo;


public abstract class Bus {
    int id;
    String fecha;
    String hora;
    public Bus(int id, String fecha, String hora){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
    }
    public int getid(){
        return id;
    }
    public abstract String tipoBus();
}
