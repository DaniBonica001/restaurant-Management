package ui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Pane;
import model.Client;
import model.Employee;
import model.SystemUser;

public class Restaurant {
	
	//Relations
	private List<Client>clients;
	private List<Employee>workers;
	
	//Constructor
	public Restaurant() {
		clients=new ArrayList<Client>();
		workers=new ArrayList<Employee>();
	}
	
	//Create Client FXML things
	@FXML
    private Pane PaneAddClient;

    @FXML
    private TextField txtClientNames;

    @FXML
    private TextField txtClientId;

    @FXML
    private TextField txtClientSurnames;

    @FXML
    private TextField txtClientAdress;

    @FXML
    private TextField txtClientPhone;

    @FXML
    private TextField txtClientObservations;

    @FXML
    void createClient(ActionEvent event) {
    	if(txtClientNames.getText()!="" && txtClientSurnames.getText()!="" && txtClientId.getText()!="" && txtClientAdress.getText()!="" && txtClientPhone.getText()!="" && txtClientObservations.getText()!="") {
    		createClient(txtClientNames.getText(),txtClientSurnames.getText(),txtClientId.getText(),txtClientAdress.getText(),txtClientPhone.getText(),txtClientObservations.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Todos los campos de texto deben ser llenados");
    		dialog.setTitle("Error al guardar datos");
    		dialog.show();
    	}
    }
    
    // Create SystemUser FXML things
    @FXML
    private Pane PaneAddUser;

    @FXML
    private TextField txtUserNames;

    @FXML
    private TextField txtUserId;

    @FXML
    private PasswordField txtUserSurnames;

    @FXML
    private TextField txtUserUsername;

    @FXML
    private TextField PfUserPassword;

    @FXML
    void createUser(ActionEvent event) {
    	if(txtUserNames.getText()!="" && txtUserSurnames.getText() !="" && txtUserId.getText() !="" && txtUserUsername.getText() !="" && PfUserPassword.getText()!="") {
    	createSystemUser(txtUserNames.getText(),txtUserSurnames.getText(),txtUserId.getText(),txtUserUsername.getText(),PfUserPassword.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Todos los campos de texto deben ser llenados");
    		dialog.setTitle("Error al guardar datos");
    		dialog.show();
    	}
    }
    
    // Delete Client FXML things
    @FXML
    private Pane PaneDeleteClient;

    @FXML
    private TextField txtDeleteClientId;

    @FXML
    void deleteClient(ActionEvent event) {
    	if(txtDeleteClientId.getText()!="") {
    		deleteClient(txtDeleteClientId.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Ingrese la identificacion del cliente a eliminar");
    		dialog.setTitle("Error al eliminar cliente");
    		dialog.show();
    	}
    }
    
    public Dialog<String> createDialog() {
  	  //Creating a dialog
  	    Dialog<String> dialog = new Dialog<String>();
  	    
  	    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
  	    dialog.getDialogPane().getButtonTypes().add(type);
  	    return dialog; 
      }
	
	public void createClient(String nam, String surnam,String id,String direction,String phone, String obs) {
		clients.add(new Client(nam, surnam, id, direction, phone, obs));
	}
	public void deleteClient(String id) {
		boolean salir=false;
		for(int i=0;i<clients.size() && salir==false;i++) {
			if(clients.get(i).getIdNumber().equals(id)) {
				clients.remove(clients.get(i));
				salir=true;
			}
		}
		if(salir=false) {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("El cliente con el id "+id+" no ha sido encontrado");
    		dialog.setTitle("Error de campos de texto incompletos");
    		dialog.show();
		}
	}
	
	public void createSystemUser(String nam, String surnam,String id,String username, String password) {
		workers.add(new SystemUser(nam, surnam, id, username, password));
	}


}
