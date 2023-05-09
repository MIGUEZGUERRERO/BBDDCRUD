package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baseDatos {

	
	public static void accionSQL(String sql) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		int resultado = 0;

		try {
			// conectar con la base de datos
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root", "");// proporcionamos la
																									// dirección, el
																									// administrador y
																									// la clave

			// creamos sentencias ejecutables sobre esa conexión
			sentenciaSQL = conexion.createStatement();

			System.out.println(sql);

			resultado = sentenciaSQL.executeUpdate(sql);

			if (resultado >= 0) {
				System.out.println("Sentencia SQL realizada correctamente en BBDD");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			// System.out.println("Error");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				sentenciaSQL.close();
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		System.out.println("Conectado/desconectado");

	}

	public static void contarPeliculas() {
	    Connection conexion=null;
	    Statement sentenciaSQL = null;
	    ResultSet rs=null;
	  

	    try {
	        //conectar con la base de datos
	        Class.forName("com.mysql.jdbc.Driver");
	        conexion = DriverManager.getConnection("jdbc:mysql://localhost/peliculas",
	                "root", "");// proporcionamos la dirección, el administrador y la clave

	        //creamos sentencias ejecutables sobre esa conexión
	        sentenciaSQL = conexion.createStatement();

	        //almaceno el resultado de la sql en un resulset (conjunto de registros)
	        rs  = sentenciaSQL.executeQuery("SELECT * FROM peliculas");
	         // chequeo que el result set no sea vacío, moviendo el cursor a la 
	         // primer fila. (El cursor inicia antes de la primer fila)
	         while(rs.next()) {
	           //Si hay resultados obtengo el valor. 
	            //numero= rs.getInt(1); // si es un int, puede ser un String
	        	 System.out.println("Título: " + rs.getString("titulo"));
	        	    System.out.println("Género: " + rs.getString("genero"));
	        	    System.out.println("Estreno: " + rs.getInt("estreno"));
	        	    System.out.println("------------------------");
	         }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        //System.out.println("Error");
	    } catch (ClassNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }finally {
	        try {
	            conexion.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }

	    System.out.println("Conectado/desconectado");
	  
	}

	
}
