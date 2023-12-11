package Interfaz;

import Codigo.Asiento;
import Codigo.Bus;
import Codigo.TipoAsiento;
import Codigo.BusUnPiso;
import Interfaz.ValorPago;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelElegirAsiento extends JPanel {

    PanelBus panelBus;
    int indexida, indexvuelta;
    JButton botonSiguiente;
    JButton botonComprar;

    PanelPiso1 panelpiso1,panelPiso1;

    PanelPiso2 panelpiso2,panelPiso2;

    PanelBus1Piso panel1piso;
    PanelBus1Piso panelBus1Piso;

    PanelResumenCompra panelrcompra;
    Bus busIda,busVuelta;

    ArrayList<BotonAsientos> asientos_seleccionados_ida= new ArrayList<>();
    ArrayList<BotonAsientos> asientos_seleccionados_vuelta;
    /**
     *Aqui dependiendo de la seleccion del tipo de bus y si es ida o vuelta, se genera su respectivo panel de botones
     */
    public PanelElegirAsiento(int indexida, int indexvuelta, PanelBus panelBus) {
        this.setLayout(null);

        this.removeAll();
        this.revalidate();
        this.repaint();


        this.panelBus=panelBus;
        this.indexvuelta = indexvuelta;
        this.indexida=indexida;



        busIda = panelBus.busArrayList.get(indexida);
        if(indexvuelta!=-1) {
            busVuelta = panelBus.busArrayList.get(indexvuelta);
        }

        System.out.println(busIda.getClass().getSimpleName());
        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {

            this.revalidate();
            this.repaint();
            panel1piso=new PanelBus1Piso(indexida,panelBus,this);
            this.add(panel1piso);
            panel1piso.setBounds(10,10,240,480);
            this.revalidate();
            this.repaint();

        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")) {

            panelpiso1 = new PanelPiso1(indexida, panelBus,this);
            this.add(panelpiso1);
            panelpiso1.setBounds(10, 10, 240, 480);
            panelpiso2 = new PanelPiso2(indexida, panelBus,this);
            this.add(panelpiso2);
            panelpiso2.setBounds(260, 10, 240, 480);
            this.revalidate();
            this.repaint();
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
            botonComprar.addActionListener(new comprarListener());
        }

        panelrcompra=new PanelResumenCompra();
        this.add(panelrcompra);
        panelrcompra.setBackground(new Color(96, 169, 224));
        panelrcompra.setBounds(10,570,600,200);
    }
    public void dibujarBusVuelta(){
        if(indexvuelta != -1){
            Bus busVuelta = panelBus.busArrayList.get(indexvuelta);
            if(busVuelta.getClass().getSimpleName().equals("BusUnPiso")){
                panelBus1Piso = new PanelBus1Piso(indexvuelta, panelBus,this);
                this.add(panelBus1Piso);
                panelBus1Piso.setBounds(10,10,240,480);
            }
            if(busVuelta.getClass().getSimpleName().equals("BusDosPisos")){
                panelPiso1 = new PanelPiso1(indexvuelta, panelBus,this);
                this.add(panelPiso1);
                panelPiso1.setBounds(10,10,240,480);
                panelPiso2 = new PanelPiso2(indexvuelta, panelBus,this);
                this.add(panelPiso2);
                panelPiso2.setBounds(260,10,240,480);
            }
        }
        botonComprar = new JButton("Comprar");
        this.add(botonComprar);
        botonComprar.setBounds(300,510,100,40);
        botonComprar.addActionListener(new comprarListener2());
        this.revalidate();
        this.repaint();


    }
    public void borrarAsientos(){
        this.removeAll();
        this.add(panelrcompra);
        this.revalidate();
        this.repaint();
    }
    public void guardarAsientosSeleccionados(){
        asientos_seleccionados_ida.clear();
        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {
            for(int i = 0; i<panel1piso.array_botones.size(); i++){
                BotonAsientos boton = panel1piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    asientos_seleccionados_ida.add(boton);
                }
            }
        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")){
            for(int i = 0; i<panelpiso1.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelpiso1.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    asientos_seleccionados_ida.add(boton);
                }
            }
            for(int i = 0; i<panelpiso2.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelpiso2.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    asientos_seleccionados_ida.add(boton);
                }
            }
        }
    }
    public void comprarAsientosIda(){
        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {
            for(int i = 0; i<panel1piso.array_botones.size(); i++){

                System.out.println(i+" "+ panel1piso.array_botones.get(i).asiento.isSelect());
                BotonAsientos boton = panel1piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    boton.asiento.comprar();
                    System.out.println(panel1piso.array_botones.get(i).asiento.isComprado());
                }
            }
            panel1piso.repaint();
            panel1piso.refresh();
        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")){
            for(int i = 0; i<panelpiso1.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelpiso1.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    boton.asiento.comprar();
                }
            }
            panelpiso1.repaint();
            panelpiso1.refresh();
            for(int i = 0; i<panelpiso2.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelpiso2.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    boton.asiento.comprar();
                }
            }
            panelpiso2.repaint();
            panelpiso2.refresh();
        }
        this.repaint();


    }

    public void comprarAsientosVuelta(){
        System.out.println("Comprar vuelta");
        if(busVuelta.getClass().getSimpleName().equals("BusUnPiso")) {
            for(int i = 0; i<panelBus1Piso.array_botones.size(); i++){

                System.out.println(i+" "+ panelBus1Piso.array_botones.get(i).asiento.isSelect());
                BotonAsientos boton = panelBus1Piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    boton.asiento.comprar();
                    System.out.println(panelBus1Piso.array_botones.get(i).asiento.isComprado());
                }
            }
            panelBus1Piso.repaint();
            panelBus1Piso.refresh();
        }
        if(busVuelta.getClass().getSimpleName().equals(("BusDosPisos"))){
            for(int i = 0; i<panelPiso1.botonAsientosArrayList.size(); i++){
                System.out.println(i+" "+ panelPiso1.botonAsientosArrayList.get(i).asiento.isSelect());
                BotonAsientos boton = panelPiso1.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    boton.asiento.comprar();
                }
            }
            for(int i = 0; i<panelPiso2.botonAsientosArrayList.size(); i++){
                System.out.println(i+" "+ panelPiso2.botonAsientosArrayList.get(i).asiento.isSelect());
                BotonAsientos boton = panelPiso2.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    boton.asiento.comprar();
                }
            }
            panelPiso1.repaint();
            panelPiso1.refresh();
            panelPiso2.repaint();
            panelPiso2.refresh();
        }
        System.out.println(asientos_seleccionados_ida);
        System.out.println(indexida);
        System.out.println(indexvuelta);

        for(int i=0; i<asientos_seleccionados_ida.size(); i++){
            BotonAsientos boton = asientos_seleccionados_ida.get(i);
            boton.asiento.comprar();
        }

        this.repaint();
    }


    public void updateResumenCompra(){

    }
    private class siguienteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            guardarAsientosSeleccionados();
            borrarAsientos();
            dibujarBusVuelta();


        }
    }
    private class comprarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            comprarAsientosIda();
        }
    }
    private class comprarListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            comprarAsientosVuelta();
        }
    }
}
