package examencorregidoFebrero.ejer1.model.clases;

import examencorregidoFebrero.ejer1.model.interfaz.Depredador;
import examencorregidoFebrero.ejer1.model.interfaz.Presa;

public class Leon extends Animal implements Depredador {

	public Leon(String nombre) {
		super(nombre);
	}

	@Override
	public boolean cazar(Animal presa) {
		
		if(presa instanceof Presa && this.energia >= presa.energia) {
			this.comer(presa.energia);
			return true;
		}else {
			this.energia = (this.energia /= this.energia/2)<1? 1 : (this.energia /= this.energia/2);
			
			if( presa instanceof Presa)
				((Presa)presa).huir();
			return false;
		}
		
	}

	@Override
	public void comer(int cantidad) {
		this.energia = ((this.energia + cantidad) > 100)? 100: this.energia + cantidad;
	}

}
