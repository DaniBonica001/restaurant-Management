package model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	//Atributes
	private String name;
	private String size;
	private String price;
	
	//Relations
	private ProductType type;
	private List<Ingredient> ingredients;
	
	//Constructor
	public Product(String name,String size,String price,String type) {
		this.name=name;
		this.size=size;
		this.price=price;
		this.type= new ProductType(type);
		ingredients= new ArrayList<Ingredient>();
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
	


	
	
	

}

