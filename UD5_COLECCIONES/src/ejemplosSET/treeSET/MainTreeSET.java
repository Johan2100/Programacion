package ejemplosSET.treeSET;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainTreeSET {
	
	private static Set<TreeAlumnoSET> alumnos = new TreeSet<>(new ComparadorNif());
	
	public static void main(String[] args) {
		
	insertAlumno(new TreeAlumnoSET("Bea","2",9));
	insertAlumno(new TreeAlumnoSET("Johan","3000",8));
	insertAlumno(new TreeAlumnoSET("Johan","3000",8));	
	insertAlumno(new TreeAlumnoSET("Zoe","4",9));
	insertAlumno(new TreeAlumnoSET("Ana","1",9));
	
	System.out.println(listadoAlumnos());
	
	System.out.println("Nuevo listado: ");
	
	
	System.out.println(listadoAlumnos());
	List<TreeAlumnoSET> listaAlumnos = new LinkedList<>();
	listaAlumnos.addAll(alumnos);
	
	listaAlumnos.sort(null);
	System.out.println("Listado ordenado Lista: ");
	for (TreeAlumnoSET a : listaAlumnos) {
		System.out.println(a);
	}
	
	
	}
	
	
	
	private static void  insertAlumno(TreeAlumnoSET a) {
		alumnos.add(a);
	}
	
	private static String listadoAlumnos() {
		String result = "";
		for (TreeAlumnoSET a : alumnos) {
			result += a + " \n";
		}
		
		return result;
	}

}
