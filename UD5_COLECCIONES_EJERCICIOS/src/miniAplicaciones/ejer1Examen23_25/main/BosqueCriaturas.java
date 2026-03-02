package miniAplicaciones.ejer1Examen23_25.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniAplicaciones.ejer1Examen23_25.model.clases.CriaturaMistica;
import miniAplicaciones.ejer1Examen23_25.model.clases.*;

public class BosqueCriaturas {
	
	static List<CriaturaMistica> criaturas = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
	
	int op = -1;
	

	while (op != 0) {
		System.out.println("""
				*** BOSQUE DE CRÍATURAS ***

				1. Añadir criatura
				2. Activar poderes solo Elfo
				3. Descripción criaturas 
				0. Salir.


				""");

		System.out.println();
		op = sc.nextInt();
		sc.nextLine();

		switch (op) {
		case 1 -> {
			submenu();
		}
		case 2 -> {
			for (CriaturaMistica d : criaturas) {
				if( d instanceof Elfo)
					d.activarPoder();
					
			}

		}
		case 3 -> {
			for (CriaturaMistica d : criaturas) {
				System.out.println(d.describirCriatura());
			}
		}
		case 0 -> {
			System.out.println("Saliendo...");
		}

		default -> System.out.println("Opción no válida");

		}
		

	}
	
	}
	
	static void submenu() {
		System.out.print("Introduce el nombre de la criatura: ");
		String nombre = sc.nextLine();
		
		System.out.print("Introduce la edad: ");
		int edad = sc.nextInt(); sc.nextLine();
		
		System.out.println("""
				
				**** TIPO DE ANIMAL ****
				
				1. Dragón 
				2. Elfo 
				3. Unicornio 
				
				""");
		
		int opT = sc.nextInt(); sc.nextLine();
		
		switch(opT) {
		
		case 1->{
			System.out.println("Introduce los atributos de Dragón");
			System.out.print("Tamaño de la cola (cm): ");
			double colam = sc.nextDouble(); sc.nextLine();
			String cola = Double.toString(colam);
			
			System.out.print("Tamaño de las alas (cm): ");
			double alas = sc.nextDouble(); sc.nextLine();
			System.out.print("Color: ");
			String color = sc.nextLine();
			
			Dragon d = new Dragon(nombre, edad);
			d.agregarDes(cola, alas, color);
			
			
			String mensaje = criaturas.add(d)?"Dragón añadido correctamente":" Dragón no se ha añadido";
			System.out.println(mensaje);
			
			
		}
		
		
		case 2 ->{
			System.out.println("Introduce los atributos de Elfo");
			System.out.print("Habilidad: ");
			String habilidad = sc.nextLine();
			
			System.out.print("Altura: ");
			double altura = sc.nextDouble(); sc.nextLine();
			
			System.out.print("Color: ");
			String color = sc.nextLine();
			
			Elfo e = new Elfo(nombre, edad); e.agregarDes(habilidad, altura, color);
			
			String mensaje = criaturas.add(e)?"Elfo añadido correctamente":" Elfo no se ha añadido";
			System.out.println(mensaje);
			
		}
		
		case 3 ->{
			System.out.println("Introduce los atributos de Unicornio");
			System.out.print("Tamaño del cuerno (cm): ");
			double colam = sc.nextDouble(); sc.nextLine();
			String cuerno = Double.toString(colam);
			
			System.out.print("Tamaño de las alas (cm): ");
			double alas = sc.nextDouble(); sc.nextLine();
			
			System.out.print("Color: ");
			String color = sc.nextLine();
			
			Unicornio u = new Unicornio(nombre, edad); u.agregarDes(cuerno, alas, color);
			
			String mensaje = criaturas.add(u)?"Unicornio añadido correctamente":" Unicornio no se ha añadido";
			System.out.println(mensaje);
			
		}
		
		}
		
		
	}

}
