package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

public class ModeloJson implements IModeloDao<Jugador> {
	List<Jugador> listaJugadores = new ArrayList<>();

	@Override
	public void create(Jugador t) {
		this.listaJugadores.add(t);
	}

	@Override
	public void delete(Jugador t) {
		int value = this.listaJugadores.lastIndexOf(t);
		this.listaJugadores.remove(value);
	}

	@Override
	public Jugador get(Jugador t) {
		int value = this.listaJugadores.lastIndexOf(t);
		return this.listaJugadores.get(value);
	}

	@Override
	public List<Jugador> list() {
		for (Jugador a : this.listaJugadores) {
			System.out.println(a.toString());
		}
		return listaJugadores;
	}

	@Override
	public void update(Jugador t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() {

		try {
			JSONObject objeto = new JSONObject();

			for (Jugador a : listaJugadores) {
				objeto.put("jugador",a.toString());
//				objeto.put("nombre", a.getNombre());
//				objeto.put("apellido", a.getApellido());
//				objeto.put("dni", a.getDni());
//				objeto.put("dorsal", a.getDorsal());
//				objeto.put("equipo", a.getEquipo());

				PrintWriter out = new PrintWriter(new FileWriter(new File(".\\resources\\FicheroJSON.json")), true);
				out.write(objeto.toString());
				out.close();
			}
		} catch (FileNotFoundException ex) {
			System.err.println("error");
		} catch (IOException ex) {
//     Logger.getLogger(JsonAcces.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public void cargar() {
		try {
			FileReader file = new FileReader(".\\resources\\FicheroJSON.json");

			JSONTokener token = new JSONTokener(file);
			JSONObject objectJson = new JSONObject(token);

			Jugador a = new Jugador();
			for (int i = 0; i < objectJson.length(); i += 5) {
				a.setNombre((String) objectJson.get("nombre"));
				a.setApellido((String) objectJson.get("apellido"));
				a.setDni((String) objectJson.get("dni"));
				a.setDorsal((int) objectJson.get("dorsal"));
				a.setEquipo((String) objectJson.get("equipo"));
				this.listaJugadores.add(a);

//                    
			}

		} catch (FileNotFoundException ex) {

		}
	}

}
