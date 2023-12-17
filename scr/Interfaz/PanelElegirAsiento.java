package Interfaz;

import Codigo.AsientoNoSeleccionadoException;
import Codigo.Bus;
import Codigo.TipoAsiento;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Panel en donde dependiendo de la seleccion de los buses para la ida y vuelta, se crean los botones que representa los asientos
 *
 */
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
    int n_salonc,n_salonc_v;
    int n_semic,n_semic_v;

    ArrayList<BotonAsientos> asientos_seleccionados_ida= new ArrayList<>();
    ArrayList<BotonAsientos> asientos_resumen_compra_ida= new ArrayList<>();
    ArrayList<BotonAsientos> asientos_resumen_compra_vuelta= new ArrayList<>();

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

    /**
     * se registran los asientos seleccioandos que ya han sido comprados en los buses
     */
    public void guardarAsientosSeleccionados() throws AsientoNoSeleccionadoException {
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
        if(asientos_seleccionados_ida.isEmpty()){
            throw new AsientoNoSeleccionadoException("Debe seleccionar al menos un asiento");
        }
    }

    /**
     * Dependiendo del bus que se selecciona, se genera la compra de los paneles de asientos respectivos a cada tipo de bus de ida
     */
    public void comprarAsientosIda() throws AsientoNoSeleccionadoException {
        boolean seleccionado=false;
        System.out.println(indexida);
        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {
            for(int i = 0; i<panel1piso.array_botones.size(); i++){

                BotonAsientos boton = panel1piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    seleccionado=true;
                    boton.asiento.comprar();
                }
            }
            panel1piso.repaint();
            panel1piso.refresh(indexida,panelBus,this);
        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")){
            for(int i = 0; i<panelpiso1.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelpiso1.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    seleccionado=true;
                    boton.asiento.comprar();
                }
            }
            panelpiso1.repaint();
            panelpiso1.refresh(indexida,panelBus,this);
            for(int i = 0; i<panelpiso2.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelpiso2.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    seleccionado=true;
                    boton.asiento.comprar();
                }
            }
            panelpiso2.repaint();
            panelpiso2.refresh(indexida,panelBus,this);
        }
        if(!seleccionado){
            throw new AsientoNoSeleccionadoException("Debe seleccionar al menos un asiento");
        }
        this.setVisible(false);
        this.removeAll();
        this.repaint();
    }
    /**
     * Dependiendo del bus que se selecciona, se genera la compra de los paneles de asientos respectivos a cada tipo de bus de vuelta
     */
    public void comprarAsientosVuelta() throws AsientoNoSeleccionadoException {
        boolean seleccionado = false;
        if(busVuelta.getClass().getSimpleName().equals("BusUnPiso")) {
            for(int i = 0; i<panelBus1Piso.array_botones.size(); i++){
                BotonAsientos boton = panelBus1Piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    seleccionado = true;
                    boton.asiento.comprar();
                }
            }
            panelBus1Piso.repaint();
            panelBus1Piso.refresh(indexida,panelBus,this);
        }
        if(busVuelta.getClass().getSimpleName().equals(("BusDosPisos"))){
            for(int i = 0; i<panelPiso1.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelPiso1.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    seleccionado = true;
                    boton.asiento.comprar();
                }
            }
            for(int i = 0; i<panelPiso2.botonAsientosArrayList.size(); i++){
                BotonAsientos boton = panelPiso2.botonAsientosArrayList.get(i);
                if(boton.asiento.isSelect()){
                    seleccionado = true;
                    boton.asiento.comprar();
                }
            }
            panelPiso1.repaint();
            panelPiso1.refresh(indexvuelta,panelBus,this);
            panelPiso2.repaint();
            panelPiso2.refresh(indexvuelta,panelBus,this);
        }
        if(!seleccionado){
            throw new AsientoNoSeleccionadoException("Debe seleccionar por lo menos un asiento");
        }
        for(int i=0; i<asientos_seleccionados_ida.size(); i++){
            BotonAsientos boton = asientos_seleccionados_ida.get(i);
            boton.asiento.comprar();
        }

        this.setVisible(false);
        this.removeAll();
        this.repaint();
    }

    /**
     * aqui es donde dependiendo de los precios y la seleccion del asiento, se actualiza el panel que entrega el precio a pagar
     * funciona para que reconozca a que bus se esta seleccionando junto con sus datos como horario de salida, si es de ida o vuelta y su numero de asiento
     */
    public void updateResumenCompra(){
        asientos_resumen_compra_ida.clear();
        asientos_resumen_compra_vuelta.clear();
        if(busIda.getClass().getSimpleName().equals("BusUnPiso"))
        {

            for(int i = 0; i<panel1piso.array_botones.size(); i++){
                BotonAsientos boton = panel1piso.array_botones.get(i);
                if(boton.asiento.isSelect()){
                    asientos_resumen_compra_ida.add(boton);
                }
            }
        }else if(busIda.getClass().getSimpleName().equals("BusDosPisos")){
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
            panelrcompra.removeAll();
            JLabel label_ida=new JLabel("Ida:");
            JLabel label_origen_i=new JLabel("Origen: "+busIda.getOrigen());
            JLabel label_destino_i = new JLabel("Destino: " + busIda.getDestino());
            JLabel label_fecha_i=new JLabel(busIda.getDia()+"-"+busIda.getMes()+"-"+busIda.getAnho());
            JLabel label_hora_i=new JLabel(busIda.getHora());
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
                panelrcompra.add(label_fecha_i);
                label_fecha_i.setBounds(325,25,80,10);
                panelrcompra.add(label_hora_i);
                label_hora_i.setBounds(410,25,150,10);

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
        precio_total_sec_i.setBounds(425,55,80,10);


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
            JLabel label_vuelta=new JLabel("Vuelta:");
            JLabel label_origen_v=new JLabel("Origen: "+busVuelta.getOrigen());
            JLabel label_destino_v = new JLabel("Destino: " + busVuelta.getDestino());
            JLabel label_fecha_v=new JLabel(busVuelta.getDia()+"-"+busVuelta.getMes()+"-"+busVuelta.getAnho());
            JLabel label_hora_v=new JLabel(busVuelta.getHora());
            n_salonc_v=0;
            n_semic_v=0;
            String numeros_salonc_v = "",numeros_semic_v="";
            for(int i=0; i<asientos_resumen_compra_vuelta.size(); i++){
                BotonAsientos asiento=asientos_resumen_compra_vuelta.get(i);
                if(asiento.asiento.getType()==TipoAsiento.SALON_CAMA){
                    numeros_salonc_v=numeros_salonc_v+asiento.asiento.getNumeroAsiento()+" ";
                    n_salonc_v+=1;
                }else{
                    numeros_semic_v=numeros_semic_v+asiento.asiento.getNumeroAsiento()+" ";
                    n_semic_v+=1;
                }

            }
            JLabel salon_cama_v=new JLabel("Salón Cama");
            JLabel nsac_v=new JLabel(Integer.toString(n_salonc_v));
            JLabel precio_u_sac_v=new JLabel("10000");
            JLabel num_asientos_sac_v=new JLabel(numeros_salonc_v);
            JLabel precio_total_sac_v=new JLabel(Integer.toString(n_salonc_v*10000));


            panelrcompra.add(label_vuelta);
            label_vuelta.setBounds(10,70,100,10);
            panelrcompra.add(label_origen_v);
            label_origen_v.setBounds(10,85,150,10);
            panelrcompra.add(label_destino_v);
            label_destino_v.setBounds(170,85,150,10);
            panelrcompra.add(label_fecha_v);
            label_fecha_v.setBounds(325,85,80,10);
            panelrcompra.add(label_hora_v);
            label_hora_v.setBounds(410,85,150,10);

            panelrcompra.add(salon_cama_v);
            salon_cama_v.setBounds(10,100,80,10);
            panelrcompra.add(nsac_v);
            nsac_v.setBounds(120,100,10,10);
            panelrcompra.add(precio_u_sac_v);
            precio_u_sac_v.setBounds(135,100,80,10);
            panelrcompra.add(num_asientos_sac_v);
            num_asientos_sac_v.setBounds(220,100,200,10);
            panelrcompra.add(precio_total_sac_v);
            precio_total_sac_v.setBounds(425,100,40,10);

            JLabel semi_cama_v=new JLabel("Semi-Cama");
            JLabel nsemic_v=new JLabel(Integer.toString(n_semic_v));
            JLabel precio_u_sec_v=new JLabel("8000");
            JLabel num_asientos_sec_v=new JLabel(numeros_semic_v);
            JLabel precio_total_sec_v=new JLabel(Integer.toString(n_semic_v*8000));

            panelrcompra.add(semi_cama_v);
            semi_cama_v.setBounds(10,115,80,10);
            panelrcompra.add(nsemic_v);
            nsemic_v.setBounds(120,115,10,10);
            panelrcompra.add(precio_u_sec_v);
            precio_u_sec_v.setBounds(135,115,80,10);
            panelrcompra.add(num_asientos_sec_v);
            num_asientos_sec_v.setBounds(220,115,200,10);
            panelrcompra.add(precio_total_sec_v);
            precio_total_sec_v.setBounds(425,115,40,10);

        }
        JLabel preciototal=new JLabel("Precio Total=" + ((n_salonc + n_salonc_v) * 10000 + (n_semic_v + n_semic) * 8000));
        panelrcompra.add(preciototal);
        preciototal.setBounds(400,130,150,20);

    }

    /**
     * refresca los paneles de el resumen de la compra, el de seleccion de asiento y de bus para otra compra
     * @param indexida
     * @param indexvuelta
     * @param panelBus
     */
    public void refresh(int indexida,int indexvuelta,PanelBus panelBus){
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

        if(busIda.getClass().getSimpleName().equals("BusUnPiso")) {

            this.revalidate();
            this.repaint();
            if(panel1piso==null){
                panel1piso=new PanelBus1Piso(indexida,panelBus,this);
                this.add(panel1piso);
                panel1piso.setBounds(10,10,240,480);
                this.revalidate();
                this.repaint();
            }else{
                this.remove(panel1piso);
                this.add(panel1piso);
                panel1piso.refresh(indexida,panelBus,this);
                panel1piso.revalidate();
                panel1piso.repaint();
                this.revalidate();
                this.repaint();
            }



        }
        if(busIda.getClass().getSimpleName().equals("BusDosPisos")) {
            if(panelpiso1==null) {
                panelpiso1 = new PanelPiso1(indexida, panelBus,this);
                this.add(panelpiso1);
                panelpiso1.setBounds(10, 10, 240, 480);
            }else{
                this.remove(panelpiso1);
                this.add(panelpiso1);
                panelpiso1.refresh(indexida,panelBus,this);
                panelpiso1.revalidate();
                panelpiso1.repaint();
                this.revalidate();
                this.repaint();
            }
            if(panelpiso2==null) {
                panelpiso2 = new PanelPiso2(indexida, panelBus,this);
                this.add(panelpiso2);
                panelpiso2.setBounds(10, 10, 240, 480);
            }else{

                panelpiso2.refresh(indexida,panelBus,this);
                this.remove(panelpiso2);
                this.add(panelpiso2);
                panelpiso2.revalidate();
                panelpiso2.repaint();
                this.revalidate();
                this.repaint();
            }

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
    private class siguienteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                guardarAsientosSeleccionados();
                borrarAsientos();
                dibujarBusVuelta();
            } catch (AsientoNoSeleccionadoException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    private class comprarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                comprarAsientosIda();
                panelBus.setVisible(false);
            } catch (AsientoNoSeleccionadoException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    private class comprarListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                comprarAsientosVuelta();
                panelBus.setVisible(false);
            } catch (AsientoNoSeleccionadoException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
