package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String code;
	private State state;
	private String date;
	private String observations;
	
	private static List<Product>productsList;
	
	public Order(String code, State state, String date, String observations, List<Product> productsList) {
		this.code = code;
		this.state = state;
		this.date = date;
		this.observations = observations;
		productsList= new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public static List<Product> getProductsList() {
		return productsList;
	}

	public static void setProductsList(List<Product> productsList) {
		Order.productsList = productsList;
	}
	



}
