package examenesPractica.ejer1Examen24_25.model;

public class MagoFuego extends MagoElemental{

	private double superficie;
	
	public MagoFuego(String nombre,double superficie) {
		super(nombre);
		this.elemento = "Fuego";
		this.superficie = superficie;
		
	}
	
	

	public double getSuperficie() {
		return superficie;
	}



	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}



	@Override
	public String lanzarHechizo() {
		return this.nombre +" ha lanzado un hechizo de fuego: " + this.superficie+ "km^2";
	}

}
