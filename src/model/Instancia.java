package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Instancia {
	private int[] _horario;
	private ArrayList<Oferta> _ofertas;
	
	public Instancia() {
		_ofertas = new ArrayList<Oferta>();
		_horario = new int[24];
	}
	
	public void agregar(Oferta oferta) {
		_ofertas.add(oferta);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Oferta> Ofertas(){
		return (ArrayList<Oferta>) _ofertas.clone();
	}

	public int[] getHorario() {
		return _horario.clone();
	}

	public void eliminarOferta(int ID) {
		Iterator<Oferta> it = _ofertas.iterator();
		while(it.hasNext())
			if(it.next().getID() == ID)
				it.remove();	
	}	
}
