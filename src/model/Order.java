package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String code;
	private State state;
	private String date;
	private String hour;
	private String observations;
	private Client client;
	private SystemUser user;
	
	private static List<Product>productsList;
	private List<Integer>productsQuantity;
	
	public Order(String code, State state, String date,String hour, String observations, Client client, SystemUser user, List<Product> productList, List<Integer> productQuantity) {
		this.code = code;
		this.state = state;
		this.date = date;
		this.hour=hour;
		this.observations = observations;
		this.client=client;
		this.user=user;
		productsQuantity=productQuantity;
		productsList=productList;
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

	public List<Product> getProductsList() {
		return productsList;
	}

	public static void setProductsList(List<Product> productsList) {
		Order.productsList = productsList;
	}
	
	
	



}
