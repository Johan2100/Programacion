package examenesPractica.ejer1Examen24_25.model;

public class MagoAire extends MagoElemental {

	private double velocidad;
	
	public MagoAire(String nombre, double velocidad) {
		super(nombre);
		this.elemento = "Aire";
		this.velocidad = velocidad;
	}

	
	
	@Override
	public String toString() {
		return "MagoAire [velocidad=" + velocidad + ", nombre=" + nombre + ", elemento=" + elemento + "]";
	}



	@Override
	public String lanzarHechizo() {
		return this.nombre +" ha lanzado un hechizo de aire:  " + this.velocidad+" km/h";
	}

}
