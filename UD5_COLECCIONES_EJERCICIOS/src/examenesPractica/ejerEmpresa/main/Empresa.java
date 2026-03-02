package examenesPractica.ejerEmpresa.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


import java.time.*;
import java.time.format.DateTimeFormatter;

import examenesPractica.ejerEmpresa.model.*;

public class Empresa {
	static Set<ApunteEconomico> gastosTotales = new HashSet<>();
	static int serialcode=1;
	static int codigoFactura=1;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int op = -1;
		
	
		while (op != 0) {
			System.out.println("""
					*** GESTIÓN EMPRESA ***
	
					1. Añadir
					2. Buscar
					3. Listado
					4.
					0. Salir.
	
	
					""");
	
			System.out.println();
			op = sc.nextInt();
			sc.nextLine();
	
			switch (op) {
			case 1 -> {
				
				agregarGasto();
	
			}
			case 2 -> {
				System.out.println("Introduce el codigo: ");
				int code = sc.nextInt(); sc.nextLine();
				
				System.out.println(buscarPorCodigo(code));
			}
			case 3 -> {
				for (ApunteEconomico g : gastosTotales) {
					System.out.println(g);
				}
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
	
	static void agregarGasto() {
		System.out.print("Introduce un año: ");
		int anyo = sc.nextInt(); sc.nextLine();
		String p = Integer.toString(anyo);
		System.out.print("Introduce un importe € (double): ");
		double importe = sc.nextDouble(); sc.nextLine();
		System.out.print("Introduce concepto: ");
		String concepto = sc.nextLine();
		
		
		System.out.println("""
				
				TIPO DE GASTO
				1. Factura
				2. Gasto Empresa
				""");
		int tipo = sc.nextInt(); sc.nextLine();
	
			switch (tipo) {
			case 1 -> {
				System.out.print("Introduce el emisor de la factura: ");
				String emisor = sc.nextLine();
				p += ""+serialcode++;
				int codigo = Integer.parseInt(p);
				System.out.println(gastosTotales.add(new Factura(codigo, importe, concepto, codigoFactura++, emisor))?"Gasto agregado":"Gasto no agregado");
				
				
			}
			case 2 -> {
				System.out.print("Introduce la fecha del gasto (dd/MM/yyyy)");
				LocalDate fecha = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy") );
				System.out.print("Introduce el DNI responsable: ");
				String dniResponsable = sc.nextLine();
				p += ""+serialcode++;
				int codigo = Integer.parseInt(p);
				System.out.println(gastosTotales.add(new GastoEmpresa(codigo, importe, concepto, fecha, dniResponsable))?"Gasto agregado":"Gasto no agregado");
				

			}
			case 3 ->{
				System.out.println(listadoGastoEmpresa());
				System.out.println(listadoPorFecha());
			}
			case 4 ->{
				System.out.println("Introduce emisor");
				String emisor = sc.nextLine();
				eliminarFacturas(emisor);
			}
			default -> System.out.println("Tipo no válida");

			}

		}
	
	static ApunteEconomico buscarPorCodigo(int code) {
		
		for (ApunteEconomico a : gastosTotales) {
			if(a.getCode() == code)
				return a;	
		}
		return null;
	}
	
	static double importeTotalFacturas() {
		double suma = 0;
		for (ApunteEconomico a : gastosTotales) {
			if( a instanceof Factura)
				suma += a.getImporte();
		}
		return suma;
	}
	
	
	/**
	 * Devuelve un listado de gastos empresariales por orden descendente
	 * de import 
	 */
	
	public static String listadoGastoEmpresa() {
		List<GastoEmpresa> listadoAux = new LinkedList<>();
		for (ApunteEconomico a : gastosTotales) {
			if(a instanceof GastoEmpresa)
				listadoAux.add((GastoEmpresa)a);
		}
		
		listadoAux.sort(null);
		
		String listado = "";
		for (GastoEmpresa g : listadoAux) {
			listado += g +"\n";
		}
		return listado;
	}
	
	public static String listadoPorFecha() {
		List<GastoEmpresa> listadoAux = new LinkedList<>();
		for (ApunteEconomico a : gastosTotales) {
			if(a instanceof GastoEmpresa)
				listadoAux.add((GastoEmpresa)a);
		}
		
		listadoAux.sort(new ComparatorFechas());
		
		String listado = "";
		for (GastoEmpresa g : listadoAux) {
			listado += g +"\n";
		}
		return listado;
	}
	
	public static void eliminarFacturas(String emisor) {
		
		Iterator<ApunteEconomico> it = gastosTotales.iterator();
		while(!(it.hasNext())) {
			ApunteEconomico a = it.next();
			if( a instanceof Factura && ((Factura)a).getEmisor().equals(emisor)) {
				it.remove();
			}
		}
	}
	
}
	

