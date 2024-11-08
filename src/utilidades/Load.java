package utilidades;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Instancia;
import model.Oferta;

public class Load {
	
	public static ArrayList<Oferta> loadInstance() {
        Gson gson = new Gson();
        ArrayList<Oferta> ret = null;

     try{
         BufferedReader br = new BufferedReader(new FileReader("src/utilidades/RegistroOfertas.json"));
         Type ofertaListType = new TypeToken<ArrayList<Oferta>>(){}.getType();
         ret = (ArrayList<Oferta>) gson.fromJson(br, ofertaListType);
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
