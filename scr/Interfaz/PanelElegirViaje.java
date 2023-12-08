package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelElegirViaje extends JPanel {
    private JMenu SeleccionOrigen;
    private JMenu SeleccionDestino;
    private JMenuBar BarraOrigen;
    private JMenuBar BarraDestino;
    private JRadioButton ida;
    private JRadioButton vuelta;
    private PanelBus panelbus;





    public PanelElegirViaje() {
        this.setLayout(null);
        BarraOrigen opcion1 = new BarraOrigen("Concepcion");
        BarraOrigen opcion2 = new BarraOrigen("Santiago");
        BarraOrigen opcion3 = new BarraOrigen("Puerto Montt");

        BarraOrigen = new JMenuBar();
        BarraOrigen.setBounds(150, 300, 100, 50);
        this.add(BarraOrigen);
        SeleccionOrigen = new JMenu("Origen");
        SeleccionOrigen.add(opcion1.getItem());
        SeleccionOrigen.add(opcion2.getItem());
        SeleccionOrigen.add(opcion3.getItem());
        BarraOrigen.add(SeleccionOrigen);

        BarraDestino opcion4 = new BarraDestino("Concepcion");
        BarraDestino opcion5 = new BarraDestino("Santiago");
        BarraDestino opcion6 = new BarraDestino("Puerto Montt");

        BarraDestino = new JMenuBar();
        BarraDestino.setBounds(150, 400, 100, 50);
        this.add(BarraDestino);
        SeleccionDestino = new JMenu("Destino");
        SeleccionDestino.add(opcion4.getItem());
        SeleccionDestino.add(opcion5.getItem());
        SeleccionDestino.add(opcion6.getItem());
        BarraDestino.add(SeleccionDestino);

        JButton siguiente = new JButton("Siguiente");
        this.add(siguiente);
        siguiente.setBounds(150,600,100,100);
        siguiente.addActionListener(new siguienteListener());

        ButtonGroup grupo = new ButtonGroup();

        ida = new JRadioButton("Solo Ida");
        ida.setBounds(150, 450, 100, 100);
        vuelta = new JRadioButton("Ida y Vuelta");
        vuelta.setBounds(275, 450, 200, 100);

        grupo.add(ida);
        grupo.add(vuelta);

        this.add(ida);
        this.add(vuelta);

        this.setBackground(Color.CYAN);


    }
    public void seleccionarBus(){
        if(ida.isSelected() || vuelta.isSelected()) {
            panelbus = new PanelBus(this);
            this.add(panelbus);
            panelbus.setBounds(400,50,500,800);
            System.out.println("ola");
        }
    }


    private class siguienteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            seleccionarBus();
        }
    }
}
