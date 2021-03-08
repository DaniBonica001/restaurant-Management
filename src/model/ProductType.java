package model;

public class ProductType {
	
	//Atributes
	private String name;
	private Condition condition;
	
	//Constructor
	public ProductType(String name) {
		this.name=name;
		setCondition(Condition.ACTIVE);
	}
	
	//Setter and getter
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
