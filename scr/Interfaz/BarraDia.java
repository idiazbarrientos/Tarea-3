package Interfaz;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraDia {
    private JMenuItem opcion;

    public BarraDia(String nombre) {
        this.opcion = new JMenuItem();
        opcion.setText(nombre);
        opcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public JMenuItem getItem(){
        return opcion;
    }
}