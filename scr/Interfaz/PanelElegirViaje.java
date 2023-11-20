package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelElegirViaje extends JFrame implements ActionListener {
    private JMenuBar SeleccionOrigen;
    private JMenuBar SeleccionDestino;
    private JMenu OpcionesOrigen;
    private JMenu OpcionesDestino;
    private JMenuItem opcion1, opcion2, opcion3, opcion4, opcion5, opcion6;

    public PanelElegirViaje(){
        SeleccionOrigen = new JMenuBar();
        SeleccionOrigen.setBounds(500,100,200,200);
        this.add(SeleccionOrigen);
        OpcionesOrigen = new JMenu("Origen");
        opcion1 = new JMenuItem("Concepcion");
        opcion1.addActionListener(this);
        OpcionesOrigen.add(opcion1);
        opcion2 = new JMenuItem("Puerto Montt");
        opcion2.addActionListener(this);
        OpcionesOrigen.add(opcion2);
        opcion3 = new JMenuItem("Santiago");
        opcion3.addActionListener(this);
        OpcionesOrigen.add(opcion3);

        SeleccionDestino =




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
