package model;

public abstract class Employee {

	//Atributes
	private String names;
	private String surnames;
	private String idNumber;
	
	//Constructor
	public Employee(String names,String surnames,String idNumber) {
		this.names=names;
		this.surnames=surnames;
		this.idNumber=idNumber;
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
	

}
