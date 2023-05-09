package control;

public class transformarsql {

	public static String insert_into(peliculas miPelicula) {

		return "INSERT INTO peliculas ( titulo, genero, estreno) VALUES ('" + miPelicula.getTitulo() + "', '"
				+ miPelicula.getGenero() + "', '" + miPelicula.getEstreno() + "');";
	}
	
	public static String update(peliculas miPelicula) {

		return "UPDATE peliculas SET titulo = '"+ miPelicula.getEstreno()+"', genero = '"+ miPelicula.getGenero() +"', estreno = "+ miPelicula.getEstreno() +" WHERE titulo = '"+ miPelicula.getTitulo() +"';";
	}

	public static String delete_from(peliculas miPelicula) {

		return "DELETE FROM peliculas WHERE titulo = '" + miPelicula.getTitulo() + "';";
	}

	
	
	public static String find(peliculas miPelicula) {

		return "SELECT * FROM peliculas WHERE titulo = '" + miPelicula.getTitulo() + "';";
}

	// DELETE FROM peliculas WHERE titulo = 'Avatar';

}
