package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import conexion.Consultas;
import modelo.Proveedor;
import conexion.Conexion;

public class Main {
	
	private static Conexion connection;
	private static Consultas consultas;
	
	/**
	 * Se inicializa la conexion con la BBDD y el objeto consultas
	 * 
	 */
	private static void iniciarConexionBBDD() {

		connection = new Conexion();
		
		try {
			connection.crearConexion();
			consultas = new Consultas(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * Se cierra la conexion con la BBDD si está abierta
	 * 
	 */
	private static void cerrarConexionBBDD() {

		connection.cerrarConexion();

	}
	
	/**
	 * Método encargado de escribir el fichero de salida
	 * @param proveedores, lista de proveedores que se volcarán en el fichero
	 * @param id_cliente, id del cliente
	 * @return true si se ha generado el fichero correctamente, false si ha ocurrido algun error
	 */
	private static boolean generarFichero(ArrayList<Proveedor> proveedores, int id_cliente) {

		String nombreFichero = "proveedores" + id_cliente + ".txt";
		
		try {
			
			File ficheroSalida = new File(nombreFichero);
			
			if (ficheroSalida.exists()) {
				ficheroSalida.delete();
				ficheroSalida.createNewFile();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida));
				
				bw.write("id_proveedor,nombre,fecha_alta,id_cliente\n");
				
				for (int i=0; i<proveedores.size(); i++) {
					bw.write(proveedores.get(i).getId_proveedor() + "," + proveedores.get(i).getNombre() + "," + proveedores.get(i).getFecha_alta() + "," + proveedores.get(i).getId_cliente() + "\n");
				}
				
				bw.close();
				
			} else {
				ficheroSalida.createNewFile();
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida));
				
				bw.write("id_proveedor,nombre,fecha_alta,id_cliente\n");
				
				for (int i=0; i<proveedores.size(); i++) {
					bw.write(proveedores.get(i).getId_proveedor() + "," + proveedores.get(i).getNombre() + "," + proveedores.get(i).getFecha_alta() + "," + proveedores.get(i).getId_cliente() + "\n");
				}
				
				bw.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * Método principal con la lógica del programa
	 * @param args, argumentos necesarios para la ejecución del programa
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		iniciarConexionBBDD();
		int id_cliente=0;
		
		try {
			id_cliente = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			System.out.println("Debes introducir un número, vuelve a ejecutar el programa.");
		}
		
		ArrayList<Proveedor> proveedores = consultas.obtenerProveedorPorIdCliente(id_cliente);
		
		if (proveedores!=null) {
			if (proveedores.size()>0) {
				System.out.println("Proveedores del cliente " + id_cliente + ":");
				System.out.printf("%-15s%-15s%-15s%-15s\n", "ID Proveedor", "Nombre", "Fecha de Alta", "ID Cliente");
				for (Proveedor prov : proveedores) {
					System.out.printf("%-15s%-15s%-15s%-15s\n", String.valueOf(prov.getId_proveedor()), prov.getNombre(), prov.getFecha_alta(), String.valueOf(prov.getId_cliente()));
				}
				System.out.println();
				System.out.println("Se va a generar el fichero de salida con los datos mostrados.");
				System.out.println("Generando fichero...");
				if (generarFichero(proveedores, id_cliente)) {
					System.out.println("El fichero se ha generado correctamente.");
				} else {
					System.out.println("Ha habido un problema al generar el fichero.");
				}
			} else {
				System.out.println("El cliente " + id_cliente + " no tiene proveedores asociados.");
			}
		}

		cerrarConexionBBDD();
	}

}
