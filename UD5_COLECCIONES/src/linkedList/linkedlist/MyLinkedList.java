package linkedList.linkedlist;


public class MyLinkedList<T> {
	
	private Node<T> start;
	private int length;
	
	//CONSTRUCTOR -- 
		public MyLinkedList(Node<T> start) {
			this.start = start;
			length = 1;
		}
		
		
	public MyLinkedList() {
		length = 0;
	}


	//GETTER AND SETTER -- 
	
	public int getLength() {
		return length;
	}

	public Node<T> getStart() {
		return start;
	}

	public void setStart(Node<T> start) {
		this.start = start;
	}
	
	//METHODS
	
	public T getByPosition(int pos) {
		Node<T> aux = start;
		for (int i = 0; i < pos; i++) {
			aux = aux.next;
		}
		
		return aux.data;
		
	}
	
	public int size() {

		Node<T> aux = start;
		int cont = 0;
		while ( aux != null) {
			aux = aux.next;
			cont++;
		}
		
		return cont;
	}
	
	public void addFirst(T dato) {
		Node<T> nodo = new Node<T>(dato);
		nodo.next = start;
		start = nodo;
		
	}
	
	public void addLast(T data) {
		Node<T> newData = new Node(data);
		Node<T> aux = start;
		
		while(aux.next != null) {
		aux = aux.next;
		}
		aux.next = newData;
		
	}
	
	
	public void removeByPosition(int pos) {
		Node<T> aux = start;
		for (int i = 0; i < pos-1; i++) {
			aux = aux.next;
		}
		aux.next = aux.next.next;
	}
	
	
	
	
	
}
	
	
