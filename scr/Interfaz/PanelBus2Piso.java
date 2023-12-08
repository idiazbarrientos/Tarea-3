package Interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelBus2Piso extends JPanel {
    public PanelBus2Piso(){
        this.setLayout(new GridLayout(1,1));
        this.setBackground(Color.green);
        this.add(new PanelAsientos());
    }
}
