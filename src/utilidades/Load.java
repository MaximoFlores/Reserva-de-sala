package utilidades;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import model.Instancia;

public class Load {
	public static Instancia loadInstance() {
		Instancia ret = null;
		try {
			FileInputStream archivo = new FileInputStream("src/utilidades/Instancia.txt");
			ObjectInputStream guardar_instancia = new ObjectInputStream(archivo);
			ret = (Instancia)guardar_instancia.readObject();
			guardar_instancia.close();
		} catch (Exception e) {
			System.out.println("no hay archivo");
		}
		return ret;
	}
	public static boolean hayArchivoInstancia() {
		try {
			FileInputStream ret = new FileInputStream("src/utilidades/Instancia.txt");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
