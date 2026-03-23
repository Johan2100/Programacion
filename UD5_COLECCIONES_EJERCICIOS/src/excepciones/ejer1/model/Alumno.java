package excepciones.ejer1.model;

public class Alumno {
	String nombre;
	int anyo;
	
	private Alumno(String nombre, int anyo) {
		this.nombre = nombre;
		this.anyo = anyo;
	}

	static public Alumno crearAlumno(String alumno, int nacimiento) {
		if(nacimiento < 0 )
			return null;
		return new Alumno(alumno,nacimiento);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	
	

}
