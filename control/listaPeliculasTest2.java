package control;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Clase que contiene las pruebas unitarias para la clase controlador.
 */
class listaPeliculasTest2 extends controlador {

	/**
	 * Prueba para el método anadirPelicula().
	 */
	@Test
	void testAnadirPelicula() {
		// Creamos una nueva película con los datos.
		peliculas nuevaPelicula = new peliculas("El Padrino", "Drama", 1972);

		// Creamos una nueva lista de películas y añadimos la nueva película.
		ArrayList<peliculas> listaPeliculas = new ArrayList<>();
		listaPeliculas.add(nuevaPelicula);

		// Verificamos que la lista contenga la película añadida.
		assertTrue(listaPeliculas.contains(nuevaPelicula));
		assertTrue(nuevaPelicula.getTitulo().equalsIgnoreCase("El Padrino"));
	}

	/**
	 * Prueba para el método modificarPelicula().
	 */
	@Test
	void testModificarPelicula() {
		// Creamos una lista de películas.
		ArrayList<peliculas> peliculas = new ArrayList<>();
		peliculas.add(new peliculas("Star Wars", "Ciencia ficción", 1977));
		peliculas.add(new peliculas("Matrix", "Ciencia ficción", 1999));

		// Modificamos una película.
		peliculas peliculaModificada = new peliculas("Matrix", "Acción", 1999); // Nueva película
		String tituloPelicula = "Matrix"; // Película a modificar
		peliculas peliculaEncontrada = buscadorpeliculas(peliculas, tituloPelicula);

		if (peliculaEncontrada == null) {
			fail("La película no se encuentra en la lista. No se puede modificar.");
		} else {
			int indicePelicula = peliculas.indexOf(peliculaEncontrada);
			peliculas.set(indicePelicula, peliculaModificada);
		}

		// Verificamos que los datos modificados sean los correctos.
		peliculas peliculaModificadaEncontrada = buscadorpeliculas(peliculas, peliculaModificada.getTitulo());
		assertNotNull(peliculaModificadaEncontrada);
		assertEquals(peliculaModificada.getGenero(), peliculaModificadaEncontrada.getGenero());
		assertEquals(peliculaModificada.getEstreno(), peliculaModificadaEncontrada.getEstreno());
	}

	/**
	 * Prueba para el método borrarPelicula().
	 */
	@Test
	public void testBorrarPelicula() {
		// Creamos una lista de películas y agregamos películas.
		ArrayList<peliculas> hollywood = new ArrayList<>();
		hollywood.add(new peliculas("Star Wars", "Ciencia ficción", 1977));
		hollywood.add(new peliculas("Matrix", "Ciencia ficción", 1999));

		// Eliminamos una película de la lista.
		String PeliculaEliminar = "Matrix";
		borrarPelicula(hollywood, PeliculaEliminar);

		// Verificamos que la película ha sido eliminada correctamente.
		peliculas peliculaEncontrada = buscadorpeliculas(hollywood, PeliculaEliminar);
		assertEquals(1, hollywood.size());
	}

	private void borrarPelicula(ArrayList<peliculas> hollywood, String tituloPelicula) {
		peliculas peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

		if (peliculaEncontrada != null) {
			hollywood.remove(peliculaEncontrada);

		} else {
			// System.out.println("La película no ha sido encontrada en la lista.");
		}
		// System.out.println("La lista hollywood contiene ahora " + hollywood.size() +"
		// película/s.");
	}

	/**
	 * Prueba unitaria para el método Buscarpelicula().
	 */
	@Test
	void testBuscarPelicula() {
		// Creamos una lista de películas.
		ArrayList<peliculas> hollywood = new ArrayList<>();

		// Buscamos una película en la lista.
		String tituloPeliculaAEliminar = "Matrix";
		borrarPelicula(hollywood, tituloPeliculaAEliminar);

		// Verificamos que la película no ha sido encontrada en la lista.
		peliculas peliculaEncontrada = buscadorpeliculas(hollywood, tituloPeliculaAEliminar);
		assertNull(peliculaEncontrada);
	}

	private peliculas buscadorpeliculas(ArrayList<peliculas> hollywood, String tituloPelicula) {
		int i = 0;
		peliculas pelicula = null;
		do {
			if (i >= hollywood.size()) {
				break;
			}
			pelicula = hollywood.get(i);
			if (pelicula.getTitulo().equalsIgnoreCase(tituloPelicula)) {
				break;
			}
			i++;
		} while (true);

		return pelicula;
	}
}
