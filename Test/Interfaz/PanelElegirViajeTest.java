package Interfaz;

import Codigo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;

class PanelElegirViajeTest {
    private PanelElegirViaje panelElegirViaje;
    @BeforeEach
    void setup(){
        panelElegirViaje= new PanelElegirViaje();
    }
    @Test
    @DisplayName("Test día de vuelta no elegido")
    public void TestNoDiaVuelta() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoDiaVueltaTest();
        assertThrows(NoFechaException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }

    @Test
    @DisplayName("Test mes de vuelta no elegido")
    public void TestNoMesVuelta() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoMesVueltaTest();
        assertThrows(NoFechaException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }

    @Test
    @DisplayName("Test año de vuelta no elegido")
    public void TestNoAnhoVuelta() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoAnhoVueltaTest();
        assertThrows(NoFechaException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }
    @Test
    @DisplayName("Test día de ida no elegido")
    public void TestNoDiaIda() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoDiaIdaTest();
        assertThrows(NoFechaException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }
    @Test
    @DisplayName("Test mes de ida no elegido")
    public void TestNoMesIda() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoMesIdaTest();
        assertThrows(NoFechaException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }
    @Test
    @DisplayName("Test año de ida no elegido")
    public void TestNoAnhoIda() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoAnhoIdaTest();
        assertThrows(NoFechaException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }
}