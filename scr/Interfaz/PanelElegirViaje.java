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
    private String diaIda;
    private String mesIda;
    private String anhoIda;
    private String diaVuelta;
    private String mesVuelta;
    private String anhoVuelta;

    public PanelElegirViaje() {
        this.setLayout(null);
        BarraOrigen opcion1 = new BarraOrigen("Concepcion");
        BarraOrigen opcion2 = new BarraOrigen("Santiago");
        BarraOrigen opcion3 = new BarraOrigen("Puerto Montt");

        BarraOrigen = new JMenuBar();
        BarraOrigen.setBounds(150, 300, 100, 30);
        this.add(BarraOrigen);
        SeleccionOrigen = new JMenu("Origen");
        SeleccionOrigen.add(opcion1.getItem());
        SeleccionOrigen.add(opcion2.getItem());
        SeleccionOrigen.add(opcion3.getItem());
        BarraOrigen.add(SeleccionOrigen);

        BarraDestino opcion4 = new BarraDestino("Concepcion");
        BarraDestino opcion5 = new BarraDestino("Santiago");
        BarraDestino opcion6 = new BarraDestino("Puerto Montt");

        BarraDestino = new JMenuBar();
        BarraDestino.setBounds(150, 400, 100, 30);
        this.add(BarraDestino);
        SeleccionDestino = new JMenu("Destino");
        SeleccionDestino.add(opcion4.getItem());
        SeleccionDestino.add(opcion5.getItem());
        SeleccionDestino.add(opcion6.getItem());
        BarraDestino.add(SeleccionDestino);

        BarraDia = new JMenuBar();
        BarraDia.setBounds(150, 550, 50, 20);
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
        BarraMes.setBounds(200,550,50,20);
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
        BarraAnho.setBounds(250,550,50,20);
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
        siguiente.setBounds(150,700,100,100);
        siguiente.addActionListener(new siguienteListener());

        ButtonGroup grupo = new ButtonGroup();

        ida = new JRadioButton("Solo Ida");
        ida.setBounds(150, 450, 100, 100);
        ida.addActionListener(new idaListener());
        vuelta = new JRadioButton("Ida y Vuelta");
        vuelta.setBounds(275, 450, 200, 100);
        vuelta.addActionListener(new vueltaListener());

        grupo.add(ida);
        grupo.add(vuelta);

        this.add(ida);
        this.add(vuelta);

        this.setBackground(Color.CYAN);


    }

    public void crearBarraVuelta(){
        BarraDiaVuelta = new JMenuBar();
        BarraDiaVuelta.setBounds(150, 600, 50, 20);
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
        BarraMesVuelta.setBounds(200,600,50,20);
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
        BarraAnhoVuelta.setBounds(250,600,50,20);
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
            panelbus.setBounds(400,50,500,800);
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
}
