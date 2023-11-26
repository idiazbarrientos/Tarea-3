package Interfaz;

import javax.swing.*;

public class PanelBus extends JPanel {
    private JMenu SeleccionHorarios;
    private JMenuBar BarraHorarios;
    public PanelBus(){
        ButtonGroup grupo = new ButtonGroup();

        JToggleButton busUnPiso = new JToggleButton("Bus de 1 piso");
        busUnPiso.setBounds(500,100,200,100);
        JToggleButton busDosPisos = new JToggleButton("Bus de 2 pisos");
        busDosPisos.setBounds(500,150,200,100);

        grupo.add(busUnPiso);
        grupo.add(busDosPisos);

        this.add(busUnPiso);
        this.add(busDosPisos);

        BarraHorarios opcion1 = new BarraHorarios("10:00 Am");
        BarraHorarios opcion2 = new BarraHorarios("15:00 Pm");
        BarraHorarios opcion3 = new BarraHorarios("22:00 Pm");

        BarraHorarios = new JMenuBar();
        BarraHorarios.setBounds(600,200,100,50);
        this.add(BarraHorarios);
        SeleccionHorarios = new JMenu("Origen");
        SeleccionHorarios.add(opcion1.getItem());
        SeleccionHorarios.add(opcion2.getItem());
        SeleccionHorarios.add(opcion3.getItem());
        BarraHorarios.add(SeleccionHorarios);


    }
}
