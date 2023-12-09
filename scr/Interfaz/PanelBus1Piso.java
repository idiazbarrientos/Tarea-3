package Interfaz;

import Codigo.Asiento;
import Codigo.Bus;
import Codigo.BusUnPiso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Codigo.TipoAsiento.SEMI_CAMA;

public class PanelBus1Piso extends JPanel {
    int busIndiceIda, busIndiceVuelta;
    PanelBus panelBus;
        public PanelBus1Piso(int busIndiceIda, int busIndiceVuelta, PanelBus panelBus){
            this.busIndiceIda = busIndiceIda;
            this.busIndiceVuelta = busIndiceVuelta;
            this.panelBus = panelBus;
            BusUnPiso ida = (BusUnPiso) panelBus.busArrayList.get(busIndiceIda);
            setLayout(new GridLayout(0, 4, 5, 5));
            ArrayList<BotonAsientos> array_botones = new ArrayList<>();

            for(int i = 1; i <= ida.asientoArrayList.size(); i++){
                array_botones.add(new BotonAsientos(ida.asientoArrayList.get(i-1)));
            }
            for(int i = 1; i <=ida.asientoArrayList.size(); i++) {
                array_botones.get(i-1).setPreferredSize(new Dimension(10,10));
                array_botones.get(i-1).setText(Integer.toString(i));
                Color color_fondo;

                if(array_botones.get(i-1).asiento.getType()==SEMI_CAMA){
                    color_fondo=Color.pink;
                }else{
                    color_fondo=Color.orange;
                }
                array_botones.get(i-1).setBackground(color_fondo);
                array_botones.get(i-1).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        if (btn.getBackground() == Color.GREEN) {
                            btn.setBackground(color_fondo); // Si está seleccionado, se deselecciona
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

