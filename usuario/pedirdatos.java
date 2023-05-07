package usuario;

import java.util.Scanner;

import control.peliculas;

public class pedirdatos {

	public static int pedirNumero(int numeroinicial, int numerofinal, String mensaje) {

		Scanner entrada = new Scanner(System.in);
		int numero = 0;

		try {

			do {
				System.out.println(mensaje);
				numero=entrada.nextInt();
				entrada.nextLine();

			} while (numero < numeroinicial || numero > numerofinal);

		} catch (Exception e) {
			// TODO: handle exception
			numero=6;
		}

		return numero;
	}

	/*
	 * public static peliculas pedirPeliculas() {
	 * 
	 * String titulo; String genero; int estreno;
	 * 
	 * return new peliculas(titulo, genero, estreno); }
	 */

}
