package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;

public class Restaurant {
	
	//Constants
	public final static String SAVE_PATH_FILE_CLIENTS="data/ClientsData.ap2";
	public final static String SAVE_PATH_FILE_PRODUCTS="data/ProductsData.ap2";
	public final static String SAVE_PATH_FILE_INGREDIENTS="data/IngredientsData.ap2";
	public final static String SAVE_PATH_FILE_PRODUCTTYPE="data/ProductType.ap2";
	public final static String SAVE_PATH_FILE_USERS="data/users.ap2";

	//Relations
	private List<Client>clients;
	private List<Employee>workers;
	private List<Product> products;
	private List<Ingredient> ingredients;
	private List<ProductType> productTypes;
	private List<String> sizes;
	
	//Constructor
	public Restaurant() {
		clients=new ArrayList<Client>();
		workers=new ArrayList<Employee>();
		products=new ArrayList<Product>();
		ingredients =new ArrayList<Ingredient>();
		productTypes =new ArrayList<ProductType>();
		setSizes(new ArrayList<>());
		sizes.add("Personal");
		sizes.add("Para dos");
	}
	
	public List<Employee> getWorkers(){
		return workers;
	}
	public List<Client> getClients(){
		return clients;
	}
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}	
	
	public List<String> getStringIngredients(){
		List<String>stringIngredients = new ArrayList<String>();
		for (int i=0;i<ingredients.size();i++) {
			stringIngredients.add(ingredients.get(i).getName());
		}
		return stringIngredients;
	}

	public List<Product> getProducts(){
		return products;
	}
	public List<ProductType> getProductTypes() {
		return productTypes;
	}
	
	public List<String> getStringProductTypes(){
		List<String> stringProductsTypes= new ArrayList<String>();
		for (int i=0;i<productTypes.size();i++){
			stringProductsTypes.add(productTypes.get(i).getName());
		}
		return stringProductsTypes;
	}
	
	public List<String> getStringProducts(){
		List<String> stringProducts = new ArrayList<String>();
		for (int i=0;i<products.size();i++) {
			stringProducts.add(products.get(i).getName());
		}
		return stringProducts;
	}
	
	public List<String> getStringProductsReferenceId(){
		List<String> stringProducts = new ArrayList<String>();
		for (int i=0;i<products.size();i++) {
			stringProducts.add(products.get(i).getReferenceId());
		}
		return stringProducts;
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
				if (username.equals(objUser.getUserName()) && password.equals(objUser.getPassword()) 
						&& objUser.getCondition().equals(Condition.ACTIVE)) {
					exit=true;
					open=true;					
				}
			}			
		}
		return open;
	}
	
	public boolean conditionUser(String username,String password) {
		boolean exit=false;
		boolean active=false;
		
		for (int i=0;i<workers.size() && !exit;i++) {
			if (workers.get(i) instanceof SystemUser) {
				SystemUser objUser = (SystemUser)workers.get(i);
				if (username.equals(objUser.getUserName()) && password.equals(objUser.getPassword()) 
						&& objUser.getCondition().equals(Condition.ACTIVE)) {
					exit=true;
					active=true;					
				}
			}			
		}
		return active;
	}
	
	public boolean findUser(String id) {	
		/*
		String message="";
		for (int k=0;k<workers.size();k++) {
			message+=workers.get(k).getNames()+", "+workers.get(k).getSurNames()+", "+workers.get(k).getIdNumber()+".";
		}
		System.out.println(message);
		System.out.println("Id que pasa por parámetro: "+id);
		*/
		boolean exit=false;
		boolean found=false;
		
		for (int i=0;i<workers.size() && !exit;i++) {
			if (workers.get(i) instanceof SystemUser) {
				SystemUser user = (SystemUser)workers.get(i);
				//System.out.println("user id number: "+user.getIdNumber());
				if (user.getIdNumber().equalsIgnoreCase(id)) {
					found=true;
					exit=true;
				}
			}
			
		}
		return found;		
	}	
	
	
	public SystemUser returnUser(String username) {
		SystemUser returnUser=null;		
		boolean exit=false;		
		for (int i=0;i<workers.size() && !exit;i++) {
			if (workers.get(i) instanceof SystemUser) {
				SystemUser user= (SystemUser)workers.get(i);
				System.out.println("Nombre del usario en el arreglo: "+user.getUserName());
				if (user.getUserName().equals(username)) {
					returnUser=user;
					exit=true;
				}
				
			}		
		}
		return returnUser;	
		
	}
	
	public void addUser(String nam, String surnam, String id, String username, String password) throws IOException{
		//System.out.println("Apellido usuario: "+surnam);
		boolean found = findUser(id);
		//System.out.println("found: "+found);
		if (found!=true) {
			workers.add(new SystemUser(nam, surnam, id, username, password));		
			saveUsersData();
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
	
	public void deleteUser(String id) throws IOException{
		boolean salir=false;
		for(int i=0;i<workers.size() && !salir;i++) {
			if(workers.get(i).getIdNumber().equalsIgnoreCase(id)) {
				workers.remove(workers.get(i));				
				salir=true;
			}
		}
		
		if(salir==false) {
    		Dialog<String> dialog=createDialog();
    		dialog.setTitle("Error al encontrar usuario");
    		dialog.setContentText("El usuario con el id "+id+" no ha sido encontrado");
    		dialog.show();
		}else if (salir==true) {
			saveUsersData();
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
	
	public Client returnClient(String name) {
		Client client=null;
		boolean exit=false;
		for (int i=0;i<clients.size() && !exit;i++) {
			if (clients.get(i).getNames().equals(name)) {
				exit=true;
				client=clients.get(i);				
			}
		}
		return client;			
	}
	
	public Client returnClientId(String id) {
		Client client=null;
		boolean exit=false;
		for (int i=0;i<clients.size() && !exit;i++) {
			if (clients.get(i).getIdNumber().equals(id)) {
				exit=true;
				client=clients.get(i);				
			}
		}
		return client;			
	}
	
	
	public Client clientBinarySearch(String name) {
		Client client=null;
			
		boolean exit=false;
		
		int start=0;
		int end=clients.size()-1;
		
		while (start<=end && !exit) {
			int middle=(start+end)/2;
			
			int compare=clients.get(middle).getNames().compareToIgnoreCase(name);
			System.out.println("Nombre del apellido de la mitad: "+clients.get(middle).getNames());
			if (compare==0) {
				exit=true;
				client=clients.get(middle);
			}else if (compare<0) {
				end=middle-1;
			}else if (compare>0) {
				start=middle+1;
			}
		}	
		return client;
	}
	
	
	public void addClient(String nam, String surnam,String id,String direction,String phone, String obs) throws IOException{
		boolean found = findClient(id);
		Client newClient =null;
		if (found!=true) {
			newClient =new Client(nam, surnam, id, direction, phone, obs);
			if (clients.isEmpty()) {
				clients.add(newClient);

			}else if (!clients.isEmpty()){

				newClient =new Client(nam, surnam, id, direction, phone, obs);				
				boolean exit=false;

				for (int i=clients.size()-1;i>=0;i--) {				

					for (int j=i;j>=0 && !exit;j--) {
						
						if (newClient.compareBySurnameAndName(clients.get(j))<0) {
							for (int k=0;k<clients.size() && !exit;k++) {
								if ((newClient.compareBySurnameAndName(clients.get(k)))<0){
									System.out.println ("apellido de nC: "+newClient.getSurnames());
									clients.add(k, newClient);
									exit=true;	
								}
							}														

						}else if (newClient.compareBySurnameAndName(clients.get(j))>0) {
							clients.add(j,newClient);							
							exit=true;



						}else if (newClient.compareBySurnameAndName(clients.get(j))==0) {
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

			saveClientsData();
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
	
	public void deleteClient(String id) throws IOException{
		boolean salir=false;
		for(int i=0;i<clients.size() && !salir;i++) {
			if(clients.get(i).getIdNumber().equals(id)) {
				clients.remove(clients.get(i));
				salir=true;
			}
		}
		if(salir==false) {
    		Dialog<String> dialog=createDialog();
    		dialog.setTitle("Error al encontrar cliente");
    		dialog.setContentText("El cliente con el id "+id+" no ha sido encontrado");
    		dialog.show();
		}else if (salir==true) {
			saveClientsData();			
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
	
	public List<Product> returnProducts(String name) {
		List<Product> searchedProducts= new ArrayList<>();

		for (int i=0;i<products.size();i++) {
			if (products.get(i).getName().equals(name)) {
				searchedProducts.add(products.get(i));
			}
		}
		return searchedProducts;			
	}
	
	public Product returnProduct(String name, String size) {
		Product product=null;
		boolean exit=false;
		for (int i=0;i<products.size() && !exit;i++) {
			if (products.get(i).getName().equalsIgnoreCase(name) && products.get(i).getSize().equals(size)) {
				exit=true;
				product=products.get(i);				
			}
		}
		return product;			
	}
	
	public void addProduct(Product product, String empleadoUsername) throws IOException {
		if(product!=null) {
			Product objProduct= returnProduct(product.getName(), product.getSize());
			if(objProduct==null) {
				products.add(product);
				saveProductsData();				
				Dialog<String> dialog=createDialog();
				dialog.setContentText("Producto añadido a la lista de productos del restaurante");
				dialog.setTitle("Producto añadido");
				dialog.show();
				product.setCreatedByUser(returnUser(empleadoUsername));
				product.setEditedByUser(returnUser(empleadoUsername));
			}
			else {
				Dialog<String> dialog=createDialog();
				dialog.setContentText("El producto con el nombre "+product.getName()+" y tamaño "+product.getSize()+" ya existe.");
				dialog.setTitle("Error al crear Producto, Producto existente");
				dialog.show();
			}
		}
	}
	
	
	public  boolean deleteProduct(String name) throws IOException{
		boolean delete=false;
		List<Product> searchedProducts= returnProducts(name);
		boolean referenced=false;
		
		for(int i=0;i<searchedProducts.size();i++) {
			if(productIsReferenced(searchedProducts.get(i))==true) {
				referenced=true;
			}
		}

		
		if (!searchedProducts.isEmpty()) {
			if(referenced==false) {
				delete=true;
				for(int i=0;i<searchedProducts.size();i++) {
					products.remove(searchedProducts.get(i));
				}
				saveProductsData();
				Dialog<String> dialog=createDialog();
				dialog.setContentText("El producto ha sido eliminado");
				dialog.setTitle("Producto Eliminado");
				dialog.show();
			}
			else {
				Dialog<String> dialog=createDialog();
				dialog.setContentText("El producto está siendo referenciado por un pedido que aún no ha sido entregado");
				dialog.setTitle("Error, producto en un pedido activo");
				dialog.show();
			}
		}
		else {
		delete=false;
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este producto no existe");
    		dialog.setTitle("Producto No econtrado");
    		dialog.show();
		}
	return delete;
	
	}
	
	public boolean productIsReferenced(Product product) {
		boolean referenced=false;
		
		for(int i=0;i<workers.size();i++) {
			for(int j=0;j<workers.get(i).getOrders().size();j++) {
				for(int w=0;w<workers.get(i).getOrders().size();w++) {
					if(workers.get(i).getOrders().get(j).getProductsList().get(w).getName().equals(product.getName()) && workers.get(i).getOrders().get(j).getState()!= State.DELIVERED){
						referenced=true;
					}
				}
			}
		}
		
		
		return referenced;
		
	}
	
	public boolean addIngredient(Ingredient ingredient) throws IOException{
		String message="";
		for (int i=0;i<ingredients.size();i++) {
			message+=ingredients.get(i).getName()+",";
		}
		System.out.println(message);
		boolean found=false;
		Ingredient ingredientExists=returnIngredient(ingredient.getName());
		if(ingredientExists==null) { 
			if(ingredient!=null) {
				ingredients.add(ingredient);
				saveIngredientsData();
				found=false;	    		
			}
		}
		else {
			found=true;    		
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
	
	
	public boolean deleteIngredient(String name) throws IOException{
		boolean delete=false;
		Ingredient objIngredient =returnIngredient(name);
		if (objIngredient!=null) {
			boolean referenced=ingredientIsReferenced(objIngredient);
			if(referenced==false) {
				delete=true;
				ingredients.remove(objIngredient);
				saveIngredientsData();
				System.out.println("Guardo la info de ingrediente: borrado");
	    		Dialog<String> dialog=createDialog();
	    		dialog.setContentText("El ingrediente ha sido eliminado");
	    		dialog.setTitle("Ingrediente Eliminado");
	    		dialog.show();
			}
			else {
	    		Dialog<String> dialog=createDialog();
	    		dialog.setContentText("El ingrediente esta siendo referenciado por un producto por lo tanto no puede ser eliminado");
	    		dialog.setTitle("Error, ingrediente referenciado");
	    		dialog.show();
			}
		}else {
			delete=false;
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este ingrediente no existe");
    		dialog.setTitle("Ingrediente No econtrado");
    		dialog.show();
		}
		return delete;
	
	}
	public boolean ingredientIsReferenced(Ingredient ingredient) {
		boolean referenced=false;
		for(int i=0;i<products.size();i++) {
			for(int j=0;j<products.get(i).getIngredients().size();j++) {
				if(products.get(i).getIngredients().get(j).getName().equals(ingredient.getName())) {
					referenced=true;
				}
			}
		}
		return referenced;	
	}
	

	public boolean addProductType(ProductType obj, String empleadoUsername) throws IOException{
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
    			obj.setCreatedByUser(returnUser(empleadoUsername));
    			obj.setEditedByUser(returnUser(empleadoUsername));
    			saveProductTypeData();
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
	public boolean deleteproductType(String name) throws IOException{
		boolean delete=false;
		ProductType obj =returnProductType(name);
		if (obj!=null) {
			boolean referenced=productTypeIsReferenced(obj);
			if(referenced==false) {
				delete=true;
				productTypes.remove(obj);
				saveProductTypeData();
				Dialog<String> dialog=createDialog();
				dialog.setContentText("El tipo de producto ha sido eliminado");
				dialog.setTitle("Tipo de producto Eliminado");
				dialog.show();
			}
			else {
				Dialog<String> dialog=createDialog();
        		dialog.setContentText("El tipo de producto se encuentra referenciado por un producto por lo que no puede ser eliminado");
        		dialog.setTitle("Error, tipo de producto referenciado");
        		dialog.show();
			}
		}else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Este tipo de producto no existe");
    		dialog.setTitle("Tipo de Producto No econtrado");
    		dialog.show();
		}
		return delete;
	
	}
	
	public boolean productTypeIsReferenced(ProductType type) {
		boolean referenced=false;
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getType().getName().equals(type.getName())) {
				referenced=true;
			}
		}
		return referenced;	
	}
	
	public void updateIngredientOfProduct(String oldName,String newName) throws IOException {
		boolean exit=false;
		for (int i=0;i<products.size();i++) {
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			ingredients= products.get(i).getIngredients();
			exit=false;
			for (int j=0;j<ingredients.size() && !exit;j++) {
				if (ingredients.get(j).getName().equalsIgnoreCase(oldName)) {
					ingredients.get(j).setName(newName);
					exit=true;
				}
			}			
		}
		saveProductsData();
		System.out.println("Nueva actualizacion del ingrediente de un producto");
	}
	
	public void updateTypeOfProduct(String oldName,String newName) throws IOException{
		for (int i=0;i<products.size();i++) {
			ProductType type = products.get(i).getType();
			if (type.getName().equalsIgnoreCase(oldName)) {
				type.setName(newName);
			}
		}
		saveProductsData();
		System.out.println("Nueva actualizacion del tipo de un producto");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Import clients Data (serializacion)
	@SuppressWarnings("unchecked")
	public boolean loadClientsData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_CLIENTS);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 clients = (List<Client>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	}
	
	//Export clients Data (serializacion)
	 public void saveClientsData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_CLIENTS));
		 oos.writeObject(clients);
		 oos.close();
	 }
	 
	 //Import products Data (serializacion)
	 @SuppressWarnings("unchecked")
	 public boolean loadProductsData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_PRODUCTS);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 products = (List<Product>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export products Data (serializacion)
	 public void saveProductsData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCTS));
		 oos.writeObject(products);
		 oos.close();
	 }
	 
	 
	 //Import ingredients Data (serializacion)
	 @SuppressWarnings("unchecked")
	 public boolean loadIngredientsData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_INGREDIENTS);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			 ingredients = (List<Ingredient>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export ingredients Data (serializacion)
	 public void saveIngredientsData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_INGREDIENTS));
		 oos.writeObject(ingredients);
		 oos.close();
	 }
	 
	 //Import products types Data (serializacion)
	 @SuppressWarnings("unchecked")
	 public boolean loadProductTypeData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_PRODUCTTYPE);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			  productTypes= (List<ProductType>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export products types Data (serializacion)
	 public void saveProductTypeData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_PRODUCTTYPE));
		 oos.writeObject(productTypes);
		 oos.close();
	 }
	 
	 //Import users types Data (serializacion)
	 @SuppressWarnings("unchecked")
	 public boolean loadUsersData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_USERS);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			  workers = (List<Employee>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export users types Data (serializacion)
	 public void saveUsersData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_USERS));
		 oos.writeObject(workers);
		 oos.close();
	 }

	public List<String> getSizes() {
		return sizes;
	}

	public void setSizes(List<String> sizes) {
		this.sizes = sizes;
	}

	public String returnSize(String text) {
		String size=null;
		for(int i=0;i<sizes.size();i++) {
			if(sizes.get(i).equals(text)) {
				size=sizes.get(i);
			}
		}
		return size;
	}


	

}
