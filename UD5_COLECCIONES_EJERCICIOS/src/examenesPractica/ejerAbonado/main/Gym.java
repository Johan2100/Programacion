package examenesPractica.ejerAbonado.main;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import examenesPractica.ejerAbonado.model.clases.*;

public class Gym {
	static List<CuerpoAbonado> clientes = new LinkedList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int op = -1;
		

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN GYM ***

					1. Agregar Clientes (0 Actividades)
					2. Agregar Actividad a Cliente
					3. Cuota Total Abonado Regular
					4. Mostrar Clientes
					5. Mostrar por dia
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				agregarCliente();
			}
			case 2 -> {
				System.out.println("Introduce el nif del cliente");
				String nif = sc.nextLine();
				agregarActividadCliente(nif);
				

			}
			case 3 -> {
				System.out.println(ingresosAbonadosRegulares());
			}
			case 4 -> {
				for (CuerpoAbonado c : clientes) {
					System.out.println(c);
				}
			}
			case 5->{
				mostrarActividadDia();
				
			}
			
			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
	}
	
	public static void agregarCliente() {
		String nombre = sc.nextLine();
		String nif = sc.nextLine();
		
		System.out.println("""
				
				TIPO DE ABONO
				1. Abonado Regular
				2. Abonado VIP
				
				""");
		int abono = sc.nextInt(); sc.nextLine();
		switch(abono) {
			case 1 ->{
				System.out.println("Tienes como máximo 10 actividades");
				clientes.add(new AbonadoRegular(nif, nombre));
			}
			
			case 2 ->{
				System.out.println("Tienes actividades ilimitadas");
				clientes.add(new AbonadoVIP(nif, nombre));
			}
		}
	}
	
	public static void agregarActividadCliente(String nif) {
		
		System.out.print("Introduce nombre de la actividad: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce cuota: ");
		double cuouta = sc.nextDouble();
		System.out.println("Cuandos dias lo vas a hacer? ");
		int dias = sc.nextInt(); sc.nextLine();
		char[] diasActividad = new char[dias];
		
		
		for (int i = 0; i < dias; i++) {
			boolean registrado = false;
			while(!(registrado)) {
				System.out.println("""
						Elige Dia:
						
						1. Lunes
						2. Martes
						3. Miercoles
						4. Jueves
						5. Viernes
						6. Sabado
						7. Domingo
						
						""");
				int op = sc.nextInt(); sc.nextLine();
				switch(op) {
				case 1 ->{
					char dia = 'L';
					diasActividad[i] = dia;
					registrado = true;
				}
				case 2 ->{
					char dia = 'M';
					diasActividad[i] = dia;
					registrado = true;
				}
				case 3 ->{
					char dia = 'X';
					diasActividad[i] = dia;
					registrado = true;
				}
				case 4 ->{
					char dia = 'J';
					diasActividad[i] = dia;
					registrado = true;
					
				}
				case 5 ->{
					char dia = 'V';
					diasActividad[i] = dia;
					registrado = true;
					
				}
				case 6 ->{
					char dia = 'S';
					diasActividad[i] = dia;
					registrado = true;		
				}
				case 7 ->{
					char dia = 'D';
					diasActividad[i] = dia;
					registrado = true;
				}
				
				default->{
					System.out.println("Dia no válido");
					
				}

				}
			}
			
			
		}
		
		
		for (CuerpoAbonado c : clientes) {
			if( c.getNif().equals(nif))
				System.out.println(c.getActividades().add(new Actividad(nombre, cuouta, diasActividad))?
						"Actividad registrada correctamente":"La actividad no se ha registrado");
		}
		
	}
	
	
	public static double ingresosAbonadosRegulares() {

		double suma = 0;
		
		for (CuerpoAbonado c : clientes) {
			if(c instanceof AbonadoRegular){
				suma+=((AbonadoRegular) c).tarifaTotal();
			}
		}
		
		return suma;
	}
	
	public static void mostrarActividadDia() {
		boolean registrado = false;
		char dia = 0;
		while(!(registrado)) {
			System.out.println("""
					Elige Dia:
					
					1. Lunes
					2. Martes
					3. Miercoles
					4. Jueves
					5. Viernes
					6. Sabado
					7. Domingo
					
					""");
			int op = sc.nextInt(); sc.nextLine();
			switch(op) {
				case 1 ->{
					 dia = 'L';
					registrado = true;
				}
				case 2 ->{
					 dia = 'M';
					registrado = true;
				}
				case 3 ->{
					 dia = 'X';
					registrado = true;
				}
				case 4 ->{
					 dia = 'J';
					registrado = true;
					
				}
				case 5 ->{
					 dia = 'V';
					registrado = true;
					
				}
				case 6 ->{
					 dia = 'S';
					registrado = true;		
				}
				case 7 ->{
					 dia = 'D';
					registrado = true;
				}
				
				default->{
					System.out.println("Dia no válido");
					
				}
			}
			System.out.println("ABONADOS REGULARES --- ");
			for (CuerpoAbonado c : clientes) {
				if(c instanceof AbonadoRegular)
					c.diasActividades(dia);
					
			}
			System.out.println("ABONADOS VIP --- ");
			for (CuerpoAbonado c : clientes) {
				if(c instanceof AbonadoVIP)
					c.diasActividades(dia);
					
			}
			

			}
		}
	}
	


