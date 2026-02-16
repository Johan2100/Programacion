package More.ejercicios.ejer2Pila.model;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	private String nombre, nif;
	private List<Alumno> alumnos = new ArrayList<>(0);

	//CONSTRUCTOR
	public Profesor(String nombre, String nif) {
		this.nombre = nombre;
		this.nif = nif;
	}

	//GETTER AND SETTER -- 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	// ToString -- 
	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", nif=" + nif + ", alumnos=" + alumnos + "]";
	}
	
	//METHODS --
	
	// -- ADD
	public void addAlumno(Alumno estudiante) {
		alumnos.add(estudiante);
	}
	
	public boolean addNota(String nif, Double nota) {
		boolean found = false;
		for (int i = 0; i < alumnos.size() && !found; i++) {
			if(alumnos.get(i).getNif().equals(nif)) {
				found = true;
				alumnos.get(i).setNota(nota);
			}
		}
		return found;
	}
	//-- PORCENTAJE
	public int porAprobados() {
		int result = 0;
		int aprobados = 0;
		
		for(Alumno a : alumnos) {
			if(a.getNota() >= 5) {
				aprobados++;
			}
		}
		
		if(aprobados != 0) {
			result = (aprobados*100)/alumnos.size();
			return result;
		}else
			return 0;
		
	}
	
	//-- DELETE 
	
	public boolean removeAlumno(String nif) {
		boolean found = false;
		
		for (int i = 0; i < alumnos.size() && !found; i++) {
			if(alumnos.get(i).getNif().equals(nif)) {
				found = true;
				alumnos.remove(i);
			}
		}
		
		return found;
	}
	
	private List<Alumno> ordenNotaDescendente() {
		
		alumnos.sort( new CriterioNotaDescendiente());
		return alumnos;
	}
	
	
	
	
	
	

}
