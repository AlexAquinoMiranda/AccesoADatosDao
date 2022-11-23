package Modelo;

import java.io.Serializable;

public class Jugador implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String Apellido;
	private String dni;
	private int dorsal;
	private String equipo;

	public Jugador(String nombre, String apellido, String dni, int dorsal, String equipo) {

		this.nombre = nombre;
		this.Apellido = apellido;
		this.dni = dni;
		this.dorsal = dorsal;
		this.equipo= equipo;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", Apellido=" + Apellido + ", dni=" + dni + ", dorsal=" + dorsal
				+ ", equipo=" + equipo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public Jugador() {

	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String GuardarFichero() {
		return nombre + ";" + Apellido + ";" + dni + ";" + dorsal
				+ ";" + equipo;
	}

}
