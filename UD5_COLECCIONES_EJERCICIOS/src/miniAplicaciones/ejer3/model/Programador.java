package miniAplicaciones.ejer3.model;

public class Programador extends Empleado {
	private String lenguajePrincipal;
	private double plusLenguaje;
	
	//CONSTRUCTOR -- 
	public Programador(String nombre, double salarioBase, String lenguajePrincipal, double plusLenguaje) {
		super(nombre, salarioBase);
		this.lenguajePrincipal = lenguajePrincipal;
		this.plusLenguaje = plusLenguaje;
	}

	//GETTER AND SETTER -- 
	public String getLenguajePrincipal() {
		return lenguajePrincipal;
	}

	public void setLenguajePrincipal(String lenguajePrincipal) {
		this.lenguajePrincipal = lenguajePrincipal;
	}

	public double getPlusLenguaje() {
		return plusLenguaje;
	}

	public void setPlusLenguaje(double plusLenguaje) {
		this.plusLenguaje = plusLenguaje;
	}
	
	
	
	
	//METHODS -- 


	@Override
	double calcularSalario() {
		return salarioBase+plusLenguaje;
	}

	@Override
	public String toString() {
		return "Programador [Nombre=" + nombre + ", Lenguaje=" + lenguajePrincipal + ", Plus="
				+ plusLenguaje +", Salario Total=" +calcularSalario()+"]";
	}

	
	
	
	
	
	
	

}
