package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import views.Observador;

public class Sala {
	
	Instancia _instancia;
	ArrayList<Solucion> _soluciones;
	ArrayList<Observador> _observadores;
	
	public Sala() {
		_instancia = new Instancia();
		_soluciones = new ArrayList<Solucion>();
		_observadores = new ArrayList<Observador>();
	}
	
	public void agregarOferta(Oferta oferta) {
		_instancia.agregar(oferta);
		nofiticarObservadores();
	}
	
	public void eliminarOferta(int ID) {
		_instancia.eliminarOferta(ID);
		nofiticarObservadores();
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
	
	public void registrarObservadores(Observador observador) {
		_observadores.add(observador);
	}
	
	public void nofiticarObservadores() {
		for (Observador observadorOfertas : _observadores) {
			observadorOfertas.notificar(this);
		}
	}
	
	public List<Oferta>getOfertas() {
		return _instancia.Ofertas();
	}
}
