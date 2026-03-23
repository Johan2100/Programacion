package JUNIT.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class calculadoraTest {

	private Calculadora calculadora;
	
	@BeforeEach
	void setUp() {
        calculadora = new Calculadora(40, 10);
        
    }
	
	@AfterEach 
	void tearDown() {
		calculadora = null;
	}
	
	@Test
	 void testSuma() {
		
		//CASO 1 - SUMA POSITIVOS
		assertEquals(50, calculadora.suma());
		
		//CASO 2 - SUMA NEGATIVOS
		Calculadora c2 = new Calculadora(-10, -30);
		assertNotEquals(40,c2.suma());
		
		//CASO 3 - SUMA POSITIVO / NEGATIVO
		Calculadora c3 = new Calculadora(50,-32);
		assertEquals(18, c3.suma());
	}

	@Test
	 void testResta() {
		
		//CASO 1 - RESULTADO POSITIVO
		assertEquals(30, calculadora.resta());
		
		//CASO 2 - RESULTADO 0 
		Calculadora c2 = new Calculadora(38, 38);
		assertEquals(0,c2.resta());
		
		//CASO 3 - RESULTADO NEGATIVO 
		Calculadora c3 = new Calculadora(-30,-15);
		assertNotEquals(15,c3.resta());
		
	}

	@Test
	 void testMultiplicar() {
		
		//CASO 1 - DOS POSITIVOS
		assertEquals(400, calculadora.multiplicar());
		
		//CASO 2 - POR CERO
		Calculadora c2 = new Calculadora(40,0);
		assertEquals(0,c2.multiplicar());
		
		//CASO 3 - NUMERO NEGATIVO
		Calculadora c3 = new Calculadora(-12,30);
		assertEquals(-360, c3.multiplicar());
		
	}

	@Test
	 void testDividir() {
		//CASO 1 - DOS ENTEROS 
		assertEquals(4, calculadora.dividir());
		
		//CASO 2 - 1 O NUMERO SENCILLO 
		Calculadora c2 = new Calculadora(7,7);
		assertNotEquals(7,c2.dividir());
		
		//CASO 3 - DIVISIÓN ENTRE 0 
		Calculadora c3 = new Calculadora(20,0);
		assertThrows(ArithmeticException.class,
				() -> c3.dividir());
	}
	
	@Test
	void testCalculadora() {
		Calculadora calc = new Calculadora(10,40);
		assertEquals(50, calc.suma());
		assertNotEquals(30, calc.resta());
		assertTrue(calc.multiplicar() > 399);
		assertEquals(1/4,calc.dividir());
	}
	
	

}
