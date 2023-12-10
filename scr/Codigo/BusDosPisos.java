package Codigo;

import java.util.ArrayList;

/**
 * Representa los buses de dos pisos de un viaje
 */
public class BusDosPisos extends Bus{
    public ArrayList<Asiento> piso1 = new ArrayList<Asiento>();
    public ArrayList<Asiento> piso2 = new ArrayList<Asiento>();

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
