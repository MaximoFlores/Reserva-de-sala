package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolverTest {

	@Test
	public void resolverPorOfertatest() {
		Solver ret = new Solver(ejemplo(), (one,other) -> other.getMonto() - one.getMonto());
		int montoTotal = ret.resolver().getMonto();
		assertEquals(44000, montoTotal);
	}
	
	@Test
	public void resolverPorHorarioTest() {
		Solver ret = new Solver(ejemplo(), (one,other) -> one.getCantHoras() - other.getCantHoras());
		int montoTotal = ret.resolver().getMonto();
		assertEquals(36000, montoTotal);
	}
	
	@Test
	public void resolverPorOfertaYHoraTest() {
		Solver ret = new Solver(ejemplo(), (one,other) -> {
			double cocienteOne = one.getMonto() / (double) one.getCantHoras();
			double cocienteOther = other.getMonto() / (double) other.getCantHoras();
			return (cocienteOne < cocienteOther)? 1 : ((cocienteOne == cocienteOther)? 0 : -1);
		});
		int montoTotal = ret.resolver().getMonto();
		assertEquals(44000, montoTotal);
	}

	
	private Instancia ejemplo() {
		Instancia ret = new Instancia();
		ret.agregar(new Oferta("", "", 16000, 8, 12, 0));
		ret.agregar(new Oferta("", "", 14000, 7, 11, 0));
		ret.agregar(new Oferta("", "", 14000, 17, 21, 0));
		ret.agregar(new Oferta("", "", 14000, 12, 15, 0));
		ret.agregar(new Oferta("", "", 8000, 8, 10, 0));
		ret.agregar(new Oferta("", "", 10000, 11, 16, 0));
		return ret;
		
	}
}
