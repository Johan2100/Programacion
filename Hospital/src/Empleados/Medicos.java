package Empleados;

public class Medicos extends Empleados {
	
	private String especialidad;
	private int numGuardias;
	
	//CONSTRUCTOR -- 
	
	public Medicos(String nombre, String dNI, double salB, String especialidad, int numGuardias) {
		super(nombre, dNI, salB);
		this.especialidad = especialidad;
		this.numGuardias = numGuardias;
	}
	
	//GETTER AND SETTER --- 

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public int getNumGuardias() {
		return numGuardias;
	}

	public void setNumGuardias(int numGuardias) {
		this.numGuardias = numGuardias;
	}
	
	//toString -- 
	
	@Override
	public String toString() {
		return "Medicos [especialidad=" + especialidad + ", numGuardias=" + numGuardias + ", nombre=" + nombre
				+ ", DNI=" + DNI + ", salB=" + salB + ", salF=" + calcularSalario() + "]";
	}
	
	
	
	
	//MÉTODOS -- 
	
	public double calcularSalario() {
		
		return salB + (numGuardias*50);
		
	}

	

	
	

	
	

}
