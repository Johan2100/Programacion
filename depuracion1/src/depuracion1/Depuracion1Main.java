package depuracion1;

import java.util.Scanner;

public class Depuracion1Main {
	public static void main(String[] args) {
		
		int op = -1;
		Scanner sc = new Scanner(System.in);

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN titulo ***

					1.
					2.
					3.
					4.
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {

			}
			case 2 -> {

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
		
		sc.close();


	
	
	
	
	
	}

}
