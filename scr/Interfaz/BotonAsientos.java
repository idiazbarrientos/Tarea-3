package Interfaz;

import Codigo.Asiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonAsientos extends JButton {
    Asiento asiento;

    public BotonAsientos(Asiento asiento) {
        this.asiento = asiento;
        setColor();

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (asiento.isSelect()) {
                    asiento.deselect();
                }

            }
        });

    }

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