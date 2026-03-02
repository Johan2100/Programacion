package examenesPractica.ejer1Examen24_25.main;

import java.util.ArrayList;
import java.util.List;

import examenesPractica.ejer1Examen24_25.model.*;

public class Hotwars {
	static List<MagoElemental> maguitos = new ArrayList<>();
	static MagoElemental[] maguitos2 = new MagoElemental[3];
	
	public static void main(String[] args) {
		
		//MAGO DE FUEGO 
		maguitos.add(new MagoFuego("Albus",100.7));
	
		//MAGO DE AIRE 
		maguitos.add(new MagoAire("Morgana",1000));
		
		//MAGO ESTUDIANTE 
		maguitos.add(new MagoEstudiante("Elmister"));
		
		for (MagoElemental d: maguitos) {
			
			if( d instanceof MagoEstudiante) {
				System.out.println(((MagoEstudiante) d).Estudiando());
				System.out.println(d.lanzarHechizo());
			}else 
				System.out.println(d.lanzarHechizo());
			
		}
		
		maguitos2[0] = new MagoFuego("Albus",100.7);
		maguitos2[1] = new MagoAire("Morgana",1000);
		maguitos2[2] = new MagoEstudiante("Elmister");
	
	}

}
