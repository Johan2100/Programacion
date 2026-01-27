package Explicacion.model.envios;

import Explicacion.Interfaz.*;
public class EnvioUrgente extends Envio implements Asegurable,Rasteables  {
	
	private double recargo;
	private EstadoEnvio estado = EstadoEnvio.CREADO; 

	//CONSTRUCTORES -- 
	
	public EnvioUrgente(int codPedido, double pesoPedido, String origen, String destino, double recargo) {
		super(codPedido, pesoPedido, origen, destino);
		this.recargo = recargo;
	}

	public EnvioUrgente() {
		
	}
	
	//GETTER AND SETTER -- 

	public double getRecargo() {
		return recargo;
	}

	public void setRecargo(double recargo) {
		this.recargo = recargo;
	}

	
	//MÉTODOS --
	
	public double calcularCoste() {
		return 5 + 2*pesoPedido + recargo;
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
	public double calcularCosteSeguro() {
		
		return 1.5+pesoPedido*0.8;
	}
	
	
	
	
	
	
	
	

}
