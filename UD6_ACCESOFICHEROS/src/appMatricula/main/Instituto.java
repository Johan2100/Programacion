package appMatricula.main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import appMatricula.model.Alumno;

public class Instituto {
	public static Set<Alumno> alumnos = new HashSet<>();
	static Scanner sc = new Scanner(System.in);
	static public String fichero = "datos\\alumnos.dat";
	
	public static void main(String[] args) {
		
//		alumnosRegistrados();
		
		addAlumno();
		addAlumno();
		for(Alumno a : alumnos)
			a.matricula();
		
		for (Alumno a : alumnos) {
			System.out.println(a);
		}
		
		try {
			guardarDatos();
		} catch (IOException e) {
			System.out.println("No se han guardado los datos");
			e.printStackTrace();
		}
	}
	
	private static boolean addAlumno() {
		System.out.print("NIF: ");
		String nif = sc.nextLine();
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		
		return alumnos.add(new Alumno(nif,nombre));
	}
	
	public void matricula() {
		
	}
	
	private static void guardarDatos() throws IOException {
		/* Le pasamos or constructor un flujo básico de bytes asociados al archivo. 
		 */
		FileOutputStream fos = new FileOutputStream(fichero);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		for(Alumno a : alumnos)
			oos.writeObject(a);
		
		
		oos.close();
		fos.close();
	}
	
	private static void alumnosRegistrados() throws FileNotFoundException, IOException {
		File f = new File(fichero);
		if(!f.exists()) {
			System.out.println("No existe el fichero");
			return;
		}
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
		
//		boolean fin = false;
//		while(!fin) {
//			try {
//
//			} catch (EOFException e) {
//
//			}
//			
//		}
		
		
	}

}
