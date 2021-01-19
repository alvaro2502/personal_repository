package util;

/**
 * 
 * @author Alvaro Sanchez Sanchez
 *
 *	Clase que contiene las constantes utilizadas para la conexión a BBDD
 */
public interface Constantes {
	
	public final String DRIVER = "com.mysql.jdbc.Driver";
    public final String DB = "testibm";
    public final String URL = "jdbc:mysql://localhost/" + DB;
    public final String USER = "root";
    public final String PASSWORD = "";
    
    public final String HOST="localhost";

}