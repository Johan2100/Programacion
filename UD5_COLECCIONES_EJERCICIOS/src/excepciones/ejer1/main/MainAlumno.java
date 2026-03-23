package excepciones.ejer1.main;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import excepciones.ejer1.model.Alumno;

public class MainAlumno {
	public static Map<String,Alumno> alumnos = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		System.out.println("Cuantos alumnos? ");
		int n = -1;
		boolean valido = false;
		
		do {
			try {
				n = sc.nextInt(); sc.nextLine();
				valido = true;
				if(n<0) {
					System.out.println("Introduce un numero positivo");
				}
			}catch(InputMismatchException ex) {
				System.out.print("Introduzca un numero entero: ");
				sc.nextLine();
			}
			
		}while(!valido || n < 0);
		
		//OPCIONES LANZANDO DOS EXPCEPCIONES; 
//		do {
//			try {
//				n = sc.nextInt(); sc.nextLine();
//				valido = true;
//				if(n > 0 )
//					valido = true;
//				else {
//					System.out.println("Introduce número positivo");
//					n = sc.nextInt(); sc.nextLine();
//				}
//				
//			}catch(InputMismatchException ex) {
//				System.out.print("Introduzca un numero entero: ");
//				sc.nextLine();
//			}catch(NumeroAlumnosNegativosException ex) {
//			}
//			
//		}while(!valido);
//		
		

//		
//		do {
//			try {
//				n = sc.nextInt(); sc.nextLine();
//				valido = true;
//				if(n > 0 )
//					valido = true;
//				else {
//					System.out.println("Introduce número positivo");
//					n = sc.nextInt(); sc.nextLine();
//				}
//				
//			}catch(InputMismatchException ex) {
//				System.out.print("Introduzca un numero entero: ");
//				sc.nextLine();
//			}
//			
//		}while(!valido);
//		
		
		for (int i = 0; i < n; i++) {
			System.out.println("Nombre:");
			String nombre = sc.nextLine();
			System.out.println("Año ");
			int anyo = sc.nextInt();
			Alumno a = Alumno.crearAlumno(nombre, anyo);
			if(a != null) {
				alumnos.put(a.getNombre(), a);
			}
		}
		
		
		
		
	}
	
	private static int leerNumero() {
		int n = sc.nextInt();
		if(n<0) {
			throw new NumeroAlumnosNegativosException();
		}
		return n;
	}
	
	//CLASE INTERNA:
	/* Para pooder usar una clase interna debemos instanciar un un objeto de la clase que la contieneo también que este comprendido en el contexto de una clase de 
	 * manera estática.
	 * El ejemplo dado en clase es que un objeto apartamento tiene que estar si o si dentro de un objeto Edificio. Ya que un apartamento tiene que estar dentro de un
	 * edificio. Por lo tanto el apartamento puedo acceder totalmente a los atributos de la clase que la contiene. 
	 * Es usada para evitar hacer otra clase aparte
	 * Para el caso de leerNumero, tienes que hacer la clase static para poder usarla y evitar el error de compilación, ya que al ser estatica
	 * 
	 */
	 private static class NumeroAlumnosNegativosException extends RuntimeException  {

		public NumeroAlumnosNegativosException() {
			super("El número de alumnos es negativo");
		}
		
	}
}




