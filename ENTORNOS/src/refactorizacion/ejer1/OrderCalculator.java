package refactorizacion.ejer1;

public class OrderCalculator {
	
	public static void main(String[] args) {
        double price = 200.0;
        int quantity = 3;
        boolean isMember = true;

        double baseAmount = price * quantity;
        double descuento = calculaDescuento(baseAmount, isMember);
        double costeEnvio = calculaEnvio(baseAmount);

        double total = baseAmount - descuento + costeEnvio;

        System.out.println("Total a pagar: " + total);
    }

    private static double calculaDescuento(double cantidad, boolean isMember) {
        if (cantidad <= 100) {
            return 0;
        }
  
        double porcentaje = isMember ? 0.15 : 0.10;
        return cantidad * porcentaje;
    }

    private static double calculaEnvio(double cantidad) {
        if (cantidad < 50) {
            return 10;
        } else if (cantidad < 100) {
            return 5;
        }
        return 0;
    }
}

