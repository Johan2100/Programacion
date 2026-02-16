package miniAplicaciones.ejer2.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import miniAplicaciones.ejer2.model.Libro;

public class CatalogoLibros {
	
	static Set<Libro> libros = new HashSet<>();
	
	
	public static void main(String[] args) {
		int op = -1;
		Scanner sc = new Scanner(System.in);

		while (op != 0) {
			System.out.println("""
					
					*** CATÁLOGO LIBROS  ***

					1. Añadir libro 
					2. Mostrar catágolo
					3. Eliminar Libro
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				System.out.print("Introduce ISBN del libro: ");
				String ISBN = sc.nextLine();
								
				System.out.print("Introduce nombre del Autor: ");
				String nombreAutor = sc.nextLine();
				
				System.out.print("Introduce titulo del libro: ");
				String titulo = sc.nextLine();
				
				
				
				String mensaje = libros.add(new Libro(ISBN, titulo, nombreAutor))? "Libro añadido correctamente":"Libro no añadido";
				System.out.println(mensaje);
				
			}
			case 2 -> {
				
			for (Libro l : libros) {
				System.out.println(l);
			}

			}
			case 3 -> {
				System.out.print("Introduce el ISBN del libro: ");
				String ISBN = sc.nextLine();
				
				boolean found = false;
				
				Iterator<Libro> it = libros.iterator();
				
				while(it.hasNext()) {
					Libro a = it.next();
					if(a.getIsbn().equals(ISBN)) {
						it.remove();
						found = true;
					}
						
				}
				
				if(found)
					System.out.println("El libro ha sido eliminado correctamente");
				else
					System.out.println("No se ha encontrado el libro ");
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
