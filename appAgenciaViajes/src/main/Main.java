package main;

import java.io.IOException;
import java.util.Scanner;

import dao.DestinoDAO;
import model.Destino;

public class Main {
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		int op = -1;

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN AGENCIA ***

					1. Insertar Destino
					2. Eliminar Destino
					3. Recuperar Destino
					4. Modificar Precio
					0. Salir.
					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.println("Ingrese Destino: ");
				String nombre = sc.nextLine();
				System.out.println("Precio: ");
				double precio = sc.nextDouble();
				
				try {
					DestinoDAO.insert(new Destino(nombre, precio));
				} catch (IOException e) {
					System.out.println("Error, no se ha ingreaso el correo");
					e.printStackTrace();
				}

			}
			case 2 -> {
				System.out.println("Introduce nombre del destino: ");
				String nombreViaje = sc.nextLine();
				try {
					DestinoDAO.delete(nombreViaje);
				} catch (IOException e) {
					System.out.println("No se ha podido eliminar el destino");
					e.printStackTrace();
				}
			}
			case 3 -> {
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
