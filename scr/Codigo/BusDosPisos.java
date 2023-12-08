package Codigo;

public class BusDosPisos extends Bus{
    public BusDosPisos(int id, String fecha, String hora){
        super(id, fecha, hora);
    }
    public String tipoBus(){
        return "Bus2pisos";
    }
}
