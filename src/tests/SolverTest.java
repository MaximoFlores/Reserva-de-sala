package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import defaultSala.Instancia;
import defaultSala.Oferta;
import defaultSala.Solver;

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
		ret.agregar(new Oferta("", "", 0, 16000, 8, 12));
		ret.agregar(new Oferta("", "", 0, 14000, 12, 15));
		ret.agregar(new Oferta("", "", 0, 10000, 11, 16));
		ret.agregar(new Oferta("", "", 0, 14000, 7, 11));
		ret.agregar(new Oferta("", "", 0, 14000, 17, 21));
		ret.agregar(new Oferta("", "", 0, 8000, 8, 10));
		return ret;
		
	}
}
