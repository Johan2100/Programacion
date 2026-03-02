package examenesPractica.ejer2Examen24_25.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import examenesPractica.ejer2Examen24_25.model.Particula;
import examenesPractica.ejer2Examen24_25.model.Punto;

public class SimuladorParticulas {
	     
	List<Particula> particulas = new ArrayList<>();
	     Scanner scanner = new Scanner(System.in);
	     
	     public static void main(String[] args) {
		        SimuladorParticulas simulacion = new SimuladorParticulas();
		        simulacion.ejecutar();
		    }
	     
	     
	     
	    
	    public void ejecutar() {
	        int opcion;
	        do {
	            mostrarMenu();
	            opcion = scanner.nextInt();
	            scanner.nextLine(); // Limpiar el buffer del scanner
	            switch (opcion) {
	                case 1:
	                    agregarParticula();
	                    break;
	                case 2:
	                    System.out.println(buscarPorRangoMasa());
	                    break;
	                case 3:
	                    eliminarPorPosicion();
	                    break;
	                case 4:
	                    particulaMaxMasa();
	                    break;
	                case 5:
	                	listarParticulas();
	                	break;
	                case 0:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción inválida.");
	            }
	        } while (opcion != 0);
	        scanner.close();
	    }

	    private void mostrarMenu() {
	        System.out.println("\n--- Simulador de Partículas ---");
	        System.out.println("1. Agregar partícula");
	        System.out.println("2. Buscar por rango de masa");
	        System.out.println("3. Eliminar por posición");
	        System.out.println("4. Buscar partícula con más masa");
	        System.out.println("0. Salir");
	        System.out.print("Ingrese una opción: ");
	    }

	    private void agregarParticula() {
	        System.out.println("Carga: (int)");
	        int carga = scanner.nextInt();
	        
	        System.out.println("Masa: (double)");
	        double masa = scanner.nextDouble();
	        
	        System.out.println("Posición x: (double)");
	        double x = scanner.nextDouble();
	        
	        System.out.println("Posición y: (double)");
	        double y = scanner.nextDouble();
	       
	        //TODO: crear la particula y añadirla a la colección de particulas
	        particulas.add(new Particula(carga, masa,new Punto(x,y)));
	        
	        System.out.println("Partícula agregada.");
	    }


	    private List<Particula> buscarPorRangoMasa() {
	    	 //TODO: buscar todas las particulas que entren el rango de masa proporcionado,
	        //guardalas en una List y devolverla
	    	
	    	List<Particula> lista= new ArrayList<>();
	        System.out.print("Rango de masa (min): (double) ");
	        double minMasa = scanner.nextDouble();
	        System.out.print("Rango de masa (max): (double) ");
	        double maxMasa = scanner.nextDouble();
	        while(maxMasa < minMasa)
	        	 maxMasa = scanner.nextDouble();
	        
	        for (Particula p : particulas) {
	        	if(p.getMasa() > minMasa && p.getMasa() < maxMasa)
	        		lista.add(p);
			}
	        
	        return lista;
	    }

	    private void eliminarPorPosicion() {
	    	 //TODO: usando el método proporcionado para calcular distancias entre dos puntos,
	        //encontrar la particula más cercana al punto proporcionado y quitarla de la colección
	        //de particulas
	    	
	        System.out.print("Posición para eliminar (x): (double)");
	        double x = scanner.nextDouble();
	        System.out.print("Posición para eliminar (y): (double)");
	        double y = scanner.nextDouble();
	        Punto posicion = new Punto(x, y);
	        
	        double distanciaMin = SimuladorParticulas.calcularDistancia(posicion, particulas.get(0).getPosicion());
	        int posD = -1;
	        
	        for (int i = 0; i < particulas.size(); i++) {
	        	double distancia = SimuladorParticulas.calcularDistancia(posicion, particulas.get(i).getPosicion());
	        	
	        	if( distanciaMin > distancia) {
	        		distanciaMin = distancia;
	        		posD = i;
	        	}
	        	
			}
	        if(posD != -1)
	        particulas.remove(posD);
	        else 
	        	System.out.println("No se ha eliminado ninguna particula");
	   
	    }

	    static private double calcularDistancia(Punto p1, Punto p2) {
	        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	    }

	    private void listarParticulas() {
	    	for (Particula particula : particulas) {
				System.out.println(particula);
			}
	    }

	    private void particulaMaxMasa() {
	    	//TODO: mostrar la particula con max Masa
	    	double maxMasa = particulas.get(0).getMasa();
	    	int posD = -1;
	    	
	    	for (int i = 0; i < particulas.size(); i++) {
				if(maxMasa < particulas.get(i).getMasa()) {
					maxMasa = particulas.get(i).getMasa();
					posD = i;
				}
			}
	    	
	    	if(posD != -1) {
	    		System.out.println("La particula con más masa es: \n"+particulas.get(posD));
	    	}else
	    		System.out.println("No hay ninguna particula con masa máxima");
	    	
	        
	    }

	    
}
