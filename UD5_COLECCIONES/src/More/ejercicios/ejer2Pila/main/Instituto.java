package More.ejercicios.ejer2Pila.main;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import More.ejercicios.ejer2Pila.model.Alumno;
import More.ejercicios.ejer2Pila.model.CriterioNotaDescendiente;
import More.ejercicios.ejer2Pila.model.Profesor;

public class Instituto {
	
	private static List<Profesor> profesores = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int op = -1;
		Scanner sc = new Scanner(System.in);

		while (op != 0) {
			System.out.println("""
					
					*** GESTIÓN INSTITUTO ***

					1. Gestión Profesor
					2. Gestión Alumno 
					0. Salir
					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				gestionProf();

			}
			case 2 -> {
				gestionAlumno();
			}
			
			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
		
	}
	
	//CONSOLE --
	
	//GESTION DE PROFESOR 
	
	public static void gestionProf() {
		int op = -1;
		Scanner sc = new Scanner(System.in);

		while (op != 0) {
			System.out.println("""
					
					*** GESTIÓN PROFESOR ***

					1. Agregar Profesor
					2. Eliminar Profesor
					3. Mostrar listado de alumnos
					4. Mostrar Porcentaje 
					0. Salir.
					
					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduce el nombre del profesor/a: ");
				String nombre = sc.nextLine();
				System.out.print("Introduce el NIF: ");
				String nif = sc.nextLine();
				
				Profesor newProf = new Profesor(nombre,nif);
				addProfesor(newProf);
			}
			case 2 -> {
				System.out.println("Introduce NIF del profesor que desea eliminar : ");
				String nif = sc.nextLine();
				deleteProfesor(nif);
			}
			case 3 -> {
				System.out.println("Introduce NIF del profesor para mostrar alumnos: ");
				String nif = sc.nextLine();
				ordenAlumno(nif);
			}
			case 4-> {
				System.out.println("Introduce el NIF del profesor: ");
				String nif = sc.nextLine();
				porcentajeProfesor(nif);
				
			}

			case 0 -> {
				System.out.println("Volviendo...");
			}

			default -> System.out.println("Opción no válida");

			}
			

		}
		
	}
	
	
	// GESTION DE ALUMNO 
	
	public static void gestionAlumno() {
		int op = -1;
		Scanner sc = new Scanner(System.in);

		while (op != 0) {
			System.out.println("""
					
					*** GESTIÓN ALUMNO ***

					1. Agregar Alumno
					2. Eliminar Alumno
					3. Profesores del Alumno
					0. Volver

					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduzca nombre del alumno: ");
				String NombreA = sc.nextLine();
				System.out.print("Introduzca el nif: ");
				String nifA = sc.nextLine();
				System.out.print("Introduzca la nota: ");
				Double notaA = sc.nextDouble(); sc.nextLine();
				Alumno alumnoAgregar = new Alumno(nifA, NombreA,notaA);
				
				System.out.print("Introduzca el nif del profesor: ");
				String nifProf = sc.nextLine();
				int posicion = posProf(nifProf);
				
				if(posicion != -1) {
					System.out.printf("El profesor es %s %n",profesores.get(posicion).getNombre());
					profesores.get(posicion).addAlumno(alumnoAgregar);
				}else
					System.out.println("Profesor no encontrado ");

			}
			case 2 -> {
				
				System.out.print("Introduzca el nif del alumno: ");
				String nifA = sc.nextLine();
				
				System.out.print("Introduzca el nif del profesor: ");
				String nifProf = sc.nextLine();
				int posicion = posProf(nifProf);
				
				if(posicion != -1) { 
					boolean found = false;
					for (int i = 0; i < profesores.get(posicion).getAlumnos().size() && !found; i++) {
						if(profesores.get(posicion).getAlumnos().get(i).getNif().equals(nifA)) {
							found = true;
							profesores.get(posicion).removeAlumno(nifA);
						}
					}
					
				}else
					System.out.println("Profesor o Alumno no encontrado ");
				

			}
			case 3 -> {
				System.out.println("Introduzca el nif del alumno:");
				String nifA = sc.nextLine();
				System.out.println(Instituto.alumnoProfesores(nifA));
				
				
				
			}
			case 0 -> {
				System.out.println("Volviendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
		
		
		
	}
	
	
	
	
	// METHODS -- 
	public static void addProfesor(Profesor docente) {
		profesores.add(docente);
	}
	
	private static void deleteProfesor(String nif) {
		
		int posP = -1;
		boolean found = false;
		for (int i = 0; i < profesores.size() && !found; i++) {
			if(profesores.get(i).getNif().equals(nif)) {
				found = true;
				posP = i;
			}
		}
		
		if(posP != -1) {
			  profesores.remove(posP);
			  System.out.println("Eliminado correctamente ");
		}else
			System.out.println("Profesor no encontrado");
		
	}
	
	private static String alumnoProfesores(String nif) {
		String result = "";
		boolean found = false;
		
		for(Profesor prof : profesores) {
			
			for (int i = 0; i < prof.getAlumnos().size() && !found; i++) {
				if(prof.getAlumnos().get(i).getNif().equals(nif)) {
					found = true;
					result += " "+prof.getNombre()+" \n";
				}
				
			}
		}
		
		return result;
	}
	
	private static void ordenAlumno(String nif) {
		
		int posP = -1;
		boolean found = false;
		for (int i = 0; i < profesores.size() && !found; i++) {
			if(profesores.get(i).getNif().equals(nif)) {
				found = true;
				posP = i;
			}
		}
		
		if(posP != -1) {
			System.out.println("Profesor -> " + profesores.get(posP).getNombre());
			//Con el comparator.comparing, no hace falta crear una clase que implemente un comparator. 
			profesores.get(posP).getAlumnos().sort(Comparator.comparing(Alumno::getNombre)); 
			
			
			System.out.println("LISTADO DE ALUMNOS: ");
			profesores.get(posP).getAlumnos().forEach(a -> System.out.println(a.getNombre()));
		}else
			System.out.println("Profesor no encontrado");
		
	}
	
	
	
	private static void porcentajeProfesor(String nif) {
		int posP = -1;
		boolean found = false;
		for (int i = 0; i < profesores.size() && !found; i++) {
			if(profesores.get(i).getNif().equals(nif)) {
				found = true;
				posP = i;
			}
		}
		
		if(posP != -1) {
			System.out.println("El porcetaje de aprobado es de "+profesores.get(posP).porAprobados()+"%");
			
		}else
			System.out.println("Profesor no encontrado");
	}
	
	
	// METODO FOUND --
	
	/**
	 * 
	 * @param Lo usamos para obtener la posición del profesor en el array 
	 * @return Si hay un profesor con el nif introducido nos devolverá la posición, de lo contrario nos devolverá -1. 
	 */
	private static int posProf(String nif) {
		int posP = -1;
		boolean found = false;
		for (int i = 0; i < profesores.size() && !found; i++) {
			if(profesores.get(i).getNif().equals(nif)) {
				found = true;
				posP = i;
			}
		}
		return posP;
		
	}

}
