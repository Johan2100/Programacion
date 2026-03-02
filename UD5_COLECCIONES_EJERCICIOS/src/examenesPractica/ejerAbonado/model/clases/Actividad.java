package examenesPractica.ejerAbonado.model.clases;

import java.util.Arrays;
import java.util.Objects;

public class Actividad {
	private String nombre;
	private double couta;
	private char[] dias;
	

	public Actividad(String nombre, double couta, char[] dias) {
		this.nombre = nombre;
		this.couta = couta;
		this.dias = dias;
	}

	public String getNombre() {
		return nombre;
	}
	
	//GETTER AND SETTER -- 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCouta() {
		return couta;
	}
	public void setCouta(double couta) {
		this.couta = couta;
	}
	public char[] getDias() {
		return dias;
	}
	public void setDias(char[] dias) {
		this.dias = dias;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	
	
	
	//METHODS -- 
	
	@Override
	public String toString() {
		return "Actividad [nombre=" + nombre + ", couta=" + couta + ", dias=" + Arrays.toString(dias) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
}
