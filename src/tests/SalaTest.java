package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.Oferta;
import model.Sala;
import model.Solucion;

public class SalaTest {

	private Sala sala;
	private Oferta oferta1;
	private Oferta oferta2;
	private Oferta oferta3;

	@Before
	public void setUp() {
		sala = new Sala();
		oferta1 = new Oferta("ofertanteA", "1111111111", 500, 9, 12, 3);
		oferta2 = new Oferta("ofertanteB", "1122222222", 100, 14, 16, 2);
		oferta3 = new Oferta("ofertanteC", "1133333333", 300, 13, 15, 2);
		sala.agregarOferta(oferta1);
	}

	@Test
	public void agregarOfertaTest() {
		sala.agregarOferta(oferta2);
		List<Oferta> ofertas = sala.getOfertas();
		assertTrue(ofertas.contains(oferta2));
	}

	@Test
	public void eliminarOfertaTest() {
		sala.eliminarOferta(oferta1.getID());
		List<Oferta> ofertas = sala.getOfertas();
		assertFalse(ofertas.contains(oferta1));
	}

	@Test
	public void mejorAdjudicacionTest() {
		sala.agregarOferta(oferta1);
		sala.agregarOferta(oferta2);
		sala.agregarOferta(oferta3);
		Solucion mejorSolucion = sala.mejorAdjudicacion();

		assertEquals(800, mejorSolucion.getMonto());
	}

	@Test
	public void hayOfertasTest() {
		assertTrue(sala.hayOfertas());
	}

	@Test
	public void hayCambioTest() {
		assertTrue(sala.hayCambio());
	}

	@Test
	public void getOfertasTest() {
		sala.agregarOferta(oferta1);
		sala.agregarOferta(oferta2);

		List<Oferta> ofertas = sala.getOfertas();
		assertTrue(ofertas.contains(oferta1));
		assertTrue(ofertas.contains(oferta2));
	}
}