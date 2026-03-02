package examencorregidoFebrero.ejer1.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import examencorregidoFebrero.ejer1.model.clases.*;
import examencorregidoFebrero.ejer1.model.interfaz.Depredador;

public class Safari {
	
	static List<Animal> Safari = new ArrayList<>();
	
	public static void main(String[] args) {
		Safari.add(new Conejo("Johan"));
		Safari.add(new Leon("Lenin"));
		Safari.add(new Conejo("Fer"));
		Safari.add(new Conejo("Yimy"));
		Safari.add(new Leon("Oliver"));
		Safari.add(new Conejo("Julia"));
	
		for(Animal a : Safari)
			a.comer((int) (Math.random()*61));
		
		Depredador primer = null;
		boolean encontrado = false;
		for (int i = 0; i < Safari.size() && !encontrado; i++) {
			if(Safari.get(i) instanceof Depredador) {
				primer = (Depredador)Safari.get(i);
				encontrado = true;
			}
		}
		
		//El iterador sirve para todo tipo de colecciones, no solo en SET 
		Iterator<Animal> it = Safari.iterator();
		boolean haCazado = false;
		while(it.hasNext()) {
			Animal a = it.next();
			if(primer.cazar(a)) {
				System.out.println("Caza Buena");
				it.remove();
				haCazado = true;
			}
			
		}
		if(!haCazado) {
			Safari.remove((Animal)primer);
			/* Para poder borrar al introducir un objeto, debemos hacer en la clase Animal un equals para poder borrar 
			 * por nombre. */
		}
		
		
	}

}
