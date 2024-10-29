package controller;

import model.Model;
import views.Dashboard;

public class Controlador {
	Model model;
	Dashboard dashboard;
	
	
	public Controlador() {
		dashboard = new Dashboard();
		model = new Model();
		model.registrarObservadores(null);
	}
	
	
}
