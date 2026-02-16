package miniAplicaciones.ejer3.model;

public class Diseñador extends Empleado {
	
	private String herramientaDiseño;
	private double plusDiseñador;
	
	//CONSTRUCTOR -- 
	public Diseñador(String nombre, double salarioBase, String herramientaDiseño, double plusDiseñador) {
		super(nombre, salarioBase);
		this.herramientaDiseño = herramientaDiseño;
		this.plusDiseñador = plusDiseñador;
	}

	
	
	//GETTER AND SETTER -- 
	public String getHerramientaDiseño() {
		return herramientaDiseño;
	}
	public void setHerramientaDiseño(String herramientaDiseño) {
		this.herramientaDiseño = herramientaDiseño;
	}
	public double getPlusDiseñador() {
		return plusDiseñador;
	}
	public void setPlusDiseñador(double plusDiseñador) {
		this.plusDiseñador = plusDiseñador;
	}

	@Override
	public String toString() {
		return "Diseñador [Nombre=" + nombre + ", Herramienta=" + herramientaDiseño + ", Plus="
				+ plusDiseñador + ", Salario Total=" + calcularSalario() + "]";
	}



	@Override
	double calcularSalario() {
		
		return salarioBase + plusDiseñador;
	}
	
	

}
