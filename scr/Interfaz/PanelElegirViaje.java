package Interfaz;

import Codigo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Aqui se planifica el origen y destino de un viaje, si es de solo ida o con vuelta, y la fecha de salida
 */
public class PanelElegirViaje extends JPanel {
    private JMenu SeleccionOrigen;
    private JMenu SeleccionDestino;
    private JMenu SeleccionDia;
    private JMenu SeleccionMes;
    private JMenu SeleccionAnho;

    private JMenu SeleccionDiaVuelta;
    private JMenu SeleccionMesVuelta;
    private JMenu SeleccionAnhoVuelta;

    private JMenuBar BarraOrigen;
    private JMenuBar BarraDestino;
    private JMenuBar BarraDia;
    private JMenuBar BarraMes;
    private JMenuBar BarraAnho;
    private JMenuBar BarraDiaVuelta;
    private JMenuBar BarraMesVuelta;
    private JMenuBar BarraAnhoVuelta;
    private JRadioButton ida;
    private JRadioButton vuelta;
    private PanelBus panelbus;
    String diaIda;
    String mesIda;
    String anhoIda;
    String diaVuelta;
    String mesVuelta;
    String anhoVuelta;

    String origen;

    String destino;

    /**
     * Se generan en pantalla los tipos de selecciones para el viaje, origen y destino, fecha de salida, ida con o sin vuelta
     */
    public PanelElegirViaje() {
        this.setLayout(null);
        JMenuItem opcion1 = new JMenuItem("Concepcion");
        JMenuItem opcion2 = new JMenuItem("Santiago");
        JMenuItem opcion3 = new JMenuItem("Puerto Montt");

        BarraOrigen = new JMenuBar();
        BarraOrigen.setBounds(10, 100, 100, 30);
        this.add(BarraOrigen);
        SeleccionOrigen = new JMenu("Origen");
        SeleccionOrigen.add(opcion1);
        SeleccionOrigen.add(opcion2);
        SeleccionOrigen.add(opcion3);
        BarraOrigen.add(SeleccionOrigen);

        opcion1.addActionListener(new origenListener());
        opcion2.addActionListener(new origenListener());
        opcion3.addActionListener(new origenListener());

        JMenuItem opcion4 = new JMenuItem("Concepcion");
        JMenuItem opcion5 = new JMenuItem("Santiago");
        JMenuItem opcion6 = new JMenuItem("Puerto Montt");

        BarraDestino = new JMenuBar();
        BarraDestino.setBounds(10, 150, 100, 30);
        this.add(BarraDestino);
        SeleccionDestino = new JMenu("Destino");
        SeleccionDestino.add(opcion4);
        SeleccionDestino.add(opcion5);
        SeleccionDestino.add(opcion6);
        BarraDestino.add(SeleccionDestino);

        opcion4.addActionListener(new destinoListener());
        opcion5.addActionListener(new destinoListener());
        opcion6.addActionListener(new destinoListener());



        BarraDia = new JMenuBar();
        BarraDia.setBounds(10, 250, 50, 20);
        this.add(BarraDia);

        SeleccionDia= new JMenu("Día");

        for(int i = 1; i<=31; i++){

            JMenuItem opcion = new JMenuItem(Integer.toString(i));
            SeleccionDia.add(opcion);
            opcion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem item = (JMenuItem) e.getSource();
                    SeleccionDia.setText(item.getText());
                    diaIda = SeleccionDia.getText();
                }
            });

        }
        BarraDia.add(SeleccionDia);

        BarraMes = new JMenuBar();
        BarraMes.setBounds(60,250,50,20);
        this.add(BarraMes);
        SeleccionMes = new JMenu("Mes");

        for(int i =1; i<=12; i++){
            JMenuItem opcion = new JMenuItem(Integer.toString(i));
            SeleccionMes.add(opcion);
            opcion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem item = (JMenuItem) e.getSource();
                    SeleccionMes.setText(item.getText());
                    mesIda = SeleccionMes.getText();
                }
            });
        }
        BarraMes.add(SeleccionMes);

        BarraAnho = new JMenuBar();
        BarraAnho.setBounds(110,250,50,20);
        this.add(BarraAnho);
        SeleccionAnho = new JMenu("Año");

        for(int i = 2023; i<=2025; i++){
            JMenuItem opcion = new JMenuItem(Integer.toString(i));
            opcion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem item= (JMenuItem) e.getSource();
                    SeleccionAnho.setText(item.getText());
                    anhoIda = SeleccionAnho.getText();
                }
            });
            SeleccionAnho.add(opcion);
        }
        BarraAnho.add(SeleccionAnho);


        JButton siguiente = new JButton("Siguiente");
        this.add(siguiente);
        siguiente.setBounds(150,350,100,50);
        siguiente.addActionListener(new siguienteListener());

        ButtonGroup grupo = new ButtonGroup();

        ida = new JRadioButton("Solo Ida");
        ida.setBounds(10, 200, 100, 20);
        ida.addActionListener(new idaListener());

        vuelta = new JRadioButton("Ida y Vuelta");
        vuelta.setBounds(120, 200, 130, 20);
        vuelta.addActionListener(new vueltaListener());

        grupo.add(ida);
        grupo.add(vuelta);

        this.add(ida);
        this.add(vuelta);

        this.setBackground(new Color(144, 183, 222));


    }

    /**
     * Parte en donde cambia la interfaz si se desea un viaje con ida y vuelta
     * creando nuevas barras de eleccion para el viaje de vuelta
     */
    public void crearBarraVuelta(){
        BarraDiaVuelta = new JMenuBar();
        BarraDiaVuelta.setBounds(10, 280, 50, 20);
        this.add(BarraDiaVuelta);

        SeleccionDiaVuelta= new JMenu("Día");

        for(int i = 1; i<=31; i++){

            JMenuItem opcion = new JMenuItem(Integer.toString(i));
            SeleccionDiaVuelta.add(opcion);
            opcion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem item = (JMenuItem) e.getSource();
                    SeleccionDiaVuelta.setText(item.getText());
                    diaVuelta = SeleccionDiaVuelta.getText();
                }
            });

        }
        BarraDiaVuelta.add(SeleccionDiaVuelta);

        BarraMesVuelta = new JMenuBar();
        BarraMesVuelta.setBounds(60,280,50,20);
        this.add(BarraMesVuelta);
        SeleccionMesVuelta = new JMenu("Mes");

        for(int i =1; i<=12; i++){
            JMenuItem opcion = new JMenuItem(Integer.toString(i));
            SeleccionMesVuelta.add(opcion);
            opcion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem item = (JMenuItem) e.getSource();
                    SeleccionMesVuelta.setText(item.getText());
                    mesVuelta = SeleccionMesVuelta.getText();
                }
            });
        }
        BarraMesVuelta.add(SeleccionMesVuelta);

        BarraAnhoVuelta = new JMenuBar();
        BarraAnhoVuelta.setBounds(110,280,50,20);
        this.add(BarraAnhoVuelta);
        SeleccionAnhoVuelta = new JMenu("Año");

        for(int i = 2023; i<=2025; i++){
            JMenuItem opcion = new JMenuItem(Integer.toString(i));
            opcion.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JMenuItem item= (JMenuItem) e.getSource();
                    SeleccionAnhoVuelta.setText(item.getText());
                    anhoVuelta = SeleccionAnhoVuelta.getText();
                }
            });
            SeleccionAnhoVuelta.add(opcion);
        }
        BarraAnhoVuelta.add(SeleccionAnhoVuelta);
        this.revalidate();
        this.repaint();
    }
    public void borrarBarraVuelta(){
        if(this.isAncestorOf(BarraDiaVuelta)){
            this.remove(BarraDiaVuelta);
            this.remove(BarraMesVuelta);
            this.remove(BarraAnhoVuelta);
        }

        diaVuelta = null;
        mesVuelta = null;
        anhoVuelta = null;
        this.revalidate();
        this.repaint();
    }

    /**
     * Aqui se crea el panel bus que contiene los horarios y el tipo de bus si al momento de apretar siguiente
     * las opciones de ida y vueltan han sido seleccionadas con anterioridad
     * @throws NoIdaNoVueltaException
     * @throws NoFechaException
     * @throws IdaAntesQueVueltaException
     * @throws NoOrigenException
     * @throws NoDestinoException
     * @throws OrigenIgualDestinoException
     */
    public void seleccionarBus() throws NoFechaException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoOrigenException, NoDestinoException, OrigenIgualDestinoException {

        if(diaIda == null || mesIda == null || anhoIda == null){
            throw new NoFechaException("Elegir fechas validas");
        }
        else if(vuelta.isSelected() && (diaVuelta == null || mesVuelta == null || anhoVuelta == null)){
            throw new NoFechaException("Elegir fechas validas");
        }
        else if(anhoVuelta != null && Integer.parseInt(anhoIda) > Integer.parseInt(anhoVuelta)){
            throw new IdaAntesQueVueltaException("La vuelta no puede ser antes que la ida");
        }
        else if(anhoVuelta != null && mesVuelta != null && Integer.parseInt(mesIda) > Integer.parseInt(mesVuelta) && Integer.parseInt(anhoIda) >= Integer.parseInt(anhoVuelta)){
            throw new IdaAntesQueVueltaException("La vuelta no puede ser antes que la ida");
        }
        else if(anhoVuelta != null && mesVuelta != null && diaVuelta != null && (Integer.parseInt(diaIda) > Integer.parseInt(diaVuelta) && Integer.parseInt(mesIda) >= Integer.parseInt(mesVuelta) && Integer.parseInt(anhoIda) >= Integer.parseInt(anhoVuelta))){
            throw new IdaAntesQueVueltaException("La vuelta no puede ser antes que la ida");
        }
        else if(origen == null){
            throw new NoOrigenException("Debe seleccionar origen");
        }
        else if(destino == null){
            throw new NoDestinoException("Debe seleccionar destino");
        }
        else if(origen.equals(destino)){
            throw new OrigenIgualDestinoException("El origen no puede ser igual al destino");
        }
        else if(ida.isSelected() || vuelta.isSelected()) {
            if(panelbus!=null){
                panelbus.setVisible(true);
            }else{
                panelbus = new PanelBus(this);
            }
            this.add(panelbus);
            panelbus.setBounds(300,10,450,460);
        }
        else{
            throw new NoIdaNoVueltaException("No se ha seleccionado ida ni vuelta");
        }
    }


    private class siguienteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                seleccionarBus();
            } catch (NoIdaNoVueltaException | NoFechaException | IdaAntesQueVueltaException ex) {
                throw new RuntimeException(ex);
            } catch (NoOrigenException ex) {
                throw new RuntimeException(ex);
            } catch (NoDestinoException ex) {
                throw new RuntimeException(ex);
            } catch (OrigenIgualDestinoException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private class vueltaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            crearBarraVuelta();
        }
    }
    private class idaListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            borrarBarraVuelta();
        }
    }

    private class origenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item= (JMenuItem) e.getSource();
            SeleccionOrigen.setText(item.getText());
            origen=SeleccionOrigen.getText();
        }
    }

    private class destinoListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem item= (JMenuItem) e.getSource();
            SeleccionDestino.setText(item.getText());
            destino=SeleccionDestino.getText();
        }
    }

    public void setupNoDiaIdaTest(){
        ida.setSelected(true);
        mesIda="1";
        anhoIda="2024";
        origen="Santiago";
        destino="Concepción";
    }

    public void setupNoMesIdaTest(){
        ida.setSelected(true);
        diaIda="9";
        anhoIda="2024";
        origen="Santiago";
        destino="Concepción";
    }
    public void setupNoAnhoIdaTest(){
        ida.setSelected(true);
        diaIda="9";
        mesIda="1";
        origen="Santiago";
        destino="Concepción";
    }

    public void setupNoDiaVueltaTest(){
        vuelta.setSelected(true);
        diaIda="9";
        mesIda="1";
        anhoIda="2024";
        origen="Santiago";
        destino="Concepción";
        anhoVuelta="2024";
        mesVuelta="12";
    }

    public void setupNoMesVueltaTest(){
        vuelta.setSelected(true);
        diaIda="9";
        mesIda="1";
        anhoIda="2024";
        origen="Santiago";
        destino="Concepción";
        anhoVuelta="2024";
        diaVuelta="3";
    }
    public void setupNoAnhoVueltaTest(){
        vuelta.setSelected(true);
        diaIda="9";
        mesIda="1";
        anhoIda="2024";
        origen="Santiago";
        destino="Concepción";
        mesVuelta="11";
        diaVuelta="3";
    }
    public void setupNoOrigenTest(){
        ida.setSelected(true);
        destino = "Concepción";
        diaIda="9";
        mesIda="1";
        anhoIda="2024";
        mesVuelta="11";
        diaVuelta="3";
        anhoVuelta = "2024";
    }
    public void setupNoDestinoTest(){
        ida.setSelected(true);
        origen = "Concepción";
        diaIda="9";
        mesIda="1";
        anhoIda="2024";
        mesVuelta="11";
        diaVuelta="3";
        anhoVuelta = "2024";
    }
}
