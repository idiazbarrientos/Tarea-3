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
    int n_salonc;
    int n_semic;

    ArrayList<BotonAsientos> asientos_seleccionados_ida= new ArrayList<>();
    ArrayList<BotonAsientos> asientos_resumen_compra_ida= new ArrayList<>();
    ArrayList<BotonAsientos> asientos_resumen_compra_vuelta= new ArrayList<>();
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
        asientos_resumen_compra_ida.clear();
        if(busIda.getClass().getSimpleName().equals("BusUnPiso"))
        {

            System.out.println("Bus 1 pisoo wiiii");
            for(int i = 0; i<panel1piso.array_botones.size(); i++){
                BotonAsientos boton = panel1piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    asientos_resumen_compra_ida.add(boton);
                }
            }
        }else if(busIda.getClass().getSimpleName()=="BusDosPisos"){
            for (int i = 0; i < panelpiso1.botonAsientosArrayList.size(); i++) {
                BotonAsientos boton = panelpiso1.botonAsientosArrayList.get(i);
                if (boton.asiento.isSelect()) {
                    asientos_resumen_compra_ida.add(boton);
                }
            }
            for (int i = 0; i < panelpiso2.botonAsientosArrayList.size(); i++) {
                BotonAsientos boton = panelpiso2.botonAsientosArrayList.get(i);
                if (boton.asiento.isSelect()) {
                    asientos_resumen_compra_ida.add(boton);
                }
            }
        }
        System.out.println("Asientos seleccionados: " +asientos_resumen_compra_ida.size());
            panelrcompra.removeAll();
            JLabel label_ida=new JLabel("Ida:");
            JLabel label_origen_i=new JLabel("Origen: "+busIda.getOrigen());
            JLabel label_destino_i = new JLabel("Destino: " + busIda.getDestino());
            n_salonc=0;
            n_semic=0;
            String numeros_salonc = "",numeros_semic="";
            for(int i=0; i<asientos_resumen_compra_ida.size(); i++){
                BotonAsientos asiento=asientos_resumen_compra_ida.get(i);
                if(asiento.asiento.getType()==TipoAsiento.SALON_CAMA){
                    numeros_salonc=numeros_salonc+asiento.asiento.getNumeroAsiento()+" ";
                    n_salonc+=1;
                }else{
                    numeros_semic=numeros_semic+asiento.asiento.getNumeroAsiento()+" ";
                    n_semic+=1;
                }

            }
                JLabel salon_cama_i=new JLabel("Salón Cama");
                JLabel nsac_i=new JLabel(Integer.toString(n_salonc));
                JLabel precio_u_sac_i=new JLabel("10000");
                JLabel num_asientos_sac_i=new JLabel(numeros_salonc);
                JLabel precio_total_sac_i=new JLabel(Integer.toString(n_salonc*10000));

                panelrcompra.add(label_ida);
                label_ida.setBounds(10,10,100,10);
                panelrcompra.add(label_origen_i);
                label_origen_i.setBounds(10,25,150,10);
                panelrcompra.add(label_destino_i);
                label_destino_i.setBounds(170,25,150,10);

                panelrcompra.add(salon_cama_i);
                salon_cama_i.setBounds(10,40,80,10);
                panelrcompra.add(nsac_i);
                nsac_i.setBounds(120,40,10,10);
                panelrcompra.add(precio_u_sac_i);
                precio_u_sac_i.setBounds(135,40,80,10);
                panelrcompra.add(num_asientos_sac_i);
                num_asientos_sac_i.setBounds(220,40,200,10);
                panelrcompra.add(precio_total_sac_i);
                precio_total_sac_i.setBounds(425,40,40,10);

        JLabel semi_cama_i=new JLabel("Semi-Cama");
        JLabel nsemic_i=new JLabel(Integer.toString(n_semic));
        JLabel precio_u_sec_i=new JLabel("8000");
        JLabel num_asientos_sec_i=new JLabel(numeros_semic);
        JLabel precio_total_sec_i=new JLabel(Integer.toString(n_semic*8000));

        panelrcompra.add(semi_cama_i);
        semi_cama_i.setBounds(10,55,80,10);
        panelrcompra.add(nsemic_i);
        nsemic_i.setBounds(120,55,10,10);
        panelrcompra.add(precio_u_sec_i);
        precio_u_sec_i.setBounds(135,55,80,10);
        panelrcompra.add(num_asientos_sec_i);
        num_asientos_sec_i.setBounds(220,55,200,10);
        panelrcompra.add(precio_total_sec_i);
        precio_total_sec_i.setBounds(425,55,40,10);


        if(indexvuelta!=-1){
            if(busVuelta.getClass().getSimpleName().equals("BusUnPiso")){
               if(panelBus1Piso!=null){
                   for(int i = 0; i<panelBus1Piso.array_botones.size(); i++){
                       BotonAsientos boton = panelBus1Piso.array_botones.get(i);
                       if(boton.asiento.isSelect()){
                           asientos_resumen_compra_vuelta.add(boton);
                       }
                   }
               }
            }else{
                if(panelPiso1!=null) {
                    for (int i = 0; i < panelPiso1.botonAsientosArrayList.size(); i++) {
                        BotonAsientos boton = panelPiso1.botonAsientosArrayList.get(i);
                        if (boton.asiento.isSelect()) {
                            asientos_resumen_compra_vuelta.add(boton);
                        }
                    }
                }
                if(panelPiso2!=null){
                    for(int i = 0; i<panelPiso2.botonAsientosArrayList.size(); i++){
                        BotonAsientos boton = panelPiso2.botonAsientosArrayList.get(i);
                        if(boton.asiento.isSelect()){
                            asientos_resumen_compra_vuelta.add(boton);
                        }
                    }
                }
            }
        }

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
