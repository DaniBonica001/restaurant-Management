package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product implements Serializable{
	
	//Constants
	public final static long serialVersionUID = 1;
	
	//Atributes
	private String name;
	private String size;
	private String price;
	private Condition condition;	
	@SuppressWarnings("unused")
	private String ingredientsLista;
	
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
		ingredientsLista="";
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
	

	public List<Ingredient> getIngredientsList(){
		return ingredients;
	}
	

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public String getIngredients(List<Ingredient> ingredients) {
		String message=Arrays.toString(ingredients.toArray());
		return message;
	}


	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void setIngredientsLista(String ing) {
		ingredientsLista=ing;
	}
	
	public String getIngredientsLista() {
		String message="";
		for (int i=0;i<ingredients.size();i++) {
			if (ingredients.get(i)==ingredients.get(ingredients.size()-1)) {
				message+=ingredients.get(i).getName();
			}else {
				message+=ingredients.get(i).getName()+", ";
			}			
		}
		return message;
	}
	

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