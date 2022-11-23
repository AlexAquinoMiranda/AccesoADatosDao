package Modelo.bbddConector;

import java.sql.*;

public class ConectarBBDD {

	private static String cadenaConexion = "jdbc:mysql://localhost:3306/gestionjugadores";
	private static String user = "root";
	private static String pass = "root1234";
	static Connection conexion = null;

	public Connection conectedSQL() {
		Connection conex = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			conex = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "12345");
//		} catch (ClassNotFoundException e) {
//			System.err.println("Error en  class.forName");
		} 
		catch (SQLException e) {

			System.err.println("Error al conectar el driver");
		}
		if (conex != null) {
			System.out.println("¡Conectado satisfactoriamente! \n\n");
		}
		return conex;

	}

	public Connection conectedMySQL() {
		Connection conexion = null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(cadenaConexion, user, pass);
		}

		catch (SQLException e) {
			System.err.println("Error al conectar el driver");
			// Lo que sea
		} 
//		catch (ClassNotFoundException e) {
//			System.err.println("Error en  class.forName");
//		}
		if (conexion != null) {
			System.out.println("¡Conectado satisfactoriamente! \n\n");
		}
		return conexion;

	}
	

	
}
