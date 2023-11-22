package Interfaz;

import javax.swing.*;

public class InterfazGUI {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new Ventana();
        });
    }
}