package Empleados;

public abstract class Empleados {
	
	protected String nombre, DNI;
	protected double salB;
	
	
	
	//CONSTRUCTOR ---
	public Empleados(String nombre, String dNI, double salB) {
		this.nombre = nombre;
		DNI = dNI;
		this.salB = salB;
	}
	
	public Empleados() {
		
	}
	
	
	//GETTER AND SETTER ----
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public double getSalB() {
		return salB;
	}

	public void setSalB(double salB) {
		this.salB = salB;
	}

	//ToString --- 
	
	@Override
	public String toString() {
		return "Empleados [nombre=" + nombre + ", DNI=" + DNI + ", salB=" + salB + ", salF="
				+ calcularSalario() + "]";
	}
	
	
	
	//MÉTODOS -- 
	
	public abstract double calcularSalario() ;
	

}
