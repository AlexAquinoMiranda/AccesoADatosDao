package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ModeloFichero implements IModeloDao<Jugador> {

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
		System.out.println(this.listaJugadores.get(value));
		return this.listaJugadores.get(value);

	}

	@Override
	public List<Jugador> list() {
		System.out.println(this.listaJugadores.size());
		for (Jugador a : listaJugadores) {
			System.out.println(a.toString());
		}
		return this.listaJugadores;
	}

	@Override
	public void update(Jugador t) {

	}

	@Override
	public void save() {
		String p = "." + File.pathSeparator + "resources" + File.pathSeparator + "ficheroJugadores.txt";
		File fichero = new File(p);
		FileWriter fw = null;
		BufferedWriter buffer = null;

		try {
			fw = new FileWriter(fichero, true);
			buffer = new BufferedWriter(fw);
			// recibir p en formato de ;añe;
		
			//me falta guardarlo en formato ;
			for (Jugador a : this.listaJugadores) {
			buffer.write("\n" + a.GuardarFichero());
			}

		} catch (IOException e) {

		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {

				}
			}
		}

	}

	@Override
	public void cargar() {
		String p = ".\\resources\\ficheroJugadores.txt";
		File fichero = new File(p);
		FileReader fr = null;
		BufferedReader buffer = null;
		String[] datos = null;
		String texto = null;
		try {
			fr = new FileReader(fichero);
			buffer = new BufferedReader(fr);
			
			
			while ((texto = buffer.readLine()) != null) {
				datos = texto.split(";");
				this.listaJugadores
						.add(new Jugador(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4]));
			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (buffer != null) {
				try {
					buffer.close();
				} catch (IOException e) {

				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {

				}
			}
		}

	}

}
