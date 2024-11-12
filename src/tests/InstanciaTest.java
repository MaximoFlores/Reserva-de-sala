package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Instancia;
import model.Oferta;

public class InstanciaTest {

	private Instancia instancia;
	private Oferta oferta1;
	private Oferta oferta2;

	@Before
	public void setUp() {
		instancia = new Instancia();
		oferta1 = new Oferta("a", "1111111111", 100, 1, 3, 2);
		oferta2 = new Oferta("b", "1122222222", 150, 4, 6, 3);
	}

	@Test
	public void agregarTest() {
		instancia.agregar(oferta1);
		assertTrue(instancia.Ofertas().contains(oferta1));
		assertEquals(1, instancia.getCantOfertas());
	}

	@Test
	public void getCantOfertasTest() {
		assertEquals(0, instancia.getCantOfertas());
		instancia.agregar(oferta1);
		instancia.agregar(oferta2);
		assertEquals(2, instancia.getCantOfertas());
	}

	@Test
	public void getHorarioTest() {
		Oferta[] horario = instancia.getHorario();
		assertNotNull(horario);
		assertEquals(24, horario.length);
		for (Oferta o : horario) {
			assertNull(o);
		}
	}

	@Test
	public void eliminarOfertaTest() {
		instancia.agregar(oferta1);
		instancia.agregar(oferta2);
		assertEquals(2, instancia.getCantOfertas());

		instancia.eliminarOferta(oferta1.getID());
		assertFalse(instancia.Ofertas().contains(oferta1));
		assertEquals(1, instancia.getCantOfertas());

		int idInvalido = -1;
		instancia.eliminarOferta(idInvalido);
		assertEquals(1, instancia.getCantOfertas());
	}

	@Test
	public void eliminarOfertaInexistenteTest() {
		instancia.agregar(oferta1);
		int nonExistentID = 999;
		instancia.eliminarOferta(nonExistentID);
		assertTrue(instancia.Ofertas().contains(oferta1));
		assertEquals(1, instancia.getCantOfertas());
	}
}