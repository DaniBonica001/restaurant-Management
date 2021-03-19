package model;

import java.io.Serializable;

public class ProductType implements Serializable{
	
	private static final long serialVersionUID = 1;
	//Atributes
	private String name;
	private Condition condition;
	private SystemUser createdByUser;
	private SystemUser editedByUser;
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

	public SystemUser getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(SystemUser createdByUser) {
		this.createdByUser = createdByUser;
	}

	public SystemUser getEditedByUser() {
		return editedByUser;
	}

	public void setEditedByUser(SystemUser editedByUser) {
		this.editedByUser = editedByUser;
	}

}
