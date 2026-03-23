package JUNIT.calculadora;

public class Calculadora {
	private int num1, num2;

	public Calculadora(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	//METHODS -- 
	public int suma() {
		return num1+num2;
	}
	public int resta() {
		return num1-num2;
	}
	public int multiplicar() {
		return num1*num2;
	}
	
	public int dividir() {
		if(num2 == 0) {
			throw new ArithmeticException("Error: Intento de división por cero.");
		}
		
		return num1/num2;
	}
	

}
