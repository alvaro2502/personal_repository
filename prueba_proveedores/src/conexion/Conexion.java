package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.Constantes;

public class Conexion {

	private Connection conexionBBDD;
	
	/**
	 * Constructor
	 */
	public Conexion() {
		
	}

	/**
	 * Se inicia la conexion con la base de datos
	 */
	public void crearConexion() {
		Connection conexion = null;
		try {
			Class.forName(Constantes.DRIVER);
			conexion = DriverManager.getConnection(
					Constantes.URL,
					Constantes.USER,
					Constantes.PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexionBBDD = conexion;
	}

	/**
	 * Se cierra la conexion con la base de datos si previamente ha sido abierta
	 */
	public void cerrarConexion() {

		try {
			
			if (conexionBBDD!=null) {
				conexionBBDD.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Se obtine el atributo que contiene la conexion con la base de datos
	 * @return la conexion con la base de datos
	 */
	public Connection getConexionBBDD() {
		return conexionBBDD;
	}

}