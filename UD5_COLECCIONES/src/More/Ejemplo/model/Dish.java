package More.Ejemplo.model;

import java.util.LinkedList;
import java.util.List;

public class Dish {
	
	private String name;
	private Double price;
	private List<String> ingredients = new LinkedList<>();
	

	//CONSTRUCTOR -- 
	public Dish(String name, Double price) {
		this.name = name;
		this.price = price;
	}


	//GETTER AND SETTER -- 
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public List<String> getIngredients() {
		return ingredients;
	}


	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	//METHODS -- 
	
	public void addIngredient(String ingredient) {
		ingredients.add(ingredient);  //Add a secas es un addLast
	}
	
	
	
	
	/**
	 * Este método borra el primer ingrediente de la lista de ingredientes que sea
	 * igual al parámetro. 
	 * 
	 * @param ingredient
	 * @return true si se borró, false si no se encontró niguno igual
	 */
	public boolean removeIngredient(String ingredient) {
		return ingredients.remove(ingredient); 
	}
	
	
	
	
	/**
	 * Este método borra el todos los ingrediente de la lista de ingredientes que sea
	 * igual al parámetro. 
	 * 
	 * @param ingredient
	 * @return true si se borró alguno, false si no se encontró niguno igual
	 */
	public boolean removeEqualsIngredient(String ingredient) {
		
		
//		int pos;
//		boolean esta = false;
//		while((pos = ingredients.indexOf(ingredient)) != -1) {
//			ingredients.remove(pos);
//			esta = true;
//			
//		}
//		ingredients.indexOf(ingredient); || Te devuelve la primera posición del ingrediente de la lista. 
//		ingredients.remove(ingredients.indexOf(ingredient)); || Sería practico, pero si se hay mas de un mismo ingrediente se trendra que hacer el while.
		
		boolean inside = false;
		while(ingredients.remove(ingredient)) {
			inside = true;
		}
		return inside;
	}
	
	
	public String listIngredients() {
		
		String result = "";
		for (int i = 0; i < ingredients.size(); i++) {
			result += ingredients.get(i) +", \n"; // \n es un  salto de linea
		}
		
		
		//for-each en colecciones 
		
//		for(String i : ingredients) {
//			result += i;
//		}
		
		return result;
	}
	
	public boolean containsIngredient (String ingredient) {
		
		
		
		boolean found = false;
		
		for (int i = 0; i < ingredients.size() && !found; i++) {
			if(ingredients.get(i).equals(ingredient))
				found = true;
		}
		/*
		 for (String i : ingredients){
		 	if(i.equals(ingredient)
		 		found = true;
		 }
		  
		*/
		
		return found; // o incluso return ingredients.contains(ingredient);
	}
	
	public boolean containsLargeIngredient(int numLetters) {
		boolean found = false;
		for(String i : ingredients) {
			if( i.length() > numLetters) {
				found = true;
			}
		}
		return found;
	}
	

	
	

	
}
