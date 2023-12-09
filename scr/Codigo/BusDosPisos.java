package Codigo;

import java.util.ArrayList;

public class BusDosPisos extends Bus{
    public ArrayList<Asiento> piso1 = new ArrayList<Asiento>();
    public ArrayList<Asiento> piso2 = new ArrayList<Asiento>();
    public BusDosPisos(int id, String dia, String mes, String anho, String hora, String origen, String destino){
        super(id, dia, mes, anho, hora, origen, destino);
        for(int i = 1; i<=32; i++){
            piso1.add(new Asiento(i, TipoAsiento.SALON_CAMA));
        }
        for(int i = 33; i<=64; i++){
            piso2.add(new Asiento(i, TipoAsiento.SEMI_CAMA));
        }
    }
    public String tipoBus(){
        return "Bus2pisos";
    }
}
