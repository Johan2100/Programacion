package linkedList.Main;

import linkedList.linkedlist.MyLinkedList;

public class Main1 {
	
	public static void main(String[] args) {
		
	MyLinkedList<String> cadenas = new MyLinkedList<>();
	
	cadenas.addFirst("Hola");
	cadenas.addFirst("Patimicola");
	cadenas.addFirst("MIMI");
	
	cadenas.addLast("Ultimo");
	cadenas.addLast("Leche");
	
	for (int i = 0; i < cadenas.size(); i++) {
		System.out.println(cadenas.getByPosition(i));
	}
	
	cadenas.removeByPosition(0);
	System.out.println("-----------------");
	for (int i = 0; i < cadenas.size(); i++) {
		System.out.println(cadenas.getByPosition(i));
	}
	
	
		
		
	}
}
