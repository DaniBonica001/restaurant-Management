package model;

import java.io.Serializable;

public class SystemUser extends Employee implements Serializable{
	//Constants
	public final static long serialVersionUID = 1;
	//Atributes
	private String userName;
	private String password;
	private Condition condition;
	
	//Constructor
	public SystemUser(String names,String surnames,String idNumber,String userName,String password) {
		super(names,surnames,idNumber);		
		this.userName=userName;
		this.password=password;
		setCondition(Condition.ACTIVE);
	}

	//Setters and getters	
	public void setUsername(String userName) {
		this.userName=userName;
	}	
	public String getUserName() {
		return userName;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	public String getName() {
		return super.getNames();
	}
	
	public String getSurnames() {
		return super.getSurNames();
	}
	
	public String getIdNumber() {
		return super.getIdNumber();
	}
	


}
