package main;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.DestinoDAO;
import dao.ReservaDAO;
import model.Destino;
import model.Reserva;

public class Main {
	static Scanner sc = new Scanner (System.in);
	public static long numCodReserva;
	
	public static void main(String[] args) {
		try {
			numCodReserva = ReservaDAO.lastMapCode();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int op = -1;

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN AGENCIA ***

					1. Insertar Destino
					2. Eliminar Destino
					3. Modificar Destino
					4. Recuperar Destino
					5. Listar Destinos
					6. Gestion Reserva
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
					if(DestinoDAO.delete(nombreViaje)) {
						System.out.println("Se ha eliminado correctamente");
					}else {
						System.out.println("No se ha encontrado el Destino");
					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
			case 3 -> {
				System.out.println("Introduce nombre del destino a modificar: ");
				String nombre = sc.nextLine();
				System.out.println("Introduce el nuevo precio: ");
				double precio = sc.nextDouble(); sc.nextLine();
				try {
					if(DestinoDAO.update(new Destino(nombre, precio)))
						System.out.println("Se ha actualizado correctamente ");
					else
						System.out.println("No se ha podido actualizar");
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
			}
			case 4 -> {
				System.out.println("Introduce el nombre del Destino: ");
				String nombre = sc.nextLine();
				try {
					System.out.println(DestinoDAO.get(nombre));
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
			}
			
			case 5->{
				try {
					DestinoDAO.listarDestinos();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			case 6->{
				subMenuReserva();
			}

			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
		
		
	}
	
	
	
	private static void subMenuReserva() {
		int op = -1;

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN RESERVA ***

					1. Añadir reserva
					2. Eliminar reserva
					3. Buscar reserva
					4. Modificar reserva
					5. Listar todas las reservas
					0. Volver
					
					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduce nombre del cliente: ");
				String nombre = sc.nextLine();
				System.out.print("Introduce fecha (dd/MM/yyyy): ");
				LocalDate fecha = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				System.out.println("Introduce Destino: ");
				String nombreDestino = sc.nextLine();
				Destino destino = null;; 
				try {
					while(DestinoDAO.get(nombreDestino) == null) {
					System.out.println("Destino no encontrado");
						System.out.print("Introduzca uno válido: ");
						nombreDestino = sc.nextLine();
					}
					destino = DestinoDAO.get(nombreDestino);
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
				

						try {
							System.out.println(ReservaDAO.insert(new Reserva(numCodReserva++, nombre, fecha, destino))?"Reserva añadida correctamente":
								"No se ha podido reservar, intente de nuevo");
						} catch (ClassNotFoundException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
			}
			case 2 -> {
				System.out.print("Introduce el codigo de la reserva a eliminar");
				Long deleteCodReserva = sc.nextLong(); sc.nextLine();
				try {
					System.out.println(ReservaDAO.delete(deleteCodReserva)?"Se ha eliminado correctamente":
						"No se ha podido eliminar");
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
				

			}
			case 3 -> {
				System.out.print("Introduce el codigo de la reserva: ");
				try {
					System.out.println(ReservaDAO.get(sc.nextLong()));
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
			}
			case 4 -> {
				System.out.print("Introduce el codigo de Reserva");
				Long codReserva = sc.nextLong();
				
				System.out.print("Introduce nuevo cliente: ");
				String nCliente = sc.nextLine();
				System.out.print("Introduce nuevo destino: ");
				String nombreDestino = sc.nextLine();
				Destino des = null;
				try {
					while(DestinoDAO.get(nombreDestino) == null) {
						System.out.println("Destino no encontrado");
						System.out.print("Introduzca uno válido: ");
						nombreDestino = sc.nextLine();
					}
					des = DestinoDAO.get(nombreDestino);
				} catch (ClassNotFoundException | IOException e) {
					
					e.printStackTrace();
				}
				System.out.print("Introduce nueva Fecha: ");
				LocalDate Fecha = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				try {
					ReservaDAO.update(new Reserva(codReserva, nCliente, Fecha, des));
					System.out.println("Reserva actualizada");
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
			
			case 5 ->{
				ReservaDAO.listarReservas();
			}

			case 0 -> {
				System.out.println("Volviendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
	}
	
	
	
	
	
	
	
	
}
