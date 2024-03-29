package model;

import java.io.Serializable;

public class Client implements Serializable{

	private static final long serialVersionUID = 1;
	//Atributes
	private String names;
	private String surnames;
	private String idNumber;
	private String adress;
	private String phoneNumber;
	private String observations;
	private Condition condition;

	public Client(String nam, String surnam,String id,String direction,String phone, String obs) {
		names= nam;
		surnames=surnam;
		idNumber=id;
		adress=direction;
		phoneNumber=phone;
		observations=obs;
		setCondition(Condition.ACTIVE);
	}

//Getters y Setters
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}	
	
	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition=condition;
	}

	
	public int compareBySurnameAndName(Client client) {
		int number=2;
		if ((client.getSurnames().compareToIgnoreCase(surnames))>0) {
			number=1;			
		}else if (((client.getSurnames().compareToIgnoreCase(surnames)))<0) {
			number=-1;
		}else if (((client.getSurnames().compareToIgnoreCase(surnames)))==0) {

			number= client.getNames().compareToIgnoreCase(names);
		}		
		System.out.println("Vine al metodo "+"Number comparator: "+number);
		return number;
	}


}
