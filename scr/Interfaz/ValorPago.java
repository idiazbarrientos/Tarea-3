package Interfaz;

import Codigo.Viaje;

import javax.swing.*;

public class ValorPago extends JPanel {
    private static ValorPago instance;

    private ValorPago() {

    }

    public static ValorPago getInstance() {
        if (instance == null) {
            instance = new ValorPago();
        }
        return instance;
    }

    public void updatePrecio() {
        this.updateUI();
        JLabel total = new JLabel("Precio Total : $");//aqui poner el valor de precio de los asientos)
    }


}
