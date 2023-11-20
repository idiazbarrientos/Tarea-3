package Interfaz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelElegirViaje extends JPanel implements ActionListener {
    private JMenuBar SeleccionOrigen;
    private JMenuBar SeleccionDestino;
    private JMenu OpcionesOrigen;
    private JMenu OpcionesDestino;
    private JMenuItem opcion1, opcion2, opcion3, opcion4, opcion5, opcion6;

    public PanelElegirViaje(){
        SeleccionOrigen = new JMenuBar();
        SeleccionOrigen.setLayout(null);
        SeleccionOrigen.setBounds(120,120,100,50);
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


        SeleccionDestino = new JMenuBar();
        SeleccionDestino.setLayout(null);
        SeleccionDestino.setBounds(150,200,100,50);
        OpcionesDestino = new JMenu("Destino");
        opcion4 = new JMenuItem("Concepcion");
        opcion4.addActionListener(this);
        OpcionesDestino.add(opcion4);
        opcion5 = new JMenuItem("Puerto Montt");
        opcion5.addActionListener(this);
        OpcionesDestino.add(opcion5);
        opcion6 = new JMenuItem("Santiago");
        OpcionesDestino.add(opcion6);
        this.setLayout(null);
        this.add(SeleccionOrigen);
        this.add(SeleccionDestino);








    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
