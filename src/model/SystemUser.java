package model;

public class SystemUser extends Employee{

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


}
