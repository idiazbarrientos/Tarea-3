package Interfaz;

import javax.swing.*;

public class Ventana extends JFrame {

    Ventana (){
        super("Buscador De Buses");
        PanelElegirViaje PanelV = new PanelElegirViaje();
        this.setSize(1920,1080);
        this.add(PanelV);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

