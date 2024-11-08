package model;

import java.io.Serializable;

public class Oferta implements Serializable{
	private static int contador = 1;
	private int _id;
	private String _nombreOferente;
	private String _telefono;
	private int _monto;
	private int _horaDesde;
	private int _horaHasta;
	private int _cantIntegrantes;
	
	public Oferta(String nombreOferente, String telefono, int monto, int horaDesde, int horaHasta, int cantIntegrantes) {
		verificarHorario(horaDesde,horaHasta);
		_nombreOferente = nombreOferente;
		_telefono = telefono;
		_cantIntegrantes = cantIntegrantes;
		_monto = monto;
		_horaDesde = horaDesde;
		_horaHasta = horaDesde == horaHasta?(horaHasta+1):horaHasta;
		_id = contador++;
	}
	private void verificarHorario(int desde, int hasta) {
		if(desde>hasta) 
			throw new IllegalArgumentException("El horario elegido es incompatible");
	}
	
	public int getHoraDesde() {
		return _horaDesde;
	}

	public int getHoraHasta() {
		return _horaHasta;
	}

	public int getCantHoras() {
		return _horaHasta - _horaDesde;
	}

	public int getMonto() {
		return _monto;
	}

	public String getNombreOferente() {
		return _nombreOferente;
	}

	public String getTelefono() {
		return _telefono;
	}

	public int getCantIntegrantes() {
		return _cantIntegrantes;
	}
	
	public int getID() {
		return _id;
	}
	
}
