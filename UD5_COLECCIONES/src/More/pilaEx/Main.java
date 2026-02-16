package More.pilaEx;


import java.util.Scanner;

import More.pilaEx.pilaClass.MiStack;

public class Main {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	MiStack<String> pila = new MiStack<String>();
	
	for (int i = 0; i < 10; i++) {
		System.out.println("Introduzca cadena:");
		String word = sc.nextLine();
		pila.push(word);
	}
	System.out.println("LLENO");
	System.out.println(pila);
	while(!pila.isEmpty())
		pila.pop();
	
	System.out.println("VACIO");
	System.out.println(pila);
	
	
	
	
	
	sc.close();	
	}
	
	
	

}
