package Interfaz;

import Codigo.excepcioncustom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class PanelElegirAsientoTest {
    private PanelElegirAsiento panelElegirAsiento;

    @BeforeEach
    void setUp() throws excepcioncustom {
        panelElegirAsiento = new PanelElegirAsiento(2,2, new PanelBus(new PanelElegirViaje()));
    }

    @Test
    void guardarAsientosSeleccionados() {
    }

    @Test
    void comprarAsientosIda() {
    }

    @Test
    void comprarAsientosVuelta() {
    }
}