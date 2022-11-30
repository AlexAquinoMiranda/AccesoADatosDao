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
//		modelo = new ModeloFichero();
//		modelo.cargar();
////		modelo.create(new Jugador("alex", "aquino", "098", 7, "madrid"));
////		modelo.get(new Jugador("alex", "aquino", "098", 7, "madrid"));
//		System.out.println("desde .txt\n");
//		modelo.list();
//		modelo.save();
//
//		System.out.println("\n \ndesde csv \n");
//		modeloCSV = new ModeloCSV();
//		Jugador a = new Jugador("alexis", "aquisno", "09s8", 7, "masdrid");
//		modeloCSV.cargar();
//		modeloCSV.create(a);
//		modeloCSV.get( a);
//		modeloCSV.list();
//
//		System.out.println("\n\n desde binario");
//		modeloBinario = new ModeloBinario();
//		modeloBinario.cargar();
////		modeloBinario.create(new Jugador("ale", "aquino", "78909", 9, "argentina"));
////		modeloBinario.create(new Jugador("ale2", "aquin22o", "7892209", 29, "arg222entina"));
//
//		modeloBinario.list();
//		modeloBinario.save();
//
		System.out.println("\n \n desde bbdd mysql");
		modeloBBDD = new ModeloBBDD();
		modeloBBDD.conectarBBDD();

		modeloBBDD.create(new Jugador("marvin", "aquate", "7890666669", 9, "Ja66pon"));
		modeloBBDD.liberarRecursos();
		
		
		modeloBBDD.conectarBBDD();

		modeloBBDD.list();
		modeloBBDD.liberarRecursos();
		
		

		modeloBBDD.conectarBBDD();

		modeloBBDD.update(new Jugador("aleUpdrtjgfdate2", "aquinwroU22222pdate", "7890666669", 9, "Jadfdgp22on"));

		modeloBBDD.liberarRecursos();
		
		modeloBBDD.conectarBBDD();

		modeloBBDD.list();
		modeloBBDD.liberarRecursos();

//		modeloBBDD.conectarBBDD();
//
//		modeloBBDD.get(new Jugador("aleUpdate", "aquinoUpdate", "78909", 9, "Japon"));
//
//		modeloBBDD.liberarRecursos();

//		System.out.println("\n desde JSON");
//		modeloJson = new ModeloJson();
////		modeloJson.cargar();
////		modeloJson.create(new Jugador("hernan", "miranda", "081201201", 5, "france"));
////		modeloJson.create(new Jugador("hernafen2", "mirandaefdw2", "0814520122201", 552, "freffan2ce"));
//		modeloJson.save();
//		modeloJson.list();

//		System.out.println("\ndesde json prb de array\n");
//		PruebaJSON a = new PruebaJSON();
//		
//		a.save();
//		a.cargar();

	}

}
