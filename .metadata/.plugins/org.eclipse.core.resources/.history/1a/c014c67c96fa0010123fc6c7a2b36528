package Explicacion.model.envios;

import Explicacion.Interfaz.*;
public class EnvioFresco extends Envio implements Asegurable {
	
	private double temperatura;

	//CONSTRUCTORES -- 
	public EnvioFresco(int codPedido, double pesoPedido, String origen, String destino, double temperatura) {
		super(codPedido, pesoPedido, origen, destino);
		this.temperatura = temperatura;
	}
	
	public EnvioFresco() {
		
	}

	
	//GETTER AND SETTER -- 
	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	//MÉTODOS -- 
	public double calcularCoste() {
		
		return (temperatura<0)?6.0+pesoPedido*2.5+4 : 6.0+pesoPedido*2.5;
	}

	@Override
	public double calcularCosteSeguro() {
		
		return 1.5+pesoPedido*0.8;
	}
	
	
	
	
	

}
