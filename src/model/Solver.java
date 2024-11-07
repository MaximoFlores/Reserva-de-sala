package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
	private Instancia _instancia;
	private Comparator<Oferta> _comparador;
	
	public Solver(Instancia instancia, Comparator<Oferta> comparador) {
		_instancia = instancia;
		_comparador = comparador;
	}
	
	public Solucion resolver() {		
		Solucion ret = new Solucion(_instancia);
		for (Oferta oferta : ofertasOrdenadas()) {
			if(ret.horarioDisponible(oferta)) {
				ret.agregar(oferta);
			}		
		}
		return ret;
	}

	private ArrayList<Oferta> ofertasOrdenadas() {
		ArrayList<Oferta> ret = _instancia.Ofertas();
		Collections.sort(ret, _comparador);
	
		return ret;
	}
}