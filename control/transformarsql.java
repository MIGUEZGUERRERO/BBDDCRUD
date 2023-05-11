package control;

public class transformarsql {

	public static String insert_into(peliculas miPeliculas) {

		return "INSERT INTO peliculas ( titulo, genero, estreno) VALUES ('" + miPeliculas.getTitulo() + "', '"
				+ miPeliculas.getGenero() + "', '" + miPeliculas.getEstreno() + "');";
	}

	public static String update(peliculas miPeliculas, String tituloAntiguo) {
		return "UPDATE peliculas SET titulo = '" + miPeliculas.getTitulo() + "', genero = '" + miPeliculas.getGenero()
				+ "', estreno = " + miPeliculas.getEstreno() + " WHERE titulo = '" + tituloAntiguo + "';";
	}

	public static String delete_from(peliculas miPeliculas) {

		return "DELETE FROM peliculas WHERE titulo = '" + miPeliculas.getTitulo() + "';";
	}

	public static String mostrar(peliculas miPeliculas) {

		return "SELECT * FROM peliculas WHERE titulo = ' " + miPeliculas.getTitulo() + " ';";
	}

}
