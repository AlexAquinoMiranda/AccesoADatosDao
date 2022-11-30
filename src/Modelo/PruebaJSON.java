package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PruebaJSON implements IModeloDao<Jugador> {

	public PruebaJSON() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Jugador t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Jugador t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Jugador get(Jugador t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Jugador> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Jugador t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {
		JSONObject objeto = new JSONObject();
		JSONArray myArray = new JSONArray();
		myArray.put(0, "nombre");
		myArray.put(1, "aquino");
		myArray.put(2, "miradna");
		myArray.put(3, "1243");
		myArray.put(4, "barca");
		objeto.put("jugador", myArray);
		
		try {
			PrintWriter out = new PrintWriter(
					new FileWriter(new File("C:\\Users\\34605\\Desktop\\resources\\archivoJson.json")));
			out.write(objeto.toString());
			out.close();
		} catch (FileNotFoundException ex) {
			System.err.println("error");
		} catch (IOException ex) {
		}

	}

	@Override
	public void cargar() {
		   FileReader file;
		try {
			file = new FileReader("C:\\Users\\34605\\Desktop\\resources\\archivoJson.json");
		
           
           JSONTokener token = new JSONTokener(file);
           JSONObject objectJson = new JSONObject(token);
		 JSONArray array = new JSONArray();
         
         array = (JSONArray) objectJson.get("jugador");
         for( int i=0; i<array.length(); i++){
             System.out.println(array.get(i));
         }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
