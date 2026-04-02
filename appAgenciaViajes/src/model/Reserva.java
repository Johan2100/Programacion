package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable{
	
	private static final long serialVersionUID = -1906181065781177851L;
	private long codReserva;
	private String cliente;
	private LocalDate fecha;
	private Destino destino;
	
	
	public Reserva(long codReserva, String cliente, LocalDate fecha, Destino destino) {
		this.codReserva = codReserva;
		this.cliente = cliente;
		this.fecha = fecha;
		this.destino = destino;
	}
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
	@Override
	public String toString() {
		return "Reserva [codReserva=" + codReserva + ", cliente=" + cliente + ", fecha=" + fecha + ", destino="
				+ destino + "]";
	}
	
	

}
