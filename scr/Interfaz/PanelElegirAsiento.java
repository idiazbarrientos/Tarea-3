package Interfaz;

import Codigo.Bus;
import Codigo.BusUnPiso;
import Interfaz.ValorPago;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelElegirAsiento extends JPanel {

    PanelBus panelBus;
    int indexvuelta;
    JButton botonSiguiente;
    JButton botonComprar;

    /**
     *Aqui dependiendo de la seleccion del tipo de bus y si es ida o vuelta, se genera su respectivo panel de botones
     */
    public PanelElegirAsiento(int indexida, int indexvuelta, PanelBus panelBus) {
        this.removeAll();
        this.setLayout(null);
        this.panelBus=panelBus;
        this.indexvuelta = indexvuelta;
        Bus busIda = panelBus.busArrayList.get(indexida);
        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {
            PanelBus1Piso panel1piso = new PanelBus1Piso(indexida, panelBus);
            this.add(panel1piso);
            panel1piso.setBounds(10,10,240,480);
        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")) {
            PanelPiso1 panelpiso1 = new PanelPiso1(indexida, panelBus);
            this.add(panelpiso1);
            panelpiso1.setBounds(10, 10, 240, 480);
            PanelPiso2 panelpiso2 = new PanelPiso2(indexida, panelBus);
            this.add(panelpiso2);
            panelpiso2.setBounds(260, 10, 240, 480);
            System.out.println("Bus 2 Pisos");
        }
        if (indexvuelta != -1) {
            botonSiguiente = new JButton("Siguiente");
            this.add(botonSiguiente);
            botonSiguiente.setBounds(300, 510, 100, 40);
            botonSiguiente.addActionListener(new siguienteListener());
        }
        else{
            botonComprar = new JButton("Comprar");
            this.add(botonComprar);
            botonComprar.setBounds(300,510,100,40);
            botonComprar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updatePrecio();
                }
            });
        }
        this.revalidate();
        this.repaint();
    }
    public void dibujarBusVuelta(){
        if(indexvuelta != -1){
            Bus busVuelta = panelBus.busArrayList.get(indexvuelta);
            if(busVuelta.getClass().getSimpleName().equals("BusUnPiso")){
                PanelBus1Piso panelBus1Piso = new PanelBus1Piso(indexvuelta, panelBus);
                this.add(panelBus1Piso);
                panelBus1Piso.setBounds(10,10,240,480);
            }
            if(busVuelta.getClass().getSimpleName().equals("BusDosPisos")){
                PanelPiso1 panelPiso1 = new PanelPiso1(indexvuelta, panelBus);
                this.add(panelPiso1);
                panelPiso1.setBounds(10,10,240,480);
                PanelPiso2 panelPiso2 = new PanelPiso2(indexvuelta, panelBus);
                this.add(panelPiso2);
                panelPiso2.setBounds(260,10,240,480);
            }
        }
        botonComprar = new JButton("Comprar");
        this.add(botonComprar);
        botonComprar.setBounds(300,510,100,40);
        this.revalidate();
        this.repaint();
    }
    public void borrarAsientos(){
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    private class siguienteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            borrarAsientos();
            dibujarBusVuelta();
        }
    }
}
