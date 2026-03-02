package examencorregidoFebrero.ejer1.model.clases;

import examencorregidoFebrero.ejer1.model.interfaz.Presa;

public class Conejo extends Animal implements Presa {

	
	//CONSTRUCTOR -- 
	public Conejo(String nombre) {
		super(nombre);
	}
	
	//METHODS --
	@Override
	public void comer(int cantidad) {
		this.energia = ((this.energia + cantidad/2) > 100)? 100: this.energia + cantidad/2;
	}

	@Override
	public void huir() {
		this.energia = 1;
	}

}
