package Interfaz;

import Codigo.BusDosPisos;
import Codigo.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * Aqui se encuentran los botones que representan los asientos del piso1 del bus de 2 pisos
 */
public class PanelPiso1 extends JPanel {
    PanelBus panelBus;
    PanelElegirAsiento panelElegirAsiento;
    int indexida;
    public ArrayList<BotonAsientos> botonAsientosArrayList = new ArrayList<BotonAsientos>();
    public PanelPiso1(int indexida, PanelBus panelBus,PanelElegirAsiento panelelegirasiento){
        this.panelElegirAsiento=panelelegirasiento;
        this.indexida = indexida;
        this.panelBus = panelBus;
        this.setLayout(new GridLayout(0,4));
        BusDosPisos busIda = (BusDosPisos) panelBus.busArrayList.get(indexida);
        int nAsientos = busIda.piso1.size();

        for(int i = 0; i<nAsientos; i++){
            BotonAsientos asiento = new BotonAsientos(busIda.piso1.get(i));
            botonAsientosArrayList.add(asiento);
        }
        for(int i = 1; i<=nAsientos; i++) {
            botonAsientosArrayList.get(i - 1).setText(Integer.toString(i));
            Color color_fondo;
            if(botonAsientosArrayList.get(i - 1).asiento.isSelect()){
                color_fondo=Color.BLUE;
            }
            else if (botonAsientosArrayList.get(i - 1).asiento.isComprado()) {
                color_fondo = Color.red;
            } else if (botonAsientosArrayList.get(i - 1).asiento.getType() == TipoAsiento.SALON_CAMA) {
                color_fondo = Color.orange;
            } else {
                color_fondo = Color.pink;
            }
            botonAsientosArrayList.get(i - 1).setBackground(color_fondo);
            botonAsientosArrayList.get(i - 1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    BotonAsientos btn = (BotonAsientos) e.getSource();
                    if (btn.getBackground() == Color.GREEN) {
                        btn.deselectAsiento();
                        btn.setBackground(color_fondo); // Si está seleccionado, se deselecciona
                    } else if (!btn.asiento.isComprado()) {
                        btn.selectAsiento();
                        btn.setBackground(Color.GREEN); // Si no está seleccionado, se selecciona (cambia a verde)
                    }
                    panelElegirAsiento.updateResumenCompra();
                }
            });

            this.add(botonAsientosArrayList.get(i - 1));
            this.revalidate();
            ;
            this.repaint();
        }
    }

    /**
     * se refresca el panel de botones del piso1, manteniendo los asientos seleccionados
     * @param indexida
     * @param panelBus
     * @param panelElegirAsiento
     */
    public void refresh(int indexida,PanelBus panelBus,PanelElegirAsiento panelElegirAsiento){
        this.indexida=indexida;
        this.panelBus=panelBus;
        this.panelElegirAsiento = panelElegirAsiento;

        this.removeAll();
        botonAsientosArrayList = new ArrayList<BotonAsientos>();
        BusDosPisos busIda = (BusDosPisos) panelBus.busArrayList.get(indexida);
        int nAsientos = busIda.piso1.size();

        for(int i = 0; i<nAsientos; i++){
            BotonAsientos asiento = new BotonAsientos(busIda.piso1.get(i));
            botonAsientosArrayList.add(asiento);
        }
        for(int i = 1; i<=nAsientos; i++) {
            botonAsientosArrayList.get(i - 1).setText(Integer.toString(i));
            Color color_fondo;
            if(botonAsientosArrayList.get(i-1).asiento.isSelect()){
                color_fondo = Color.BLUE;
            }
            else if (botonAsientosArrayList.get(i - 1).asiento.isComprado()) {
                color_fondo = Color.red;
            } else if (botonAsientosArrayList.get(i - 1).asiento.getType() == TipoAsiento.SALON_CAMA) {
                color_fondo = Color.orange;
            } else {
                color_fondo = Color.pink;
            }
            botonAsientosArrayList.get(i - 1).setBackground(color_fondo);
            botonAsientosArrayList.get(i - 1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    BotonAsientos btn = (BotonAsientos) e.getSource();
                    if (btn.getBackground() == Color.GREEN) {
                        btn.deselectAsiento();
                        btn.setBackground(color_fondo); // Si está seleccionado, se deselecciona
                    } else if (!btn.asiento.isComprado()) {
                        btn.selectAsiento();
                        btn.setBackground(Color.GREEN); // Si no está seleccionado, se selecciona (cambia a verde)
                    }
                    panelElegirAsiento.updateResumenCompra();
                }
            });

            this.add(botonAsientosArrayList.get(i - 1));
            this.revalidate();
            this.repaint();
        }
    }
}
