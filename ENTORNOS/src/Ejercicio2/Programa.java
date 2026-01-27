package Ejercicio2;

public class Programa {

	public static void main(String[] args) {
		int x= 50, y= 100;
		String pais = "Francia";
		
		for(int i = 0; i < 100;i++) {
			x++;
		System.out.println("Estoy dentro del for "+x);
		}
		
		int bucle = 0;
		 while (bucle < 50){
			 	x--;
				System.out.println("Estoy dentro del while "+x);
				bucle++;
			}
		 
		 System.out.println("El pais actual es "+pais);
		 
		
		 
		 if ( x == y )
			 pais = "Italia";
		 
		 else if (x < y)
			 pais = "Grecia";
		
		 else 
			 pais = "Alemania";
		
		 System.out.println("El nuevo pais es "+pais);

	}

}
