package Ejercicio3;



public class depuracion3 {
	
	public static void main(String[] args) {
		int x;
		int contador = 0;
			String[] prestados = new String[10];
			String[] disponibles = new String[] {"El vicio de poder",
					"Juego de tronos", 
					"El secreto de sus ojos", 
					"Breaking Bad", 
					"El señor de los anillos", 
					"Amelie", 
					"Gladiator", 
					"300", 
					"La lengua de las mariposas", 
					"Matrix"
			};
			
			for (int i = 0; i < 10; i++) {
				x = (int) (Math.random() * 10);

				if (disponibles[x].equals("- ")) {
					System.out.println("Falta el dvd del estante " + x);
				} else {
					String z = disponibles[x];
					prestados[contador] = z;
					contador++;
					disponibles[x] = "- ";
					System.out.println("Se ha prestado el dvd de " + z);
				}
			}
	
			
			
	}

}
