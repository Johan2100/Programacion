package examencorregidoFebrero.ejer1.model.clases;

import java.util.Objects;

public abstract class Animal {
	protected String nombre;
	protected int energia = 1;
	
	
	//CONSTRUCTOR -- 
	public Animal(String nombre) {
		this.nombre = nombre;
	}
	
	//GETTER AND SETTER --
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	
	//toString -- 
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", energia=" + energia + "]";
	}
	
	// EQUALS AND HASHCODE -- 
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nombre, other.nombre);
	}
	
	//METHODS -- 
	public abstract void comer(int cantidad);
	
	
}
