package Explicacion.Interfaz;

import Explicacion.model.envios.EstadoEnvio;

public interface Rasteables {
	
	EstadoEnvio obtenerEstado();
	
	void actualizarEstado(EstadoEnvio nuevoEstado);

}
