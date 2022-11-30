package Controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import Modelo.IModeloDao;

public class Controller {

	private IModeloDao model;
	private JFrame vista;

	public Controller(IModeloDao model, JFrame vista) {
		this.vista = vista;
		this.model = model;
	}

	void eventos() {
		model.cargar();
		model.list();
	}

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		Scanner sc = new Scanner(System.in);
		System.out.println("\t Menú: \n" + "1. Dar Alta Jugador.\n" + "2. Consultar ficha de jugador.\n"
				+ "3. Listado de jugadores.\n" + "4. Dar de baja jugador.\n" + "5. generar volcado a  extensión txt.\n"
				+ "6. Cargar jugadores desde txt/csv.\n" + "7. Generar volcado a extensión {.dat}\n" + "8. Salir.\n\n"

				+ "Introuce  valor de  acción a realizar: ");

		int valor = 0;
		try {
			valor = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("¡Ingresa un valor correcto!");
		}
		
		switch(valor) {
		case 1: 
			System.out.println("valor 1");
			break;
		case 2: 
			System.out.println("valor 2");
			break;
		case 3: 
			System.out.println("valor 3");
			break;
		case 4: 
			System.out.println("valor 4");
			break;
		case 5: 
			System.out.println("valor 5");
			break;
		case 6: 
			System.out.println("valor 6");
			break;
		case 7: 
			System.out.println("valor 7");
			break;
		case 8: 
			System.out.println("valor 8");
			break;
		}

	}

}
