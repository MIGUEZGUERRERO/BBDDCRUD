package control;


import java.util.ArrayList;
import java.util.Scanner;

import datos.baseDatos;

/**
 * Clase que recoge una LISTA del objeto pelicula, compuesta por título, género
 * y año de estreno.
 * 
 * @author Francisco Miguez
 * @version 1.4
 */
public class listaPeliculas {
	/**
	 * Lista de películas almacenadas con nombre hollywood.
	 */

	private ArrayList<peliculas> hollywood;

	/**
	 * Constructor que inicializa la lista de películas.
	 */

	public listaPeliculas() {
		this.hollywood = new ArrayList<peliculas>();

	}

	/**
	 * Método para añadir una película a una lista.
	 * 
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void anadirPelicula() {

		Scanner entrada = new Scanner(System.in);
		
		
		String titulo;
		boolean existe;
		do {
			existe = false;
			System.out.print("Ingrese el título de la película: ");
			titulo = entrada.nextLine();
			for (peliculas pelicula : hollywood) {
				if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
					System.out.println("La película ya existe en la lista.");
					existe = true;
					break;
				}
			}
		} while (existe);

		System.out.print("Ingrese el género de la película: ");
		String genero = entrada.nextLine();
		System.out.print("Ingrese el año de la película: ");
		int estreno = entrada.nextInt();
		peliculas nuevapelicula = new peliculas(titulo, genero, estreno);
		hollywood.add(nuevapelicula);
		System.out.println("La película ha sido añadida exitosamente.");
		peliculas miPeliculas=nuevapelicula;
		String sql=transformarsql.insert_into(miPeliculas);
		baseDatos.accionSQL(sql);
			
		System.out.println("La lista hollywood contiene actualmente " + hollywood.size() + " película/s.");
	}

	/**
	 * Método para modificar datos de una película existente en una lista.
	 * 
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void modificarPelicula() {

		Scanner entrada = new Scanner(System.in);

		do {
			System.out.print("Ingrese el título de la película a modificar: ");
			String tituloPelicula = entrada.nextLine();
			peliculas peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

			if (peliculaEncontrada == null) {
				System.out.println("La película no se encuentra en la lista. No se puede modificar.");

			} else {

				peliculas peliculaModificada = new peliculas(tituloPelicula, tituloPelicula, 0);

				System.out.println("Introduce el nuevo título de la película:");
				peliculaModificada.setTitulo(entrada.nextLine());
				System.out.println("Introduce el nuevo género de la película:");
				peliculaModificada.setGenero(entrada.nextLine());
				System.out.println("Introduce el nuevo año de la película:");
				peliculaModificada.getEstreno();
				peliculas miPeliculas=peliculaModificada;
				String sql=transformarsql.insert_into(miPeliculas);
				baseDatos.accionSQL(sql);
				int indicePelicula = hollywood.indexOf(peliculaEncontrada);
				hollywood.set(indicePelicula, peliculaModificada);
				System.out.println("La película se ha modificado correctamente.");
				break;
			}
		} while (true);
	}

	/**
	 * Método para eliminar una película de una lista.
	 * 
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void borrarPelicula() {
		Scanner entrada = new Scanner(System.in);

		System.out.print("Ingrese el título de la película a eliminar: ");
		String tituloPelicula = entrada.nextLine();
		peliculas peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

		if (peliculaEncontrada != null) {
			hollywood.remove(peliculaEncontrada);
			System.out.println("La película ha sido eliminada correctamente.");
			peliculas miPeliculas=peliculaEncontrada;
			String sql=transformarsql.delete_from(miPeliculas);
			baseDatos.accionSQL(sql);
		} else {
			System.out.println("La película no ha sido encontrada en la lista.");
		}
		System.out.println("La lista hollywood contiene ahora " + hollywood.size() + " película/s.");
	}

	/**
	 * Método para buscar película en una lista.
	 * 
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void buscarPelicula() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el título de la película a buscar: ");
		String tituloPelicula = entrada.nextLine();

		peliculas peliculaEncontrada = buscadorpeliculas(hollywood, tituloPelicula);

		if (peliculaEncontrada != null) {
			System.out.println("Título: " + peliculaEncontrada.getTitulo());
			System.out.println("Género: " + peliculaEncontrada.getGenero());
			System.out.println("Estreno: " + peliculaEncontrada.getEstreno());
			
		} else {
			System.out.println("La película no se encontró en la lista.");
		}

	}

	/**
	 * Método para mostrar las películas almacenadas en una lista.
	 * 
	 * @author Francisco Miguez
	 * @version 1.4
	 */
	public void mostrarPeliculas() {
		System.out.println("Listado de películas:");
		for (peliculas pelicula : hollywood) {
			System.out.println("Título: " + pelicula.getTitulo());
			System.out.println("Género: " + pelicula.getGenero());
			System.out.println("Año: " + pelicula.getEstreno());
			peliculas miPeliculas=pelicula;
			String sql=transformarsql.find(miPeliculas);
			baseDatos.contarPeliculas();
		}
		System.out.println("La lista hollywood contiene " + hollywood.size() + " pelicula/s actualmente.");
	}

	/**
	 * Método que pueden acceder otros métodos para buscar una película en una
	 * lista.
	 * 
	 * @param hollywood      Lista de películas en la que se realizará la búsqueda.
	 * @param tituloPelicula Título de la película a buscar.
	 * @return La película encontrada o null si no se encuentra.
	 */
	private peliculas buscadorpeliculas(ArrayList<peliculas> hollywood, String tituloPelicula) {
		int i = 0;
		peliculas pelicula = null;
		do {
			if (i >= hollywood.size()) {
				System.out.println("La película no se encuentra en la lista.");
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
