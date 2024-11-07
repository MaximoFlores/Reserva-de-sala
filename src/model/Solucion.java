package model;

import java.util.ArrayList;

public class Solucion {

	private Instancia _instancia;
	private ArrayList<Oferta> _ofertas;
	public int[] _horario;
	private int _monto;
	
	public Solucion(Instancia instancia) {
		_instancia = instancia;
		_ofertas = new ArrayList<Oferta>();
		_horario = instancia.getHorario();
	}
	
	public void agregar(Oferta oferta) {
		_ofertas.add(oferta);
		_monto += oferta.getMonto();
		setHorario(oferta);
	}

	private void setHorario(Oferta oferta) {
		for (int i = oferta.getHoraDesde()-1; i < oferta.getHoraHasta()-1; i++) {
			_horario[i] = 1;
		}
	}	
	
	public boolean horarioDisponible(Oferta oferta) {
		for (int i = oferta.getHoraDesde()-1; i < oferta.getHoraHasta()-1; i++) {
			if(_horario[i]==1) {
				return false;
			}
		}
		return true;
	}

	public int getMonto() {
		return _monto;
	}
	
}
