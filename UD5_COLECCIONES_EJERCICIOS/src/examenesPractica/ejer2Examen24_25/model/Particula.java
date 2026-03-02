package examenesPractica.ejer2Examen24_25.model;

public class Particula {
	
	private int carga;
    private double masa;
    private Punto posicion;
    
    public Particula(int carga, double masa, Punto posicion) {
        this.carga = carga;
        this.masa = masa;
        this.posicion = posicion;
    }


    public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public Punto getPosicion() {
		return posicion;
	}

	public void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

	
    @Override
    public String toString() {
        return "Carga: " + carga + ", Masa: " + masa + ", Posición: " + posicion;
    }
}
