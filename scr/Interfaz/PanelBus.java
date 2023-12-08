package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBus extends JPanel {
    private JMenu SeleccionHorarios;
    private JMenuBar BarraHorarios;
    private JToggleButton busUnPiso;
    private JToggleButton busDosPisos;
    private PanelBus1Piso panelBus1Piso;
    private PanelBus2Piso panelBus2Piso;
    private JRadioButton temprano;
    private JRadioButton tarde;
    private JRadioButton noche;
    private PanelElegirViaje panelElegirViaje;
    public PanelBus(PanelElegirViaje panelElegirViaje){
        ButtonGroup grupo = new ButtonGroup();
        this.setLayout(null);
        this.panelElegirViaje = panelElegirViaje;
        busUnPiso = new JToggleButton("Bus de 1 piso");
        busUnPiso.setBounds(100,300,150,50);
        busDosPisos = new JToggleButton("Bus de 2 pisos");
        busDosPisos.setBounds(100,200,150,50);

        grupo.add(busUnPiso);
        grupo.add(busDosPisos);

        this.add(busUnPiso);
        this.add(busDosPisos);

        ButtonGroup group = new ButtonGroup();

        temprano = new JRadioButton("10:00 am");
        temprano.setBounds(100, 500, 100, 50);
        tarde = new JRadioButton("16:00 pm");
        tarde.setBounds(100, 450, 100, 50);
        noche = new JRadioButton("22:00 pm");
        noche.setBounds(100,400,100,50);

        group.add(temprano);
        group.add(tarde);
        group.add(noche);


        this.add(temprano);
        this.add(tarde);
        this.add(noche);

        JButton EscogerAsiento = new JButton("Escoger Asiento");
        this.add(EscogerAsiento);
        EscogerAsiento.setBounds(100,600,150,50);
        EscogerAsiento.addActionListener(new PanelBus.EscogerAsientoteListener());
        this.setBackground(Color.BLUE);

    }
    public void seleecionarTipoDeBus(){
        if(busUnPiso.isSelected()){
            panelBus1Piso = new PanelBus1Piso();
            panelElegirViaje.add(panelBus1Piso);
            panelBus1Piso.setBounds(910,50,500,800);
            panelBus1Piso.setBackground(Color.red);
            panelElegirViaje.repaint();
            panelElegirViaje.revalidate();
            System.out.println("ola");
        } else if (busDosPisos.isSelected()){
            JButton Piso2 = new JButton("Piso2");
            JButton Piso1 = new JButton("Piso1");
            Piso2.setBounds(1150,3,150,50);
            Piso1.setBounds(1000,3,150,50);
            panelBus2Piso = new PanelBus2Piso();
            panelElegirViaje.add(panelBus2Piso);
            panelBus2Piso.setBounds(910,50,500,800);
            panelBus2Piso.setBackground(Color.pink);
            panelElegirViaje.repaint();
            panelElegirViaje.revalidate();
            panelElegirViaje.add(Piso1);
            panelElegirViaje.add(Piso2);
        }
    }
    private class EscogerAsientoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seleecionarTipoDeBus();
        }
    }
}
