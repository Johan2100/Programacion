package appGestorBiblioteca.model.gestor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import appGestorBiblioteca.model.libro.Libro;

public class GestorPresDev implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5023022536377071542L;
	private static File datosPD = new File("datos\\GestionPrestamosDevoluciones.txt");
	private static File Persistencia = new File("datos\\ListadoPrestamosDevoluciones.dat");
	private static List<Libro> devoluciones = new ArrayList<>();
	private static List<Libro> prestamos = new ArrayList<>();
		
	//GETTER AND SETTER 
	public static File getDatosPD() {
		return datosPD;
	}
	public static void setDatosPD(File datosPD) {
		GestorPresDev.datosPD = datosPD;
	}
	public static List<Libro> getDevoluciones() {
		return devoluciones;
	}
	public static void setDevoluciones(List<Libro> devoluciones) {
		GestorPresDev.devoluciones = devoluciones;
	}
	public static List<Libro> getPrestamos() {
		return prestamos;
	}
	public static void setPrestamos(List<Libro> prestamos) {
		GestorPresDev.prestamos = prestamos;
	}
	
	//MÉTODOS
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * El método permite introducir libros a la lista de préstamos si el libro ya lo teniamos registrado en el map de libros, 
	 * tras añadir la cantidad este se modificará en la lista de libros MAP. 
	 * Luego de añadirlo en el fichero "historial" pondrá la fecha y el tipo de movimiento que se hizo tal dia, que en este método será 
	 * prestamo 
	 * @param titulo
	 * @throws IOException
	 */
	
	public static void insertPrestamo(String titulo) throws IOException {
		
		if(GestorLibros.listaLibros.containsKey(titulo)) {
			System.out.print("Introduce fecha del prestamo (dd/MM/yyyy): ");
			LocalDate fecha = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			int stockActual = GestorLibros.listaLibros.get(titulo).getStock();
			System.out.printf("Existen %d en stock de este título \n", stockActual);
			System.out.print("Cuantas unidades va a tomar: ");
				int cantidad = sc.nextInt(); sc.nextLine();
			
				while(cantidad > GestorLibros.listaLibros.get(titulo).getStock()) {
					System.out.println("Introduzca un valor menor al stock disponible ");
					 cantidad = sc.nextInt();
				}
			
			Libro temp = new Libro(GestorLibros.listaLibros.get(titulo).getTitulo(), GestorLibros.listaLibros.get(titulo).getAutor(),
					GestorLibros.listaLibros.get(titulo).getISBN(),GestorLibros.listaLibros.get(titulo).getStock()); 
		        temp.setStock(cantidad); 
		        temp.setFechaP(fecha);
		        
			prestamos.add(temp);
			
			try(FileWriter fw = new FileWriter(datosPD,true)){
				fw.write("Fecha: "+fecha+", cantidad: "+ temp.getStock() +", título: "+temp.getTitulo()+", Tipo movimiento: préstamo \n ");
			}
			
			GestorLibros.listaLibros.get(titulo).setStock(stockActual - cantidad);
			save();
			GestorLibros.save();
			
		}else
			System.out.println("El libro introducido no se encuentra en nuestra base de datos");
		
	}
	/**
	 * Método para introducir devoluciones de libros prestados, para que funcione debe estar el libro tanto en el MAP de 
	 * GestorLibros y que pertenezca en la lista Prestamo. 
	 * Tras finalizar actualizará los datos en las colecciones, anotará el movimiento en el fichero de movimientos y el libro 
	 * que estaba en la Lista de prestamos pasará a devoluciones. 
	 * Tanto en el fichero como el los array aparecerá la fecha de dichos movimientos. 
	 * @param titulo
	 * @throws IOException
	 */
	public static void insertDevolucion(String titulo) throws IOException {
		
		if(GestorLibros.listaLibros.containsKey(titulo) && prestamoContainsBook(titulo)) {
			int cantidadActual = GestorLibros.listaLibros.get(titulo).getStock();
			System.out.println("Lista de Prestamos hechos al libro: ");
			printPrestamoByName(titulo);
			System.out.println();
			
			System.out.println("Introduzca la fecha de prestamo del libro para devolver (dd/MM/yyyy):  ");
			LocalDate fechaPrestamo = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			while ( getByFecha(fechaPrestamo, titulo) == null) {
				System.out.println("Introduzca una fecha válida: ");
				fechaPrestamo = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			}
			System.out.println();
			System.out.println("Introduzca la fecha de devolucion (dd/MM/yyyy):");
			LocalDate fechaDevolucion = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			while(fechaDevolucion.isBefore(fechaPrestamo)) {
				System.out.println("Introduce una fecha mayor que "+fechaPrestamo);
				fechaDevolucion = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			}
			
			
			Libro temp = getByFecha(fechaPrestamo, titulo);
			int cantidadDevolver = temp.getStock();
			GestorLibros.listaLibros.get(titulo).setStock(cantidadActual + cantidadDevolver);
			prestamos.remove(temp);
			devoluciones.add(temp);
			
			try(FileWriter fw = new FileWriter(datosPD,true)){
				fw.write("Fecha: "+fechaDevolucion+", cantidad: "+cantidadDevolver+", título: "+temp.getTitulo()+", Tipo movimiento: devolución \n ");
				
			}
			GestorLibros.save();
			save();
			
		}else
			System.out.println("Libro no encontrado");
		
		
	}
	/**
	 * Imprime el historial de movimientos (Prestamos/Devoluciones)
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void printAllMovimientos() throws FileNotFoundException, IOException {
		if(datosPD.exists()) {
			try(BufferedReader br = new BufferedReader(new FileReader(datosPD))){
				String linea="";
				while( (linea = br.readLine()) != null) {
					System.out.println(linea);
				}
			}
		}
		System.out.println();
		
	}
	
	/**
	 * Imprime el contenido de los Array
	 */
	public static void printAllArray() {
		System.out.println("Prestamos: ");
			for (Libro libro : prestamos) {
				System.out.println(libro.toStringFecha());
			}
			
		System.out.println("Devoluciones: ");
			for (Libro libro : devoluciones) {
				System.out.println(libro.toStringFecha());
			}
		System.out.println();
	}
	/**
	 * Permite saber si el libro esta en la lista de Préstamos
	 * @param titulo
	 * @return true: libro en la lista Prestados; false: el libro no se encuentra en la lista Préstamos
	 */
	private static boolean prestamoContainsBook(String titulo) {
		
		for (Libro libro : prestamos) {
			if(libro.getTitulo().equals(titulo))
				return true;
		}
		
		return false;
	}
	/**
	 * Utilizado para saber los prestamos activos de dicho libro
	 * @param titulo
	 */
	private static void printPrestamoByName(String titulo) {
		for (Libro libro : prestamos) {
			if(libro.getTitulo().equals(titulo))
				System.out.println(libro.toStringFecha());
		}
	}

	/**
	 * Nos permite obtener un titulo mediante fecha y titulo del la Lista Prestamos
	 * En caso de haber dos libros con mismo titulo y fecha, obtendra el primero de ellos. 
	 * @param fecha
	 * @param titulo
	 * @return Object Libro si se encuentra en la Lista; Null: si no encuentra 
	 */
	private static Libro getByFecha (LocalDate fecha, String titulo) {
		for (Libro libro : prestamos) {
			if(libro.getTitulo().equals(titulo) && libro.getFechaP().equals(fecha)) {
				return libro;
			}		
		}
		return null;
	}
	
	
	/**
	 * Actualiza los arrays tras hacer cualquier prestamo o devolucion 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void save() throws FileNotFoundException, IOException {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Persistencia))){
			oos.writeObject(prestamos);
			oos.writeObject(devoluciones);
		}
		
	}

	/**
	 * Método que restaura el contenido de anteriores ejecuciones, permitiendo la persistencia de datos.
	 * El método se tiene que implementar al principio del main
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void lastSave() throws FileNotFoundException, IOException, ClassNotFoundException {
		if(!Persistencia.exists()) return;
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Persistencia))){
	
			List<Libro> pres = (List<Libro>) ois.readObject();
			List<Libro> dev = (List<Libro>) ois.readObject();
					
			prestamos = pres;
			devoluciones = dev;
					
			}
	}
		
}

