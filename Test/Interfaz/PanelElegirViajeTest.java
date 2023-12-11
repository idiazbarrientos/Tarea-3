package Interfaz;

import Codigo.excepcioncustom;

import javax.swing.*;

class PanelElegirViajeTest {
    JRadioButton ida;
    JRadioButton vuelta;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ida = new JRadioButton("Solo Ida");
        vuelta = new JRadioButton("Ida y Vuelta");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


    /**
     * se prueba que se necesita seleccionar ida o vuelta en la planificacion del viaje
     * @throws excepcioncustom
     */
    @org.junit.jupiter.api.Test
    void seleccionarBus() throws excepcioncustom {
        if(ida == null || vuelta == null){
            throw new excepcioncustom("No se ha seleccionado ida ni vuelta");
        }
    }
}