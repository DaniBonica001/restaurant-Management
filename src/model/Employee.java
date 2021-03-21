package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class Employee implements Serializable{
	//Constants
	private static final long serialVersionUID = 1;
	public final static String SAVE_PATH_FILE_ORDERS="data/orders.ap2";
	public final static String SAVE_PATH_FILE_USER_ORDERS="data/prueba1.ap2";
	//Atributes
	private String saveDataFileName;
	private String names;
	private String surnames;
	private String idNumber;
	
	//relations
	private List<Order> orders;
	
	//Constructor #1
	public Employee(String names,String surnames,String idNumber) {
		this.names=names;
		this.surnames=surnames;
		this.idNumber=idNumber;
		orders=new ArrayList<>();
		this.setSaveDataFileName("data/prueba1.ap2");	
	}
	
	

	//Setters and getters
	public String getSaveDataFileName() {
		return saveDataFileName;
	}



	public void setSaveDataFileName(String saveDataFileName) {
		this.saveDataFileName = saveDataFileName;
	}
	
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


	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(String code,String date, String hour, String observations,Client client, SystemUser user,
			List<Product>productList,  List<Integer> productsQuantity) throws IOException, ClassNotFoundException{
		
		orders.add(new Order(code,State.REQUESTED,date, hour,observations,client,user,productList,productsQuantity));
		for (int i =0;i<productsQuantity.size();i++) {
			System.out.println("Antes de ir al contructor: "+productsQuantity.get(i));
		}
		saveUsersOrdersData(user.getNames());
		loadUsersOrdersData(user.getNames());
		
		//saveOrdersData();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
    	alert.setHeaderText("Pedido Agregado");
    	alert.setContentText("El pedido ha sido agregado a la lista de pedidos del empleado");
    	alert.showAndWait(); 
    	
    	for (int i=0;i<user.getOrders().size();i++) {
    		System.out.println("+++++order "+i+":"+user.getOrders().get(i).getCode()+", "+user.getOrders().get(i).getProducts()+", "+user.getOrders().get(i).getStringQuantity());
    	}
		
	}
	
	
	 //Import orders types Data (serializacion)
	 @SuppressWarnings("unchecked")
	 public boolean loadOrdersData() throws IOException, ClassNotFoundException{
		 File f = new File(SAVE_PATH_FILE_ORDERS);
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			   orders= (List<Order>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export orders types Data (serializacion)
	 public void saveOrdersData() throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_ORDERS));
		 oos.writeObject(orders);
		 oos.close();
	 }
	 
	 //__________________________________________________________________________________________________________________________________
	 
	 //Import user orders Data
	 @SuppressWarnings("unchecked")
	public boolean loadUsersOrdersData(String username) throws IOException, ClassNotFoundException{
		 File f = new File("data/"+username+".ap2");
		 boolean loaded = false;
		 if(f.exists()){
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			   orders= (List<Order>)ois.readObject();
			 ois.close();
			 loaded = true;
		 }		 
		 return loaded;	
	 }

	 //Export user orders Data (serializacion)
	 public void saveUsersOrdersData(String userName) throws IOException{
		 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/"+userName+".ap2"));
		 oos.writeObject(orders);
		 oos.close();
	 }
	 
	 //____________________________________________________________________________________________________________________________________________________________
	
	 
	 public boolean findOrder(String code) {
		 boolean found=false;
		 boolean exit=false;

		 for (int i=0;i<orders.size() && !exit;i++) {
			 if (orders.get(i)!=null && orders.get(i).getCode().equals(code)) {
				 found=true;
				 exit=false;
			 }
		 }
		 return found;
	 }

}
