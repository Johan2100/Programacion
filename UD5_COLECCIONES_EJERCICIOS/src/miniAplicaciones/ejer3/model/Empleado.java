package miniAplicaciones.ejer3.model;

import java.util.Objects;

public abstract class Empleado {
	
	protected String nombre;
	protected double salarioBase;
	
	//CONSTRUCTOR -- 
	
	public Empleado(String nombre, double salarioBase) {
		this.nombre = nombre;
		this.salarioBase = salarioBase;
	}
	
	//GETTER AND SETTER --- 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	
	
	
	//METHODS -- 
	
	
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
		Empleado other = (Empleado) obj;
		return Objects.equals(nombre, other.nombre);
	}

	abstract double calcularSalario();
	


}
