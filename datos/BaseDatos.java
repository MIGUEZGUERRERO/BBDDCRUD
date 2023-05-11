package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que contiene metodo principal para ejecutar sentencias SQL en una base
 * de datos.
 * 
 * @author Francisco Miguez.
 * @version 1.3
 */
public class BaseDatos {

	/**
	 * Ejecuta una sentencia SQL en la base de datos.
	 * 
	 * @param sql la sentencia SQL a ejecutar.
	 */
	public static void accionSQL(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root", "");// proporcionamos la

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			System.out.println(sql);

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 0) {
				System.out.println("Sentencia SQL realizada correctamente en BBDD");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado");

	}

	/**
	 * Ejecuta una sentencia SQL en la base de datos.
	 * 
	 */
	public static void contarPeliculas() {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;
		String sql = "";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root", "");// proporcionamos la

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			sql = ("SELECT * FROM peliculas");

			rs = sentenciaSQL.executeQuery(sql);

			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				// numero= rs.getInt(1); // si es un int, puede ser un String
				System.out.println("Sentencia SQL realizada correctamente en BBDD");
				System.out.println("Título: " + rs.getString("titulo") + "Género: " + rs.getString("genero")
						+ "Estreno: " + rs.getInt("estreno"));
				System.out.println("------------------------");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado");
	}

	/**
	 * Ejecuta una sentencia SQL en la base de datos.
	 * 
	 */
	public static void buscarPeliculasSQL(String tituloPelicula) {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet rs = null;
		String sql = "";

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root", "");// proporcionamos la

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// almaceno el resultado de la sql en un resulset (conjunto de registros)
			sql = "SELECT * FROM peliculas WHERE titulo = '" + tituloPelicula + "';";
			System.out.println(sql);

			rs = sentenciaSQL.executeQuery(sql);

			boolean peliculaEncontrada = false;

			while (rs.next()) {
				// Si hay resultados obtengo el valor.
				// numero= rs.getInt(1); // si es un int, puede ser un String
				// System.out.println("Sentencia SQL realizada correctamente en BBDD");
				System.out.println("Título: " + rs.getString("titulo") + "Género: " + rs.getString("genero")
						+ "Estreno: " + rs.getInt("estreno"));
				System.out.println("------------------------");
				peliculaEncontrada = true;
			}

			// Si no encuentra la pelicula, devuelve no encontrado.
			if (!peliculaEncontrada) {
				System.out.println("No encontrado");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado");

	}

	/**
	 * Método para inicializar la base de datos eliminando todos los datos de la
	 * tabla 'peliculas'.
	 * 
	 */
	public static void iniciartodo() {
		Connection conexion = null;
		Statement sentenciaSQL = null;
		String sql = "";

		try {
			// Conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root", "");

			// Crear sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			// Borrar los datos de la tabla peliculas
			sql = "DELETE FROM peliculas";
			sentenciaSQL.executeUpdate(sql);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (sentenciaSQL != null) {
					sentenciaSQL.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Conexión cerrada");
	}

}
