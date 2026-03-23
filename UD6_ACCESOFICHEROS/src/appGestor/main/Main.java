package appGestor.main;

import java.io.IOException;
import java.util.Scanner;

import appGestor.dataAccess.*;


public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int op = -1;
		

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN GASTOS ***

					1. Añadir Gasto / Día y Mes
					2. Gastos de un mes
					3. Día de más gasto en un Mes
					4. Eliminar Dia
					5. Listado Gastos Mes
					6. Mes mayor gasto
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Mes: ");
				String mes = sc.nextLine();
				System.out.print("Dia: ");
				int dia = Integer.parseInt(sc.nextLine());
				System.out.print("Gasto: ");
				double gasto = Double.parseDouble(sc.nextLine());
				try {
					Datos.addGasto(mes, dia, gasto);
				} catch (IOException e) {
					System.err.println("No se ha guardado el gasto");
					e.printStackTrace();
				}
				
			}
			case 2 -> {
				System.out.print("Mes:");
				try {
					System.out.println(Datos.gastosMes(sc.nextLine()));
				} catch (IOException e) {
					System.err.println("No se ha podido calcular el mes");
					e.printStackTrace();
				}

			}
			case 3 -> {
				System.out.print("Mes:");
				try {
					System.out.println(Datos.diaMayorGasto(sc.nextLine()));
				} catch (IOException e) {
					System.err.println("Mio esta algo mal");
					e.printStackTrace();
				}
			}
			case 4 -> {
				System.out.print("Mes: ");
				String mes = sc.nextLine();
				System.out.print("Dia a eliminar: ");
				int dia = Integer.parseInt(sc.nextLine());
				try {
					Datos.eliminarDiaMes(mes,dia);
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			case 5 ->{
				
			}
			case 6 ->{
				
			}

			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}

	}

}
