package prueba;

public class DelegadoList {
	
	private String[] datos = new String[0];
	
	//ADD NAME
	public void add(String dato) {
		
		String[] aux = new String[datos.length+1];
		for (int i = 0; i < datos.length; i++) {
			aux[i] = datos[i];
		}
		
		aux[aux.length-1] = dato;
		datos = aux;
		
	}
	
	//DELETE NAME
	
	public void delete(int pos) {
		
		
	}
	
	//GET NAME
	
	public String get(int pos) {
		
		if(pos > datos.length-1 || pos < 0 )
			return null;
		else
			return datos[pos];
	}
	
	//GET SIZE
	public int size() {
		return datos.length;
	}
	
	
}
