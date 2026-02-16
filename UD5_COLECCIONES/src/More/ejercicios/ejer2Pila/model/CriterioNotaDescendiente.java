package More.ejercicios.ejer2Pila.model;

import java.util.Comparator;


public class CriterioNotaDescendiente implements Comparator<Alumno>{

	@Override
	public int compare(Alumno o1, Alumno o2) {
		// TODO Auto-generated method stub
		return (int) (o2.getNota() - o1.getNota());
	}

	
}
