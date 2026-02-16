package miniAplicaciones.ejer1.main;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import miniAplicaciones.ejer1.model.Estudiante;

public class MainMiniInstituto {
	static Set<Estudiante> estudiantes = new HashSet<>();
	
	public static void main(String[] args) {
		
		int op = -1;
		Scanner sc = new Scanner(System.in);

		while (op != 0) {
			System.out.println("""
					*** GESTIÓN ESTUDIANTES ***

					1. Añadir Alumno
					2. Listar Alumnos
					3. Buscar Alumno
					4. Mostrar Alumnos aprobados 
					5. Eliminar Alumno
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduce nombre del estudiante: ");
				String nombre = sc.nextLine();
				
				System.out.print("Introduce la edad: ");
				int edad = sc.nextInt(); sc.nextLine();
				while(!(edad >= 6 && edad <= 99)) {
					System.out.println("Introduce edad entre 6 a 99");
					edad = sc.nextInt(); sc.nextLine();
				}
				
				System.out.print("Introduce la nota Media: ");
				double notaMedia = sc.nextDouble(); sc.nextLine();
				while(!(notaMedia >= 0 && notaMedia <= 10)) {
					System.out.println("Introduce nota entre 0 a 10");
					notaMedia = sc.nextDouble(); sc.nextLine();
				}
				
				;
				String mensaje = estudiantes.add(new Estudiante(nombre, edad,notaMedia))?"Añadido correctamente" :"No se ha añadido";
				System.out.println(mensaje);
			}
			case 2 -> {
				System.out.println("-- LISTADO DE ALUMNOS --");
				for (Estudiante s : estudiantes) {
					System.out.println(s);
				}
			}
			case 3 -> {
				System.out.print("Introduce el nombre del alumno: ");
				String nombre = sc.nextLine();
				Iterator<Estudiante> it = estudiantes.iterator();
				while(it.hasNext()){
					Estudiante a = it.next();
					if(a.getNombre().equals(nombre)) {
						System.out.println(a);
					}
				}
				
				
			}
			case 4 -> {
				System.out.println("-- LISTADO DE APROBADOS ");
				Iterator<Estudiante> it = estudiantes.iterator();
				while(it.hasNext()) {
					Estudiante a = it.next();
					if(a.getNotaMedia() >= 5)
						System.out.println(a);
				}
			}
			
			case 5 ->{
				System.out.print("Introduce el nombre del alumno: ");
				String nombre = sc.nextLine();
				boolean found = false;
				Iterator<Estudiante> it = estudiantes.iterator();
				while(it.hasNext()){
					Estudiante a = it.next();
					if(a.getNombre().equals(nombre)) {
						it.remove();
						found = true;
						
					}
				}
				
				if(found)
					System.out.println("Borrado correctamente a "+nombre);
				else
					System.out.println("No se ha encontrado el estudiante "+nombre);
				
			}

			case 0 -> {
				System.out.println("Saliendo...");
				sc.close();
			}

			default -> System.out.println("Opción no válida");

			}

		}
	
	}
	
	
	
	

}
