package examenesPractica.ejer1Examen24_25.model;

import examenesPractica.ejer1Examen24_25.model.interfaz.Aprendiz;

public class MagoEstudiante extends MagoElemental implements Aprendiz {

	public MagoEstudiante(String nombre) {
		super(nombre);
		this.elemento = "Prácticas";
	}

	@Override
	public String Estudiando() {
		return "SHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH, Estudiando....";
	}

	@Override
	public String lanzarHechizo() {
		return this.nombre + " ha lanzado el hechizo: Estoy de  "+elemento+", Sin elemento !QUE PRINGAO¡";
	}

}
