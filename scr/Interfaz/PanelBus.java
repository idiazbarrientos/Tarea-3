package Interfaz;

import javax.swing.*;

public class PanelBus extends JPanel {
    private JMenu SeleccionHorarios;
    private JMenuBar BarraHorarios;
    public PanelBus(){
        ButtonGroup grupo = new ButtonGroup();

        JToggleButton busUnPiso = new JToggleButton("Bus de 1 piso");
        busUnPiso.setBounds(100,300,110,50);
        JToggleButton busDosPisos = new JToggleButton("Bus de 2 pisos");
        busDosPisos.setBounds(100,200,110,50);

        grupo.add(busUnPiso);
        grupo.add(busDosPisos);

        this.add(busUnPiso);
        this.add(busDosPisos);

        BarraHorarios opc1 = new BarraHorarios("10:00 Am");
        BarraHorarios opc2 = new BarraHorarios("15:00 Pm");
        BarraHorarios opc3 = new BarraHorarios("22:00 Pm");

        BarraHorarios = new JMenuBar();
        BarraHorarios.setBounds(100,425,150,100);
        this.add(BarraHorarios);
        SeleccionHorarios = new JMenu("Horarios");
        SeleccionHorarios.add(opc1.getItem());
        SeleccionHorarios.add(opc2.getItem());
        SeleccionHorarios.add(opc3.getItem());
        BarraHorarios.add(SeleccionHorarios);


    }
}
