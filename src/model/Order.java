package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	//Constants
	private static final long serialVersionUID = 1;
	
	//Atribute
	private String code;
	private State state;
	private String date;
	private String hour;
	private String observations;
	private Client client;
	private SystemUser user;
	
	//Relations	
	private List<Product>productsList;
	private List<Integer>productsQuantity;
	
	//Fiels of table view
	private String employeeName;
	private String clientName;	
	@SuppressWarnings("unused")
	private String products;	
	
	private String stringQuantity;
	
	
	public Order(String code, State state, String date,String hour, String observations, Client client, SystemUser user, List<Product> productsList, List<Integer> productsQuantity) {
		System.out.println("el que pasa en en parámetro de order: "+productsQuantity.size());
		this.code = code;
		this.state = state;
		this.date = date;
		this.hour=hour;
		this.observations = observations;
		this.client=client;
		this.user=user;
		this.productsQuantity=productsQuantity;
		this.productsList=productsList;
		this.setStringQuantity(convertQuantityToString(productsQuantity));
			
		employeeName="";
		clientName="";
		products="";
		
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
	
	public String getProducts() {		
		String message="";
		for (int i=0;i<productsList.size();i++) {
			if (productsList.get(i)!=null) {
				if (productsList.get(i)==productsList.get(productsList.size()-1)) {
					message+=productsList.get(i).getName();
				}else {
					message+=productsList.get(i).getName()+"\n";
				}
			}
		}
		return message;
	}

	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getClientName() {
		clientName=client.getNames()+" "+client.getSurnames();
		return clientName;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public String getEmployeeName() {
		employeeName= user.getNames()+" "+user.getSurNames();
		return employeeName;
	}
	
	public SystemUser getUser() {
		return user;
	}

	public void setUser(SystemUser user) {
		this.user = user;
	}
	
	/*
	public String getStringQuantity() {
		String m="";
		m=Integer.toString(productsQuantity.get(0));
		String message="";
		//System.out.println("Tamaño cantidad de productos: "+productsQuantity.size());
		for (int i=0;i<productsQuantity.size();i++) {
			if (productsQuantity.get(i)!=null) {
				if (i==productsQuantity.size()-1) {
					message+=productsQuantity.get(i);
				}else {
					message+=productsQuantity.get(i)+"\n";
				}
			}			
		}				
		System.out.println("message getStringProductsQuantity with message "+message);
		
		return m;
	}
	*/
	
	public String convertQuantityToString(List<Integer> quantities) {		
		String message=quantities.get(0).toString()+"\n";
		
		for (int i=1;i<quantities.size();i++) {
			if(i!=quantities.size()-1) {
				message+=quantities.get(i).toString()+"\n";
			}
			else {
				message+=quantities.get(i).toString();
			}
		}		
		return message;
	}

	public List<Integer> getProductsQuantity() {
		return productsQuantity;
	}

	public void setProductsQuantity(List<Integer> productsQuantity) {
		this.productsQuantity = productsQuantity;
	}

	public String getStringQuantity() {
		return stringQuantity;
	}

	public void setStringQuantity(String stringQuantity) {
		this.stringQuantity = stringQuantity;
	}
	

	
	



}
