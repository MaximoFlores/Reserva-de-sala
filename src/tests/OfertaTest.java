package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Oferta;

public class OfertaTest {

	private Oferta oferta;

	@Before
	public void setUp() {
		oferta = new Oferta("ofertanteA", "1111111111", 500, 9, 12, 3);
	}

	@Test
	public void verificarHorarioValidoTest() {
		assertEquals(9, oferta.getHoraDesde());
		assertEquals(12, oferta.getHoraHasta());

	}

	@Test(expected = IllegalArgumentException.class)
	public void verificarHorarioInvalidoTest() {
		new Oferta("ofertanteB", "1111111111", 200, 19, 10, 4);
	}

	@Test
	public void getHoraDesdeTest() {
		assertEquals(9, oferta.getHoraDesde());
	}

	@Test
	public void getHoraHastaTest() {
		assertEquals(12, oferta.getHoraHasta());
	}

	@Test
	public void getCantHorasTest() {
		assertEquals(3, oferta.getCantHoras());
	}

	@Test
	public void getMontoTest() {
		assertEquals(500, oferta.getMonto());
	}

	@Test
	public void getNombreOfertanteTest() {
		assertEquals("ofertanteA", oferta.getNombreOferente());
	}

	@Test
	public void getTelefonoTest() {
		assertEquals("1111111111", oferta.getTelefono());
	}

	@Test
	public void getCantIntegrantesTest() {
		assertEquals(3, oferta.getCantIntegrantes());
	}

	@Test
	public void getIDTest() {
		int expectedID = oferta.getID();
		assertEquals(expectedID, oferta.getID());
	}
}