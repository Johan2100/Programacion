package ejemplosSET;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainSET {
	public static void main(String[] args) {
		
	//TRES IMPLEMENTACIONES:
	//HashSet, LinkedHasSet, TreeSet
		ejemploHashSet();
		ejemploAlumnoSet();
		
		
		
	}
	
	
	private static void ejemploHashSet() {
	
		Set<String> nombre = new HashSet<>();
		nombre.add("Juan");
		nombre.add("Ana");
		nombre.add("Zoe");
		
		System.out.println(nombre.size());
		System.out.println("--- Plantilla 1 ---");
		//El orden de iteración no es el de inserción, por tanto no hay posiciones. 
		for(String n : nombre){
			System.out.println(n); 
		}
		
		//Al no tener indice no podemos usar los remove o indexOf ya que no contamos con una posición exacta, 
		//por tanto los for con indice i, no lo podemos usar. 
		//Por tanto otro método para recorrer la coleccion sería con iteradores. 
		
		Iterator<String> it = nombre.iterator(); //Util para eliminar ya que tiene el método remove. 
		System.out.println("--- Plantilla 2 ---");
		while(it.hasNext()) {
			String n = it.next();
			System.out.println(n);
		}
		
		//Queremos eliminar los nombres que empiecen por A. 
		//Este for nos suelta un error de concurrencia:
//		for(String n : nombre) {
//			if(n.charAt(0) == 'A')
//				nombre.remove(n);
//		}
		System.out.println("---------- BORRADO -------------");
		it = nombre.iterator();
		while(it.hasNext()) {
			String n = it.next();
			if(n.charAt(0) == 'A')
				it.remove();
		}
		nombre.remove("Zoe"); // Otra forma de borrar, aqui se usa es .equals de la clase String 
		
		for(String n : nombre){
			System.out.println(n); 
		}
		
	}
	
	
	private static void ejemploAlumnoSet() {
		
		Set<AlumnoSET> alumnos = new HashSet<>();
		
		alumnos.add(new AlumnoSET("200F",2));
		alumnos.add(new AlumnoSET("200A",9));
		
		for (AlumnoSET a : alumnos) {
			System.out.println(a);
		}
		alumnos.add(new AlumnoSET("200A",2));
		
		alumnos.add(new AlumnoSET("5678",8));
		for (AlumnoSET a : alumnos) {
			System.out.println(a);
		}
		
		alumnos.remove(new AlumnoSET("5678",8));
		System.out.println("------");
		for (AlumnoSET a : alumnos) {
			System.out.println(a);
		}
		
		Iterator<AlumnoSET> it = alumnos.iterator();
		while(it.hasNext()) {
			AlumnoSET a = it.next();
			if(a.getNota() < 5)
				it.remove();
		}
		System.out.println("Borrado < 5 ---");
		for (AlumnoSET a : alumnos) {
			System.out.println(a);
		}
	}


}
