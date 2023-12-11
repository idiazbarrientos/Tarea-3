package Codigo;

import java.util.ArrayList;

/**
 * Representa los buses de un piso y sus asientos de un viaje
 */
public class BusUnPiso extends Bus{
    public ArrayList<Asiento> asientoArrayList = new ArrayList<Asiento>();

    /**
     *
     * @param id numero del bus
     * @param dia dia de viaje del bus
     * @param mes mes de viaje del bus
     * @param anho año de viaje del bus
     * @param hora hora de salida del bus
     * @param origen de donde sale el bus
     * @param destino a donde llega el bus
     */
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
