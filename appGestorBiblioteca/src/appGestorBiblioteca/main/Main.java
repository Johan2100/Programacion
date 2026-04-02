package appGestorBiblioteca.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import appGestorBiblioteca.model.gestor.GestorLibros;
import appGestorBiblioteca.model.gestor.GestorPresDev;
import appGestorBiblioteca.model.libro.Libro;

public class Main {
	static Random RN = new Random();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			GestorPresDev.lastSave();
			GestorLibros.lastSave();
			
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No se ha podido recuperar los datos anteriores");
			e.printStackTrace();
		}
		
		
		
		int op = -1;
		

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN BIBLIOTECA ***

					1. Gestion Libros
					2. Gestión Prestamos y Devoluciones
					0. Salir


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				try {
					subMenuLibros();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			case 2 -> {
				try {
					subMenuPD();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
	}

	

	private static void subMenuLibros() throws FileNotFoundException, IOException {
		int op = -1;

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN LIBROS ***

					1. Añadir
					2. Eliminar
					3. Buscar
					4. Listar Libros
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt(); sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduzca el nombre del libro: ");
					String titulo = sc.nextLine();
				System.out.print("Introduzca el nombre del autor: ");
					String autor = sc.nextLine();
				System.out.print("Introzca el stock total: ");
					int stock = sc.nextInt(); sc.nextLine();
		
				GestorLibros.insert(new Libro(titulo, autor, RN.nextLong(0,1000000000), stock));
			}
			case 2 -> {
				System.out.print("Introduzca el nombre del libro: ");
					String titulo = sc.nextLine(); 
					
				System.out.println(GestorLibros.delete(titulo)? "Eliminado correctamente":"No se ha podido eliminar");

			}
			case 3 -> {
				System.out.print("Introduzca el nombre del libro: ");
					String titulo = sc.nextLine();
				
				System.out.println(GestorLibros.get(titulo));
			}
			case 4 -> {
				GestorLibros.listarLibros();
			}

			case 0 -> {
				System.out.println("Volviendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
	}
	
	
	
	private static void subMenuPD() throws IOException {
		int op = -1;
		while (op != 0) {
			System.out.println("""
					*** GESTIÓN PRÉSTAMOS/DEVOLUCIONES ***

					1. Introducir préstamo
					2. Introducir devolución
					3. Imprimir movimientos
					4. Listar Array
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduzca el nombre del libro: ");
					String titulo = sc.nextLine();
				GestorPresDev.insertPrestamo(titulo);
			}
			case 2 -> {
				System.out.print("Introduzca el nombre del libro: ");
					String titulo = sc.nextLine();
				GestorPresDev.insertDevolucion(titulo);

			}
			case 3 -> {
				GestorPresDev.printAllMovimientos();	
				GestorPresDev.printAllArray();
			}
			case 4 -> {
			}

			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
	}

}
