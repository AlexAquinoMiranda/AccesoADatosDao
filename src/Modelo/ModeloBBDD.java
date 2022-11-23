package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Modelo.bbddConector.ConectarBBDD;

public class ModeloBBDD implements IModeloDao<Jugador> {
	static ResultSet consultaJugadores = null;
	static Connection conexion = null;
	static PreparedStatement preparedStatement = null;

	@Override
	public void create(Jugador t) {
		String jugadorCMD = "INSERT INTO `jugadores`(`nombre`, `apellido`, `dni`, `dorsal`, `equipo` )"
				+ "	VALUES   ( ?, ?, ?, ?, ?)";
		int i = 0;
		try {

			conexion.setAutoCommit(false);

			preparedStatement = conexion.prepareStatement(jugadorCMD);
			preparedStatement.setString(1, t.getNombre());
			preparedStatement.setString(2, t.getApellido());
			preparedStatement.setString(3, t.getDni());
			preparedStatement.setInt(4, t.getDorsal());
			preparedStatement.setString(5, t.getEquipo());

			i += preparedStatement.executeUpdate();

			System.out.println(
					i + " CAMBIOS EFECTUADOS." + " \n  se ha insertado correctamente al jugador: " + t.getNombre());

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conexion != null)
					conexion.commit();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(Jugador t) {
		int cambios = 0;

		String comd = "delete from jugadores where dni =  ?";

		try {
			conexion.setAutoCommit(false);

			preparedStatement = conexion.prepareStatement(comd);
			preparedStatement.setString(1, t.getDni());

			cambios += preparedStatement.executeUpdate();

			System.out.println(cambios + " cambios efectuados");
			System.out.println("se ha eliminado al jugador " + t.getNombre());

		} catch (SQLException ex) {
			System.err.println(ex);
		} finally {
			if (conexion != null) {
				try {
					conexion.commit();
				} catch (SQLException e) {

				}
			}
		}

	}

	@Override
	public Jugador get(Jugador t) {
		if (conexion != null) {
			try {
				if (preparedStatement == null || preparedStatement.isClosed()) {

					String SQL = "Select * from jugadores where dni =?";
					preparedStatement = conexion.prepareStatement(SQL);
				}

				preparedStatement.setString(1, t.getDni());

				consultaJugadores = preparedStatement.executeQuery();
				while (consultaJugadores.next()) {
					System.out.print("{ id : " + consultaJugadores.getString(1) + ", nombre :"
							+ consultaJugadores.getString(2) + ", apellido : " + consultaJugadores.getString(3)
							+ ", dni :" + consultaJugadores.getString(4) + ", dorsal :" + consultaJugadores.getString(5)
							+ ", equipo :" + consultaJugadores.getString(6) + "}");
				}

			} catch (SQLException e) {
				System.err.println("error al buscar el objetos");
			}
		}
		return null;
	}

	@Override
	public List<Jugador> list() {
		List<Jugador> list = new ArrayList<>();
		if (conexion != null) {
			try {
				if (preparedStatement == null || preparedStatement.isClosed()) {

					String SQL = "Select * from  jugadores;";
					preparedStatement = conexion.prepareStatement(SQL);
				}

				consultaJugadores = preparedStatement.executeQuery();
				while (consultaJugadores.next()) {
//					list.add(new Jugador(consultaJugadores.getString(2), consultaJugadores.getString(3),
//							consultaJugadores.getString(4), Integer.valueOf(consultaJugadores.getString(5)),
//							consultaJugadores.getString(6)));
					System.out.print("\t{ id : " + consultaJugadores.getString(1) + ", nombre :"
							+ consultaJugadores.getString(2) + ", apellido : " + consultaJugadores.getString(3)
							+ ", dni :" + consultaJugadores.getString(4) + ", dorsal :" + consultaJugadores.getString(5)
							+ ", equipo :" + consultaJugadores.getString(6) + "}\n");
				}

			} catch (SQLException e) {
				System.err.println("error al buscar al objetos");
			}
		}

		return list;
	}

	public void conectarBBDD() {
		ConectarBBDD c = new ConectarBBDD();

		conexion = c.conectedMySQL();
	}

	@Override
	public void update(Jugador t) {
		String jugadorCMD = "update `gestionjugadores`.`jugadores` "
				+ "set `nombre` = ? , apellido= ?, dni = ?, dorsal= ?, equipo =?" + "where `dni` =?;";

		int i = 0;
		try {

			conexion.setAutoCommit(false);

			preparedStatement = conexion.prepareStatement(jugadorCMD);
			preparedStatement.setString(1, t.getNombre());
			preparedStatement.setString(2, t.getApellido());
			preparedStatement.setString(3, t.getDni());
			preparedStatement.setInt(4, t.getDorsal());
			preparedStatement.setString(5, t.getEquipo());
			preparedStatement.setString(6, t.getDni());

			i += preparedStatement.executeUpdate();

			System.out.println(
					i + " CAMBIOS EFECTUADOS." + " \n  se ha modificado correctamente al jugador: " + t.getNombre());

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (conexion != null)
					conexion.commit();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	public void liberarRecursos() {

		try {
			if (consultaJugadores != null) {
				consultaJugadores.close();
			}

			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (conexion != null) {
				System.out.println("\n \tdesconectado");
				conexion.close();
			}
		} catch (SQLException e) {
			System.err.println("No se ha podido liberar recursos");
		}

	}

	@Override
	public void save() {

	}

	@Override
	public void cargar() {
	}

}
