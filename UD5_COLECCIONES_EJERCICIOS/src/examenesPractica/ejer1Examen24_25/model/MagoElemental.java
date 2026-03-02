package examenesPractica.ejer1Examen24_25.model;

public abstract class MagoElemental {
	
	protected String nombre;
	protected String elemento;
	
	

	public MagoElemental(String nombre) {
		this.nombre = nombre;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract String lanzarHechizo();
	

}
