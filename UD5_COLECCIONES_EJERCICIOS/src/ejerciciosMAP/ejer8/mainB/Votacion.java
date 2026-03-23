package ejerciciosMAP.ejer8.mainB;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Votacion {
	static Scanner sc = new Scanner(System.in);
	static Map<String,Integer> candidatos = new HashMap<>();
	
	private static void agregarCandidato(String nombre) {
		candidatos.put(nombre, 0);
	}
	
	private static boolean agregarVoto(String nombre) throws VotoNoValidoException {
		boolean agregado = false;
		if(candidatos.containsKey(nombre)) {
			int votosActuales = candidatos.get(nombre);
			candidatos.put(nombre, votosActuales+1);
			return agregado = true;
		}else {
			throw new VotoNoValidoException();
		}
		
	}
	
	private static void imprimirCandidatos() {
		Set<String> nombre = candidatos.keySet();
		for (String s : nombre) {
			System.out.println("Candidatos -> "+s);
		}
		
	}
	
	private static void votacion() {
			String nombre = "";
			try {
				do {
				System.out.println("A quien vota?");
				nombre = sc.nextLine();
				}while(!agregarVoto(nombre));
			} catch (VotoNoValidoException e) {
				
				e.printStackTrace();
			}
		
	}
	
	private static void eliminarNoVotados() {
//		Map<String,Integer> candidatosaux = new HashMap<>();
//		
//		
//		Set<String> nombre = candidatos.keySet();
//		for (String s : nombre) {
//			if(candidatos.get(s) > 1) {
//				candidatosaux.put(s, candidatos.get(s));
//			}
//		}
//		candidatos = candidatosaux;
//		candidatosaux.clear();
//		
		
		//Tambien podemos usar el Iterator para obtener el campo key o el campo value debemos hacer 
		//Para solo key - Iterator<String> itNombre = votos.keySet().iterator(); - parecido al Set
		//Para solo value - Iterator<Integer> itVotos = votos.values().iterator();
		
		Iterator<Map.Entry<String,Integer>> it = candidatos.entrySet().iterator();
		//Podemos hacer el getValue ya que entramos al mapa gracias al Map.Entry.
		//El entrySet obtenemos un objeto que tiene ambos contenidos, tanto la key y el value, siendo la forma más eficiente
		//Para recorrer una coleccion MAP
		//Para acceder al value o key usamos el método - getKey() o getValue() 
		
		while (it.hasNext()) {
			Map.Entry<String,Integer> cantidadVotos = it.next();
			if(cantidadVotos.getValue() < 1) {
				it.remove();
			}
		}
		
		
	}
	
	private static void mayoria (Map<String,Integer> recuento) {
		int totalVotos = 0;
		for(Integer v : recuento.values()) {
			totalVotos += v ;
		}		
		Set<String> nombre = recuento.keySet();

		int numero = Integer.MIN_VALUE;
		String nombreMayor="";
		for (String s : nombre) {
			if(recuento.get(s) > numero) {
				numero = recuento.get(s);
				nombreMayor = s;
			}
		}
		if(numero > (totalVotos/2)) {
			System.out.println("Candidato/a con mayoria absoluta: "+ nombreMayor);
		}else {
			System.out.println("No hay mayoria de votos");
		}
		
		
	}
	
	private static int validarNumero() {
		int n = 0;
		boolean noValido = true;
		while(noValido) {
			try {
				n = sc.nextInt(); sc.nextLine();
				noValido = false;
			}catch(InputMismatchException ex){
				System.out.println("G pon un numero entero");
				sc.nextLine();
			}
			
		}
		
		
		return n;
	}
	
	
	
	public static void main(String[] args) {
		
	System.out.println("¿Cuantos candidatos se van a presentar?");
	int numCandidatos = validarNumero();
	
	try {
		 numCandidatos = sc.nextInt(); sc.nextLine();

	} catch (InputMismatchException e) {
		System.out.println("Se ha establecido 5 candidatos automáticamente");
		sc.nextLine(); //Se usa para limpiar el buuffer y no de error
	} //catch (ArrayIndexOfBoundException){
		//Podemos en caso de necesitar otra excepcion se puede hacer por separado
		//Usamos el IndexOfBoundException por que en clase añadimos un array para probar
	//}
	
	
	
	for (int i = 0; i < numCandidatos; i++) {
		System.out.print("Nombre del participante "+(i+1)+" : ");
		agregarCandidato(sc.nextLine());
		
	}
	
	imprimirCandidatos();
	
	for (int i = 0; i < 30; i++) {
		votacion();
	}
	
	
	candidatos.forEach((nombre,cantidad) -> {
		System.out.println("Candidato "+nombre+ " -Votos: "+cantidad);
	});
	
	eliminarNoVotados();
	System.out.println();
	System.out.println("*** LISTA DE VOTADOS ***");
	imprimirCandidatos();
	
	mayoria(candidatos);
	
	
	}

}
