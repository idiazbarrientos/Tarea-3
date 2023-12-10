package Interfaz;

import Codigo.Bus;
import Codigo.BusUnPiso;

import javax.swing.*;

public class PanelElegirAsiento extends JPanel {

    PanelBus panelBus;

    /**
     *Aqui dependiendo de la seleccion del tipo de bus y si es ida o vuelta, se genera su respectivo panel de botones
     */
    public PanelElegirAsiento(int indexida, int indexvuelta, PanelBus panelBus) {
        this.setLayout(null);
        this.panelBus=panelBus;
        Bus busIda = panelBus.busArrayList.get(indexida);
        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {
            PanelBus1Piso panel1piso = new PanelBus1Piso(indexida, indexvuelta, panelBus);
            this.add(panel1piso);
            panel1piso.setBounds(10,10,240,480);
        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")){
            PanelPiso1 panelpiso1 = new PanelPiso1(indexida, indexvuelta, panelBus);
            this.add(panelpiso1);
            panelpiso1.setBounds(10,10,240,480);
            PanelPiso2 panelpiso2 = new PanelPiso2(indexida, indexvuelta, panelBus);
            this.add(panelpiso2);
            panelpiso2.setBounds(260,10,240,480);
            System.out.println("Bus 2 Pisos");
        }

    }
}
