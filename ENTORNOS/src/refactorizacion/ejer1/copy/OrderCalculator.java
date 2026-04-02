package refactorizacion.ejer1.copy;

public class OrderCalculator {
	
	public static void main(String[] args) {

		double price = 200.0;
		int quantity = 3;
		boolean isMember = true;
		double d = 0;
		double sc = 0;

		if (price * quantity > 100) {
			if (isMember == true) {
				d = price * quantity * 0.15;
			} else {
				d = price * quantity * 0.10;
			}
		} else {
			d = 0;
		}

		if (price * quantity < 50) {
			sc = 10;
		} else if (price * quantity < 100) {
			sc = 5;
		} else {
			sc = 0;
		}

		double total = (price * quantity) - d + sc;
		System.out.println("Total a pagar: " + total);
    }
}

