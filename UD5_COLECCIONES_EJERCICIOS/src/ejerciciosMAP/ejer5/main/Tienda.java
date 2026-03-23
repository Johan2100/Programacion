package ejerciciosMAP.ejer5.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Tienda {
	
	static HashMap<String,Float> listaProductos = new HashMap<String,Float>();
	static Scanner sc = new Scanner(System.in);
	
	public static void guardarProducto(String codigo, Float precio) {
		listaProductos.put(codigo, precio);
	}
	public static void modificaPrecio(String code) {
		if(listaProductos.containsKey(code)) {
			System.out.print("Producto encontrado, introduce nuevo precio: ");
			Float precio = sc.nextFloat(); sc.nextLine();
			listaProductos.put(code, precio);
		}else {
			System.out.println("Producto no encontrado");
		}
	}
	
	public static void mostrarProductos() {
		Set<String> nombres = listaProductos.keySet();
		for (String s : nombres) {
			System.out.println("-Codigo: "+s+" -Valor: "+listaProductos.get(s));
		}
	}
	
	public static void eliminaProducto(String codigo) {
		
		if(listaProductos.containsKey(codigo)) {
			listaProductos.remove(codigo);
			System.out.println("Producto eliminado");
		}else {
			System.out.println("Producto no encontrado");
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {

	 
	    int opcionElegida = 0;
	    float precio;
	    String codigo;

	    while (opcionElegida != 5) {
	        System.out.println("Introduce el numero de la opción que quieras:");
	        System.out.println("1.- Introducir producto");
	        System.out.println("2.- Modificar precio");
	        System.out.println("3.- Mostrar todos los productos");
	        System.out.println("4.- Eliminar producto");
	        System.out.println("5.- Salir");
	        opcionElegida = sc.nextInt();


	        switch (opcionElegida) {
	            case 1:
	                System.out.println("Introduce el códido del producto:");
	                codigo = sc.next();
	                System.out.println("Introduce el precio del producto:");
	                precio = sc.nextFloat();
	                guardarProducto(codigo, precio);
	                break;
	            case 2:
	                System.out.println("Introduce el códido del producto del que quieres cambiar el precio:");
	                codigo = sc.next();
	                modificaPrecio(codigo);
	                break;
	            case 3:
	                mostrarProductos();
	                break;
	            case 4:
	            	System.out.println("Introduce el códido del producto que quieres eliminar:");
	            	codigo = sc.next();
	            	eliminaProducto(codigo);
	            	break;
	            case 5:
	                break;   // Si la opcion es 5 no se hace nada 
	            default:
	                System.out.println("Tienes que introducir una opcion valida");
	        }

	    }
	}


}
