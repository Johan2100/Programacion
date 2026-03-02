package examenesPractica.ejerAbonado.model.clases;

import examenesPractica.ejerAbonado.model.interfaz.Abonado;

public class AbonadoRegular extends CuerpoAbonado implements Abonado {

	
	
	public AbonadoRegular(String nif, String nombre) {
		super(nif, nombre);
	
	}

	@Override
	public boolean registrarActividad(Actividad a) {
		boolean agregada = false;
		if( this.actividades.size() <= 10) {
			actividades.add(a);
			agregada = true;
		}
		return agregada;
	}
	
	public double tarifaTotal() {
		double suma = 0;
		for (Actividad a : actividades) {
			suma += a.getCouta();
		}
		return suma;
	}
	

	@Override
	public String toString() {
		return "AbonadoRegular [nif=" + nif + ", nombre=" + nombre + ", actividades=" + actividades + "]";
	}

	@Override
	public boolean cancelarActividad(String nombre) {
		return this.actividades.remove(nombre); // Clave primaria es nombre, sino lo hariamos con un iterator 
	}

}
