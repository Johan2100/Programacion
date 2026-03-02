package miniAplicaciones.ejer1Examen23_25.model.clases;

import java.util.Scanner;

import miniAplicaciones.ejer1Examen23_25.model.interfaz.PoderMistico;

public abstract class CriaturaMistica implements PoderMistico {
	static Scanner sc = new Scanner(System.in);
	protected String nombre;
	protected int edad;
	
	//CONSTRUCTOR -- 
	public CriaturaMistica(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	//GETTER AND SETTER -- 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//METHODS -- ,
	public abstract void agregarDes(String atributo1, double atributo2, String atributo3);
	public abstract String describirCriatura();
	

}
