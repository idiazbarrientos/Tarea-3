package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBus1Piso extends JPanel {
        public PanelBus1Piso(){
            setLayout(new GridLayout(0, 1, 5, 5));
            int TotalAsientos = 10;
            for(int i = 1; i <= TotalAsientos; i++){
                JButton btnAsiento = new JButton(" " + i);
                btnAsiento.setPreferredSize(new Dimension(50, 10));
                btnAsiento.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        if (btn.getBackground() == Color.GREEN) {
                            btn.setBackground(null); // Si está seleccionado, se deselecciona
                        } else {
                            btn.setBackground(Color.GREEN); // Si no está seleccionado, se selecciona (cambia a verde)
                        }
                    }
                });
                this.add(btnAsiento);
                }
            }
}

