package control;
/**
 * Clase que recoge el OBJETO pelicula, compuesta por título, género y año de
 * estreno.
 * 
 * @author Francisco Miguez
 * @version 1.3
 */
public class peliculas {

	
	
	// Atributos de la pelicula.
	private int idpelicula;
	private String titulo;
	private String genero;
	private int estreno;



	/**
	 * Constructor de la clase "objetopelicula".
	 * 
	 * @param idpelicula El id de la película.
	 * @param titulo El título de la película.
	 * @param genero El género de la película.
	 * @param ano    El año de estreno de la película.
	 */
	
	public peliculas(int idpelicula, String titulo, String genero, int estreno) {
		super();
		this.idpelicula = idpelicula;
		this.titulo = titulo;
		this.genero = genero;
		this.estreno = estreno;
	}

	/**
	 * Constructor de la clase "objetopelicula".
	 * 
	 * @param titulo El título de la película.
	 * @param genero El género de la película.
	 * @param ano    El año de estreno de la película.
	 */
	
	//Se realiza un segundo constructor, porque en la BBDD  el id lo genera de manera automática.
	public peliculas(String titulo, String genero, int estreno) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.estreno = estreno;
	}

	/**
	 * Método getter. Devuelve el id de la película.
	 * 
	 * @return El id de la película.
	 */
	public int getIdpelicula() {
		return idpelicula;
	}
	/**
	 * Método setter. Establece id de la película.
	 * 
	 * @param id El id de la película.
	 */
	public void setIdpelicula(int idpelicula) {
		this.idpelicula = idpelicula;
	}
	/**
	 * Método getter. Devuelve el título de la película.
	 * 
	 * @return El título de la película.
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * Método setter. Establece título de la película.
	 * 
	 * @param titulo El título de la película.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * Método getter.Devuelve el género de la película.
	 * 
	 * @return El género de la película.
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * Método setter.Establece el género de la película.
	 * 
	 * @param genero El género de la película.
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * Método getter.Devuelve el año de estreno de la película.
	 * 
	 * @return El año de estreno de la película.
	 */
	public int getEstreno() {
		return estreno;
	}
	/**
	 * Método setter.Establece el año de estreno de la película.
	 * 
	 * @param ano El año de estreno de la película.
	 */
	public void setEstreno(int estreno) {
		this.estreno = estreno;
	}
	/**
	 * Devuelve una cadena de caracteres del objeto película.
	 * 
	 * @return Una cadena de caracteres del objeto película.
	 */
	@Override
	public String toString() {
		return "peliculas [idpelicula=" + idpelicula + ", titulo=" + titulo + ", genero=" + genero + ", estreno="
				+ estreno + "]";
	}



	
	
	



	


	
	


	
	
	
	

	
	
}

