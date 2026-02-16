package More.ejercicios.ejer2Pila.model;


public class Alumno {
	private String nif, nombre;
	private Double nota = (double) 0;
	
	//CONSTRUCTOR -- 
	
	public Alumno(String nif, String nombre, Double nota) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	//GETTER AND SETTER -- 
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	//ToString 
	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", nota=" + nota + "]";
	}

	//METHODS 
	

}
