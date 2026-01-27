package repositorio;

import java.util.Arrays;

import model2.Envio;

public class RepositorioEnvios {

	public static Envio[] envios = new Envio[0];
	
	//CONSTRUCTOR -- 

	public RepositorioEnvios() {
		super();
	}

	

	public static Envio findEnvioByCodigo(int codigo) {
		for (Envio e : envios) {
			if (e.getCodigo() == codigo) {
				return e;
			}
		}
		return null;
	}
	
	//ToString -- 
	
	@Override
	public  String toString() {
		return "RepositorioEnvios [envios=" + Arrays.toString(envios) + "]";
	}
	
	public void mostrarListado() {
		
		for(Envio s : envios) {
			System.out.println(s);
		
		}
	}


	// MÉTODOS --- 
	
	// HACEMOS LAS FUNCIONES CRUD
		// CREAT, READ, UPDATE,DELETE
		
		//READ
		/**
		 * 
		 * @param codigo El codigo de envio
		 * @return El envio, null si no se encuentra
		 */
	
	// CREATE
	public static void insetEnvio(Envio e) {
		Envio[] aux = new Envio[envios.length + 1];
		for (int i = 0; i < envios.length; i++) {
			aux[i] = envios[i];
		}
		aux[aux.length - 1] = e;
		envios = aux;
	}

	
	
	// DELETE

	
	public static boolean deleteEnvio(int codigo) {
		Envio[] aux = new Envio[envios.length-1];

		boolean encontrado = false;
		for (int i = 0, j = 0; j < aux.length; i++) {
			if (envios[i].getCodigo() != codigo) {
				aux[j++] = envios[i];
			} else {
				encontrado = true;
			}
		}
		if (encontrado) {
			envios = aux;

		} else 
			if (envios[envios.length - 1].getCodigo() == codigo) {

			encontrado = true;
			envios = aux;
		}
		return encontrado;

	}
	
	//UPDATE
	public static boolean updateEnvio(Envio envio) {
		
		boolean found = false;
		
		for (int i = 0; i < envios.length && !found; i++) {
			if(envios[i].getCodigo() == envio.getCodigo()) { // YIMMY -> envios[i].equals(envio) 
				envios[i] = envio;
				found = true;
			}
			
		}
		
		return found;
	}
	
	
	
	//READ
	public static Envio[] findAll() {
		return envios;
	}
	

}
