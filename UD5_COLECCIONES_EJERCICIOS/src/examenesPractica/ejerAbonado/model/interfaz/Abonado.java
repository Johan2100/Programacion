package examenesPractica.ejerAbonado.model.interfaz;

import examenesPractica.ejerAbonado.model.clases.Actividad;

public interface Abonado {

	boolean registrarActividad(Actividad actividad);
	boolean cancelarActividad(String nombre);
}
