package Interfaz;

import Codigo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Aqui se planifica el tipo de bus que se desea para solo la ida o ida y vuelta y el horario de salida del mismo
 */
public class PanelBus extends JPanel {
    private JMenu SeleccionHorarios;
    private JMenuBar BarraHorarios;
    private JToggleButton busUnPiso;
    private JToggleButton busDosPisos;

    private JToggleButton busUnPiso2;
    private JToggleButton busDosPisos2;
    private PanelElegirAsiento panelElegirAsiento;
    private JRadioButton temprano;
    private JRadioButton tarde;
    private JRadioButton noche;
    private JRadioButton tempranoVuelta;
    private JRadioButton tardeVuelta;
    private JRadioButton nocheVuelta;
    ArrayList<Bus> busArrayList = new ArrayList<Bus>();
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
    String tipobusvuelta;

    /**
     *Se generan en pantalla los tipos de selecciones para el bus, como el tipo, y su horario de salida
     */
    public PanelBus(PanelElegirViaje panelElegirViaje){

        origen=panelElegirViaje.origen;
        destino=panelElegirViaje.destino;

        JLabel labelida= new JLabel("Ida");
        labelida.setBounds(90,30,100,20);
        labelida.setFont(new Font("Arial",Font.BOLD,20));
        this.add(labelida);
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
        busUnPiso.setBounds(30,70,150,50);
        busDosPisos = new JToggleButton("Bus de 2 pisos");
        busDosPisos.setBounds(30,130,150,50);

        grupo.add(busUnPiso);
        grupo.add(busDosPisos);

        this.add(busUnPiso);
        this.add(busDosPisos);

        ButtonGroup group = new ButtonGroup();

        temprano = new JRadioButton("10:00 am");
        temprano.setBounds(55, 190, 100, 50);
        tarde = new JRadioButton("16:00 pm");
        tarde.setBounds(55, 240, 100, 50);
        noche = new JRadioButton("22:00 pm");
        noche.setBounds(55,290,100,50);

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
        EscogerAsiento.setBounds(215,370,150,50);
        EscogerAsiento.addActionListener(new PanelBus.EscogerAsientoteListener());
        this.setBackground(new Color(172, 229, 232));
        if(diaVuelta != null && mesVuelta != null && anhoVuelta != null){
            JLabel labelvuelta= new JLabel("Vuelta");
            labelvuelta.setBounds(260,30,100,20);
            labelvuelta.setFont(new Font("Arial",Font.BOLD,20));
            this.add(labelvuelta);

            tempranoVuelta = new JRadioButton("10:00 am");
            tempranoVuelta.setBounds(240, 190, 100, 50);
            tardeVuelta = new JRadioButton("16:00 pm");
            tardeVuelta.setBounds(240, 240, 100, 50);
            nocheVuelta = new JRadioButton("22:00 pm");
            nocheVuelta.setBounds(240,290,100,50);
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
            busUnPiso2.setBounds(215,70,150,50);
            busDosPisos2 = new JToggleButton("Bus de 2 pisos");
            busDosPisos2.setBounds(215,130,150,50);

            ButtonGroup grupopisos= new ButtonGroup();
            grupopisos.add(busUnPiso2);
            grupopisos.add(busDosPisos2);

            this.add(busUnPiso2);
            this.add(busDosPisos2);
        }

    }

    /**
     * Aqui dependiendo de la seleccion del bus, se genera su respectivo piso de asientos
     */
    public void selecionarTipoDeBus () throws NoFechaException {
        int indexida, indexvuelta = -1;
        indexida=buscarBusIda();
        if(diaVuelta != null && mesVuelta != null && anhoVuelta != null){
            indexvuelta=buscarBusVuelta();

            if(busUnPiso2.isSelected()){
                tipobusvuelta="unpiso";
            }
            if(busDosPisos2.isSelected()){
                tipobusvuelta="dospisos";
            }
        }
        if(panelElegirAsiento==null) {
            panelElegirAsiento = new PanelElegirAsiento(indexida, indexvuelta, this);
            panelElegirViaje.add(panelElegirAsiento);
            panelElegirAsiento.setBounds(760, 10, 1150, 990);
            panelElegirAsiento.setBackground(new Color(156, 207, 155));
            panelElegirAsiento.repaint();
            panelElegirAsiento.revalidate();
            this.revalidate();
            this.repaint();
            panelElegirViaje.repaint();
            panelElegirViaje.revalidate();
        }else{
            panelElegirAsiento.setVisible(true);

            panelElegirAsiento.refresh(indexida,indexvuelta,this);
            panelElegirAsiento.repaint();
            panelElegirAsiento.revalidate();
            this.revalidate();
            this.repaint();
            panelElegirViaje.repaint();
            panelElegirViaje.revalidate();
            panelElegirAsiento.updateResumenCompra();
        }


    }

    /**
     * aqui si se selecciona el tipo de bus para la ida, se crea su bus con sus datos y los asientos correspondientes
     * @return
     */
    public int buscarBusIda(){
        for(int i = 0; i<busArrayList.size(); i++){
            Bus bus=busArrayList.get(i);
            if(Objects.equals(bus.getDia(), diaIda) && Objects.equals(bus.getMes(), mesIda) && Objects.equals(bus.getAnho(), anhoIda) && Objects.equals(bus.getHora(), horarioIda) && Objects.equals(bus.getOrigen(), origen) && Objects.equals(bus.getDestino(), destino)){
               if(busUnPiso.isSelected() && bus.tipoBus()=="bus1piso"){
                   return i;
               }
               if(busDosPisos.isSelected() && bus.tipoBus()=="Bus2pisos"){
                   return i;
               }
            }
        }
        if(busUnPiso.isSelected()){
            BusUnPiso nuevobus=new BusUnPiso(busArrayList.size()+1,diaIda,mesIda,anhoIda,horarioIda,destino,origen);
            busArrayList.add(nuevobus);
            return busArrayList.size()-1;
        }
        if(busDosPisos.isSelected()){
            BusDosPisos nuevobus=new BusDosPisos(busArrayList.size()+1,diaIda,mesIda,anhoIda,horarioIda,destino,origen);
            busArrayList.add(nuevobus);
            return busArrayList.size()-1;
        }
        return -1;
    }

    /**
     * aqui si selecciona el tipo de bus para la vuelta, se crea su bus con sus datos y los asientos correspondientes
     * @return
     */
    public int buscarBusVuelta(){
        for(int i = 0; i<busArrayList.size(); i++){

            Bus bus=busArrayList.get(i);

            if(Objects.equals(bus.getDia(), diaVuelta) && Objects.equals(bus.getMes(), mesVuelta) && Objects.equals(bus.getAnho(), anhoVuelta) && Objects.equals(bus.getHora(), horarioVuelta) && Objects.equals(bus.getOrigen(), destino) && Objects.equals(bus.getDestino(), origen)){
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
            return busArrayList.size()-1;
        }
        if(busDosPisos2.isSelected()){
            BusDosPisos nuevobus=new BusDosPisos(busArrayList.size()+1,diaVuelta,mesVuelta,anhoVuelta,horarioVuelta,origen,destino);
            busArrayList.add(nuevobus);
            return busArrayList.size()-1;
        }
        return -1;
    }
    public void refresh(PanelElegirViaje panelElegirViaje){
        this.removeAll();
        this.panelElegirViaje=panelElegirViaje;
        origen=panelElegirViaje.origen;
        destino=panelElegirViaje.destino;

        JLabel labelida= new JLabel("Ida");
        labelida.setBounds(90,30,100,20);
        labelida.setFont(new Font("Arial",Font.BOLD,20));
        this.add(labelida);
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
        busUnPiso.setBounds(30,70,150,50);
        busDosPisos = new JToggleButton("Bus de 2 pisos");
        busDosPisos.setBounds(30,130,150,50);

        grupo.add(busUnPiso);
        grupo.add(busDosPisos);

        this.add(busUnPiso);
        this.add(busDosPisos);

        ButtonGroup group = new ButtonGroup();

        temprano = new JRadioButton("10:00 am");
        temprano.setBounds(55, 190, 100, 50);
        tarde = new JRadioButton("16:00 pm");
        tarde.setBounds(55, 240, 100, 50);
        noche = new JRadioButton("22:00 pm");
        noche.setBounds(55,290,100,50);

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
        EscogerAsiento.setBounds(215,370,150,50);
        EscogerAsiento.addActionListener(new PanelBus.EscogerAsientoteListener());
        this.setBackground(new Color(172, 229, 232));
        if(diaVuelta != null && mesVuelta != null && anhoVuelta != null){
            JLabel labelvuelta= new JLabel("Vuelta");
            labelvuelta.setBounds(260,30,100,20);
            labelvuelta.setFont(new Font("Arial",Font.BOLD,20));
            this.add(labelvuelta);

            tempranoVuelta = new JRadioButton("10:00 am");
            tempranoVuelta.setBounds(240, 190, 100, 50);
            tardeVuelta = new JRadioButton("16:00 pm");
            tardeVuelta.setBounds(240, 240, 100, 50);
            nocheVuelta = new JRadioButton("22:00 pm");
            nocheVuelta.setBounds(240,290,100,50);
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
            busUnPiso2.setBounds(215,70,150,50);
            busDosPisos2 = new JToggleButton("Bus de 2 pisos");
            busDosPisos2.setBounds(215,130,150,50);

            ButtonGroup grupopisos= new ButtonGroup();
            grupopisos.add(busUnPiso2);
            grupopisos.add(busDosPisos2);

            this.add(busUnPiso2);
            this.add(busDosPisos2);
        }
        this.revalidate();
        this.repaint();
    }
    private class EscogerAsientoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                selecionarTipoDeBus();
            } catch (NoFechaException ex) {
                throw new RuntimeException(ex);
            }
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
