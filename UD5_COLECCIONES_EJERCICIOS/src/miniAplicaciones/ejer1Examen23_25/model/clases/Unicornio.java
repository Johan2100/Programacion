package miniAplicaciones.ejer1Examen23_25.model.clases;


public class Unicornio extends CriaturaMistica {

	private String cuerno, color;
	private double altura;
	public Unicornio(String nombre, int edad) {
		super(nombre, edad);
		
	}
	
	

	public String getCuerno() {
		return cuerno;
	}



	public void setCuerno(String cuerno) {
		this.cuerno = cuerno;
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



	//METOHDS 
	@Override
	public void activarPoder() {
		System.out.println(this.nombre+" CUERNO RELAMPAGO" );
	}
		
	

	@Override
	public void agregarDes(String cuerno, double altura, String color) {
		this.cuerno = cuerno;
		this.altura = altura;
		this.color = color;
		
	}


	@Override
	public String describirCriatura() {
		String result = "";
		
		result += "DESCRIPCIÓN Unicornio - "+this.nombre+"\n";
		result += " Tamaño Cuerno: "+this.cuerno+" cm \n" ;
		result += " Altura: "+this.altura+" cm \n";
		result += " Color: "+this.color+"\n";
		
		return result;
	}

}
