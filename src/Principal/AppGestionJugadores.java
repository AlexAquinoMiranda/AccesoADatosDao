package Principal;

import Modelo.IModeloDao;
import Modelo.*;

public class AppGestionJugadores {

	private static IModeloDao modelo = null;
	private static IModeloDao modeloCSV = null;
	private static IModeloDao modeloBinario = null;
	private static ModeloBBDD modeloBBDD = null;
	private static IModeloDao modeloJson = null;

	public static void main(String[] args) {
		modelo = new ModeloFichero();
		modelo.cargar();
		modelo.create(new Jugador("ale", "aquino", "78909", 9, "argentina"));
		System.out.println("desde .txt\n");
		modelo.list();
		modelo.save();

		System.out.println("\n \ndesde csv \n");
		modeloCSV = new ModeloCSV();
		modeloCSV.cargar();
		modeloCSV.list();

		System.out.println("\n\n desde binario");
		modeloBinario = new ModeloBinario();
//		modeloBinario.cargar();
		modeloBinario.create(new Jugador("ale", "aquino", "78909", 9, "argentina"));
		modeloBinario.create(new Jugador("ale2", "aquin22o", "7892209", 29, "arg222entina"));

		modeloBinario.list();
		modeloBinario.save();

		System.out.println("\n \n desde bbdd mysql");
		modeloBBDD = new ModeloBBDD();
		modeloBBDD.conectarBBDD();

		modeloBBDD.list();

		modeloBBDD.liberarRecursos();
		
		
		
		
		System.out.println("\n desde JSON");
		modeloJson = new ModeloJson();
//		modeloJson.cargar();
		modeloJson.create(new Jugador("hernan", "miranda", "081201201", 5, "france"));
		modeloJson.create(new Jugador("hernafen2", "mirandaefdw2", "0814520122201", 552, "freffan2ce"));
		modeloJson.save();
		modeloJson.list();
		

	}

}
