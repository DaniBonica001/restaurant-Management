package ui;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Pane;
import model.Client;
import model.Employee;

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


}
