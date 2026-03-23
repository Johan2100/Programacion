package ejemploMAP.prueba1.model;

public class Alumno {
	
	private String nombre;
	int nota = 0;
	
	public Alumno(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	

}
