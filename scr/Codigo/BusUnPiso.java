package Codigo;

public class BusUnPiso extends Bus{
    public BusUnPiso(int id, String fecha, String hora){
        super(id, fecha, hora);
    }
    public String tipoBus(){
        return "bus1piso";
    }
}
