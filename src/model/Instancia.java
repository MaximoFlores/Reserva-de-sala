package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Instancia implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Oferta[] _horario;
	private ArrayList<Oferta> _ofertas;
	//Parametros
	private int cantHorasXDia = 24;
	
	public Instancia() {
		_ofertas = new ArrayList<Oferta>();
		_horario = new Oferta[cantHorasXDia];
	}
	
	public Instancia(ArrayList<Oferta> ofertas) {
		_ofertas = ofertas;
		_horario = new Oferta[cantHorasXDia];
	}
	
	public void agregar(Oferta oferta) {
		_ofertas.add(oferta);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Oferta> Ofertas(){
		return (ArrayList<Oferta>) _ofertas.clone();
	}
	
	public int getCantOfertas() {
		return _ofertas.size();
	}

	public Oferta[] getHorario() {
		return _horario.clone();
	}

	public void eliminarOferta(int ID) {
		Iterator<Oferta> it = _ofertas.iterator();
		while(it.hasNext())
			if(it.next().getID() == ID)
				it.remove();	
	}	
}
