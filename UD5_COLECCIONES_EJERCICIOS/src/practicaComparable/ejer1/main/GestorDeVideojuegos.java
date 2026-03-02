package practicaComparable.ejer1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import practicaComparable.ejer1.model.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class GestorDeVideojuegos {
	
	static Scanner sc = new Scanner(System.in);
	static List<Videojuego> listajuegos = new ArrayList<>();
	public static void main(String[] args) {
		
		listajuegos.add(new Videojuego(1,"The Forest",200.32));
		listajuegos.add(new Videojuego(2,"Zoe",323.32));
		listajuegos.add(new Videojuego(3,"Pinterest",12.39));
		listajuegos.add(new Videojuego(4,"Avecrem",23400.3249));
		
		listajuegos.sort(new ComparadorTitulo().reversed());
		
		for (Videojuego v : listajuegos) {
			System.out.println(v);
		}
		
		LocalDate fecha = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
	
	
	}

}
