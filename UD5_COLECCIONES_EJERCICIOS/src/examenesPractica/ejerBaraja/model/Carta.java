package examenesPractica.ejerBaraja.model;

import java.util.Objects;

public class Carta {
	
	private int numero;
	private String palo;
	
	public Carta(int numero, String palo) {
		this.numero = numero;
		this.palo = palo;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Carta [Numero-> " + numero + ", Palo-> " + palo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, palo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		return numero == other.numero && Objects.equals(palo, other.palo);
	}
	
	

}
