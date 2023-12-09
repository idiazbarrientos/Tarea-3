package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PipedOutputStream;
import java.util.ArrayList;
public class PanelBus2Piso extends JPanel {
    int indexida, indexvuelta;
    PanelBus panelBus;
    public PanelBus2Piso(int indexida, int indexvuelta, PanelBus panelBus){
        this.indexida = indexida;
        this.indexvuelta = indexvuelta;
        this.panelBus = panelBus;

        setLayout(new GridLayout(10,0,5,5));
        int AsientosPrimerPiso = 14;
        ArrayList<JButton> array_botones = new ArrayList<>();

        for(int i=1; i<=AsientosPrimerPiso; i++){
            array_botones.add(new JButton(" "+i));
        }
        for(int i = 1; i <= AsientosPrimerPiso; i++) {
            //JButton btnAsiento = new JButton(" " + i);
            array_botones.get(i-1).setSize(50,50);
            // btnAsiento.setSize(50, 50);
            array_botones.get(i-1).addActionListener(new ActionListener() {
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
            this.add( array_botones.get(i-1));
            System.out.println("agregar botón " + i);
            this.revalidate();
            this.repaint();
        }
    }
}
