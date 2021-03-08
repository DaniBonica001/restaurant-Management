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
import javafx.scene.control.TextInputDialog;
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
	
    //Method to create a dialog window
    public Dialog<String> createDialog() {
  	  //Creating a dialog
  	    Dialog<String> dialog = new Dialog<String>();
  	    
  	    ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
  	    dialog.getDialogPane().getButtonTypes().add(type);
  	    return dialog; 
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
    	String empty="";
    	String names=txtClientNames.getText();
    	String surnames=txtClientSurnames.getText();
    	String id= txtClientId.getText();
    	String adress = txtClientAdress.getText();
    	String phone =txtClientPhone.getText();
    	String observations =txtClientObservations.getText();
    	
    	if (!names.equals(empty) && !surnames.equals(empty) && !id.equals(empty) && !adress.equals(empty)
    			&& !phone.equals(empty) && !observations.equals(empty)) {
    		createClient(names,surnames,id,adress,phone,observations);    		
    	}else {
    		Dialog<String> dialog=createDialog();
    		dialog.setTitle("Error al guardar datos");
    		dialog.setContentText("Todos los campos de texto deben ser llenados");    		
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
    		//labelUserMessage.setText("The user has been created");       		
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
    	String empty="";
    	String id =txtDeleteClientId.getText();
    	if(!id.equals(empty)) {
    		restaurant.deleteClient(id);
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Delete Client");
        	alert.setContentText("The client has been deleted");
        	alert.showAndWait();    
    		
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
    	String empty="";
    	String id=txtDeleteUserId.getText();
    	if(!id.equals(empty)) {
    		restaurant.deleteUser(txtDeleteUserId.getText());
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setTitle("Confirmation Dialog");
        	alert.setHeaderText("Delete User");
        	alert.setContentText("The user has been deleted");
        	alert.showAndWait(); 
    	}
    	else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("Ingrese la identificacion del usuario a eliminar");
    		dialog.setTitle("Error al eliminar usuario");
    		dialog.show();
    	}
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
    
<<<<<<< HEAD
    //Method to open the Options-window.fxml
=======

  //Method to open the Options-window.fxml
>>>>>>> 96e39494490c13b7bb627142345275db148d3fcf
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
	public void openUpdateClient(ActionEvent event) throws IOException {
		FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-Client.fxml"));
		updateClientFxml.setController(this);
		Parent root = updateClientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);

	}
	
    @FXML
    public void openAddIngredient(ActionEvent event) throws IOException {
    	FXMLLoader addIngredientFxml = new FXMLLoader(getClass().getResource("create-ingredient.fxml"));
    	addIngredientFxml.setController(this);
		Parent root = addIngredientFxml.load();
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
    public void openAddProduct(ActionEvent event) throws IOException {
    	FXMLLoader addProductFxml = new FXMLLoader(getClass().getResource("create-product.fxml"));
    	addProductFxml.setController(this);
		Parent root = addProductFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
		sizeOptions.clear();
		selectedIngredients.clear();
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
    public void openDeleteProductType(ActionEvent event) throws IOException{
    	FXMLLoader deleteProductTypeFxml = new FXMLLoader(getClass().getResource("Delete-ProductType.fxml"));
    	deleteProductTypeFxml.setController(this);
		Parent root = deleteProductTypeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
    }
<<<<<<< HEAD
=======
    //_________________________________________________________________________________________________________________________
    @FXML
    public void openUpdateProduct(ActionEvent event) throws IOException{
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("Text Input Dialog");
    	dialog.setHeaderText("Look, a Text Input Dialog");
    	dialog.setContentText("Please enter the name of the product:");
    	dialog.showAndWait();

    	Product productToUpdate= restaurant.returnProduct(dialog.getEditor().getText());
    	
    	if(productToUpdate!=null) {
    		FXMLLoader updateProductFxml = new FXMLLoader(getClass().getResource("Update-Product.fxml"));
    		updateProductFxml.setController(this);
    		Parent root = updateProductFxml.load();
    		mainPane_OptionsWindow.getChildren().setAll(root);
    		
    		sizeOptions.clear();
    		initializeComboUpdateSize();
    		initializeComboUpdateType();
    		initializeChoiceUpdateIngredients();
    		
    		LabelProductName.setText(productToUpdate.getName());
    		txtUpdateProductName.setText(productToUpdate.getName());
    		txtUpdateProductPrice.setText(productToUpdate.getPrice());
    		selectedIngredients.clear();
    		ComboUpdateSize.setValue(productToUpdate.getSize());
    		ComboUpdateType.setValue(productToUpdate.getType().getName());	
    	}
    	else {
      		Dialog<String> dialog1=createDialog();
      		dialog1.setContentText("No existe ningun producto con este nombre");
      		dialog1.setTitle("Error al cargar datos");
      		dialog1.show();
    	}

    }
    //__________________________________________________________________________________________________________________________
>>>>>>> 96e39494490c13b7bb627142345275db148d3fcf
    
    //delete-ProductType FXML things
    @FXML
    private Pane PaneDeleteProductType;

    @FXML
    private TextField txtDeleteProductTypeName;

    @FXML
    public void deleteProductType(ActionEvent event) {    	
    	if(!txtDeleteProductTypeName.getText().equals("")) {
    		restaurant.deleteproductType(txtDeleteProductTypeName.getText());
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
    public void deleteIngredient(ActionEvent event) {
    	if(!txtDeleteIngredientName.getText().equals("")) {
    		restaurant.deleteIngredient(txtDeleteIngredientName.getText());
    		ingredientsOptions.remove(txtDeleteIngredientName.getText());
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
    	String empty="";
    	String ingredientName=txtIngredientName.getText();
    	if(!ingredientName.equals(empty)) {
    		Ingredient objIngredient= new Ingredient(ingredientName);
    		restaurant.addIngredient(objIngredient);
    		ingredientsOptions.add(ingredientName);
    		txtIngredientName.setText("");
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
    public void deleteProduct(ActionEvent event) {		
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
<<<<<<< HEAD
    	String empty="";
    	String name=txtProductTypeName.getText();
    	if (!name.equals(empty)) {
    		ProductType obj=new ProductType(txtProductTypeName.getText());
        	restaurant.addProductType(obj);
        	typeOptions.add(name);
        	txtProductTypeName.setText("");
    	} else {
    		Dialog<String> dialog=createDialog();
    		dialog.setContentText("El tipo de producto a crear debe tener un nombre ");
    		dialog.setTitle("Error, Campo sin datos");
    		dialog.show();
    		
    	}
    }
       
=======
    	if(!txtProductTypeName.getText().equals("")) {
    	ProductType obj=new ProductType(txtProductTypeName.getText());

    	typeOptions.add(txtProductTypeName.getText()); //Se añade a la lista de tipos de producto para ser mostrada en los combobox
    	restaurant.addProductType(obj); // Se añade a la lista de tipos de producto DEL RESTAURANTE
    	txtProductTypeName.setText("");
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar los datos");
			dialog.show();
    	}

    }
>>>>>>> 96e39494490c13b7bb627142345275db148d3fcf
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
    public void UpdateClient(ActionEvent event) {
    	
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
<<<<<<< HEAD
    public void addIngredientToProduct(ActionEvent event) {
    	if(ChoiceIngredients.getValue()!=null) {
	    	selectedIngredients.add(ChoiceIngredients.getValue());
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Ingrediente "+ChoiceIngredients.getValue()+" ha sido añadido al producto");
			dialog.setTitle("Adicion de Ingrediente satisfactoria");
			dialog.show();
=======
    void addIngredientToProduct(ActionEvent event) {
    	boolean ingredientExists=false;

    	for(int i=0;i<selectedIngredients.size() && ingredientExists==false;i++) {
    		if(selectedIngredients.get(i).equalsIgnoreCase(ChoiceIngredients.getValue())) {
    			ingredientExists=true;
    		}
>>>>>>> 96e39494490c13b7bb627142345275db148d3fcf
    	}
    	if(ingredientExists==false) {
	    	if(ChoiceIngredients.getValue()!=null) {
		    	selectedIngredients.add(ChoiceIngredients.getValue());
				Dialog<String> dialog=createDialog();
				dialog.setContentText("Ingrediente "+ChoiceIngredients.getValue()+" ha sido añadido al producto");
				dialog.setTitle("Adicion de Ingrediente satisfactoria");
				dialog.show();
	    	}
	    	else {
				Dialog<String> dialog=createDialog();
				dialog.setContentText("Debe escoger algun ingrediente para que pueda ser añadido");
				dialog.setTitle("Campo requerido");
				dialog.show();
	    	}
    	}
    	else{
			Dialog<String> dialog=createDialog();
			dialog.setContentText("El ingrediente con el nombre "+ChoiceIngredients.getValue()+" ya existe");
			dialog.setTitle("Error, Ingrediente existente");
			dialog.show();
    	}
    	
    }
    
    @FXML
<<<<<<< HEAD
    public void createProduct(ActionEvent event) {  
=======
    void createProduct(ActionEvent event) {
>>>>>>> 96e39494490c13b7bb627142345275db148d3fcf
    	if(!txtProductName.getText().equals("") && !txtProductPrice.getText().equals("") && ComboSize.getValue()!=null && ComboType.getValue()!=null && selectedIngredients.size()!=0) {
    		Product objProduct=new Product(txtProductName.getText(),ComboSize.getValue(), txtProductPrice.getText(), ComboType.getValue(),selectedIngredients);
    		
    		restaurant.addProduct(objProduct);
    		
    		txtProductName.setText(null);
    		txtProductPrice.setText(null);
    		ComboSize.setValue(null);
    		ComboType.setValue(null);
    		ChoiceIngredients.setValue(null);
    		selectedIngredients.clear();
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar los datos");
			dialog.show();
    	}
    
    }

    ObservableList<String> sizeOptions = FXCollections.observableArrayList("pp","yy");
    ObservableList<String> typeOptions = FXCollections.observableArrayList("entry","juice");
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
    
    //Update-Product FXML things

    @FXML
    private Pane PaneUpdateProduct;

    @FXML
    private TextField txtUpdateProductName;

    @FXML
    private TextField txtUpdateProductPrice;

    @FXML
    private ComboBox<String> ComboUpdateSize;

    @FXML
    private ComboBox<String> ComboUpdateType;

    @FXML
    private Label LabelProductName;

    @FXML
    private ChoiceBox<String> ChoiceUpdateIngredients;
    
    @FXML
    void addUpdateIngredientToProduct(ActionEvent event) {
    	if(ChoiceUpdateIngredients.getValue()!=null) {
	    	selectedIngredients.add(ChoiceUpdateIngredients.getValue());
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Ingrediente "+ChoiceUpdateIngredients.getValue()+" ha sido añadido al producto");
			dialog.setTitle("Adicion de Ingrediente satisfactoria");
			dialog.show();
			ChoiceUpdateIngredients.setValue(null);
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Debe escoger algun ingrediente para que pueda ser añadido");
			dialog.setTitle("Campo requerido");
			dialog.show();
    	}
    }

    @FXML
    void updateProduct(ActionEvent event) {
    	Product productToUpdate= restaurant.returnProduct(LabelProductName.getText());
    	if(!txtUpdateProductName.getText().equals("") && !txtUpdateProductPrice.getText().equals("") && selectedIngredients.isEmpty()==false) {
    		productToUpdate.setName(txtUpdateProductName.getText());
    		productToUpdate.setPrice(txtUpdateProductPrice.getText());
    		productToUpdate.setSize(ComboUpdateSize.getValue());
    		productToUpdate.setType(toProductType(ComboUpdateType.getValue()));
    		productToUpdate.setIngredients(toIngredient(selectedIngredients));
    		
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Producto actualizado satisfactoriamente");
			dialog.setTitle("Proceso Satisfactorio");
			dialog.show();
			
			txtUpdateProductName.setText("");
			txtUpdateProductPrice.setText("");
			ComboUpdateSize.setValue("");
			ComboUpdateType.setValue("");
			ChoiceUpdateIngredients.setValue("");
			LabelProductName.setText("");

			try {
		  		FXMLLoader optionsFxml = new FXMLLoader (getClass().getResource("Options-window.fxml"));
		  		optionsFxml.setController(this);
		  		Parent opWindow= optionsFxml.load();
				mainPaneLogin.getChildren().setAll(opWindow);	
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    	else {
			Dialog<String> dialog=createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
    	}
    	
    }
    
    public void initializeComboUpdateSize() {
    	sizeOptions.add(Size.PERSONAL.toString());
    	sizeOptions.add(Size.FOR_TWO.toString());
    	ComboUpdateSize.setItems(sizeOptions);
    }
    
    public void initializeComboUpdateType(){
    	ComboUpdateType.setItems(typeOptions);
    }
    public void initializeChoiceUpdateIngredients() {
    	ChoiceUpdateIngredients.setItems(ingredientsOptions);
    }
    
    public ProductType toProductType(String name) {
    	ProductType productType= new ProductType(name);
		return productType;
    }
    
	public List<Ingredient> toIngredient(List<String> ingredientsList ){
		List<Ingredient> ingredients= new ArrayList<Ingredient>();
		for(int i=0;i<ingredientsList.size();i++) {
			ingredients.add(new Ingredient(ingredientsList.get(i)));
		}
		return ingredients;	
	}
    
    



	

}
