package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import defaultSala.Oferta;
import model.Sala;
import views.Dashboard;
import views.PanelRegistro;

public class Controller {
	Sala model;
	Dashboard dashboard;
	PanelRegistro panelRegistro;
	
	
	public Controller() {
		panelRegistro = new PanelRegistro();
		dashboard = new Dashboard();
		dashboard.getFrame().setVisible(true);
		model = new Sala();
		model.registrarObservadores(panelRegistro);
	}
	
	public void run() {
		panelRegistro.getBtnAñadirOferta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				int monto = Integer.parseInt(tfMonto.getText());
				int horaDesde = (int) spDesde.getValue();
				int horaHasta = (int) spHasta.getValue();
				int cantIntegrantes = (int) spCantInt.getValue();

				new Oferta(tfNombre.getText(), tfTelefono.getText(), monto, horaDesde, horaHasta, cantIntegrantes);

				panelRegistro.limpiarCampos();
			}
		});
	}
	
	
}
