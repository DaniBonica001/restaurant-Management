package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	//Relations
	private List<Client>clients;
	private List<Employee>workers;
	
	//Constructor
	public Restaurant() {
		clients=new ArrayList<Client>();
		workers=new ArrayList<Employee>();
	}

}
