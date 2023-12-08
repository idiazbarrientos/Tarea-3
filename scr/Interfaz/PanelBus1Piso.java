package Interfaz;

import Codigo.Asiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelBus1Piso extends JPanel {
        public PanelBus1Piso(){
            setLayout(new GridLayout(10, 0, 5, 5));
            int TotalAsientos = 14;
            ArrayList<JButton> array_botones = new ArrayList<>();

            for(int i=1; i<=TotalAsientos; i++){
                array_botones.add(new JButton(" "+i));
            }
            for(int i = 1; i <= TotalAsientos; i++) {
                //JButton btnAsiento = new JButton(" " + i);
                array_botones.get(i-1).setSize(50,50);
               // btnAsiento.setSize(50, 50);
                array_botones.get(i-1).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    }
                });
                this.add( array_botones.get(i-1));
                System.out.println("agregar botón " + i);
                this.revalidate();
                this.repaint();
                }
            }
}

