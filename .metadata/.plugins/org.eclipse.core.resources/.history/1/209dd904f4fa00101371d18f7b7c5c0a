package model2;

public abstract class EnvioRastreable extends Envio {

	protected EstadoEnvio estado = EstadoEnvio.CREADO;

	public EnvioRastreable(String origen, String destino, int peso, int codigo) {
		super(origen, destino, peso, codigo);
	}

	public EnvioRastreable() {
		super();
	}

	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	public abstract EstadoEnvio obtenerEstado();

	public abstract void actualizarEstado(EstadoEnvio estado);

}
