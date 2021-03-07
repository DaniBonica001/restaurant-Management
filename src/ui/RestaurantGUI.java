package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Pane;
import model.Ingredient;
import model.Product;
import model.ProductType;
import model.Restaurant;
import model.Size;


public class RestaurantGUI {
	
	//Relations	
	private Restaurant restaurant;
	
	//Constructor
	public RestaurantGUI(Restaurant rest) {
		restaurant=rest;	
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
    public void createClient(ActionEvent event) {
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
    private Pane mainPaneRegister;

    @FXML
    private TextField txtUserNames;

    @FXML
    private TextField txtUserSurnames;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtUserUsername;

    @FXML
    private PasswordField PfUserPassword;

    @FXML
    private Label labelUserMessage;
    
    //Method to return from Add-User.fxml to login.fxml
    @FXML
    public void buttonLogIn(ActionEvent event) throws IOException {
    	FXMLLoader loginScreen = new FXMLLoader(getClass().getResource("login.fxml"));
    	loginScreen.setController(this);
    	Parent changeToLogin = loginScreen.load();
    	mainPaneRegister.getChildren().setAll(changeToLogin);
    }
    
    //Method to create an user with the Add-User.fxml form
    @FXML
    public void createUser(ActionEvent event) {    
    	String empty="";
    	String name = txtUserNames.getText();
    	String lastName= txtUserSurnames.getText();
    	String id = txtUserId.getText();
    	String username= txtUserUsername.getText();
    	String password= PfUserPassword.getText();   	
    	  	
    	if (!name.equals(empty) && !lastName.equals(empty) && !id.equals(empty) && !username.equals(empty) && !password.equals(empty)) {
    		createSystemUser(name,lastName,id,username,password);
    		labelUserMessage.setText("The user has been created");
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Create user");
        	alert.setContentText("The user has been created");
        	alert.showAndWait();    		
    	}else {   
    		labelUserMessage.setText("The user couldn't be created");
    		Dialog<String> dialog=createDialog();
    		dialog.setTitle("Error al guardar datos");
    		dialog.setContentText("Todos los campos de texto deben ser llenados");    		
    		dialog.show();    			
    	}    	
    }
    
    // Delete-Client FXML things
    @FXML
    private Pane PaneDeleteClient;

    @FXML
    private TextField txtDeleteClientId;

    //Method from Delete-Client.fxml to delete a Client
    @FXML
    public void deleteClient(ActionEvent event) {
    	if(txtDeleteClientId.getText()!="") {
    		restaurant.deleteClient(txtDeleteClientId.getText());
    		
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Ingrese la identificacion del cliente a eliminar");
    		dialog.setTitle("Error al eliminar cliente");
    		dialog.show();
    	}
    }
    
    //Delete User FXML things
    @FXML
    private Pane PaneDeleteUser;

    @FXML
    private TextField txtDeleteUserId;
    
    //Method from Delete-User-fxml to delete an User
    @FXML
    public void deleteUser(ActionEvent event) {
    	if(txtDeleteUserId.getText()!="") {
    		restaurant.deleteUser(txtDeleteUserId.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Ingrese la identificacion del usuario a eliminar");
    		dialog.setTitle("Error al eliminar usuario");
    		dialog.show();
    	}
    }
    
    //Method to create a dialog window
    public Dialog<String> createDialog() {
  	  //Creating a dialog
  	    Dialog<String> dialog = new Dialog<String>();
  	    
  	    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
  	    dialog.getDialogPane().getButtonTypes().add(type);
  	    return dialog; 
      }
	
    //Method to create and add the client to the clients List in Restaurant class
	public void createClient(String nam, String surnam,String id,String direction,String phone, String obs) {
		restaurant.addClient(nam, surnam, id, direction, phone, obs);
	}
	
	
	//Method to create and add the user to the workers List in Restaurant class
	public void createSystemUser(String nam, String surnam,String id,String username, String password) {
		restaurant.addUser(nam, surnam, id, username, password);
	}

	
	//Login.fxml things
	
    @FXML
    private Pane mainPaneLogin;

    @FXML
    private TextField txtSystemUserUsername;

    @FXML
    private PasswordField passFieldSystemUserPassword;
    
    //Method to open the register form (Add-User.fxml)
    @FXML
	public void buttonSingUp(ActionEvent event) throws IOException {
		FXMLLoader addUserfxml = new FXMLLoader(getClass().getResource("Add-User.fxml"));
		addUserfxml.setController(this);
		Parent addUser = addUserfxml.load();		
		mainPaneLogin.getChildren().setAll(addUser);
	}
    
  //Method to open the Options-window.fxml
  	@FXML
  	public void buttonSingIn(ActionEvent event) throws IOException {
  		if (!txtSystemUserUsername.getText().equals("") && !passFieldSystemUserPassword.getText().equals("")) {
  			
  			String username=txtSystemUserUsername.getText();
  			String password=passFieldSystemUserPassword.getText();
  			
  			boolean openWindow = restaurant.logInUser(username,password);
  			
  			if (openWindow==true) {
  				FXMLLoader optionsFxml = new FXMLLoader (getClass().getResource("Options-window.fxml"));
  				optionsFxml.setController(this);
  				Parent opWindow = optionsFxml.load();
  				mainPaneLogin.getChildren().setAll(opWindow);				
  			}
  			else {
  	    		Dialog<String> dialog=createDialog();
  	    		dialog.setContentText("Este usuario no ha sido encontrado, si desea crear uno ingrese a sign up");
  	    		dialog.setTitle("Usuario no encontrado");
  	    		dialog.show();
  			}
  		}else {
      		Dialog<String> dialog=createDialog();
      		dialog.setContentText("Todos los campos deben ser llenados");
      		dialog.setTitle("Error al cargar datos");
      		dialog.show();
  		}

  	}
	
	//Options-window.fxml things
	@FXML
	private Pane mainPane_OptionsWindow;
	
	@FXML
	public void openAddClient(ActionEvent event) throws IOException{
		FXMLLoader addClientFxml = new FXMLLoader(getClass().getResource("Add-Client.fxml"));
		addClientFxml.setController(this);
		Parent addRoot = addClientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(addRoot);

	}

	@FXML
	public void openDeleteClient(ActionEvent event) throws IOException {
		FXMLLoader deleteClientFxml = new FXMLLoader(getClass().getResource("Delete-Client.fxml"));
		deleteClientFxml.setController(this);
		Parent deleteRoot = deleteClientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(deleteRoot);

	}
	
    @FXML
    public void openAddIngredient(ActionEvent event) throws IOException {
    	FXMLLoader addIngredientFxml = new FXMLLoader(getClass().getResource("create-ingredient.fxml"));
    	addIngredientFxml.setController(this);
		Parent root = addIngredientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);

    }
    @FXML
    public void openUpdateClient(ActionEvent event) throws IOException {
    	FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-Client.fxml"));
    	updateClientFxml.setController(this);
		Parent root = updateClientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);

    }
    @FXML
    public void openAddProduct(ActionEvent event) throws IOException {
    	FXMLLoader addProductFxml = new FXMLLoader(getClass().getResource("create-product.fxml"));
    	addProductFxml.setController(this);
		Parent root = addProductFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
		sizeOptions.clear();
		initializeComboSize();
		initializeComboType();
		initializeChoiceIngredient();
    }
    @FXML
    public void openDeleteProduct(ActionEvent event) throws IOException {
    	FXMLLoader deleteProductFxml = new FXMLLoader(getClass().getResource("Delete-Product.fxml"));
    	deleteProductFxml.setController(this);
		Parent root = deleteProductFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
    }
    @FXML
    public void openAddProductType(ActionEvent event) throws IOException{
    	FXMLLoader addTypeFxml = new FXMLLoader(getClass().getResource("create-productType.fxml"));
    	addTypeFxml.setController(this);
		Parent root = addTypeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
    }
    @FXML
    public void openDeleteIngredient(ActionEvent event) throws IOException{
    	FXMLLoader deleteIngredientFxml = new FXMLLoader(getClass().getResource("Delete-Ingredient.fxml"));
    	deleteIngredientFxml.setController(this);
		Parent root = deleteIngredientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
    }
    @FXML
    public void openDeleteProductType(ActionEvent event) throws IOException{
    	FXMLLoader deleteProductTypeFxml = new FXMLLoader(getClass().getResource("Delete-ProductType.fxml"));
    	deleteProductTypeFxml.setController(this);
		Parent root = deleteProductTypeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
    }
    //delete-ProductType FXML things

    @FXML
    private Pane PaneDeleteProductType;

    @FXML
    private TextField txtDeleteProductType;

    @FXML
    void deleteProductType(ActionEvent event) {
    	if(!txtDeleteProductType.getText().equals("")) {
    		restaurant.deleteproductType(txtDeleteProductType.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Los campos deben ser llenados");
    		dialog.setTitle("Error, Campo sin datos");
    		dialog.show();
    	}
    }
    
    //delete-ingredient FXML things

    @FXML
    private Pane PaneDeleteIngredient;

    @FXML
    private TextField txtDeleteIngredientName;

    @FXML
    void deleteIngredient(ActionEvent event) {
    	if(!txtDeleteIngredientName.getText().equals("")) {
    		restaurant.deleteIngredient(txtDeleteIngredientName.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Los campos deben ser llenados");
    		dialog.setTitle("Error, Campo sin datos");
    		dialog.show();
    	}
    }
    
    //create-ingredient.fxml things
    @FXML
    private TextField txtIngredientName;

    @FXML
    private Label labelIngredientMessage;

    @FXML
    public void buttonCreateIngredient(ActionEvent event) {
    	if(txtIngredientName.getText()!=null) {
    		Ingredient objIngredient= new Ingredient(txtIngredientName.getText());
    		restaurant.addIngredient(objIngredient);
    		ingredientsOptions.add(txtIngredientName.getText());
    		txtIngredientName.setText(null);
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("El ingrediente a crear debe tener un nombre ");
    		dialog.setTitle("Error, Campo sin datos");
    		dialog.show();
    	}
    }
    //delete-Product FXML things

    @FXML
    private Pane PaneDeleteProduct;

    @FXML
    private TextField txtDeleteProductName;

    @FXML
    void deleteProduct(ActionEvent event) {		
    	if(!txtDeleteProductName.getText().equals("")) {
    		restaurant.deleteProduct(txtDeleteProductName.getText());
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Los campos deben ser llenados");
    		dialog.setTitle("Error, Campo sin datos");
    		dialog.show();
    	}
    }
    
    //create-ProductType.fxml things

    @FXML
    private TextField txtProductTypeName;

    @FXML
    private Label labelProductTypeMessage;

    @FXML
    public void buttonCreateProductType(ActionEvent event) {
    	createProductType(txtProductTypeName.getText());
    	ProductType obj=new ProductType(txtProductTypeName.getText());
    	restaurant.addProductType(obj);
    	txtProductTypeName.setText("");
    }
    
    public void createProductType(String name) {
    	typeOptions.add(name);
    }
    
    //UpdateClient FXML things
    @FXML
    private Pane PaneUpdateClient;

    @FXML
    private TextField txtUpdateClientNames;

    @FXML
    private TextField txtUpdateClientId;
    
    @FXML
    private TextField txtUpdateClientSurnames;

    @FXML
    private TextField txtUpdateClientAdress;

    @FXML
    private TextField txtUpdateClientPhone;

    @FXML
    private TextField txtUpdateClientObservations;

    @FXML
    void UpdateClient(ActionEvent event) {
    	
    }
    
    // CreateProduct FXML things
    @FXML
    private Pane PaneCreateProduct;

    @FXML
    private TextField txtProductName;

    @FXML
    private TextField txtProductPrice;

    @FXML
    private ComboBox<String> ComboSize;

    @FXML
    private ComboBox<String> ComboType;

    @FXML
    private ChoiceBox<String> ChoiceIngredients;
    
    //Button add Ingredient
    @FXML
    void addIngredientToProduct(ActionEvent event) {
    	if(ChoiceIngredients.getValue()!=null) {
	    	selectedIngredients.add(ChoiceIngredients.getValue());
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Ingrediente "+ChoiceIngredients.getValue()+" ha sido a�adido al producto");
			dialog.setTitle("Adicion de Ingrediente satisfactoria");
			dialog.show();
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Debe escoger algun ingrediente para que pueda ser a�adido");
			dialog.setTitle("Campo requerido");
			dialog.show();
    	}
    }
    
    @FXML
    void createProduct(ActionEvent event) {  
    	if(!txtProductName.getText().equals("") && !txtProductPrice.getText().equals("") && ComboSize.getValue()!=null && ComboType.getValue()!=null && selectedIngredients.size()!=0) {
    		Product objProduct=new Product(txtProductName.getText(),ComboSize.getValue(), txtProductPrice.getText(), ComboType.getValue(),selectedIngredients);
    		restaurant.addProduct(objProduct);
    		selectedIngredients.clear();
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar los datos");
			dialog.show();
    	}
    
    }

    ObservableList<String> sizeOptions = FXCollections.observableArrayList();
    ObservableList<String> typeOptions = FXCollections.observableArrayList();
    ObservableList<String> ingredientsOptions = FXCollections.observableArrayList();
    List<String>selectedIngredients=new ArrayList<>();
    
    //The next 3 method are the initialization of combobox and choiceBox, when a Type of product is created the combotype add a new value and the same occurs with ChoiceBox of ingredients
    public void initializeComboSize() {
    	sizeOptions.add(Size.PERSONAL.toString());
    	sizeOptions.add(Size.FOR_TWO.toString());
    	ComboSize.setItems(sizeOptions);
    }
    
    public void initializeComboType(){
    	ComboType.setItems(typeOptions);
    }
    public void initializeChoiceIngredient() {
    	ChoiceIngredients.setItems(ingredientsOptions);
    }
    
    
    



	

}
