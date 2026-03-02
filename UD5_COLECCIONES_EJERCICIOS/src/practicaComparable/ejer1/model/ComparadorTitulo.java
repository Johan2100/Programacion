package practicaComparable.ejer1.model;

import java.util.Comparator;

public class ComparadorTitulo implements Comparator<Videojuego>{

	
	
	public ComparadorTitulo() {
	}

	@Override
	public int compare(Videojuego o1, Videojuego o2) {
		
		return o1.getNombre().compareTo(o2.getNombre());
	}
	

}
