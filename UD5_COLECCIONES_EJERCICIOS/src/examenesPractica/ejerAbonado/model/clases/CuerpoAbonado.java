package examenesPractica.ejerAbonado.model.clases;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class CuerpoAbonado {
	protected String nif;
	protected String nombre;
	protected Set<Actividad> actividades = new HashSet<>();
	
	public CuerpoAbonado(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public void diasActividades(char d) {
		
		Iterator<Actividad> it = actividades.iterator();
		
		while(it.hasNext()) {
			Actividad a = it.next();
			for (char c : a.getDias()) {
				if(c == d)
					System.out.println(nombre);
			}
		}
		
		
	}
	

	
	
	
	
	

}
