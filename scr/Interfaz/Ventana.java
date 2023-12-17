package Interfaz;

import Codigo.NoIdaNoVueltaException;

import javax.swing.*;

public class Ventana extends JFrame {

    Ventana (){
        super("Buscador De Buses");
        this.setLayout(null);
        this.setSize(1920,1080);
        PanelElegirViaje PanelV = null;
        PanelV = new PanelElegirViaje();
        PanelV.setBounds(0,0,1920,1000);
        this.add(PanelV);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);






    }
}

