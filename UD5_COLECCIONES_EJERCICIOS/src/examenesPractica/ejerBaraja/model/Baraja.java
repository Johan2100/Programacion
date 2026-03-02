package examenesPractica.ejerBaraja.model;

import java.util.HashSet;
import java.util.Set;

public class Baraja {
	private Set<Carta> cartasB = new HashSet<>();

	
	public Baraja() {
		for (int i = 0,j=1; i < 40; i++) {
			
			
			if(i < 10) {
				cartasB.add(new Carta(j++,"Oros"));
				
			}else if(i < 20) {
				cartasB.add(new Carta(j++,"Bastos"));
				
			}else if( i < 30) {
				cartasB.add(new Carta(j++,"Espadas"));
				
				
			}else {
				cartasB.add(new Carta(j++,"Copas"));
				
			}
			
			if( j == 10)
				j = 1;
			
			
		}
	}

	
	@Override
	public String toString() {
		return "Baraja [cartasB=" + cartasB + "]\n";
	}


	public Set<Carta> getCartasB() {
		return cartasB;
	}

	public void setCartasB(Set<Carta> cartasB) {
		this.cartasB = cartasB;
	}
	
	

}
