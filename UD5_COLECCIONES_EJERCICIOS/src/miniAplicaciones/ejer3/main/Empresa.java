package miniAplicaciones.ejer3.main;

import java.util.List;
import java.util.Scanner;

import java.util.LinkedList;

import miniAplicaciones.ejer3.model.Diseñador;
import miniAplicaciones.ejer3.model.Empleado;
import miniAplicaciones.ejer3.model.Programador;

public class Empresa {
	static List<Empleado> empleados = new LinkedList<>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
	
		int op = -1;
		

		while (op != 0) {
			System.out.println("""
					
					*** GESTIÓN EMPRESA  ***

					1. Añadir Empleado
					2. Eliminar Empleado 
					3. Mostrar Empleados 
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				
				submenuTipo();

			}
			case 2 -> {
				System.out.println("Introduce el nombre del empleado: ");
				String nombre = sc.nextLine();
				
				String mensaje = removeEmpleado(nombre)? "Se ha eliminado correctamente" : "No se ha eliminado" ;
				System.out.println(mensaje);

			}
			case 3 -> {
				System.out.println("--- LISTA DE EMPLEADOS ---");
				for (Empleado e : empleados) {
					System.out.println(e);	
				}
			}
			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
		
		
		
	}
	
	private static void submenuTipo() {
		System.out.print("Introduce el nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Introduce el salario base: ");
		double salarioBase = sc.nextDouble(); sc.nextLine();
		
		System.out.println("""
				
				**** ELIGE EL TIPO DE EMPLEADO *** 
				
					1. Diseñador 
					2. Programador
				
				""");
		int op = sc.nextInt(); sc.nextLine();
		
		switch(op) {
			case 1 ->{
				System.out.print("Introduce la herramienta del diseñador: ");
				String herramienta = sc.nextLine();
				System.out.print("Introduce el plus del diseñador: ");
				double plus = sc.nextDouble(); sc.nextLine();
				
				
				String mensaje = empleados.add(new Diseñador(nombre, salarioBase, herramienta, plus))?"Empleado tipo diseñador agregado correctamente" :"Empleado no añadido" ;
				System.out.println(mensaje);
			}
			
			case 2 ->{
				System.out.print("Introduce el lenguaje de programación: ");
				String lenguaje = sc.nextLine();
				System.out.print("Introduce el plus del programador: ");
				double plus = sc.nextDouble(); sc.nextLine();
				
				String mensaje = empleados.add(new Programador(nombre, salarioBase, lenguaje, plus))?"Empleado tipo programador añadido correctamente" : "Empleado no añadido";
				System.out.println(mensaje);
			}
			
			default ->{
				System.out.println("Tipo de empleado no válido");
			}
		
		}
		
	}
	
	static boolean removeEmpleado(String nombre) {
		boolean found = false;
		for (int i = 0; i < empleados.size(); i++) {
			
			if(empleados.get(i).getNombre().equals(nombre)) {
				found = true;
				empleados.remove(i);
			}
				
		}
		return found;
	}
	

}
