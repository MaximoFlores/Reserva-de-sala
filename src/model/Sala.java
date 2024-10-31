package model;

import java.util.ArrayList;
import java.util.Collections;

import defaultSala.Instancia;
import defaultSala.Oferta;
import defaultSala.Solucion;
import defaultSala.Solver;
import views.ObservadorOfertas;

public class Sala {
	
	Instancia _instancia;
	ArrayList<Solucion> _soluciones;
	ArrayList<ObservadorOfertas> _observadores;
	
	public Sala() {
		_instancia = new Instancia();
		_soluciones = new ArrayList<Solucion>();
		_observadores = new ArrayList<ObservadorOfertas>();
	}
	
	public void agregarOferta(Oferta oferta) {
		_instancia.agregar(oferta);
		nofiticarObservadores(oferta);
	}
	
	
	public Solucion mejorAdjudicacion() {
		// Mejor oferta
		_soluciones.add(new Solver(_instancia, (one,other) -> other.getMonto() - one.getMonto()).resolver());
		// Mejor hora
		_soluciones.add(new Solver(_instancia, (one,other) -> one.getCantHoras() - other.getCantHoras()).resolver());
		// Mejor oferta/hora
		_soluciones.add(new Solver(_instancia, (one,other) -> {
			double cocienteOne = one.getMonto() / (double) one.getCantHoras();
			double cocienteOther = other.getMonto() / (double) other.getCantHoras();
			return (cocienteOne < cocienteOther)? 1 : ((cocienteOne == cocienteOther)? 0 : -1);
		}).resolver());
		
		return Collections.max(_soluciones, (p,q) -> p.getMonto() - q.getMonto());
	}
	
	public void registrarObservadores(ObservadorOfertas observador) {
		_observadores.add(observador);
	}
	
	public void nofiticarObservadores(Oferta oferta) {
		for (ObservadorOfertas observadorOfertas : _observadores) {
			observadorOfertas.notificarOferta(oferta);
		}
	}
}
