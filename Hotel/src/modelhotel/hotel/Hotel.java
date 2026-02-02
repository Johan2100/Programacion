package modelhotel.hotel;



import modelhotel.habitaciones.Habitacion;
import modelhotel.reservas.Reserva;

public class Hotel {
	
	public static Habitacion[] habitaciones = new Habitacion[0];
	public static Reserva[] reservas = new Reserva[0];
	

	//CRUD -- 
	
	
	//CREATE 
	public void createRoom(Habitacion room) {
		Habitacion[] aux = new Habitacion[habitaciones.length+1];
		
		for (int i = 0; i < aux.length; i++) {
			aux[i] = habitaciones[i];
		}
		aux[aux.length-1] = room;
		habitaciones = aux;
		
	}
	
	
}
