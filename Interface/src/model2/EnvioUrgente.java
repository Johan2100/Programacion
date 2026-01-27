package model2;

public class EnvioUrgente extends EnvioRastreable implements Asegurable {

	private double recargo;

	public double getRecargo() {
		return recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	public EnvioUrgente(String origen, String destino, int peso, int codigo, double recargo) {
		super(origen, destino, peso, codigo);
		this.recargo = recargo;
	}

	@Override
	public double calcularCoste() {

		return 5 + 2 * peso + recargo;
	}

	@Override
	public EstadoEnvio obtenerEstado() {

		return estado;
	}

	@Override
	public void actualizarEstado(EstadoEnvio nuevoEstado) {
		this.estado = nuevoEstado;
	}

	@Override
	public double calcuralCosteSeguro() {

		return 1.5 + peso * 0.8;
	}

	@Override
	public String toString() {
		return "EnvioUrgente [recargo=" + recargo + ", estado=" + estado + ", origen=" + origen + ", destino=" + destino
				+ ", peso=" + peso + ", codigo=" + codigo + "]";
	}
	
	

}
