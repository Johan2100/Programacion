package ejemplosSET.treeSET;

import java.util.Objects;

public class TreeAlumnoSET implements Comparable <TreeAlumnoSET> {
	
	private String nombre, nif;
	private int Nota;
	
	//CONSTRUCTOR 
	public TreeAlumnoSET(String nombre, String nif, int nota) {
		this.nombre = nombre;
		this.nif = nif;
		Nota = nota;
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
	public int getNota() {
		return Nota;
	}
	public void setNota(int nota) {
		Nota = nota;
	}
	@Override
	public String toString() {
		return "TreeAlumnoSET [nombre=" + nombre + ", nif=" + nif + ", Nota=" + Nota + "]";
	}
	//Este es el criterio de igualdad para TreeSET
	/**
	 * Devolverá -1 si es una posción hacia atras, 0 si es la misma y +1 si es la siguiente 
	 */
	@Override
	public int compareTo(TreeAlumnoSET o) {
		return this.nombre.compareTo(o.nombre);
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
		TreeAlumnoSET other = (TreeAlumnoSET) obj;
		return Objects.equals(nif, other.nif);
	}
	
	
	
	
	
	

	

}
