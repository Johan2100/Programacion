package miniAplicaciones.ejer1Examen23_25.model.clases;

public class Elfo extends CriaturaMistica {

	private String habilidad, color;
	private double altura;
	
	public Elfo(String nombre, int edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}
	
	

	public String getHabilidad() {
		return habilidad;
	}



	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	@Override
	public void activarPoder() {
		System.out.println(this.nombre+" INVISIBILIDAD");
		
	}


	@Override
	public void agregarDes(String habilidad , double altura, String color) {
		this.habilidad = habilidad;
		this.altura = altura;
		this.color = color;
	}

	@Override
	public String describirCriatura() {
		String result = "";
		
		result += "DESCRIPCIÓN Elfo - "+this.nombre+"\n";
		result += " Habilidad: "+this.habilidad+"\n" ;
		result += " Altura: "+this.altura+" cm \n";
		result += " Color: "+this.color+"\n";
		
		
		return result;
	}

}
