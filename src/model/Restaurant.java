package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class Restaurant {

	//Relations
	private List<Client>clients;
	private List<Employee>workers;
	private List<Product> products;
	private List<Ingredient> ingredients;
	private List<ProductType> productTypes;
	
	//Constructor
	public Restaurant() {
		clients=new ArrayList<Client>();
		workers=new ArrayList<Employee>();
		products=new ArrayList<Product>();
		ingredients =new ArrayList<Ingredient>();
		productTypes =new ArrayList<ProductType>();
	}
	
	
	public List<ProductType> getProductTypes() {
		return productTypes;
	}


	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}


	//Methods	
	public Dialog<String> createDialog() {
		//Creating a dialog
		Dialog<String> dialog = new Dialog<String>();

		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		return dialog; 
	}
	
	
	public boolean logInUser(String username,String password) {
		boolean exit=false;
		boolean open=false;
		
		for (int i=0;i<workers.size() && !exit;i++) {
			if (workers.get(i) instanceof SystemUser) {
				SystemUser objUser = (SystemUser)workers.get(i);
				if (username.equalsIgnoreCase(objUser.getUserName()) && password.equals(objUser.getPassword())) {
					exit=true;
					open=true;					
				}
			}			
		}
		return open;
	}
	
	public boolean findUser(String id) {
		boolean exit=false;
		boolean found=false;
		for (int i=0;i<workers.size() && !exit;i++) {
			if (workers.get(i).getIdNumber().equalsIgnoreCase(id)) {
				found=true;
				exit=true;
			}
		}
		return found;		
	}	

	public void addUser(String nam, String surnam, String id, String username, String password) {
		boolean found = findUser(id);
		if (found!=true) {
			workers.add(new SystemUser(nam, surnam, id, username, password));
			Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Create user");
        	alert.setContentText("The user has been created");
        	alert.showAndWait(); 
		}else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este usuario ya existe");
    		dialog.setTitle("Error de Usuario existente");
    		dialog.show();
		}
		
	}
	
	public void deleteUser(String id) {
		boolean salir=false;
		for(int i=0;i<workers.size() && salir==false;i++) {
			if(workers.get(i).getIdNumber().equalsIgnoreCase(id)) {
				workers.remove(workers.get(i));
				salir=true;
			}
		}
		if(salir=false) {
    		Dialog<String> dialog=createDialog();
    		dialog.setTitle("Error al encontrar usuario");
    		dialog.setContentText("El usuario con el id "+id+" no ha sido encontrado");
    		dialog.show();
		}
	}
	
	
	public boolean findClient(String id) {
		boolean exit=false;
		boolean found=false;
		for (int i=0;i<clients.size() && !exit;i++) {
			if (clients.get(i).getIdNumber().equalsIgnoreCase(id)) {
				found=true;
				exit=true;
			}
		}
		return found;			
	}

	
	
	public void addClient(String nam, String surnam,String id,String direction,String phone, String obs) {
		boolean found = findClient(id);
		Client newClient =null;
		if (found!=true) {
			newClient =new Client(nam, surnam, id, direction, phone, obs);
			if (clients.isEmpty()) {
				clients.add(newClient);
				
			}else if (!clients.isEmpty()){
				
				newClient =new Client(nam, surnam, id, direction, phone, obs);				
				boolean exit=false;
							
				for (int i=0;i<clients.size();i++) {				
					
					for (int j=i;j>=0 && !exit;j--) {
						if (newClient.compareBySurnameAndName(clients.get(j))>0) {
							clients.add(j,newClient);							
							exit=true;							
							
						}else if (newClient.compareBySurnameAndName(clients.get(j))<0) {							
							
							for (int k=clients.size()-1;k>0 && !exit;k--) {
								if ((clients.get(k).compareBySurnameAndName(newClient))>0) {
									clients.add(k+1, newClient);
									exit=true;								
								}								
							}					
							
						}else if (newClient.compareBySurnameAndName(clients.get(clients.size()-1))==0) {
			 				if (newClient.compareBySurnameAndName(clients.get(j))<0) {
								clients.add(j+1,newClient);		
								exit=true;
							}else if (newClient.compareBySurnameAndName(clients.get(j))>0) {
								clients.add(j,newClient);	
								exit=true;
							}else if (newClient.compareBySurnameAndName(clients.get(j))==0) {
								clients.add(j,newClient);	
								exit=true;
							}
							
						} 
						
					}
					
				}				
			}
			String name="";
			for (int k=0;k<clients.size();k++) {
				name+=clients.get(k).getSurnames()+" "+clients.get(k).getNames()+"\n";				
			}
			System.out.println("Ordenamiento de clientes: "+ name);
			
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Create client");
        	alert.setContentText("The client has been created");
        	alert.showAndWait();  
		}else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este Cliente ya existe");
    		dialog.setTitle("Error de Cliente existente");
    		dialog.show();
		}
	}
	
	public void deleteClient(String id) {
		boolean salir=false;
		for(int i=0;i<clients.size() && !salir;i++) {
			if(clients.get(i).getIdNumber().equals(id)) {
				clients.remove(clients.get(i));
				salir=true;
			}
		}
		if(salir=false) {
    		Dialog<String> dialog=createDialog();
    		dialog.setTitle("Error al encontrar cliente");
    		dialog.setContentText("El cliente con el id "+id+" no ha sido encontrado");
    		dialog.show();
		}
	}
	
	public Product returnProduct(String name) {
		Product product=null;
		boolean exit=false;
		for (int i=0;i<products.size() && !exit;i++) {
			if (products.get(i).getName().equalsIgnoreCase(name)) {
				exit=true;
				product=products.get(i);				
			}
		}
		return product;			
	}
	
	public void addProduct(Product product) {
		if(product!=null) {
			Product objProduct= returnProduct(product.getName());
			if(objProduct==null) {
				products.add(product);
				Dialog<String> dialog=createDialog();
				dialog.setContentText("Producto añadido a la lista de productos del restaurante");
				dialog.setTitle("Producto añadido");
				dialog.show();
			}
			else {
				Dialog<String> dialog=createDialog();
				dialog.setContentText("El producto con el nombre "+product.getName()+" ya existe");
				dialog.setTitle("Error, Producto existente");
				dialog.show();
			}
		}
	}
	
	
	public void deleteProduct(String name) {
		Product objProduct =returnProduct(name);
		if (objProduct!=null) {
			products.remove(objProduct);
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("El producto ha sido eliminado");
    		dialog.setTitle("Producto Eliminado");
    		dialog.show();
		}
		else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este producto no existe");
    		dialog.setTitle("Producto No econtrado");
    		dialog.show();
		}
	
	}
	
	public boolean addIngredient(Ingredient ingredient) {
		boolean found=false;
		Ingredient ingredientExists=returnIngredient(ingredient.getName());
		if(ingredientExists==null) {
			if(ingredient!=null) {
				ingredients.add(ingredient);
				found=false;
	    		Dialog<String> dialog=createDialog();
	    		dialog.setContentText("Ingrediente añadido a la lista de ingredientes del restaurante");
	    		dialog.setTitle("Ingrediente añadido");
	    		dialog.show();
			}
		}
		else {
			found=true;
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este ingrediente ya existe");
    		dialog.setTitle("Error, ingrediente existente");
    		dialog.show();
		}
		return found;
	}
	
	public Ingredient returnIngredient(String name) {
		Ingredient ingredient=null;
		boolean exit=false;
		for (int i=0;i<ingredients.size() && !exit;i++) {
			if (ingredients.get(i).getName().equalsIgnoreCase(name)) {
				exit=true;
				ingredient=ingredients.get(i);				
			}
		}
		return ingredient;		
	} 
	
	
	public void deleteIngredient(String name) {
		Ingredient objIngredient =returnIngredient(name);
		if (objIngredient!=null) {
			ingredients.remove(objIngredient);
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("El ingrediente ha sido eliminado");
    		dialog.setTitle("Ingrediente Eliminado");
    		dialog.show();
		}
		else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este ingrediente no existe");
    		dialog.setTitle("Ingrediente No econtrado");
    		dialog.show();
		}
	
	}

	public boolean addProductType(ProductType obj) {
		//Verify if this type of product already exists
    	boolean objExists=false;
    	
    	for(int i=0;i<productTypes.size() && objExists==false;i++) {
    		if(productTypes.get(i).getName().equals(obj.getName())){
    			objExists=true;
    		}
    	}
    	if(objExists==false) {
    		if(obj!=null) {
    			productTypes.add(obj);
    			Dialog<String> dialog=createDialog();
    			dialog.setContentText("Tipo de producto añadido a la lista de tipos de productos del restaurante");
    			dialog.setTitle("Tipo de producto creado");
    			dialog.show();
    		}
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Este tipo de producto ya existe");
			dialog.setTitle("Error, Tipo de producto existente");
			dialog.show();
    	}
    	return objExists;		
	}
	
	public ProductType returnProductType(String name) {
		ProductType productType=null;
		boolean exit=false;
		for (int i=0;i<productTypes.size() && !exit;i++) {
			if (productTypes.get(i).getName().equalsIgnoreCase(name)) {
				exit=true;
				productType=productTypes.get(i);				
			}
		}
		return productType;		
	}
	public void deleteproductType(String name) {
		ProductType obj =returnProductType(name);
		if (obj!=null) {
			productTypes.remove(obj);
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("El tipo de producto ha sido eliminado");
    		dialog.setTitle("Tipo de producto Eliminado");
    		dialog.show();
		}
		else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este tipo de producto no existe");
    		dialog.setTitle("Tipo de Producto No econtrado");
    		dialog.show();
		}
	
	}
	
	public List<Ingredient> getIngredients(){
		return ingredients;
	}

	

}
