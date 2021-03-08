package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	//Atributes
	private String name;
	private String size;
	private String price;
	private Condition condition;
	
	//Relations
	private ProductType type;
	private List<Ingredient> ingredients;
	
	//Constructor
	public Product(String name,String size,String price,String type, List<String> ingredientsList ) {
		this.name=name;
		this.size=size;
		this.price=price;
		this.type= new ProductType(type);
		ingredients=convertListStringToIngredient(ingredientsList);
		setCondition(Condition.ACTIVE);
	}
	
	//Setters and getters
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
	public void setSize(String size) {
		this.size=size;
	}
	public String getSize() {
		return size;
	}
	
	public void setPrice(String price) {
		this.price=price;
	}
	public String getPrice() {
		return price;
	}
	
	public void setType(ProductType type) {
		this.type=type;
	}
	public ProductType getType() {
		return type;
	}	
	
<<<<<<< HEAD
	public List<Ingredient> getIngredientsList(){
		return ingredients;
	}
	
=======
	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

>>>>>>> 96e39494490c13b7bb627142345275db148d3fcf
	//Method to receive a list of Strings of the ingredients chose by the user and convert each String element to Ingredient object
	public List<Ingredient> convertListStringToIngredient(List<String> ingredientsList ){
		List<Ingredient> ingredients= new ArrayList<Ingredient>();
		for(int i=0;i<ingredientsList.size();i++) {
			ingredients.add(new Ingredient(ingredientsList.get(i)));
		}
		return ingredients;	
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	


	
	
	

}

