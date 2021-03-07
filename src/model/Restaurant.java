package model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;

public class Restaurant {

	//Relations
	private List<Client>clients;
	private List<Employee>workers;
	
	//Constructor
	public Restaurant() {
		clients=new ArrayList<Client>();
		workers=new ArrayList<Employee>();
	}
	
	//Methods	
	public Dialog<String> createDialog() {
		//Creating a dialog
		Dialog<String> dialog = new Dialog<String>();

		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		return dialog; 
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
    		dialog.setContentText("El usuario con el id "+id+" no ha sido encontrado");
    		dialog.setTitle("Error al encontrar usuario");
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
		if (found!=true) {
			clients.add(new Client(nam, surnam, id, direction, phone, obs));
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
    		dialog.setContentText("El cliente con el id "+id+" no ha sido encontrado");
    		dialog.setTitle("Error al encontrar cliente");
    		dialog.show();
		}
	}
	
	public void deleteProduct (String productName) {
		
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

	

}
