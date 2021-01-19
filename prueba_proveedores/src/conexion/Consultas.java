package conexion;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Proveedor;

public class Consultas extends Conexion {

	private Conexion conexion;

	/**
	 * Constructor
	 * 
	 * @param conex conexion con la base de datos
	 */
	public Consultas(Conexion conex) {
		conexion = conex;
	}
	
	/**
	 * Metodo encargado de realizar una consulta select
	 * de los proveedores de un cliente
	 * 
	 * @param id_cliente id del cliente del que se quieren obtener los proveedores
	 * @return ArrayList<proveedor> con los proveedores que coincidan con el id del cliente
	 */
	public ArrayList<Proveedor> obtenerProveedorPorIdCliente(int id_cliente) {
		
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		String sql = "select * from proveedores where id_cliente=?;";
		
		try {
			
			PreparedStatement sentencia = conexion.getConexionBBDD().prepareStatement(sql);
			sentencia.setInt(1, id_cliente);
			
			ResultSet resultado = sentencia.executeQuery();
			
			while (resultado.next()) {
				
				Proveedor proveedor = new Proveedor();
				proveedor.setId_proveedor(resultado.getInt("id_proveedor"));
				proveedor.setNombre(resultado.getString("nombre"));
				proveedor.setFecha_alta(resultado.getString("fecha_alta"));
				proveedor.setId_cliente(resultado.getInt("id_cliente"));
				proveedores.add(proveedor);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return proveedores;
		
	}

}