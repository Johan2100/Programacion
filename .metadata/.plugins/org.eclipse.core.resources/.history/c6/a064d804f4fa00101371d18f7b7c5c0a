package model2;

public class EnvioEstandar extends EnvioRastreable  {

	private int diasEstimados;
	

	public EnvioEstandar(String origen, String destino, int peso, int codigo, int diasEstimados) {
		super(origen, destino, peso, codigo);
		this.diasEstimados = diasEstimados;
	}

	

	public int getDiasEstimados() {
		return diasEstimados;
	}

	public void setDiasEstimados(int diasEstimados) {
		this.diasEstimados = diasEstimados;
	}
	
	

	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	@Override
	public double calcularCoste() {
		double resultado;
		if (diasEstimados <= 2) {
			resultado = 3 + 1.2 * peso + 2;
		} else {
			resultado = 3 + 1.2 * peso;
		}

		return resultado;
	}



	@Override
	public EstadoEnvio obtenerEstado() {
		
		return estado;
	}



	@Override
	public void actualizarEstado(EstadoEnvio nuevoEstado) {
		
		estado = nuevoEstado;
		
	}



	@Override
	public String toString() {
		return "EnvioEstandar [diasEstimados=" + diasEstimados + ", estado=" + estado + ", origen=" + origen
				+ ", destino=" + destino + ", peso=" + peso + ", codigo=" + codigo + "]";
	}
	
	

}
