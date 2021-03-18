package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Employee implements Serializable{

	private static final long serialVersionUID = 1;
	//Atributes
	private String names;
	private String surnames;
	private String idNumber;
	
	//relations
	private List<Order> orders;
	
	//Constructor #1
	public Employee(String names,String surnames,String idNumber) {
		this.names=names;
		this.surnames=surnames;
		this.idNumber=idNumber;
		orders=new ArrayList<>();
	}
	
	//Setters and getters
	public void setNames(String names) {
		this.names=names;
	}	
	public String getNames() {
		return names;
	}
	
	public void setSurNames(String surnames) {
		this.surnames=surnames;
	}	
	public  String getSurNames() {
		return surnames;
	}
	
	public void setIdNumber(String id) {
		idNumber=id;
	}
	public String getIdNumber() {
		return idNumber;
	}


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	

}
