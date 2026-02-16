package entendimiento;

public class DelegadoListSinMas<T> {
	
	//Esta clase se ha convertido en una clase generica, por tanto hay que poner al lado del
	//nombre de la clase <"ParamentName">
	
	//Estos parametros no podemos instanciarlos como variables primitivos -> Double, Int, Char, Etc.... 
	//Para los primitivos tenemos que usar sus nombres completos o el nombre envolvente 
	//En este caso de int -> Intenger, double -> Double ...
	
	private T[] datos = (T[]) new Object[0];
	//ADD NAME
		public void add(T dato) {
			
			T[] aux = (T[]) new Object[datos.length+1];
			for (int i = 0; i < datos.length; i++) {
				aux[i] = datos[i];
			}
			
			aux[aux.length-1] = dato;
			datos = aux;
			
		}
		
		public int size() {
			return datos.length;
		}
		
		public T get(int pos) {
			
			if(pos > datos.length-1 || pos < 0 )
				return null;
			else
				return datos[pos];
		}
		

}
