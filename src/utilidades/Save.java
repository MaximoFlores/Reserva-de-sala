package utilidades;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.Instancia;
import model.Oferta;

public class Save {
	

	    public static void saveInstance(ArrayList<Oferta> listaOfertas) {
	        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(listaOfertas);
	        try {
	            FileWriter writer = new FileWriter("src/utilidades/RegistroOfertas.json");
	            writer.write(json);
	            writer.close();
	        } catch (Exception e) {
	        }
	    }
	
	
	
//	public static void saveInstance(Instancia instancia) {
//		try {
//			FileOutputStream archivo = new FileOutputStream("src/utilidades/Instancia.txt");
//			ObjectOutputStream guardar_instancia = new ObjectOutputStream(archivo);
//			guardar_instancia.writeObject(instancia);
//			guardar_instancia.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
}
