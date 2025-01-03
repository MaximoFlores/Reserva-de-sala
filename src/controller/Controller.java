package controller;

import model.Oferta;
import model.Sala;
import model.Solucion;
import utilidades.ObservadorSala;

public class Controller {
	Sala model;
	
	public Controller() {
		model = new Sala();
	}
	
	public void agregarOferta(Oferta oferta) {
		model.agregarOferta(oferta);
	}
	
	public void eliminarOferta(int id) {
		model.eliminarOferta(id);
	}
	
	public boolean existeOfertas() {
		return model.hayOfertas();
	}
	
	public Solucion getSolAG() {
		return model.mejorAdjudicacion();
	}

	public void agregarObs(ObservadorSala obs) {
		model.registrarObservadores(obs);
	}
	
	public void guardarInstancia() {
		model.guardarInstancia();
	}
	
	public void cargarInstancia() {
		model.cargarInstancia();
	}
	
	public boolean hayCambios() {
		return model.hayCambio();
	}
	
}
