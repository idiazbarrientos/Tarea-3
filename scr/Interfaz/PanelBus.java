package Interfaz;

import Codigo.Bus;
import Codigo.BusDosPisos;
import Codigo.BusUnPiso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelBus extends JPanel {
    private JMenu SeleccionHorarios;
    private JMenuBar BarraHorarios;
    private JToggleButton busUnPiso;
    private JToggleButton busDosPisos;

    private JToggleButton busUnPiso2;
    private JToggleButton busDosPisos2;
    private PanelBus1Piso panelBus1Piso;
    private PanelBus2Piso panelBus2Piso;
    private JRadioButton temprano;
    private JRadioButton tarde;
    private JRadioButton noche;
    private JRadioButton tempranoVuelta;
    private JRadioButton tardeVuelta;
    private JRadioButton nocheVuelta;
    private ArrayList<Bus> busArrayList = new ArrayList<Bus>();
    private PanelElegirViaje panelElegirViaje;
    private String diaIda;
    private String mesIda;
    private String anhoIda;
    private String diaVuelta;
    private String mesVuelta;
    private String anhoVuelta;
    private String horarioIda;

    private String origen;
    private String destino;
    private String horarioVuelta;
    public PanelBus(PanelElegirViaje panelElegirViaje){

        origen=panelElegirViaje.origen;
        destino=panelElegirViaje.destino;

        ButtonGroup grupo = new ButtonGroup();
        this.setLayout(null);
        this.panelElegirViaje = panelElegirViaje;
        diaIda = panelElegirViaje.diaIda;
        mesIda = panelElegirViaje.mesIda;
        anhoIda = panelElegirViaje.anhoIda;
        diaVuelta = panelElegirViaje.diaVuelta;
        mesVuelta = panelElegirViaje.mesVuelta;
        anhoVuelta = panelElegirViaje.anhoVuelta;
        busUnPiso = new JToggleButton("Bus de 1 piso");
        busUnPiso.setBounds(100,300,150,50);
        busDosPisos = new JToggleButton("Bus de 2 pisos");
        busDosPisos.setBounds(100,200,150,50);

        grupo.add(busUnPiso);
        grupo.add(busDosPisos);

        this.add(busUnPiso);
        this.add(busDosPisos);

        ButtonGroup group = new ButtonGroup();

        temprano = new JRadioButton("10:00 am");
        temprano.setBounds(100, 400, 100, 50);
        tarde = new JRadioButton("16:00 pm");
        tarde.setBounds(100, 450, 100, 50);
        noche = new JRadioButton("22:00 pm");
        noche.setBounds(100,500,100,50);

        group.add(temprano);
        group.add(tarde);
        group.add(noche);


        this.add(temprano);
        this.add(tarde);
        this.add(noche);
        temprano.addActionListener(new idaListener());
        tarde.addActionListener(new idaListener());
        noche.addActionListener(new idaListener());

        JButton EscogerAsiento = new JButton("Escoger Asiento");
        this.add(EscogerAsiento);
        EscogerAsiento.setBounds(100,600,150,50);
        EscogerAsiento.addActionListener(new PanelBus.EscogerAsientoteListener());
        this.setBackground(Color.BLUE);
        if(diaVuelta != null && mesVuelta != null && anhoVuelta != null){
            tempranoVuelta = new JRadioButton("10:00 am");
            tempranoVuelta.setBounds(200, 400, 100, 50);
            tardeVuelta = new JRadioButton("16:00 pm");
            tardeVuelta.setBounds(200, 450, 100, 50);
            nocheVuelta = new JRadioButton("22:00 pm");
            nocheVuelta.setBounds(200,500,100,50);
            ButtonGroup group2 = new ButtonGroup();
            group2.add(tempranoVuelta);
            group2.add(tardeVuelta);
            group2.add(nocheVuelta);


            this.add(tempranoVuelta);
            this.add(tardeVuelta);
            this.add(nocheVuelta);
            tempranoVuelta.addActionListener(new vueltaListener());
            tardeVuelta.addActionListener(new vueltaListener());
            nocheVuelta.addActionListener(new vueltaListener());

            busUnPiso2 = new JToggleButton("Bus de 1 piso");
            busUnPiso2.setBounds(300,300,150,50);
            busDosPisos2 = new JToggleButton("Bus de 2 pisos");
            busDosPisos2.setBounds(300,200,150,50);

            ButtonGroup grupopisos= new ButtonGroup();
            grupopisos.add(busUnPiso2);
            grupopisos.add(busDosPisos2);

            this.add(busUnPiso2);
            this.add(busDosPisos2);
        }

    }
    public void seleecionarTipoDeBus(){
        int indexida, indexvuelta;
        indexida=buscarBusIda();
        if(diaVuelta != null && mesVuelta != null && anhoVuelta != null){
            indexvuelta=buscarBusVuelta();
        }

        if(busUnPiso.isSelected()){
            panelBus1Piso = new PanelBus1Piso();
            panelElegirViaje.add(panelBus1Piso);
            panelBus1Piso.setBounds(910,50,500,800);
            panelBus1Piso.setBackground(Color.red);
            panelElegirViaje.repaint();
            panelElegirViaje.revalidate();
            System.out.println("ola");
        } else if (busDosPisos.isSelected()){
            JButton Piso2 = new JButton("Piso2");
            JButton Piso1 = new JButton("Piso1");
            Piso2.setBounds(1150,3,150,50);
            Piso1.setBounds(1000,3,150,50);
            panelBus2Piso = new PanelBus2Piso();
            panelElegirViaje.add(panelBus2Piso);
            panelBus2Piso.setBounds(910,50,500,800);
            panelBus2Piso.setBackground(Color.pink);
            panelElegirViaje.repaint();
            panelElegirViaje.revalidate();
            panelElegirViaje.add(Piso1);
            panelElegirViaje.add(Piso2);
        }
    }
    public int buscarBusIda(){
        for(int i = 0; i<busArrayList.size(); i++){
            Bus bus=busArrayList.get(i);
            if(bus.getDia() == diaIda && bus.getMes() == mesIda && bus.getAnho() == anhoIda && bus.getHora() == horarioIda && bus.getOrigen() == origen && bus.getDestino() == destino){
               if(busUnPiso.isSelected() && bus.tipoBus()=="bus1piso"){
                   return i;
               }
               if(busDosPisos.isSelected() && bus.tipoBus()=="Bus2pisos"){
                   return i;
               }
            }
        }
        if(busUnPiso.isSelected()){
            BusUnPiso nuevobus=new BusUnPiso(busArrayList.size()+1,diaIda,mesIda,anhoIda,horarioIda,origen,destino);
            busArrayList.add(nuevobus);
            return busArrayList.size();
        }
        if(busDosPisos.isSelected()){
            BusDosPisos nuevobus=new BusDosPisos(busArrayList.size()+1,diaIda,mesIda,anhoIda,horarioIda,origen,destino);
            busArrayList.add(nuevobus);
            return busArrayList.size();
        }
        return 0;
    }
    public int buscarBusVuelta(){
        for(int i = 0; i<busArrayList.size(); i++){
            Bus bus=busArrayList.get(i);
            if(bus.getDia() == diaVuelta && bus.getMes() == mesVuelta && bus.getAnho() == anhoVuelta && bus.getHora() == horarioVuelta && bus.getOrigen() == destino && bus.getDestino() == origen){
                if(busUnPiso2.isSelected() && bus.tipoBus()=="bus1piso"){
                    return i;
                }
                if(busDosPisos2.isSelected() && bus.tipoBus()=="Bus2pisos"){
                    return i;
                }
            }
        }
        if(busUnPiso2.isSelected()){
            BusUnPiso nuevobus=new BusUnPiso(busArrayList.size()+1,diaVuelta,mesVuelta,anhoVuelta,horarioVuelta,origen,destino);
            busArrayList.add(nuevobus);
            return busArrayList.size();
        }
        if(busDosPisos2.isSelected()){
            BusDosPisos nuevobus=new BusDosPisos(busArrayList.size()+1,diaVuelta,mesVuelta,anhoVuelta,horarioVuelta,origen,destino);
            busArrayList.add(nuevobus);
            return busArrayList.size();
        }
        return 0;
    }
    private class EscogerAsientoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            seleecionarTipoDeBus();
        }
    }
    private class idaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton hora = (JRadioButton) e.getSource();
            horarioIda = hora.getText();
        }
    }
    private class vueltaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JRadioButton hora = (JRadioButton) e.getSource();
            horarioVuelta = hora.getText();
        }
    }
}
