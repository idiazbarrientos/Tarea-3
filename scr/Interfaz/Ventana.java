package Interfaz;

import javax.swing.*;

public class Ventana extends JFrame {

    Ventana (){
        super("Buscador De Buses");
        this.setSize(1920,1080);
        PanelElegirViaje PanelV = new PanelElegirViaje();
        this.add(PanelV);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);






    }
}

