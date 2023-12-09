package Codigo;

import java.util.ArrayList;

public class BusUnPiso extends Bus{
    public ArrayList<Asiento> asientoArrayList = new ArrayList<Asiento>();
    public BusUnPiso(int id, String dia, String mes, String anho, String hora, String origen, String destino){
        super(id,dia,mes,anho,hora,origen,destino);
        for(int i = 1; i<=16; i++){
            asientoArrayList.add(new Asiento(i,TipoAsiento.SALON_CAMA));
        }
        for(int i = 17; i<=32; i++){
            asientoArrayList.add(new Asiento(i,TipoAsiento.SEMI_CAMA));
        }
    }
    public String tipoBus(){
        return "bus1piso";
    }
}
