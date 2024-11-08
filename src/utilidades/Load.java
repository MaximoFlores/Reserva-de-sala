package utilidades;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

import com.google.gson.Gson;

import model.Instancia;

public class Load {
	
	public static Instancia loadInstance() {
        Gson gson = new Gson();
        Instancia ret = null;

     try{
         BufferedReader br = new BufferedReader(new FileReader("src/utilidades/RegistroOfertas.json"));
         ret = gson.fromJson(br, Instancia.class);
     }
     catch (Exception e) {

     }

     return ret;
}

    public static boolean hayArchivoInstancia() {
        try {
            BufferedReader ret = new BufferedReader(new FileReader("src/utilidades/RegistroOfertas.json"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
//	public static Instancia loadInstance() {
//		Instancia ret = null;
//		try {
//			FileInputStream archivo = new FileInputStream("src/utilidades/Instancia.txt");
//			ObjectInputStream guardar_instancia = new ObjectInputStream(archivo);
//			ret = (Instancia)guardar_instancia.readObject();
//			guardar_instancia.close();
//		} catch (Exception e) {
//			System.out.println("no hay archivo");
//		}
//		return ret;
//	}
//	public static boolean hayArchivoInstancia() {
//		try {
//			FileInputStream ret = new FileInputStream("src/utilidades/Instancia.txt");
//		} catch (Exception e) {
//			return false;
//		}
//		return true;
//	}

}
