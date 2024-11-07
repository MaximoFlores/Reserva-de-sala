package controller;

import model.Oferta;
import model.Sala;
import views.Observador;

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

	public void agregarObs(Observador obs) {
		model.registrarObservadores(obs);
	}
	
}
