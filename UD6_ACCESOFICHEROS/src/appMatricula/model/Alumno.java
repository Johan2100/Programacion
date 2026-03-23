package appMatricula.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Alumno implements Serializable {
	private String nif, nombre;
	private Matricula matricula;
	static Scanner sc = new Scanner(System.in);
	
	public Alumno(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
		this.matricula = new Matricula();
	}
	
	
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
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
		
	@Override
	public String toString() {
		return "Alumno [nif=" + nif + ", nombre=" + nombre + ", matricula=" + matricula + "]";
	}

	public void matricula() {
		
		int code = (int) (Math.random()*100000);
		boolean end = false;
		List<String> asignaturas = new ArrayList<>();
		
		do {
			System.out.print("Introduzca nombre de la asignatura // 'Fin' para terminar: ");
			String nomAsig = sc.nextLine();
			
			if(nomAsig.equalsIgnoreCase("Fin")) {
				end = true;
			}else {
				asignaturas.add(nomAsig);
			}
			
		}while(!end);
	
		this.matricula.setAsignaturas(asignaturas);	
		this.matricula.setCode(code);
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(nif);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nif, other.nif);
	}
	


	
	
	

}
