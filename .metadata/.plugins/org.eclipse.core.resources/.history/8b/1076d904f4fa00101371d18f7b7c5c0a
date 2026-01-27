package model2;

public abstract class Envio {

	protected String origen, destino;
	protected int peso, codigo;

	public Envio(String origen, String destino, int peso, int codigo) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.peso = peso;
		this.codigo = codigo;
	}

	public Envio() {
		super();
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Envio [origen=" + origen + ", destino=" + destino + ", peso=" + peso + ", codigo=" + codigo + "]";
	}

	public abstract double calcularCoste();

}
