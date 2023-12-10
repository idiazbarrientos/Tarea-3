package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
     * Aqui se planifica la parte de Destino y Origen, si es solo ida o con vuelta, la fecha, de un viaje
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

    public void seleccionarBus(){
        if(ida.isSelected() || vuelta.isSelected()) {
            panelbus = new PanelBus(this);
            this.add(panelbus);
            panelbus.setBounds(300,10,450,460);
            System.out.println("ola");
        }
    }


    private class siguienteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            seleccionarBus();
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

}
