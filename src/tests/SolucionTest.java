package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Instancia;
import model.Oferta;
import model.Solucion;

public class SolucionTest {

    private Instancia instancia;
    private Solucion solucion;
    private Oferta oferta1;
    private Oferta oferta2;
    private Oferta oferta3;

    @Before
    public void setUp() {
        instancia = new Instancia();
        solucion = new Solucion(instancia);

        oferta1 = new Oferta("Oferente1", "1111111111", 100, 8, 12, 3); 
        oferta2 = new Oferta("Oferente2", "1122222222", 150, 12, 15, 2); 
        oferta3 = new Oferta("Oferente3", "1133333333", 120, 11, 16, 4); 
        
    
    }

    @Test
    public void agregarTest() {
        solucion.agregar(oferta1); 
        assertEquals(100, solucion.getMonto());
    }
    
    

    @Test
    public void setHorarioTest() {
        solucion.agregar(oferta1);
        Oferta[] horario = solucion.getHorario();

        for (int i = 7; i < 11; i++) { 
            assertEquals(oferta1, horario[i]);
        }
        assertNull(horario[11]); 
    }

    @Test
    public void horarioDisponibleTrueTest() {
        assertTrue(solucion.horarioDisponible(oferta1));
    }

    @Test
    public void horarioDisponibleFalseTest() {
        solucion.agregar(oferta1); 
        assertFalse(solucion.horarioDisponible(oferta3)); 
    }

    @Test
    public void getHorarioTest() {
        solucion.agregar(oferta1);
        Oferta[] horario = solucion.getHorario();
        assertEquals(24, horario.length); 

        for (int i = 7; i < 11; i++) { 
            assertEquals(oferta1, horario[i]);
        }
    }

    @Test
    public void getMontoTest() {
        solucion.agregar(oferta1);
        solucion.agregar(oferta2);
        assertEquals(250, solucion.getMonto()); 
    }
}