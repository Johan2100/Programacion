package examenesPractica.ejerAbonado.model.clases;



import java.util.Iterator;

import examenesPractica.ejerAbonado.model.interfaz.Abonado;

public class AbonadoVIP extends CuerpoAbonado implements Abonado {

	public AbonadoVIP(String nif, String nombre) {
		super(nif, nombre);
		
	}

	
	
	
	@Override
	public String toString() {
		return "AbonadoVIP [nif=" + nif + ", nombre=" + nombre + ", actividades=" + actividades + "]";
	}




	@Override
	public boolean registrarActividad(Actividad a ) {
		return this.actividades.add(a);
	}

	@Override
	public boolean cancelarActividad(String nombre) {
		boolean borrado = false;
		Iterator<Actividad> it = actividades.iterator();
		
		while(it.hasNext()) {
			Actividad a = it.next();
			if( a.getNombre().equals(nombre)) {
				it.remove();
				borrado = true;
			}
		}
		return borrado;
	}

}
