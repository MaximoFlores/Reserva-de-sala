package defaultSala;

public class Oferta {
	private int _horaDesde;
	private int _horaHasta;
	private int _monto;
	private String _nombreOferente;
	private String _telefono;
	private int _cantIntegrantes;
	
	public Oferta(String nombreOferente, String telefono, int monto, int horaDesde, int horaHasta, int cantIntegrantes) {
		_nombreOferente = nombreOferente;
		_telefono = telefono;
		_cantIntegrantes = cantIntegrantes;
		_monto = monto;
		_horaDesde = horaDesde;
		_horaHasta = horaHasta;
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

	public String get_nombreOferente() {
		return _nombreOferente;
	}

	public String get_telefono() {
		return _telefono;
	}

	public int get_cantIntegrantes() {
		return _cantIntegrantes;
	}
	
}
