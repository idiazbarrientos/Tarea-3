package Interfaz;

import Codigo.BusNoSeleccionadoException;
import Codigo.HorarioNoSeleccionadoException;
import Codigo.NoFechaException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PanelBusTest {
    private PanelElegirViaje panelElegirViaje;
    private PanelBus panelBus;
    @BeforeEach
    void setup(){
        panelElegirViaje = new PanelElegirViaje();
        panelBus = new PanelBus(panelElegirViaje);
    }
    @AfterEach
    void tearDown(){
        panelBus = null;
        panelElegirViaje = null;
    }
    @Test
    @DisplayName("Test bus ida no seleccionado")
    public void TestBusIdaNoSeleccionado() throws BusNoSeleccionadoException{
        panelBus.setupBusIdaNoSeleccionadoTest();
        assertThrows(BusNoSeleccionadoException.class,()->{
            panelBus.selecionarTipoDeBus();
        });
    }
    @Test
    @DisplayName("Test bus vuelta no seleccionado")
    public void TestBusVueltaNoSeleccionado() throws BusNoSeleccionadoException{
        panelBus.setupBusVueltaNoSeleccionadoTest();
        assertThrows(BusNoSeleccionadoException.class,()->{
            panelBus.selecionarTipoDeBus();
        });
    }
    @Test
    @DisplayName("Test horario ida no seleccionado")
    public void TestHorarioIdaNoSeleccionado() throws HorarioNoSeleccionadoException{
        panelBus.setupHorarioIdaNoSeleccionadoTest();
        assertThrows(HorarioNoSeleccionadoException.class,()->{
            panelBus.selecionarTipoDeBus();
        });
    }
    @Test
    @DisplayName("Test horario vuelta no seleccionado")
    public void TestHorarioVueltaNoSeleccionado() throws HorarioNoSeleccionadoException{
        panelBus.setupHorarioVueltaNoSeleccionadoTest();
        assertThrows(HorarioNoSeleccionadoException.class,()->{
            panelBus.selecionarTipoDeBus();
        });
    }
}