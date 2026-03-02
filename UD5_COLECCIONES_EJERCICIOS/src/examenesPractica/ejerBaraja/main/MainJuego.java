package examenesPractica.ejerBaraja.main;



import java.util.Random;
import java.util.Scanner;

import examenesPractica.ejerBaraja.model.*;

public class MainJuego {
	
	public static Baraja barajas = new Baraja();
	static Random RN = new Random();
	static Jugador uno = new Jugador("ChatGPT");
	static Jugador dos = new Jugador("Gemini");
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		
		
		int op = -1;
		

		while (op != 0) {
			System.out.println("""
					 
					*** MESA ***

					1. Repartir Cartas
					2. Jugar  
					3. Mostrar cartas del jugador 
					4.
					0. Salir.


					""");

			System.out.println();
			op = sc.nextInt();
			sc.nextLine();

			switch (op) {
			case 1 -> {
				repartirCartas();

			}
			case 2 -> {

			}
			case 3 -> {
				uno.mostrarCartas();
				dos.mostrarCartas();
				
			}
			case 4 -> {
			}

			case 0 -> {
				System.out.println("Saliendo...");
			}

			default -> System.out.println("Opción no válida");

			}

		}
		
	}

	static void repartirCartas() {
		
			for (int i = 0; i < 10; i++) {
				int num = 0;
				int palo = 0;
				String tipoPalo;
				boolean repartida = false;
			
				//REPATIR JUGADOR UNO --
				do{
				 num = RN.nextInt(1,11);
				 palo = RN.nextInt(0,4);
				
				switch (palo) {
					case 0-> {
						 tipoPalo = "Oros";
						if(uno.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
						
						
					}
					case 1->{
						 tipoPalo = "Bastos";
						if(uno.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
						
					}
					case 2->{
						 tipoPalo = "Copas";
						if(uno.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
						
						
					}
					case 3->{
						 tipoPalo = "Espadas";
						if(uno.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
					}
					
				}
			
				}while(!(repartida));
				
				//REPARTIR JUGADOR DOS -- 
				repartida = false;
				do {
				num = RN.nextInt(1,11);
				palo = RN.nextInt(0,4);
				
				switch (palo) {
					case 0->{
						 tipoPalo = "Oro";
						if(dos.recibirCarta(new Carta(num,tipoPalo)))	
							repartida = true;
					}
					case 1->{
						 tipoPalo = "Bastos";
						if(dos.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
						
					}
					case 2->{
						 tipoPalo = "Copas";
						if(dos.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
						
					}
					case 3->{
						 tipoPalo = "Espadas";
						if(dos.recibirCarta(new Carta(num,tipoPalo)))
							repartida = true;
					}
				
				}
				}while(!(repartida));
			
				
			}
		}
	}
			

	
	
	
	



