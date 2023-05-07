package control;
/**
 * Clase que recoge el OBJETO pelicula, compuesta por título, género y año de
 * estreno.
 * 
 * @author Francisco Miguez
 * @version 1.5
 */
public class peliculas {

	// Atributos de la pelicula.
		private int idpelicula;
		private String titulo;
		private String genero;
		private int estreno;
		public peliculas(int idpelicula, String titulo, String genero, int estreno) {
			super();
			this.idpelicula = idpelicula;
			this.titulo = titulo;
			this.genero = genero;
			this.estreno = estreno;
		}
		public peliculas(String titulo, String genero, int estreno) {
			super();
			this.titulo = titulo;
			this.genero = genero;
			this.estreno = estreno;
		}
		public int getIdpelicula() {
			return idpelicula;
		}
		public void setIdpelicula(int idpelicula) {
			this.idpelicula = idpelicula;
		}
		public String getTitulo() {
			return titulo;
		}
		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public int getEstreno() {
			return estreno;
		}
		public void setEstreno(int estreno) {
			this.estreno = estreno;
		}
		@Override
		public String toString() {
			return "peliculas [idpelicula=" + idpelicula + ", titulo=" + titulo + ", genero=" + genero + ", estreno="
					+ estreno + "]";
		}
		
		
	
}
