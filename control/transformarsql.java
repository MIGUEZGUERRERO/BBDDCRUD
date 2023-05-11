package control;

/**
 * Clase para transformar objetos Peliculas a sentencias SQL de inserción,
 * actualización, eliminación y consulta.
 */
public class transformarsql {

	/**
	 * Convierte un objeto Peliculas en una sentencia SQL de inserción
	 * 
	 * @param miPeliculas objeto Peliculas a insertar
	 * @return sentencia SQL de inserción
	 */
	public static String insert_into(peliculas miPeliculas) {

		return "INSERT INTO peliculas ( titulo, genero, estreno) VALUES ('" + miPeliculas.getTitulo() + "', '"
				+ miPeliculas.getGenero() + "', '" + miPeliculas.getEstreno() + "');";
	}

	/**
	 * Convierte un objeto Peliculas y su título antiguo en una sentencia SQL de
	 * actualización
	 * 
	 * @param miPeliculas   objeto Peliculas a actualizar
	 * @param tituloAntiguo título antiguo de la Peliculas
	 * @return sentencia SQL de actualización
	 */
	public static String update(peliculas miPeliculas, String tituloAntiguo) {
		return "UPDATE peliculas SET titulo = '" + miPeliculas.getTitulo() + "', genero = '" + miPeliculas.getGenero()
				+ "', estreno = " + miPeliculas.getEstreno() + " WHERE titulo = '" + tituloAntiguo + "';";
	}

	/**
	 * Convierte un objeto Peliculas en una sentencia SQL de eliminación
	 * 
	 * @param miPeliculas objeto Peliculas a eliminar
	 * @return sentencia SQL de eliminación
	 */
	public static String delete_from(peliculas miPeliculas) {

		return "DELETE FROM peliculas WHERE titulo = '" + miPeliculas.getTitulo() + "';";
	}

	/**
	 * Convierte un objeto Peliculas en una sentencia SQL de consulta
	 * 
	 * @param miPeliculas objeto Peliculas a consultar
	 * @return sentencia SQL de consulta
	 */
	public static String mostrar(peliculas miPeliculas) {

		return "SELECT * FROM peliculas WHERE titulo = ' " + miPeliculas.getTitulo() + " ';";
	}

}
