package control;

import java.util.ArrayList;

public class listaPeliculas {

	
	//atributos
	private String identificador;
	private ArrayList<peliculas> listadoPeliculas= new ArrayList<peliculas>();
	
	//constructor
	public listaPeliculas(String identificador) {
		super();
		this.identificador = identificador;
	}

	
	//getter setter
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public ArrayList<peliculas> getHollywood() {
		return listadoPeliculas;
	}

	public void setHollywood(ArrayList<peliculas> hollywood) {
		this.listadoPeliculas = hollywood;
	}

	
	@Override
	public String toString() {
		return "listaPeliculas [identificador=" + identificador + ", hollywood=" + listadoPeliculas + "]";
	}
	
	public void mostrarPeliculas(){
		System.out.println("LISTADO DE PELICULAS:");
		for (peliculas item : listadoPeliculas) {
			System.out.println("TITULO:  " + item.getTitulo());
			System.out.println("GENERO:  " + item.getGenero());
			System.out.println("ESTRENO: " + item.getEstreno());
			System.out.println("******************************");
		}
		
		
		
	}
	
	
}
