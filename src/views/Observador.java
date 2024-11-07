package views;

import model.Sala;

public interface Observador {

	public void notificar(Sala sala);
}
