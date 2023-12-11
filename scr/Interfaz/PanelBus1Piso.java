package Interfaz;

import Codigo.BusUnPiso;
import Codigo.TipoAsiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Aqui se encuentran los botones que representan los asientos del bus de 1 piso
 */
public class PanelBus1Piso extends JPanel {
    int busIndiceIda;
    PanelBus panelBus;
    PanelElegirAsiento panelElegirAsiento;
    public ArrayList<BotonAsientos> array_botones = new ArrayList<>();
        public PanelBus1Piso(int busIndiceIda, PanelBus panelBus, PanelElegirAsiento panelElegirAsiento) {
            this.panelElegirAsiento=panelElegirAsiento;
            this.busIndiceIda = busIndiceIda;
            this.panelBus = panelBus;
            BusUnPiso ida = (BusUnPiso) panelBus.busArrayList.get(busIndiceIda);
            setLayout(new GridLayout(0, 4, 5, 5));


            for(int i = 1; i <= ida.asientoArrayList.size(); i++){
                array_botones.add(new BotonAsientos(ida.asientoArrayList.get(i-1)));
            }

            for(int i = 1; i <=ida.asientoArrayList.size(); i++) {
                array_botones.get(i-1).setText(Integer.toString(i));
                Color color_fondo;
                if(array_botones.get(i-1).asiento.isSelect()){
                    color_fondo=Color.BLUE;
                }
                else if(array_botones.get(i-1).asiento.isComprado()){
                    color_fondo=Color.red;
                }
                else if(array_botones.get(i-1).asiento.getType() == TipoAsiento.SALON_CAMA){
                    color_fondo = Color.orange;
                }
                else{
                    color_fondo = Color.pink;
                }
                array_botones.get(i-1).setBackground(color_fondo);
                array_botones.get(i-1).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        BotonAsientos btn = (BotonAsientos) e.getSource();
                        if (btn.getBackground() == Color.GREEN) {
                            btn.deselectAsiento();
                            btn.setBackground(color_fondo); // Si está seleccionado, se deselecciona
                        } else if(!btn.asiento.isComprado()){
                            btn.selectAsiento();

                            System.out.println("Listener"+btn.asiento.isSelect());
                            btn.setBackground(Color.GREEN); // Si no está seleccionado, se selecciona (cambia a verde)
                        }
                        panelElegirAsiento.updateResumenCompra();
                    }
                });

                this.add(array_botones.get(i-1));
                this.revalidate();;
                this.repaint();
            }
        }

    /**
     * se refresca el panel de botones de 1 piso, manteniendo los asientos seleccionados
     * @param indexida
     * @param panelBus
     * @param panelElegirAsiento
     */
        public void refresh(int indexida, PanelBus panelBus, PanelElegirAsiento panelElegirAsiento){
            this.panelBus=panelBus;
            this.busIndiceIda=indexida;
            this.panelElegirAsiento=panelElegirAsiento;
            this.removeAll();
            array_botones=new ArrayList<>();
            BusUnPiso ida = (BusUnPiso) panelBus.busArrayList.get(busIndiceIda);
            System.out.println("Refrescando bus: "+ida.asientoArrayList);
            setLayout(new GridLayout(0, 4, 5, 5));
            for(int i = 1; i <= ida.asientoArrayList.size(); i++){
                array_botones.add(new BotonAsientos(ida.asientoArrayList.get(i-1)));
            }
            System.out.println("Refrescando bus: "+array_botones);
            for(int i = 1; i <=array_botones.size(); i++) {

                array_botones.get(i-1).setText(Integer.toString(i));
                Color color_fondo;

                if(array_botones.get(i-1).asiento.isComprado()){
                    color_fondo=Color.red;
                }
                else if(array_botones.get(i-1).asiento.getType() == TipoAsiento.SALON_CAMA){
                    color_fondo = Color.orange;
                }
                else{
                    color_fondo = Color.pink;
                }
                array_botones.get(i-1).setBackground(color_fondo);
                array_botones.get(i-1).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BotonAsientos btn = (BotonAsientos) e.getSource();
                        if (btn.getBackground() == Color.GREEN) {
                            btn.asiento.deselect();
                            btn.setBackground(color_fondo); // Si está seleccionado, se deselecciona
                        } else if(!btn.asiento.isComprado()){
                            btn.asiento.select();
                            //btn.SelectAsiento();
                            System.out.println("Listener"+btn.asiento.isSelect());
                            btn.setBackground(Color.GREEN); // Si no está seleccionado, se selecciona (cambia a verde)
                        }
                        panelElegirAsiento.updateResumenCompra();
                    }
                });

                this.add(array_botones.get(i-1));
                this.revalidate();;
                this.repaint();
            }
            this.revalidate();
            this.repaint();
            this.setVisible(false);
            this.setVisible(true);
        }
}

