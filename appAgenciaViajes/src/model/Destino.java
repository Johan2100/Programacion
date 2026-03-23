package model;

import java.io.Serializable;

public class Destino implements Serializable{
	private String nombreDestino;
	private double precio;
	
	

	public Destino(String nombreDestino, double precio) {
		this.nombreDestino = nombreDestino;
		this.precio = precio;
	}
	public String getNombreDestino() {
		return nombreDestino;
	}
	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

}
