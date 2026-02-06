package More.Ejemplo.model;


import java.util.LinkedList;
import java.util.List;

public class Restaurant {
	
	private String name;
	private List<Dish> menu = new LinkedList<>();
	
	// CONSTRUCTOR --- 
	public Restaurant(String name) {
		this.name = name;

	}

	//GETTER AND SETTER --
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Dish> getMenu() {
		return menu;
	}

	public void setMenu(List<Dish> menu) {
		this.menu = menu;
	}
	
	
	//METHODS -- 
	
	public void addDish(Dish dish) {
		menu.add(dish);
		
	}
	
	public String viewCart() {
		String result = "";
		for (int i = 0; i < menu.size(); i++) {
			result += menu.get(i);
		}
		return null;
	}
	
	public String ingredientsDish() {
		return null;
	}
	
	public List<String> getIngredientsDish (String name){
		return null;
	}
	
	public String recommendedDish() {
		return null;
	}
	
	
	
	
	

}
