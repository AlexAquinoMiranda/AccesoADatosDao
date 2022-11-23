package Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ModeloBinario implements IModeloDao<Jugador> {
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
		ObjectOutputStream serializador = null;

		try {
			serializador = new ObjectOutputStream(new FileOutputStream(".\\resources\\FicheroBinario.dat"));

			serializador.writeObject(this.listaJugadores);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (serializador != null) {
					serializador.close();
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	}

	@Override
	public void cargar() {
		ObjectInputStream deserializador = null;
		try {
			deserializador = new ObjectInputStream(new FileInputStream(".\\resources\\FicheroBinario.dat"));
			this.listaJugadores = (ArrayList<Jugador>) deserializador.readObject();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
