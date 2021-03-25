package model;

import java.io.Serializable;

public class Ingredient implements Serializable, Comparable<Ingredient>{
	
	//Constants
	public final static long serialVersionUID = 1;
	
	//Atributes 
	private String name;
	private Condition condition;
	private SystemUser createdByUser;
	private SystemUser editedByUser;

	public Ingredient(String name) {		
		this.name = name;
		setCondition(Condition.ACTIVE);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public int compareTo(Ingredient o) {
		return this.name.compareTo(o.name);
	}
	
	
	public int compareByName(Ingredient ingredient) {
		int number=0;
		if ((ingredient.getName().compareToIgnoreCase(name))>0){
			number=1;
		}else if ((ingredient.getName().compareToIgnoreCase(name))<0) {
			number=-1;
		}else if ((ingredient.getName().compareToIgnoreCase(name))==0) {
			number=0;
		}
		return number;
		
	}
	
	
	
	


}
