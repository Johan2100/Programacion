package model2;

public class EnvioRefrigerado extends Envio implements Asegurable {

	double temperaturaObjetivo;

	// CONSTRUCTOR -- 
	public EnvioRefrigerado() {
		super();
	}

	public EnvioRefrigerado(String origen, String destino, int peso, int codigo, double temperaturaObjetivo) {
		super(origen, destino, peso, codigo);
		this.temperaturaObjetivo = temperaturaObjetivo;
	}

	//GETTER AND SETTER --
	public double getTemperaturaObjetivo() {
		return temperaturaObjetivo;
	}

	public void setTemperaturaObjetivo(double temperaturaObjetivo) {
		this.temperaturaObjetivo = temperaturaObjetivo;
	}

	//ToString -- 

	@Override
	public String toString() {
		return "EnvioRefrigerado [temperaturaObjetivo=" + temperaturaObjetivo + ", origen=" + origen + ", destino="
				+ destino + ", peso=" + peso + ", codigo=" + codigo + "]";
	}
	

	//MÉTODOS -- 
	@Override
	public double calcularCoste() {
		double resultado;
		if (temperaturaObjetivo < 0) {
			resultado = (6 + peso * 2.5) + 4;
		} else
			resultado = 6 + peso * 2.5;

		return resultado;
	}

	@Override
	public double calcuralCosteSeguro() {

		return 1.5 + peso * 0.8;
	}

}
