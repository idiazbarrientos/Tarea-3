package Interfaz;

import Codigo.excepcioncustom;

import javax.swing.*;

public class Ventana extends JFrame {

    Ventana (){
        super("Buscador De Buses");
        this.setLayout(null);
        this.setSize(1920,1080);
        PanelElegirViaje PanelV = null;
        try {
            PanelV = new PanelElegirViaje();
        } catch (excepcioncustom e) {
            throw new RuntimeException(e);
        }
        PanelV.setBounds(0,0,1920,1000);
        this.add(PanelV);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);






    }
}

