package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utilidades.Load;
import utilidades.ObservadorSala;
import utilidades.Save;

public class Sala {
	
	private Instancia _instancia;
	private ArrayList<Solucion> _soluciones;
	private ArrayList<ObservadorSala> _observadores;
	private boolean hayCambio;
	
	public Sala() {
		_instancia = new Instancia();
		_soluciones = new ArrayList<Solucion>();
		_observadores = new ArrayList<ObservadorSala>();
	}
	
	public void agregarOferta(Oferta oferta) {
		_instancia.agregar(oferta);
		hayCambio = true;
		notificarObservadores();
	}
	
	public void eliminarOferta(int ID) {
		_instancia.eliminarOferta(ID);
		hayCambio = true;
		notificarObservadores();
	}
	
	
	public Solucion mejorAdjudicacion() {
		_soluciones.clear();
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
	
	public void registrarObservadores(ObservadorSala observador) {
		_observadores.add(observador);
	}
	
	public boolean hayOfertas() {
		return _instancia.getCantOfertas()>=1;
	}
	
	public boolean hayCambio() {
		return hayCambio;
	}

	public void notificarObservadores() {
		for (ObservadorSala observadorOfertas : _observadores) {
			observadorOfertas.notificar(this);
		}
	}
	
	public List<Oferta>getOfertas() {
		return _instancia.Ofertas();
	}

	public void guardarInstancia() {
		Save.saveInstance(_instancia);	
	}
	
	public void cargarInstancia() {
		_instancia = Load.loadInstance();
		notificarObservadores();
	}
	
}
