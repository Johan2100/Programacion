package JUNIT.calculadora;

public class MainCalculadora {
	public static void main(String[] args) {
		
		Calculadora c = new Calculadora(20,10);
		System.out.println(c.suma());
		System.out.println(c.resta());
		System.out.println(c.multiplicar());
		System.out.println(c.dividir());
	
	}
	
	

}
