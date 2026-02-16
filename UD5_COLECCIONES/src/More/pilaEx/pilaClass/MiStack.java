package More.pilaEx.pilaClass;

import java.util.ArrayList;
import java.util.List;



public class MiStack <T> {
	List<T> content = new ArrayList<>();
	
	//METOHDS
	public boolean isEmpty() {
		return content.isEmpty();
	}
	
	public int size() {
		return content.size();
	}
	
	public void push ( T data) {
		content.addFirst(data);	
	}
	
	public void pop() {
		System.out.println(content.get(0));
		content.removeFirst();
	}

	
	
	
	//ToString 
	@Override
	public String toString() {
		return "MiStack [content=" + content + "]";
	}

}
