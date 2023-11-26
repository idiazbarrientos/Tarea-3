package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBus extends JPanel {
    private JMenu SeleccionHorarios;
    private JMenuBar BarraHorarios;
    private JToggleButton busUnPiso;
    private JToggleButton busDosPisos;
    private PanelBus1Piso panelBus1Piso;
    private PanelBus2Piso panelBus2Piso;
    public PanelBus(){
        ButtonGroup grupo = new ButtonGroup();

        busUnPiso = new JToggleButton("Bus de 1 piso");
        busUnPiso.setBounds(100,300,110,50);
        busDosPisos = new JToggleButton("Bus de 2 pisos");
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

        JButton EscogerAsiento = new JButton("Escoger Asiento");
        this.add(EscogerAsiento);
        EscogerAsiento.setBounds(100,600,150,50);
        EscogerAsiento.addActionListener(new PanelBus.EscogerAsientoteListener());


    }
    public void seleecionarTipoDeBus(){
        if(busUnPiso.isSelected()){
            panelBus1Piso = new PanelBus1Piso();
            this.add(panelBus1Piso);
        } else if (busDosPisos.isSelected()){
            panelBus2Piso = new PanelBus2Piso();
            this.add(panelBus2Piso);

        }
    }
    private class EscogerAsientoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seleecionarTipoDeBus();
        }
    }
}
