package control;


import usuario.menu;
import usuario.pedirdatos;

public class controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion = 0;
		
		listaPeliculas listaA = new listaPeliculas("A");
		
		do {
			menu.mostrarMenu();
			opcion = pedirdatos.pedirNumero(1, 6, "Seleccione una opción del MENU: ");
			if (opcion>=1 &&opcion<=5) {
			procesarOpcion(opcion,listaA);	
				
			}

		} while (opcion != 6);

		System.out.println("Sayonara Baby");
	}

	private static void procesarOpcion (int opcion, listaPeliculas listaA) {
		
		switch (opcion) {
		case 1:
			//peliculas.anadirPelicula();
		case 2:
			//peliculas.modificarPelicula();
			break;
		case 3:
			//peliculas.borrarPelicula();
			break;
		case 4:
			//peliculas.buscarPelicula();
			break;
		case 5:
			listaA.mostrarPeliculas();
			break;
	}
			
	}
}
