package Interfaz;

import Codigo.Asiento;

import javax.swing.*;

public class BotonAsientos extends JButton {
    public Asiento asiento;

    /**
     *
     * @param asiento asiento al que se hace referencia como boton
     */
    public BotonAsientos(Asiento asiento) {
        this.asiento = asiento;
    }
    public void selectAsiento(){
        this.asiento.select();
    }
    public void deselectAsiento(){
        this.asiento.deselect();
    }


}