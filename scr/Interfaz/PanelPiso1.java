package Interfaz;

import Codigo.BusDosPisos;
import Codigo.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelPiso1 extends JPanel {
    PanelBus panelBus;
    int indexida, indexvuelta;
    public PanelPiso1(int indexida, int indexvuelta, PanelBus panelBus){
        this.indexida = indexida;
        this.indexvuelta = indexvuelta;
        this.panelBus = panelBus;
        this.setLayout(new GridLayout(0,4));
        BusDosPisos busIda = (BusDosPisos) panelBus.busArrayList.get(indexida);
        int nAsientos = busIda.piso1.size();
        ArrayList<BotonAsientos> botonAsientosArrayList = new ArrayList<BotonAsientos>();
        for(int i = 0; i<nAsientos; i++){
            BotonAsientos asiento = new BotonAsientos(busIda.piso1.get(i));
            botonAsientosArrayList.add(asiento);
        }
        for(int i = 1; i<=nAsientos; i++){
            botonAsientosArrayList.get(i-1).setText(Integer.toString(i));
            Color color_fondo;
            if(botonAsientosArrayList.get(i-1).asiento.getType() == TipoAsiento.SALON_CAMA){
                color_fondo = Color.orange;
            }
            else{
                color_fondo = Color.pink;
            }
            botonAsientosArrayList.get(i-1).addActionListener(new ActionListener() {
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
            botonAsientosArrayList.get(i-1).setBackground(color_fondo);
            this.add(botonAsientosArrayList.get(i-1));
            this.revalidate();;
            this.repaint();
        }
    }
}
