package examenesPractica.ejerBaraja.model;

import java.util.ArrayList;
import java.util.List;

import examenesPractica.ejerBaraja.main.MainJuego;

public class Jugador {
	private String nombre;
	private int puntuacion;
	private List<Carta> mano = new ArrayList<>();
	
	
	
	//CONSTRUCTOR -- 
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntuacion = 0;
	}
	
	//GETTER AND SETTER --
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntuacion() {
		return puntuacion;
	}
	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}
	public List<Carta> getMano() {
		return mano;
	}
	public void setMano(List<Carta> mano) {
		this.mano = mano;
	}
	
	
	//METHODS -- 
	public boolean recibirCarta(Carta carta) {
		boolean recibido = false;
		
	
			if(MainJuego.barajas.getCartasB().contains(carta)) {
			mano.add(carta);
			MainJuego.barajas.getCartasB().remove(carta);
			recibido = true;
			}
				
		
		
		return recibido;
	
	}
	
	public Carta jugarCarta(String palo) {
		int maxCarta = 0;
		for (Carta carta : mano) {
			if(carta.getPalo().equals(palo) && carta.getNumero() > maxCarta) {
				maxCarta = carta.getNumero();
				
			}
				
		}
		
		return new Carta(maxCarta,palo);
	}
	
	public void mostrarCartas() {
		System.out.println("CARTAS DEL JUGADOR "+this.nombre);
		for (Carta carta : mano) {
			System.out.println(carta);
		}
	}
	
	
}
