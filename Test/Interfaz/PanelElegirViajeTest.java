package Interfaz;

import Codigo.*;
import org.junit.jupiter.api.AfterEach;
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
    @AfterEach
    void tearDown(){
        panelElegirViaje = null;
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
    @Test
    @DisplayName("Test origen no elegido")
    public void TestOrigenNoElegido() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoOrigenTest();
        assertThrows(NoOrigenException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }
    @Test
    @DisplayName("Test destino no elegido")
    public void TestDestinoNoElegido() throws NoFechaException, OrigenIgualDestinoException, NoOrigenException, IdaAntesQueVueltaException, NoIdaNoVueltaException, NoDestinoException {
        panelElegirViaje.setupNoDestinoTest();
        assertThrows(NoDestinoException.class,()->{
            panelElegirViaje.seleccionarBus();
        });
    }

}