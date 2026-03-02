package miniAplicaciones.ejer1Examen23_25.model.clases;

public class Dragon extends CriaturaMistica {
	
	private String cola,color;
	private double alas;
	
	public Dragon(String nombre, int edad) {
		super(nombre, edad);
		
	}


	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}


	public double getAlas() {
		return alas;
	}


	public void setAlas(double alas) {
		this.alas = alas;
	}


	//METHODS -- 
	@Override
	public void agregarDes(String cola, double alas, String color) {
		this.cola = cola;
		this.alas = alas;
		this.color = color;
	}
	
	@Override
	public void activarPoder() {
		System.out.println(this.nombre+" BOLA DE FUEGO");
	}

	@Override
	public String describirCriatura() {
		String result = "";
		result += "DESCRIPCIÓN Dragón - "+this.nombre+"\n";
		result += " Cola: "+this.cola+" cm \n";
		result += " Tamaño de Alas: "+this.alas+" cm \n";
		result += " Color: "+this.color+" \n";
		
		return result;
		
		
		
	}


}
