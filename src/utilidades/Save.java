package utilidades;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import model.Instancia;

public class Save {
	public static void saveInstance(Instancia instancia) {
		try {
			FileOutputStream archivo = new FileOutputStream("src/utilidades/Instancia.txt");
			ObjectOutputStream guardar_instancia = new ObjectOutputStream(archivo);
			guardar_instancia.writeObject(instancia);
			guardar_instancia.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
