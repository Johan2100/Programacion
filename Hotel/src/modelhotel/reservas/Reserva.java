package modelhotel.reservas;

import java.time.LocalDate;

import modelhotel.habitaciones.Habitacion;

public class Reserva {
	protected LocalDate fecha;
	protected int numHabitacion, numPer;
	protected Habitacion[] habReservadas = new Habitacion[0];
	
	// CONSTUCTOR -- 
	public Reserva(LocalDate fecha, int numHabitacion, int numPer) {
		super();
		this.fecha = fecha;
		this.numHabitacion = numHabitacion;
		this.numPer = numPer;
	}


	//GETTER AND SETTER -- 
	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public int getNumHabitacion() {
		return numHabitacion;
	}


	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}


	public int getNumPer() {
		return numPer;
	}


	public void setNumPer(int numPer) {
		this.numPer = numPer;
	}


	public Habitacion[] getHabReservadas() {
		return habReservadas;
	}


	public void setHabReservadas(Habitacion[] habReservadas) {
		this.habReservadas = habReservadas;
	}
	
	//MÉTODOS -- 
	
	

	
	
	
	

}
