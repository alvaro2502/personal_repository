package modelo;

/**
 * 
 * @author Alvaro Sanchez
 * 
 * Clase que representa los datos obtenidos de la tabla proveedores de BBDD
 *
 */
public class Proveedor {
	
	private int id_proveedor;
	private String nombre;
	private String fecha_alta;
	private int id_cliente;
	
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_alta() {
		return fecha_alta;
	}
	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
