package linkedList.linkedlist;

class Node<T> {

	 T data;
	 Node<T> next;
	
	public Node (T dato) {
		this.data = dato;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public Node getNext() {
		return next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	


	@Override
	public boolean equals(Object obj) {
		
		return ((Node)obj).getData().equals(data);
		
	}

	
	
	
}
