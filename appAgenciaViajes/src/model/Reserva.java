package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable{
	private long codReserva;
	private String cliente;
	private LocalDate fecha;
	private Destino destino;
	
	
	
	
	public long getCodReserva() {
		return codReserva;
	}
	public void setCodReserva(long codReserva) {
		this.codReserva = codReserva;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Destino getDestino() {
		return destino;
	}
	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
	

}
