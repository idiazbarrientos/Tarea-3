package Interfaz;

import Codigo.Asiento;
import Interfaz.ValorPago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAsientos extends JButton {
    Asiento asiento;

    /**
     *
     * @param asiento asiento al que se hace referencia como boton
     */
    public BotonAsientos(Asiento asiento) {
        this.asiento = asiento;
        setColor();

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (asiento.isSelect()) {
                    asiento.deselect();
                }
                setColor();
                ValorPago.getInstance().updatePrecio();
            }

        });

        this.setVisible(true);
    }
/**
 * El cambio de color que se realiza al momento de seleccionar o comprar un asiento/boton
 */
    void setColor() {
        if (asiento.isSelect()) {
            this.setBackground(Color.BLUE);
            return;
        }
        if (asiento.isComprado()) {
            this.setBackground(Color.RED);
            return;
        }
    }
}