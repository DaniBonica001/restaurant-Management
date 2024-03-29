package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Pane;
import model.Client;
import model.Condition;
import model.Employee;
import model.Ingredient;
import model.Order;
import model.Product;
import model.ProductType;
import model.Restaurant;
import model.SortOrdersByDateHour;
import model.SortProductsByPrice;
import model.State;
import model.SystemUser;

public class RestaurantGUI {

	private String empleadoUsername;

	// Relations
	private Restaurant restaurant;

	// Constructor
	public RestaurantGUI(Restaurant rest) {
		restaurant = rest;
		empleadoUsername = null;
	}

	public String getEmpleadoUsername() {
		return empleadoUsername;
	}

	public void setEmpleadoUsername(String empleadoUsername) {
		this.empleadoUsername = empleadoUsername;
	}
	
	// Create Client FXML things
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
		
		// Delete User FXML things
		@FXML
		private Pane PaneDeleteUser;

		@FXML
		private TextField txtDeleteUserId;

	// Update-User.fxml things

		@FXML
		private Label LabelSystemUserName;

		@FXML
		private TextField txtSystemUserNewname;

		@FXML
		private TextField txtSystemUserNewLastname;

		@FXML
		private TextField txtSystemUserNewId;

		@FXML
		private TextField txtSystemUserNewUsername;

		@FXML
		private PasswordField passwordSystemUserNewPassword;

	// Delete-Client FXML things
		@FXML
		private Pane PaneDeleteClient;

		@FXML
		private TextField txtDeleteClientId;
	// Login.fxml things

		@FXML
		private Pane mainPaneLogin;

		@FXML
		private TextField txtSystemUserUsername;

		@FXML
		private PasswordField passFieldSystemUserPassword;

	//Options-window.fxml things__________________________________________________________________________________________________________
		@FXML
		private Pane mainPane_OptionsWindow;

		@FXML
		private Pane paneToComeBackToLogin;

	//TABLEVIEW ORDERS.FXML THINGS-------------------------------------------------------------------------------------------------------------------------
		@FXML
		private TableView<Order> tableViewOrders;

		@FXML
		private TableColumn<Order, String> columnOrderCode;

		@FXML
		private TableColumn<Order, State> columnOrderState;

		@FXML
		private TableColumn<Order, String> columnOrderEmployee;

		@FXML
		private TableColumn<Order, String> columnOrderClient;

		@FXML
		private TableColumn<Order, String> columnOrderProducts;

		@FXML
		private TableColumn<Order, String> columnOrderCant;

		@FXML
		private TableColumn<Order, String> columnOrderDate;

		@FXML
		private TableColumn<Order, String> columnOrderHour;

		@FXML
		private TableColumn<Order, String> columnOrderObservations;

	//updateOrderState

		@FXML
		private Label labelOrderCode;

		@FXML
		private ChoiceBox<State> choiceState;

	//_____________________________________________________________________________________________________________________________________

		// Update-productType.fxml things
		@FXML
		private TextField txtProductTypeNewName;

		@FXML
		private TextField txtProductTypeLastName;

	// update-ingredients.fxml things
		@FXML
		private TextField txtIngredientLastName;

		@FXML
		private TextField txtIngredientNewName;

	// Client-BinarySearch.fxml

		@FXML
		private Pane paneBinarySearch;

	// findClient-BinarySearch.fxml
		@FXML
		private TextField txtSearchClient;

	// infoClient-binarySearch.fxml
		@FXML
		private Label labelClientNameBS;

		@FXML
		private Label labelClientLastNameBS;

		@FXML
		private Label labelClientIdBS;

		@FXML
		private Label labelClientAdressBS;

		@FXML
		private Label labelClientPhoneBS;

		@FXML
		private Label labelClientConditionBS;

		@FXML
		private Label labelClientObservations;

		@FXML
		private Label labelBinarySearchTime;

	// delete-ProductType FXML things
		@FXML
		private Pane PaneDeleteProductType;

		@FXML
		private TextField txtDeleteProductTypeName;

	// delete-ingredient FXML things

		@FXML
		private Pane PaneDeleteIngredient;

		@FXML
		private TextField txtDeleteIngredientName;

	//create-ingredient.fxml things
		@FXML
		private TextField txtIngredientName;

		@FXML
		private Label labelIngredientMessage;

	//delete-Product FXML things

		@FXML
		private Pane PaneDeleteProduct;

		@FXML
		private TextField txtDeleteProductName;

	//create-Size.fxml things
		@FXML
		private TextField txtCreateSizeName;

	//create-ProductType.fxml things

		@FXML
		private TextField txtProductTypeName;

		@FXML
		private Label labelProductTypeMessage;

	//UpdateClient FXML things----------------------------------------------------------------------------------------------
		@FXML
		private Pane PaneUpdateClient;

		@FXML
		private Label LabelUpdateClientName;

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

	//Disable Product FXML things
		@FXML
		private Pane PaneDisableProduct;

		@FXML
		private TextField txtNameDisableProduct;

	//Disable Ingredients FXML things

		@FXML
		private Pane PaneDisableIngredient;

		@FXML
		private TextField txtNameDisableIngredient;

	//Disable TypeOfProduct
		@FXML
		private Pane PaneDisableProductType;

		@FXML
		private TextField txtNameDisableProductType;

	//Disable-Client FXML things
		@FXML
		private Pane PaneDisableClient;

		@FXML
		private TextField txtIdDisableClient;

	// Administrator things

		@FXML
		private Pane paneToChange_AdministratorWindow;

		@FXML
		private Pane mainPane_AdministratorOptionsWindow;

		// clients-List.fxml

		@FXML
		private TableView<Client> tableViewClientsList;

		@FXML
		private TableColumn<Client, String> columnClientName;

		@FXML
		private TableColumn<Client, String> columnClientLastName;

		@FXML
		private TableColumn<Client, String> columnClientID;

		@FXML
		private TableColumn<Client, String> columnClientAdress;

		@FXML
		private TableColumn<Client, String> columnClientPhoneNumber;

		@FXML
		private TableColumn<Client, String> columnClientObservations;

		@FXML
		private TableColumn<Client, Condition> columnClientCondition;

		// update-ClientAdm.fxml things
		@FXML
		private Pane PaneUpdateClientAdm;

		@FXML
		private TextField txtUpdateClientNamesAdm;

		@FXML
		private TextField txtUpdateClientIdAdm;

		@FXML
		private TextField txtUpdateClientAdressAdm;

		@FXML
		private TextField txtUpdateClientPhoneAdm;

		@FXML
		private TextField txtUpdateClientObservationsAdm;

		@FXML
		private Label LabelUpdateClientNameAdm;

		@FXML
		private TextField txtUpdateClientSurnamesAdm;

		// productType-List.fxml things

		@FXML
		private TableView<ProductType> tableViewProductTypeList;

		@FXML
		private TableColumn<ProductType, String> columnProductTypeName;

		@FXML
		private TableColumn<ProductType, Condition> columnProductTypeCondition;

		// update-productTypeAdm.fxml
		@FXML
		private TextField txtProductTypeNewNameAdm;

		@FXML
		private TextField txtProductTypeLastNameAdm;

	// Update Product in ADMINISTRATOR fxml things

		@FXML
		private Pane PaneUpdateProductAdm;

		@FXML
		private TextField txtUpdateProductNameAdm;

		@FXML
		private TextField txtUpdateProductPriceAdm;

		@FXML
		private ComboBox<String> ComboUpdateSizeAdm;

		@FXML
		private ComboBox<String> ComboUpdateTypeAdm;

		@FXML
		private Label LabelProductNameAdm;

		@FXML
		private ChoiceBox<String> ChoiceUpdateIngredientsAdm;

		// product-List.fxml things
		@FXML
		private TableView<Product> tableViewProductsList;

		@FXML
		private TableColumn<Product, String> columnProductName;

		@FXML
		private TableColumn<Ingredient, String> columngProductIngredients;

		@FXML
		private TableColumn<Product, String> columnProductType;

		@FXML
		private TableColumn<Product, String> columnProductSize;

		@FXML
		private TableColumn<Product, String> columnProductPrice;

		@FXML
		private TableColumn<Product, Condition> columnProductCondition;

		// user-List.fxml things

		@FXML
		private TableView<Employee> tableViewUsers;

		@FXML
		private TableColumn<SystemUser, String> columnUserNames;

		@FXML
		private TableColumn<SystemUser, String> columnUserLastName;

		@FXML
		private TableColumn<SystemUser, String> columnUserId;

		@FXML
		private TableColumn<SystemUser, String> columnUserUsername;

		@FXML
		private TableColumn<SystemUser, Condition> columnUserCondition;
		
		// Disable-User.fxml things
		@FXML
		private TextField txtDisableMyUser;

		// update-UserAdm.fxml

		@FXML
		private Label LabelSystemUserNameAdm;

		@FXML
		private TextField txtSystemUserNewnameAdm;

		@FXML
		private TextField txtSystemUserNewLastnameAdm;

		@FXML
		private TextField txtSystemUserNewIdAdm;

		@FXML
		private TextField txtSystemUserNewUsernameAdm;

		@FXML
		private PasswordField passwordSystemUserNewPasswordAdm;

		// Update-ingredientAdm.fxml things

		@FXML
		private TextField txtIngredientNewNameAdm;

		@FXML
		private TextField txtIngredientLastNameAdm;

		// ingredient-List.fxml things

		@FXML
		private TableView<Ingredient> tableViewIngredients;

		@FXML
		private TableColumn<Ingredient, String> columnIngredientName;

		@FXML
		private TableColumn<Ingredient, Condition> columnIngredientCondition;

	//Update the state of an order in administrator fxml things
		@FXML
		private Label labelOrderCodeAdm;

		@FXML
		private ChoiceBox<State> choiceStateAdm;

	//Create order fxml things
		@FXML
		private Label LabelFecha;
		@FXML
		private TextField txtOrderEmployee;
		@FXML
		private TextField txtOrderCode;
		@FXML
		private TextField txtOrderObservations;
		@FXML
		private TextField txtOrderClientId;
		@FXML
		private TextField txtOrderProductSize;
		@FXML
		private TextField txtOrderClientName;
		@FXML
		private TextField txtOrderProductQuantity;
		@FXML
		private ChoiceBox<String> ComboProducts;
		@FXML
		private Label LabelHora;

	//generate-Report fxml things

	    @FXML
	    private TextField txtReportSeparator;

	    @FXML
	    private DatePicker InitialDate;

	    @FXML
	    private DatePicker FinalDate;

	    @FXML
	    private TextField InitialHour;

	    @FXML
	    private TextField FinalHour;
	    
	    @FXML
	    private Label LabelReportType;
	    

		ObservableList<String> sizeOptions = FXCollections.observableArrayList(); //list with existing sizes so the size of the product can be created
		ObservableList<String> typeOptions = FXCollections.observableArrayList(); //list with existing types so the type of the product can be created
		ObservableList<String> ingredientsOptions = FXCollections.observableArrayList(); //list with existing ingredients so the ingredient of the product can be created
		List<String> selectedIngredients = new ArrayList<>(); //List of the ingredients the user had been chosen, it is being constanty modified until the product is created



	// Method to create a dialog window
	public Dialog<String> createDialog() {
		// Creating a dialog
		Dialog<String> dialog = new Dialog<String>();

		ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(type);
		return dialog;
	}

	// Method to create and add the client to the clients List in Restaurant class
	public void createClient(String nam, String surnam, String id, String direction, String phone, String obs, int number) {
		try {
			restaurant.addClient(nam, surnam, id, direction, phone, obs, number);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Method to create and add the user to the workers List in Restaurant class
	public void createSystemUser(String nam, String surnam, String id, String username, String password) {
		try {
			restaurant.addUser(nam, surnam, id, username, password);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//method to button createClient
	@FXML
	public void createClient(ActionEvent event) {
		String empty = "";
		String names = txtClientNames.getText();
		String surnames = txtClientSurnames.getText();
		String id = txtClientId.getText();
		String adress = txtClientAdress.getText();
		String phone = txtClientPhone.getText();
		String observations = txtClientObservations.getText();

		if (!names.equals(empty) && !surnames.equals(empty) && !id.equals(empty) && !adress.equals(empty)
				&& !phone.equals(empty) && !observations.equals(empty)) {
			createClient(names, surnames, id, adress, phone, observations, 1);
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error al guardar datos");
			dialog.setContentText("Todos los campos de texto deben ser llenados");
			dialog.show();
		}
	}

	

	// Method to go back from Add-User.fxml to login.fxml
	@FXML
	public void buttonLogIn(ActionEvent event) throws IOException {
		FXMLLoader loginScreen = new FXMLLoader(getClass().getResource("login.fxml"));
		loginScreen.setController(this);
		Parent changeToLogin = loginScreen.load();
		mainPaneRegister.getChildren().setAll(changeToLogin);
	}
	
	// Method to create an user with the Add-User.fxml form
	@FXML
	public void createUser(ActionEvent event) {
		String empty = "";
		String name = txtUserNames.getText();
		String lastName = txtUserSurnames.getText();
		String id = txtUserId.getText();
		String username = txtUserUsername.getText();
		String password = PfUserPassword.getText();

		if (!name.equals(empty) && !lastName.equals(empty) && !id.equals(empty) && !username.equals(empty)
				&& !password.equals(empty)) {
			createSystemUser(name, lastName, id, username, password);
			txtUserNames.setText("");
			txtUserSurnames.setText("");
			txtUserId.setText("");
			txtUserUsername.setText("");
			PfUserPassword.setText("");
			// labelUserMessage.setText("The user has been created");
		} else if (name.equals(empty) && lastName.equals(empty) && id.equals(empty) && username.equals(empty)
				&& password.equals(empty)) {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error al guardar datos");
			dialog.setContentText("Todos los campos de texto deben ser llenados");
			dialog.show();
		}
	}

	// Method to delete my User
	@FXML
	public void openDeleteMyUser(ActionEvent event) throws IOException {
		FXMLLoader deleteUser = new FXMLLoader(getClass().getResource("Delete-User.fxml"));
		deleteUser.setController(this);
		Parent rootUser = deleteUser.load();
		mainPane_OptionsWindow.getChildren().setAll(rootUser);
	}

	// Method from Delete-User-fxml to delete an User
	@FXML
	public void deleteUser(ActionEvent event) {
		String empty = "";
		String id = txtDeleteUserId.getText();
		if (!id.equals(empty)) {
			boolean found = restaurant.findUser(id);
			if (found == true) {
				try {
					restaurant.deleteUser(txtDeleteUserId.getText());
					restaurant.saveUsersData();
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Delete User");
					alert.setContentText("The user has been deleted");
					alert.showAndWait();
					txtDeleteUserId.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
					dialog.setTitle("Error guardar datos");
					dialog.show();
				}
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("El usuario no existe");
				dialog.setTitle("Error al eliminar usuario");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Ingrese la identificacion del usuario a eliminar");
			dialog.setTitle("Error al eliminar usuario");
			dialog.show();
		}
	}

	// Method to disable my User
	@FXML
	public void openDisableMyUser(ActionEvent event) throws IOException {
		FXMLLoader disableUser = new FXMLLoader(getClass().getResource("Disable-User.fxml"));
		disableUser.setController(this);
		Parent rootDisableUser = disableUser.load();
		mainPane_OptionsWindow.getChildren().setAll(rootDisableUser);
	}
	
	//button to diable an user
	@FXML
	public void disableMyUser(ActionEvent event) {
		if (!txtDisableMyUser.getText().isEmpty()) {
			SystemUser user = restaurant.returnUser(txtDisableMyUser.getText());

			if (user != null) {
				try {
					user.setCondition(Condition.INACTIVE);
					restaurant.saveUsersData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Tu usuario ha sido deshabilitado");
					dialog.setTitle("Usuario Deshabilitado");
					dialog.show();
					txtDisableMyUser.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del usuario");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este usuario no existe");
				dialog.setTitle("Error, usuario inexistente");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}
	}

	// Method to update my User
	@FXML
	public void openUpdateMyUser(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter your username:");
		dialog.showAndWait();

		SystemUser user = restaurant.returnUser(dialog.getEditor().getText());

		if (user != null) {
			FXMLLoader updateUser = new FXMLLoader(getClass().getResource("Update-User.fxml"));
			updateUser.setController(this);
			Parent rootIUpdateUser = updateUser.load();
			mainPane_OptionsWindow.getChildren().setAll(rootIUpdateUser);

			LabelSystemUserName.setText(user.getUserName());

			txtSystemUserNewname.setText(user.getNames());
			txtSystemUserNewLastname.setText(user.getSurNames());
			txtSystemUserNewId.setText(user.getIdNumber());
			txtSystemUserNewUsername.setText(user.getUserName());

		} else {
			Dialog<String> dialog1 = createDialog();
			dialog1.setContentText("No existe ningun usuario con este nombre de usuario");
			dialog1.setTitle("Error al cargar datos");
			dialog1.show();
		}

	}

	//Update my user option to the user who has login
	@FXML
	public void updateMyUser(ActionEvent event) {
		SystemUser userToUpdate = restaurant.returnUser(LabelSystemUserName.getText());
		String name = txtSystemUserNewname.getText();
		String lastName = txtSystemUserNewLastname.getText();
		String id = txtSystemUserNewId.getText();
		String username = txtSystemUserNewUsername.getText();

		if (!name.equals("") && !lastName.equals("") && !id.equals("") && !username.equals("")) {

			try {
				userToUpdate.setNames(name);
				userToUpdate.setSurNames(lastName);
				userToUpdate.setIdNumber(id);
				userToUpdate.setUsername(username);
				userToUpdate.setPassword(passwordSystemUserNewPassword.getText());
				restaurant.saveUsersData();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Usuario actualizado satisfactoriamente");
				dialog.setTitle("Proceso Satisfactorio");
				dialog.show();

				txtSystemUserNewname.setText("");
				txtSystemUserNewLastname.setText("");
				txtSystemUserNewId.setText("");
				txtSystemUserNewUsername.setText("");
				passwordSystemUserNewPassword.setText("");
			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n del usuario");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

			try {
				FXMLLoader opWindow = new FXMLLoader(getClass().getResource("Options-window.fxml"));
				opWindow.setController(this);
				Parent opPane = opWindow.load();
				mainPaneLogin.getChildren().setAll(opPane);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}
	}



	// Method from Delete-Client.fxml to delete a Client
	@FXML
	public void deleteClient(ActionEvent event) {
		String empty = "";
		String id = txtDeleteClientId.getText();
		if (!id.equals(empty)) {
			boolean found = restaurant.findClient(id);
			if (found == true) {
				try {
					restaurant.deleteClient(id);
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Confirmation Dialog");
					alert.setHeaderText("Delete Client");
					alert.setContentText("The client has been deleted");
					alert.showAndWait();
					txtDeleteClientId.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
					dialog.setTitle("Error guardar datos");
					dialog.show();
				}
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("El Cliente no existe");
				dialog.setTitle("Error al eliminar cliente");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Ingrese la identificacion del cliente a eliminar");
			dialog.setTitle("Error al eliminar cliente");
			dialog.show();
		}
	}



	// Method to open the register form (Add-User.fxml)
	@FXML
	public void buttonSingUp(ActionEvent event) throws IOException {
		FXMLLoader addUserfxml = new FXMLLoader(getClass().getResource("Add-User.fxml"));
		addUserfxml.setController(this);
		Parent addUser = addUserfxml.load();
		mainPaneLogin.getChildren().setAll(addUser);
	}
	
	// Method to sign up as the ADMINISTRATOR
	@FXML
	public void buttonSignUpAdministrator(ActionEvent event) throws IOException {
		FXMLLoader addUserfxml = new FXMLLoader(getClass().getResource("Add-User.fxml"));
		addUserfxml.setController(this);
		Parent addUser = addUserfxml.load();
		mainPaneLogin.getChildren().setAll(addUser);

		txtUserUsername.setText("ADMINISTRATOR");
		txtUserUsername.setEditable(false);
	}

//METHODS TO OPEN SCREENS
	public void buttonSingIn(ActionEvent event) throws IOException {

		if (!txtSystemUserUsername.getText().equals("") && !passFieldSystemUserPassword.getText().equals("")) {

			String username = txtSystemUserUsername.getText();
			String password = passFieldSystemUserPassword.getText();

			boolean openWindow = restaurant.logInUser(username, password);
			boolean active = restaurant.conditionUser(username, password);

			if (openWindow == true && active == true) {
				if (username.equals("ADMINISTRATOR")) {
					FXMLLoader optionsFxml = new FXMLLoader(
							getClass().getResource("Administrator-Options-window.fxml"));
					optionsFxml.setController(this);
					Parent opWindow = optionsFxml.load();
					mainPaneLogin.getChildren().setAll(opWindow);

				} else {
					FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Options-window.fxml"));
					optionsFxml.setController(this);
					Parent opWindow = optionsFxml.load();
					mainPaneLogin.getChildren().setAll(opWindow);

				}
				setEmpleadoUsername(username);
				ingredientsOptions.clear();
				ingredientsOptions.addAll(restaurant.getStringIngredients());
				typeOptions.clear();
				typeOptions.addAll(restaurant.getStringProductTypes());
				productOptions.clear();
				productOptions.addAll(restaurant.getStringReferencedIdsProducts());

			} else {

				Dialog<String> dialog = createDialog();
				dialog.setContentText(
						"Este usuario no ha sido encontrado y/o se encuentra inactivo. Si desea crear uno ingrese a sign up o active su usuario");
				dialog.setTitle("Usuario no encontrado");
				dialog.show();

			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al cargar datos");
			dialog.show();
		}

	}
	
	@FXML
	public void opeeSeeClients(ActionEvent event) throws IOException {
		FXMLLoader clientsList = new FXMLLoader(getClass().getResource("clients-List.fxml"));
		clientsList.setController(this);
		Parent rootClientList = clientsList.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootClientList);

		initializeClientTableViewAdm();
	}

	@FXML
	public void openAddClient(ActionEvent event) throws IOException {
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
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter the id of the client:");
		dialog.showAndWait();

		Client clientToUpdate = restaurant.returnClientId(dialog.getEditor().getText());

		if (clientToUpdate != null) {
			FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-Client.fxml"));
			updateClientFxml.setController(this);
			Parent root = updateClientFxml.load();
			mainPane_OptionsWindow.getChildren().setAll(root);

			LabelUpdateClientName.setText(clientToUpdate.getNames());
			txtUpdateClientNames.setText(clientToUpdate.getNames());
			txtUpdateClientSurnames.setText(clientToUpdate.getSurnames());
			txtUpdateClientPhone.setText(clientToUpdate.getPhoneNumber());
			txtUpdateClientAdress.setText(clientToUpdate.getAdress());
			txtUpdateClientId.setText(clientToUpdate.getIdNumber());
			txtUpdateClientObservations.setText(clientToUpdate.getObservations());
		} else {
			Dialog<String> dialog1 = createDialog();
			dialog1.setContentText("No existe ningun cliente con este nombre");
			dialog1.setTitle("Error al cargar datos");
			dialog1.show();
		}

	}

	@FXML
	public void openDisableClient(ActionEvent event) throws IOException {
		FXMLLoader disableClientFxml = new FXMLLoader(getClass().getResource("Disable-Client.fxml"));
		disableClientFxml.setController(this);
		Parent root = disableClientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}
	
	@FXML
	public void openSeeProducts(ActionEvent event) throws IOException {
		FXMLLoader productList = new FXMLLoader(getClass().getResource("product-List.fxml"));
		productList.setController(this);
		Parent rootProductList = productList.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootProductList);

		initializeProductTableViewAdm();
	}

	@FXML
	public void openSearchClient(ActionEvent event) throws IOException {
		FXMLLoader findClientBS = new FXMLLoader(getClass().getResource("Client-BinarySearch.fxml"));
		findClientBS.setController(this);
		Parent root = findClientBS.load();
		mainPane_OptionsWindow.getChildren().setAll(root);

		FXMLLoader searchClient = new FXMLLoader(getClass().getResource("findClient-BinarySearch.fxml"));
		searchClient.setController(this);
		Parent searchClientBS = searchClient.load();
		paneBinarySearch.getChildren().setAll(searchClientBS);
	}

	@FXML
	public void openAddIngredient(ActionEvent event) throws IOException {
		FXMLLoader addIngredientFxml = new FXMLLoader(getClass().getResource("create-ingredient.fxml"));
		addIngredientFxml.setController(this);
		Parent root = addIngredientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDeleteIngredient(ActionEvent event) throws IOException {
		FXMLLoader deleteIngredientFxml = new FXMLLoader(getClass().getResource("Delete-Ingredient.fxml"));
		deleteIngredientFxml.setController(this);
		Parent root = deleteIngredientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openUpdateIngredient(ActionEvent event) throws IOException {
		FXMLLoader updateIngredient = new FXMLLoader(getClass().getResource("update-ingredient.fxml"));
		updateIngredient.setController(this);
		Parent root = updateIngredient.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}
	
	@FXML
	public void openSeeProductTypes(ActionEvent event) throws IOException {
		FXMLLoader productTypeList = new FXMLLoader(getClass().getResource("productType-List.fxml"));
		productTypeList.setController(this);
		Parent rootTypeList = productTypeList.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootTypeList);

		initializeProductTypeTableViewAdm();

	}

	@FXML
	public void openDisableIngredient(ActionEvent event) throws IOException {
		FXMLLoader disableIngredientFxml = new FXMLLoader(getClass().getResource("Disable-Ingredient.fxml"));
		disableIngredientFxml.setController(this);
		Parent root = disableIngredientFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openAddProduct(ActionEvent event) throws IOException {
		FXMLLoader addProductFxml = new FXMLLoader(getClass().getResource("create-Product.fxml"));
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
	public void openUpdateProduct(ActionEvent event) throws IOException {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("Look, a Text Input Dialog");
		dialog.setContentText("Please enter the name of the product:");
		dialog.showAndWait();

		Product productToUpdate = restaurant.returnProduct(dialog.getEditor().getText());

		if (productToUpdate != null) {
			FXMLLoader updateProductFxml = new FXMLLoader(getClass().getResource("Update-Product.fxml"));
			updateProductFxml.setController(this);
			Parent root = updateProductFxml.load();
			mainPane_OptionsWindow.getChildren().setAll(root);

			selectedIngredients.clear();

			initializeComboUpdateSize();
			initializeComboUpdateType();
			initializeChoiceUpdateIngredients();
			LabelProductName.setText(productToUpdate.getName());
			txtUpdateProductName.setText(productToUpdate.getName());
			txtUpdateProductPrice.setText(productToUpdate.getPrice());
			selectedIngredients.clear();
			ComboUpdateSize.setValue(productToUpdate.getSize());
			ComboUpdateType.setValue(productToUpdate.getType().getName());
		} else {
			Dialog<String> dialog1 = createDialog();
			dialog1.setContentText("No existe ningun producto con este nombre");
			dialog1.setTitle("Error al cargar datos");
			dialog1.show();
		}

	}

	@FXML
	public void openDisableProduct(ActionEvent event) throws IOException {
		FXMLLoader disableProductFxml = new FXMLLoader(getClass().getResource("Disable-Product.fxml"));
		disableProductFxml.setController(this);
		Parent root = disableProductFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openAddProductType(ActionEvent event) throws IOException {
		FXMLLoader addTypeFxml = new FXMLLoader(getClass().getResource("create-productType.fxml"));
		addTypeFxml.setController(this);
		Parent root = addTypeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDeleteProductType(ActionEvent event) throws IOException {
		FXMLLoader deleteProductTypeFxml = new FXMLLoader(getClass().getResource("Delete-ProductType.fxml"));
		deleteProductTypeFxml.setController(this);
		Parent root = deleteProductTypeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openUpdateProductType(ActionEvent event) throws IOException {
		FXMLLoader updateProductType = new FXMLLoader(getClass().getResource("update-productType.fxml"));
		updateProductType.setController(this);
		Parent root = updateProductType.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDisableProductType(ActionEvent event) throws IOException {
		FXMLLoader disableProductTypeFxml = new FXMLLoader(getClass().getResource("Disable-ProductType.fxml"));
		disableProductTypeFxml.setController(this);
		Parent root = disableProductTypeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openLoginScreenUser(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("login.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();
		paneToComeBackToLogin.getChildren().setAll(rootLogin);
	}

	@FXML
	public void openUserSeeClients(ActionEvent event) throws IOException {
		FXMLLoader clientsList = new FXMLLoader(getClass().getResource("clients-List.fxml"));
		clientsList.setController(this);
		Parent rootClientList = clientsList.load();
		mainPane_OptionsWindow.getChildren().setAll(rootClientList);

		initializeUserClientTableView();
	}
	
	@FXML
	public void openUserSeeIngredients(ActionEvent event) throws IOException {
		FXMLLoader ingredientsList = new FXMLLoader(getClass().getResource("ingredient-List.fxml"));
		ingredientsList.setController(this);
		Parent rootIngredientsList = ingredientsList.load();
		mainPane_OptionsWindow.getChildren().setAll(rootIngredientsList);

		initializeUserIngredientsTableView();
	}

	@FXML
	public void openUserSeeOrders(ActionEvent event) throws IOException {
		FXMLLoader ordersList = new FXMLLoader(getClass().getResource("orders-List.fxml"));
		ordersList.setController(this);
		Parent rootOrdersList = ordersList.load();
		mainPane_OptionsWindow.getChildren().setAll(rootOrdersList);

		initializeUserOrdersTableView();
	}
	
	@FXML
	public void openUserSeeProductTypes(ActionEvent event) throws IOException {
		FXMLLoader productsList = new FXMLLoader(getClass().getResource("productType-List.fxml"));
		productsList.setController(this);
		Parent rootProductsList = productsList.load();
		mainPane_OptionsWindow.getChildren().setAll(rootProductsList);

		initializeUserProductTypeTableView();
	}

	@FXML
	public void openUserSeeProducts(ActionEvent event) throws IOException {
		FXMLLoader productList = new FXMLLoader(getClass().getResource("product-List.fxml"));
		productList.setController(this);
		Parent rootProductList = productList.load();
		mainPane_OptionsWindow.getChildren().setAll(rootProductList);

		initializeUsersProductTableView();

	}
	@FXML
	public void openfindClientBinarySearch(ActionEvent event) throws IOException {
		FXMLLoader searchClient = new FXMLLoader(getClass().getResource("findClient-BinarySearch.fxml"));
		searchClient.setController(this);
		Parent searchClientBS = searchClient.load();
		paneBinarySearch.getChildren().setAll(searchClientBS);
	}

	@FXML
	public void openBinarySearchFindClient(ActionEvent event) throws IOException {
		String empty = "";
		if (!txtSearchClient.getText().equals(empty)) {
			long start = System.nanoTime();
			Client findClient = restaurant.clientBinarySearch(txtSearchClient.getText());
			long end = System.nanoTime();

			if (findClient != null) {
				FXMLLoader searchClient = new FXMLLoader(getClass().getResource("infoClient-binarySearch.fxml"));
				searchClient.setController(this);
				Parent searchClientBS = searchClient.load();
				paneBinarySearch.getChildren().setAll(searchClientBS);

				labelClientNameBS.setText(findClient.getNames());
				labelClientLastNameBS.setText(findClient.getSurnames());
				labelClientIdBS.setText(findClient.getIdNumber());
				labelClientAdressBS.setText(findClient.getAdress());
				labelClientPhoneBS.setText(findClient.getPhoneNumber());
				labelClientConditionBS.setText(findClient.getCondition().name());
				labelClientObservations.setText(findClient.getObservations());
				labelBinarySearchTime.setText("Cliente encontrado en " + (end - start) + " nanosegundos");
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setTitle("Error");
				dialog.setContentText("El Cliente no existe");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error");
			dialog.setContentText("Debes ingresar el nombre del Cliente");
			dialog.show();
		}

	}
	
	@FXML
	public void openCreateSize(ActionEvent event) throws IOException {
		FXMLLoader createSizeFxml = new FXMLLoader(getClass().getResource("create-Size.fxml"));
		createSizeFxml.setController(this);
		Parent rootTypeList = createSizeFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(rootTypeList);
	}

	
	
//Method to initialize the values in Clients Tableview in user screen
	public void initializeUserClientTableView() {
		ObservableList<Client> clientsList = FXCollections.observableArrayList(restaurant.getClients());

		columnClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("names"));
		columnClientLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("surnames"));
		columnClientID.setCellValueFactory(new PropertyValueFactory<Client, String>("idNumber"));
		columnClientAdress.setCellValueFactory(new PropertyValueFactory<Client, String>("adress"));
		columnClientPhoneNumber.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
		columnClientObservations.setCellValueFactory(new PropertyValueFactory<Client, String>("observations"));
		columnClientCondition.setCellValueFactory(new PropertyValueFactory<Client, Condition>("condition"));

		tableViewClientsList.setItems(clientsList);

		tableViewClientsList.setRowFactory(tv -> {
			TableRow<Client> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Client client = row.getItem();
					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-Client.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_OptionsWindow.getChildren().setAll(root);

						LabelUpdateClientName.setText(client.getNames());
						txtUpdateClientNames.setText(client.getNames());
						txtUpdateClientSurnames.setText(client.getSurnames());
						txtUpdateClientPhone.setText(client.getPhoneNumber());
						txtUpdateClientAdress.setText(client.getAdress());
						txtUpdateClientId.setText(client.getIdNumber());
						txtUpdateClientObservations.setText(client.getObservations());

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			return row;
		});
	}

//Method to initialize the orders table view in a user screen
	public void initializeUserOrdersTableView() {
		SystemUser user = restaurant.returnUser(txtSystemUserUsername.getText());
		
		ObservableList<Order> userOrder = FXCollections.observableArrayList(user.getOrders());
		ObservableList<Order> orders = FXCollections.observableArrayList();

		for (int i = 0; i < userOrder.size(); i++) {
			Order order = userOrder.get(i);

			if (order.getUser().getUserName().equals(empleadoUsername)) {
				orders.add(order);
			}
		}

		tableViewOrders.getItems().clear();

		columnOrderCode.setCellValueFactory(new PropertyValueFactory<Order, String>("code"));
		columnOrderState.setCellValueFactory(new PropertyValueFactory<Order, State>("state"));
		columnOrderEmployee.setCellValueFactory(new PropertyValueFactory<Order, String>("employeeName"));
		columnOrderClient.setCellValueFactory(new PropertyValueFactory<Order, String>("clientName"));
		columnOrderProducts.setCellValueFactory(new PropertyValueFactory<Order, String>("products"));
		columnOrderCant.setCellValueFactory(new PropertyValueFactory<Order, String>("stringQuantity"));
		columnOrderDate.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
		columnOrderHour.setCellValueFactory(new PropertyValueFactory<Order, String>("hour"));
		columnOrderObservations.setCellValueFactory(new PropertyValueFactory<Order, String>("observations"));
		

		tableViewOrders.setItems(orders);

		tableViewOrders.setRowFactory(tv -> {
			TableRow<Order> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Order order = row.getItem();
					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("update-OrderState.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_OptionsWindow.getChildren().setAll(root);

						labelOrderCode.setText(order.getCode());

						ObservableList<State> statesOrderUser; 
						if (order.getState().equals(State.REQUESTED)) {
							statesOrderUser = FXCollections.observableArrayList(State.IN_PROCESS);							
						}else if (order.getState().equals(State.IN_PROCESS)) {
							statesOrderUser = FXCollections.observableArrayList(State.SENT);							
						}else if (order.getState().equals(State.SENT)) {
							statesOrderUser = FXCollections.observableArrayList(State.DELIVERED);							
						}else {
							statesOrderUser = FXCollections.observableArrayList(State.DELIVERED);
						}

						initializeChoiceState(statesOrderUser);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			return row;
		});
	}


//Method to initialize the choiceBox choiceState 
	public void initializeChoiceState(ObservableList<State> statesOrderUser) {
		choiceState.setItems(statesOrderUser);
	}
	
	
//method to update the state of an order
	@FXML
	public void buttonUpdateOrderState(ActionEvent event) {
		boolean exit = false;
		State state = choiceState.getValue();
		SystemUser user = restaurant.returnUser(txtSystemUserUsername.getText());
		try {
			for (int i = 0; i < user.getOrders().size() && !exit; i++) {
				if (user.getOrders().get(i).getCode().equals(labelOrderCode.getText())) {
					user.getOrders().get(i).setState(state);
					exit = true;
				}
			}
			user.saveUsersOrdersData(user.getName());
			FXMLLoader ordersList = new FXMLLoader(getClass().getResource("Options-window.fxml"));
			ordersList.setController(this);
			Parent root = ordersList.load();
			mainPaneLogin.getChildren().setAll(root);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
//method of the button update productType
	@FXML
	public void updateProductType(ActionEvent event) {
		if (!txtProductTypeNewName.getText().equals("") && !txtProductTypeLastName.getText().equals("")) {
			ProductType pType = restaurant.returnProductType(txtProductTypeLastName.getText());

			if (pType != null) {
				try {
					pType.setName(txtProductTypeNewName.getText());
					restaurant.saveProductTypeData();
					restaurant.updateTypeOfProduct(txtProductTypeLastName.getText(), txtProductTypeNewName.getText());
					typeOptions.clear();
					typeOptions.addAll(restaurant.getStringProductTypes());
					pType.setEditedByUser(restaurant.returnUser(empleadoUsername));
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Ingrediente actualizado satisfactoriamente");
					dialog.setTitle("Proceso Satisfactorio");
					dialog.show();

					txtProductTypeLastName.setText("");
					txtProductTypeNewName.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
					dialog.setTitle("Error al guardar datos");
					dialog.show();

				}
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setTitle("Error");
				dialog.setContentText("El tipo de producto " + txtProductTypeLastName.getText() + " no existe");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error");
			dialog.setContentText("Debes ingresar el antiguo y nuevo nombre del tipo de producto");
			dialog.show();
		}

	}

//method of the button updateIngredient
	@FXML
	public void updateIngredient(ActionEvent event) {
		String empty = "";
		if (!txtIngredientLastName.getText().equals(empty) && !txtIngredientNewName.getText().equals(empty)) {
			Ingredient ingredient = restaurant.returnIngredient(txtIngredientLastName.getText());

			if (ingredient != null) {

				try {
					ingredient.setName(txtIngredientNewName.getText());
					restaurant.saveIngredientsData();
					restaurant.updateIngredientOfProduct(txtIngredientLastName.getText(),
							txtIngredientNewName.getText());
					ingredientsOptions.clear();
					ingredientsOptions.addAll(restaurant.getStringIngredients());
					ingredient.setEditedByUser(restaurant.returnUser(empleadoUsername));
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Ingrediente actualizado satisfactoriamente");
					dialog.setTitle("Proceso Satisfactorio");
					dialog.show();

					txtIngredientLastName.setText("");
					txtIngredientNewName.setText("");

				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setTitle("Error");
				dialog.setContentText("El ingrediente " + txtIngredientLastName.getText() + " no existe");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error");
			dialog.setContentText("Debes ingresar el antiguo y nuevo nombre del ingrediente");
			dialog.show();
		}

	}

//Method of the button delete a productType
	@FXML
	public void deleteProductType(ActionEvent event) {
		if (!txtDeleteProductTypeName.getText().equals("")) {
			try {
				boolean remove = restaurant.deleteproductType(txtDeleteProductTypeName.getText());
				if (remove == true) {
					typeOptions.remove(txtDeleteProductTypeName.getText());
					txtDeleteProductTypeName.setText("");
				}
			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
				dialog.setTitle("Error guardar datos");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Los campos deben ser llenados");
			dialog.setTitle("Error, Campo sin datos");
			dialog.show();
		}

	}

	
//method of the button deleteIngredient
	@FXML
	public void deleteIngredient(ActionEvent event) {
		if (!txtDeleteIngredientName.getText().equals("")) {
			try {
				boolean delete = restaurant.deleteIngredient(txtDeleteIngredientName.getText());
				if (delete == true) {
					ingredientsOptions.remove(txtDeleteIngredientName.getText());
					txtDeleteIngredientName.setText("");
				}
			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
				dialog.setTitle("Error guardar datos");
				dialog.show();
			}

		} else {
			txtDeleteIngredientName.setText(null);
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Los campos deben ser llenados");
			dialog.setTitle("Error, Campo sin datos");
			dialog.show();
		}
	}

	
//Method of the button create ingredient
	@FXML
	public void buttonCreateIngredient(ActionEvent event) {
		String empty = "";
		String ingredientName = txtIngredientName.getText();
		Ingredient ingredient = restaurant.returnIngredient(ingredientName);

		if (ingredient == null) {
			if (!ingredientName.equals(empty)) {
				Ingredient objIngredient = new Ingredient(ingredientName);
				try {
					boolean found = restaurant.addIngredient(objIngredient);
					Ingredient ingredientAdded = restaurant.returnIngredient(ingredientName);// returns the ingredient
																								// already added
					if (found == false) {
						ingredientsOptions.add(ingredientName);
						ingredientAdded.setCreatedByUser(restaurant.returnUser(empleadoUsername));
						ingredientAdded.setEditedByUser(restaurant.returnUser(empleadoUsername));
						txtIngredientName.setText("");

						Dialog<String> dialog = createDialog();
						dialog.setContentText("El ingrediente " + objIngredient.getName()
								+ " ha sido a�adido a la lista de ingredientes del restaurante");
						dialog.setTitle("Ingrediente a�adido");
						dialog.show();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}

				/*
				 * restaurant.getIngredients().add(objIngredient);
				 * ingredientsOptions.add(ingredientName); txtIngredientName.setText("");
				 * 
				 * Dialog<String> dialog=createDialog();
				 * dialog.setContentText("El ingrediente "+objIngredient.getName()
				 * +" ha sido a�adido a la lista de ingredientes del restaurante");
				 * dialog.setTitle("Ingrediente a�adido"); dialog.show();
				 */
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("El ingrediente a crear debe tener un nombre ");
				dialog.setTitle("Error, Campo sin datos");
				dialog.show();

			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("El ingrediente ya existe");
			dialog.setTitle("Error, Ingrediente existente");
			dialog.show();
			txtIngredientName.setText("");
		}
	}

//Method of the button delete product
	@FXML
	public void deleteProduct(ActionEvent event) {
		if (!txtDeleteProductName.getText().equals("")) {
			try {

				List<Product> productToDelete = restaurant.findSameProduct(txtDeleteProductName.getText());
				boolean delete = restaurant.deleteProduct(txtDeleteProductName.getText());
				if (delete == true) {
					for (int i = 0; i < productOptions.size(); i++) {
						for (int j = 0; j < productToDelete.size(); j++) {
							if (productOptions.get(i) != null && productOptions.get(i)
									.equalsIgnoreCase(productToDelete.get(j).getReferenceId())) {
								productOptions.remove(productToDelete.get(j).getReferenceId());
							}
						}
					}
				}

				txtDeleteProductName.setText("");

			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los productos");
				dialog.setTitle("Error guardar datos");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Los campos deben ser llenados");
			dialog.setTitle("Error, Campo sin datos");
			dialog.show();
		}
	}

//Method of the button create a new size
	@FXML
	public void buttonCreateSize(ActionEvent event) {
		String name = txtCreateSizeName.getText();
		if (!txtCreateSizeName.getText().equals("")) {
			String size = restaurant.returnSize(name);
			if (size == null) {

				try {
					restaurant.getSizes().add(name);
					restaurant.saveSizesData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Tama�o creado satisfactoriamente");
					dialog.setTitle("Tama�o creado");
					dialog.show();
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar el nuevo tama�o");
					dialog.setTitle("Error guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este tama�o ya existe");
				dialog.setTitle("Error, tama�o existente");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Los campos deben ser llenados");
			dialog.setTitle("Error, Campo sin datos");
			dialog.show();
		}
		txtCreateSizeName.setText("");
	}

//Method of the button create productType
	@FXML
	public void buttonCreateProductType(ActionEvent event) {
		String empty = "";
		String name = txtProductTypeName.getText();
		if (!name.equals(empty)) {
			ProductType obj = new ProductType(txtProductTypeName.getText());
			try {
				boolean found = restaurant.addProductType(obj, empleadoUsername); // Se a�ade a la lista de tipos de
																					// producto DEL RESTAURANTE
				if (found == false) {
					typeOptions.add(name);// Se a�ade a la lista de tipos de producto para ser mostrada en los combobox
				}
				txtProductTypeName.setText("");
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("El tipo de producto a crear debe tener un nombre ");
			dialog.setTitle("Error, Campo sin datos");
			dialog.show();

		}
	}

//Method of the button update Client
	@FXML
	public void UpdateClient(ActionEvent event) {
		Client clientToUpdate = restaurant.returnClient(LabelUpdateClientName.getText());
		if (!txtUpdateClientNames.getText().equals("") && !txtUpdateClientSurnames.getText().equals("")
				&& !txtUpdateClientAdress.getText().equals("") && !txtUpdateClientPhone.getText().equals("")
				&& !txtUpdateClientObservations.getText().equals("") && !txtUpdateClientId.getText().equals("")) {

			try {
				clientToUpdate.setNames(txtUpdateClientNames.getText());
				clientToUpdate.setSurnames(txtUpdateClientSurnames.getText());
				clientToUpdate.setAdress(txtUpdateClientAdress.getText());
				clientToUpdate.setPhoneNumber(txtUpdateClientPhone.getText());
				clientToUpdate.setObservations(txtUpdateClientObservations.getText());
				clientToUpdate.setIdNumber(txtUpdateClientId.getText());

				restaurant.saveClientsData();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Cliente actualizado satisfactoriamente");
				dialog.setTitle("Proceso Satisfactorio");
				dialog.show();

				txtUpdateClientNames.setText("");
				txtUpdateClientSurnames.setText("");
				txtUpdateClientAdress.setText("");
				txtUpdateClientPhone.setText("");
				txtUpdateClientObservations.setText("");
				txtUpdateClientId.setText("");
			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

			try {
				FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Options-window.fxml"));
				optionsFxml.setController(this);
				Parent opWindow = optionsFxml.load();
				mainPaneLogin.getChildren().setAll(opWindow);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

// Method of the Button add Ingredient to Product
	@FXML
	public void addIngredientToProduct(ActionEvent event) {
		Ingredient ingredient = restaurant.returnIngredient(ChoiceIngredients.getValue());
		boolean ingredientExists = false;

		for (int i = 0; i < selectedIngredients.size() && ingredientExists == false; i++) {
			if (selectedIngredients.get(i).equalsIgnoreCase(ChoiceIngredients.getValue())) {
				ingredientExists = true;
			}
		}
		if (ingredientExists == false) {
			if (ChoiceIngredients.getValue() != null) {
				if (ingredient.getCondition() == Condition.ACTIVE) {
					selectedIngredients.add(ChoiceIngredients.getValue());
					Dialog<String> dialog = createDialog();
					dialog.setContentText(
							"Ingrediente " + ChoiceIngredients.getValue() + " ha sido a�adido al producto");
					dialog.setTitle("Adicion de Ingrediente satisfactoria");
					dialog.show();
				} else {
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El ingrediente ha sido deshabilitado por lo que no puede ser utilizado");
					dialog.setTitle("Error, ingrediente Deshabilitado");
					dialog.show();
				}
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Debe escoger algun ingrediente para que pueda ser a�adido");
				dialog.setTitle("Campo requerido");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("El ingrediente con el nombre " + ChoiceIngredients.getValue() + " ya existe");
			dialog.setTitle("Error, Ingrediente existente");
			dialog.show();
		}

	}

//Method of the button to create a product
	@FXML
	public void createProduct(ActionEvent event) {
		if (!txtProductName.getText().equals("") && !txtProductPrice.getText().equals("")
				&& ComboSize.getValue() != null && ComboType.getValue() != null && selectedIngredients.size() != 0) {

			Product objProduct = new Product(txtProductName.getText(), ComboSize.getValue(), txtProductPrice.getText(),
					ComboType.getValue(), selectedIngredients);

			try {
				restaurant.addProduct(objProduct, empleadoUsername);

				txtProductName.setText(null);
				txtProductPrice.setText(null);
				ComboSize.setValue(null);
				ComboType.setValue(null);
				ChoiceIngredients.setValue(null);
				selectedIngredients.clear();
				productOptions.clear();
				productOptions.addAll(restaurant.getStringReferencedIdsProducts());

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar los datos");
			dialog.show();
		}

	}
	
	/*
	The next 3 method are the initialization of combobox and choiceBox, when a
	Type of product is created the combotype add a new value and the same occurs
	with ChoiceBox of ingredients
	*/
	
	public void initializeComboSize() {
		sizeOptions.clear();
		for (int i = 0; i < restaurant.getSizes().size(); i++) {
			if (restaurant.getSizes().get(i) != null) {
				sizeOptions.add(restaurant.getSizes().get(i));
			}
		}
		ComboSize.setItems(sizeOptions);
	}

	public void initializeComboType() {
		Collections.sort(typeOptions);
		ComboType.setItems(typeOptions);
	}

	public void initializeChoiceIngredient() {
		Collections.sort(ingredientsOptions);
		ChoiceIngredients.setItems(ingredientsOptions);
	}
	

//Method to add an ingredient to the product ingredients List
	@FXML
	public void addUpdateIngredientToProduct(ActionEvent event) {
		if (ChoiceUpdateIngredients.getValue() != null) {
			selectedIngredients.add(ChoiceUpdateIngredients.getValue());
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Ingrediente " + ChoiceUpdateIngredients.getValue() + " ha sido a�adido al producto");
			dialog.setTitle("Adicion de Ingrediente satisfactoria");
			dialog.show();
			ChoiceUpdateIngredients.setValue(null);
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Debe escoger algun ingrediente para que pueda ser a�adido");
			dialog.setTitle("Campo requerido");
			dialog.show();
		}
	}

//Method of the button update a Product
	@FXML
	public void updateProduct(ActionEvent event) {
		Product productToUpdate = restaurant.returnProduct(LabelProductName.getText());
		if (!txtUpdateProductName.getText().equals("") && !txtUpdateProductPrice.getText().equals("")
				&& selectedIngredients.isEmpty() == false) {

			try {
				productToUpdate.setName(txtUpdateProductName.getText());
				productToUpdate.setPrice(txtUpdateProductPrice.getText());
				productToUpdate.setSize(ComboUpdateSize.getValue());
				productToUpdate.setType(toProductType(ComboUpdateType.getValue()));
				productToUpdate.setIngredients(toIngredient(selectedIngredients));

				productToUpdate.setEditedByUser(restaurant.returnUser(empleadoUsername));

				restaurant.saveProductsData();
				productOptions.clear();
				productOptions.addAll(restaurant.getStringReferencedIdsProducts());
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Producto actualizado satisfactoriamente");
				dialog.setTitle("Proceso Satisfactorio");
				dialog.show();

				txtUpdateProductName.setText("");
				txtUpdateProductPrice.setText("");
				ComboUpdateSize.setValue("");
				ComboUpdateType.setValue("");
				ChoiceUpdateIngredients.setValue("");
				LabelProductName.setText("");

			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los productos");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

			try {
				FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Options-window.fxml"));
				optionsFxml.setController(this);
				Parent opWindow = optionsFxml.load();
				mainPaneLogin.getChildren().setAll(opWindow);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

	public void initializeComboUpdateSize() {
		sizeOptions.clear();
		sizeOptions.addAll(restaurant.getSizes());
		ComboUpdateSize.setItems(sizeOptions);
	}

	public void initializeComboUpdateType() {
		typeOptions.clear();
		typeOptions.addAll(restaurant.getStringProductTypes());
		ComboUpdateType.setItems(typeOptions);
	}

	public void initializeChoiceUpdateIngredients() {
		ingredientsOptions.clear();
		ingredientsOptions.addAll(restaurant.getStringIngredients());
		ChoiceUpdateIngredients.setItems(ingredientsOptions);
	}

//converts a productName to a productType
	public ProductType toProductType(String name) {
		ProductType productType = new ProductType(name);
		return productType;
	}

//converts a list of ingredients names to a list of type Ingredient
	public List<Ingredient> toIngredient(List<String> ingredientsList) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		for (int i = 0; i < ingredientsList.size(); i++) {
			ingredients.add(new Ingredient(ingredientsList.get(i)));
		}
		return ingredients;
	}

//Method of the button disable a product 
	@FXML
	public void disableProduct(ActionEvent event) {
		if (!txtNameDisableProduct.getText().equals("")) {
			List<Product> searchedProducts = restaurant.findSameProduct(txtNameDisableProduct.getText());
			if (!searchedProducts.isEmpty()) {
				try {
					for (int i = 0; i < searchedProducts.size(); i++) {
						searchedProducts.get(i).setCondition(Condition.INACTIVE);
					}
					restaurant.saveProductsData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El producto ha sido deshabilitado");
					dialog.setTitle("Producto Deshabilitado");
					dialog.show();
					txtNameDisableProduct.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los productos");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este Producto no existe");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Debe ingresar el nombre del producto");
			dialog.setTitle("Error");
			dialog.show();
		}

	}

//Method of the button disable an ingredient
	@FXML
	public void disableIngredient(ActionEvent event) {
		if (!txtNameDisableIngredient.getText().isEmpty()) {
			Ingredient ingredient = restaurant.returnIngredient(txtNameDisableIngredient.getText());
			if (ingredient != null) {

				try {
					ingredient.setCondition(Condition.INACTIVE);
					restaurant.saveIngredientsData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El ingrediente ha sido deshabilitado");
					dialog.setTitle("Ingrediente Deshabilitado");
					dialog.show();
					txtNameDisableIngredient.setText(null);
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del Ingrediente");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este Ingrediente no existe");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

//method of the button enable an ingredient
	@FXML
	public void enableIngredient(ActionEvent event) {
		if (!txtNameDisableIngredient.getText().isEmpty()) {
			Ingredient ingredient = restaurant.returnIngredient(txtNameDisableIngredient.getText());
			if (ingredient != null) {

				try {
					ingredient.setCondition(Condition.ACTIVE);
					restaurant.saveIngredientsData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El ingrediente ha sido habilitado");
					dialog.setTitle("Ingrediente Habilitado");
					dialog.show();
					txtNameDisableIngredient.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del Ingrediente");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este Ingrediente no existe");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

//method of the button enable my user
	@FXML
	public void enableMyUser(ActionEvent event) {
		if (!txtDisableMyUser.getText().isEmpty()) {
			SystemUser user = restaurant.returnUser(txtDisableMyUser.getText());

			if (user != null) {
				try {
					user.setCondition(Condition.ACTIVE);
					restaurant.saveUsersData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Tu usuario ha sido habilitado");
					dialog.setTitle("Usuario Deshabilitado");
					dialog.show();
					txtDisableMyUser.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del usuario");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este usuario no existe");
				dialog.setTitle("Error, usuario inexistente");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}
	}

//Method of the button disable a productType
	@FXML
	public void disableType(ActionEvent event) {
		if (!txtNameDisableProductType.getText().equals("")) {
			ProductType productType = restaurant.returnProductType(txtNameDisableProductType.getText());
			if (productType != null) {
				try {
					productType.setCondition(Condition.INACTIVE);
					typeOptions.remove(productType.getName());
					restaurant.saveProductTypeData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El tipo de producto ha sido deshabilitado");
					dialog.setTitle("Tipo de producto Deshabilitado");
					dialog.show();
					txtNameDisableProductType.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del tipo de producto");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este tipo de producto no existe");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}
	}

//Method of the button to enable a productType
	@FXML
	public void enableType(ActionEvent event) {
		// boolean typeExists=false;
		if (!txtNameDisableProductType.getText().isEmpty()) {
			ProductType productType = restaurant.returnProductType(txtNameDisableProductType.getText());
			if (productType != null) {

				try {
					productType.setCondition(Condition.ACTIVE);
					restaurant.saveProductTypeData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El tipo de producto ha sido habilitado");
					dialog.setTitle("Tipo de producto habilitado");
					dialog.show();
					txtNameDisableProductType.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del tipo de producto");
					dialog.setTitle("Error al guardar datos");
					dialog.show();

				}

				/*
				 * for(int i=0;i<typeOptions.size() && !typeExists;i++) {
				 * if(typeOptions.get(i).equals(productType.getName())) typeExists=true; }
				 * 
				 * if (typeExists==false) { typeOptions.add(productType.getName()); }
				 */

			} else {
				typeOptions.add(txtNameDisableProductType.getText());
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este tipo de producto no existe. Ha sido a�adido");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}
		}

		else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

//Method of the button to disable a Client
	@FXML
	public void disableClient(ActionEvent event) {
		if (!txtIdDisableClient.getText().equals("")) {
			Client client = restaurant.returnClientId(txtIdDisableClient.getText());

			if (client != null) {

				try {
					client.setCondition(Condition.INACTIVE);
					restaurant.saveClientsData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El cliente ha sido deshabilitado");
					dialog.setTitle("Cliente Deshabilitado");
					dialog.show();
					txtIdDisableClient.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del Cliente");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este cliente no existe");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

//Method of the button to enable a Client
	@FXML
	public void enableClient(ActionEvent event) {
		if (!txtIdDisableClient.getText().isEmpty()) {
			Client client = restaurant.returnClientId(txtIdDisableClient.getText());
			if (client != null) {
				try {
					client.setCondition(Condition.ACTIVE);
					restaurant.saveClientsData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El cliente ha sido habilitado");
					dialog.setTitle("Cliente habilitado");
					dialog.show();
					txtIdDisableClient.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se ha podido guardar el nuevo estado del Cliente");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este cliente no existe");
				dialog.setTitle("Error, objeto no existente");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

//Method of the button to enable a product
	@FXML
	public void enableProduct(ActionEvent event) {
		if (!txtNameDisableProduct.getText().equals("")) {
			List<Product> searchedProducts = restaurant.findSameProduct(txtNameDisableProduct.getText());
			if (!searchedProducts.isEmpty()) {
				try {
					for (int i = 0; i < searchedProducts.size(); i++) {
						searchedProducts.get(i).setCondition(Condition.ACTIVE);
					}
					restaurant.saveProductsData();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("El producto ha sido habilitado");
					dialog.setTitle("Producto Deshabilitado");
					dialog.show();
					txtNameDisableProduct.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los productos");
					dialog.setTitle("Error al guardar datos");
					dialog.show();

				}
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Este producto no existe");
				dialog.setTitle("Error");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Debe ingresar el nombre del producto");
			dialog.setTitle("Error");
			dialog.show();
		}

	}


//Method to initialize the table view of clients in ADMINISTRATOR
	public void initializeClientTableViewAdm() {
		ObservableList<Client> clientsList = FXCollections.observableArrayList(restaurant.getClients());

		columnClientName.setCellValueFactory(new PropertyValueFactory<Client, String>("names"));
		columnClientLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("surnames"));
		columnClientID.setCellValueFactory(new PropertyValueFactory<Client, String>("idNumber"));
		columnClientAdress.setCellValueFactory(new PropertyValueFactory<Client, String>("adress"));
		columnClientPhoneNumber.setCellValueFactory(new PropertyValueFactory<Client, String>("phoneNumber"));
		columnClientObservations.setCellValueFactory(new PropertyValueFactory<Client, String>("observations"));
		columnClientCondition.setCellValueFactory(new PropertyValueFactory<Client, Condition>("condition"));

		tableViewClientsList.setItems(clientsList);

		tableViewClientsList.setRowFactory(tv -> {
			TableRow<Client> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Client client = row.getItem();
					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-ClientAdm.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_AdministratorOptionsWindow.getChildren().setAll(root);

						LabelUpdateClientNameAdm.setText(client.getNames());
						txtUpdateClientNamesAdm.setText(client.getNames());
						txtUpdateClientSurnamesAdm.setText(client.getSurnames());
						txtUpdateClientIdAdm.setText(client.getIdNumber());
						txtUpdateClientAdressAdm.setText(client.getAdress());
						txtUpdateClientPhoneAdm.setText(client.getPhoneNumber());
						txtUpdateClientObservationsAdm.setText(client.getObservations());
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			return row;
		});
	}

//Method to update a client in ADMINISTRATOR
	@FXML
	public void UpdateClientAdm(ActionEvent event) {
		Client clientToUpdate = restaurant.returnClient(LabelUpdateClientNameAdm.getText());
		if (!txtUpdateClientNamesAdm.getText().equals("") && !txtUpdateClientSurnamesAdm.getText().equals("")
				&& !txtUpdateClientAdressAdm.getText().equals("") && !txtUpdateClientPhoneAdm.getText().equals("")
				&& !txtUpdateClientObservationsAdm.getText().equals("") && !txtUpdateClientIdAdm.getText().equals("")) {

			try {
				clientToUpdate.setNames(txtUpdateClientNamesAdm.getText());
				clientToUpdate.setSurnames(txtUpdateClientSurnamesAdm.getText());
				clientToUpdate.setAdress(txtUpdateClientAdressAdm.getText());
				clientToUpdate.setPhoneNumber(txtUpdateClientPhoneAdm.getText());
				clientToUpdate.setObservations(txtUpdateClientObservationsAdm.getText());
				clientToUpdate.setIdNumber(txtUpdateClientIdAdm.getText());

				restaurant.saveClientsData();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Cliente actualizado satisfactoriamente");
				dialog.setTitle("Proceso Satisfactorio");
				dialog.show();

				txtUpdateClientNamesAdm.setText("");
				txtUpdateClientSurnamesAdm.setText("");
				txtUpdateClientAdressAdm.setText("");
				txtUpdateClientPhoneAdm.setText("");
				txtUpdateClientObservationsAdm.setText("");
				txtUpdateClientIdAdm.setText("");
			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

			try {
				FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Administrator-Options-window.fxml"));
				optionsFxml.setController(this);
				Parent opWindow = optionsFxml.load();
				mainPaneLogin.getChildren().setAll(opWindow);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}
	}

//Method to initialize tableview of productTypes in USER screen
	public void initializeUserProductTypeTableView() {
		ObservableList<ProductType> typeList = FXCollections.observableArrayList(restaurant.getProductTypes());

		columnProductTypeName.setCellValueFactory(new PropertyValueFactory<ProductType, String>("name"));
		columnProductTypeCondition.setCellValueFactory(new PropertyValueFactory<ProductType, Condition>("condition"));

		tableViewProductTypeList.setItems(typeList);

		tableViewProductTypeList.setRowFactory(tv -> {
			TableRow<ProductType> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {

					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("update-productType.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_OptionsWindow.getChildren().setAll(root);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return row;
		});
	}

	//Method to initialize tableview of productTypes in ADMINISTRATOR screen
	public void initializeProductTypeTableViewAdm() {
		ObservableList<ProductType> typeList = FXCollections.observableArrayList(restaurant.getProductTypes());

		columnProductTypeName.setCellValueFactory(new PropertyValueFactory<ProductType, String>("name"));
		columnProductTypeCondition.setCellValueFactory(new PropertyValueFactory<ProductType, Condition>("condition"));

		tableViewProductTypeList.setItems(typeList);

		tableViewProductTypeList.setRowFactory(tv -> {
			TableRow<ProductType> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {

					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("update-productType.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return row;
		});
	}


	@FXML
	public void updateProductTypeAdm(ActionEvent event) {
		if (!txtProductTypeNewNameAdm.getText().equals("") && !txtProductTypeLastNameAdm.getText().equals("")) {
			ProductType pType = restaurant.returnProductType(txtProductTypeLastNameAdm.getText());

			if (pType != null) {
				try {
					pType.setName(txtProductTypeNewNameAdm.getText());
					restaurant.saveProductTypeData();
					restaurant.updateTypeOfProduct(txtProductTypeLastNameAdm.getText(),
							txtProductTypeNewNameAdm.getText());
					typeOptions.clear();
					typeOptions.addAll(restaurant.getStringProductTypes());
					pType.setEditedByUser(restaurant.returnUser(empleadoUsername));
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Ingrediente actualizado satisfactoriamente");
					dialog.setTitle("Proceso Satisfactorio");
					dialog.show();

					txtProductTypeLastNameAdm.setText("");
					txtProductTypeNewNameAdm.setText("");
				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
					dialog.setTitle("Error al guardar datos");
					dialog.show();

				}
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setTitle("Error");
				dialog.setContentText("El tipo de producto " + txtProductTypeLastName.getText() + " no existe");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error");
			dialog.setContentText("Debes ingresar el antiguo y nuevo nombre del tipo de producto");
			dialog.show();
		}

	}

	public void initializeProductTableViewAdm() {
		Collections.sort(restaurant.getProducts(), new SortProductsByPrice());
		ObservableList<Product> productsList = FXCollections.observableArrayList(restaurant.getProducts());

		columnProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		columngProductIngredients.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientsLista"));
		columnProductType.setCellValueFactory(new PropertyValueFactory<Product, String>("productType"));
		columnProductSize.setCellValueFactory(new PropertyValueFactory<Product, String>("size"));
		columnProductPrice.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
		columnProductCondition.setCellValueFactory(new PropertyValueFactory<Product, Condition>("condition"));

		tableViewProductsList.setItems(productsList);

		tableViewProductsList.setRowFactory(tv -> {
			TableRow<Product> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Product product = row.getItem();
					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-ProductAdm.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_AdministratorOptionsWindow.getChildren().setAll(root);

						sizeOptions.clear();
						sizeOptions.addAll(restaurant.getSizes());
						ComboUpdateSizeAdm.setItems(sizeOptions);

						typeOptions.clear();
						typeOptions.addAll(restaurant.getStringProductTypes());
						ComboUpdateTypeAdm.setItems(typeOptions);

						ingredientsOptions.clear();
						ingredientsOptions.addAll(restaurant.getStringIngredients());
						ChoiceUpdateIngredientsAdm.setItems(ingredientsOptions);

						LabelProductNameAdm.setText(product.getName());
						txtUpdateProductNameAdm.setText(product.getName());
						txtUpdateProductPriceAdm.setText(product.getPrice());
						selectedIngredients.clear();
						ComboUpdateSizeAdm.setValue(product.getSize());
						ComboUpdateTypeAdm.setValue(product.getType().getName());

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return row;
		});
	}
	
	@FXML
	public void addUpdateIngredientToProductAdm(ActionEvent event) {
		if (ChoiceUpdateIngredientsAdm.getValue() != null) {
			selectedIngredients.add(ChoiceUpdateIngredientsAdm.getValue());
			Dialog<String> dialog = createDialog();
			dialog.setContentText(
					"Ingrediente " + ChoiceUpdateIngredientsAdm.getValue() + " ha sido a�adido al producto");
			dialog.setTitle("Adicion de Ingrediente satisfactoria");
			dialog.show();
			ChoiceUpdateIngredientsAdm.setValue(null);
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Debe escoger algun ingrediente para que pueda ser a�adido");
			dialog.setTitle("Campo requerido");
			dialog.show();
		}
	}

	@FXML
	public void updateProductAdm(ActionEvent event) {
		Product productToUpdate = restaurant.returnProduct(LabelProductNameAdm.getText());
		if (!txtUpdateProductNameAdm.getText().equals("") && !txtUpdateProductPriceAdm.getText().equals("")
				&& selectedIngredients.isEmpty() == false) {

			try {
				productToUpdate.setName(txtUpdateProductNameAdm.getText());
				productToUpdate.setPrice(txtUpdateProductPriceAdm.getText());
				productToUpdate.setSize(ComboUpdateSizeAdm.getValue());
				productToUpdate.setType(toProductType(ComboUpdateTypeAdm.getValue()));
				productToUpdate.setIngredients(toIngredient(selectedIngredients));

				productToUpdate.setEditedByUser(restaurant.returnUser(empleadoUsername));

				restaurant.saveProductsData();
				productOptions.clear();
				productOptions.addAll(restaurant.getStringReferencedIdsProducts());
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Producto actualizado satisfactoriamente");
				dialog.setTitle("Proceso Satisfactorio");
				dialog.show();

				txtUpdateProductNameAdm.setText("");
				txtUpdateProductPriceAdm.setText("");
				ComboUpdateSizeAdm.setValue("");
				ComboUpdateTypeAdm.setValue("");
				ChoiceUpdateIngredientsAdm.setValue("");
				LabelProductNameAdm.setText("");

			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n de los productos");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

			try {
				FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Administrator-Options-window.fxml"));
				optionsFxml.setController(this);
				Parent opWindow = optionsFxml.load();
				mainPaneLogin.getChildren().setAll(opWindow);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}


	public void initializeUsersProductTableView() {
		Collections.sort(restaurant.getProducts(), new SortProductsByPrice());
		ObservableList<Product> productsList = FXCollections.observableArrayList(restaurant.getProducts());

		columnProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		columngProductIngredients.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("ingredientsLista"));
		columnProductType.setCellValueFactory(new PropertyValueFactory<Product, String>("productType"));
		columnProductSize.setCellValueFactory(new PropertyValueFactory<Product, String>("size"));
		columnProductPrice.setCellValueFactory(new PropertyValueFactory<Product, String>("price"));
		columnProductCondition.setCellValueFactory(new PropertyValueFactory<Product, Condition>("condition"));

		tableViewProductsList.setItems(productsList);

		tableViewProductsList.setRowFactory(tv -> {
			TableRow<Product> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Product product = row.getItem();
					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-Product.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_OptionsWindow.getChildren().setAll(root);

						sizeOptions.clear();
						sizeOptions.addAll(restaurant.getSizes());
						ComboUpdateSize.setItems(sizeOptions);

						typeOptions.clear();
						typeOptions.addAll(restaurant.getStringProductTypes());
						ComboUpdateType.setItems(typeOptions);

						ingredientsOptions.clear();
						ingredientsOptions.addAll(restaurant.getStringIngredients());
						ChoiceUpdateIngredients.setItems(ingredientsOptions);

						LabelProductName.setText(product.getName());
						txtUpdateProductName.setText(product.getName());
						txtUpdateProductPrice.setText(product.getPrice());
						selectedIngredients.clear();
						ComboUpdateSize.setValue(product.getSize());
						ComboUpdateType.setValue(product.getType().getName());

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return row;
		});
	}

	@FXML
	public void openSeeUsers(ActionEvent event) throws IOException {
		FXMLLoader usersList = new FXMLLoader(getClass().getResource("user-List.fxml"));
		usersList.setController(this);
		Parent rootUsersList = usersList.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootUsersList);

		initializeUsersTableView();
	}


	public void initializeUsersTableView() {
		ObservableList<Employee> systemUsers = FXCollections.observableArrayList(restaurant.getWorkers());

		columnUserNames.setCellValueFactory(new PropertyValueFactory<SystemUser, String>("names"));
		columnUserLastName.setCellValueFactory(new PropertyValueFactory<SystemUser, String>("surnames"));
		columnUserId.setCellValueFactory(new PropertyValueFactory<SystemUser, String>("idNumber"));
		columnUserUsername.setCellValueFactory(new PropertyValueFactory<SystemUser, String>("userName"));
		columnUserCondition.setCellValueFactory(new PropertyValueFactory<SystemUser, Condition>("condition"));

		tableViewUsers.setItems(systemUsers);

		tableViewUsers.setRowFactory(tv -> {
			TableRow<Employee> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Employee worker = row.getItem();
					SystemUser user = (SystemUser) worker;

					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("Update-UserAdm.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_AdministratorOptionsWindow.getChildren().setAll(root);

						LabelSystemUserNameAdm.setText(user.getUserName());
						txtSystemUserNewnameAdm.setText(user.getNames());
						txtSystemUserNewLastnameAdm.setText(user.getSurNames());
						txtSystemUserNewIdAdm.setText(user.getIdNumber());
						txtSystemUserNewUsernameAdm.setText(user.getUserName());

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return row;
		});

	}

	@FXML
	public void updateUserAdm(ActionEvent event) {
		SystemUser userToUpdate = restaurant.returnUser(LabelSystemUserNameAdm.getText());
		String name = txtSystemUserNewnameAdm.getText();
		String lastName = txtSystemUserNewLastnameAdm.getText();
		String id = txtSystemUserNewIdAdm.getText();
		String username = txtSystemUserNewUsernameAdm.getText();

		if (!name.equals("") && !lastName.equals("") && !id.equals("") && !username.equals("")) {

			try {
				userToUpdate.setNames(name);
				userToUpdate.setSurNames(lastName);
				userToUpdate.setIdNumber(id);
				userToUpdate.setUsername(username);
				userToUpdate.setPassword(passwordSystemUserNewPasswordAdm.getText());
				restaurant.saveUsersData();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Usuario actualizado satisfactoriamente");
				dialog.setTitle("Proceso Satisfactorio");
				dialog.show();

				txtSystemUserNewnameAdm.setText("");
				txtSystemUserNewLastnameAdm.setText("");
				txtSystemUserNewIdAdm.setText("");
				txtSystemUserNewUsernameAdm.setText("");
				passwordSystemUserNewPasswordAdm.setText("");
			} catch (IOException e) {
				e.printStackTrace();
				Dialog<String> dialog = createDialog();
				dialog.setContentText("No se pudo guardar la actualizaci�n del usuario");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

			try {
				FXMLLoader opWindow = new FXMLLoader(getClass().getResource("Administrator-Options-window.fxml"));
				opWindow.setController(this);
				Parent opPane = opWindow.load();
				mainPaneLogin.getChildren().setAll(opPane);
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}

	}

	@FXML
	public void openSeeIngredients(ActionEvent event) throws IOException {
		FXMLLoader ingredientsList = new FXMLLoader(getClass().getResource("ingredient-List.fxml"));
		ingredientsList.setController(this);
		Parent rootIngredientsList = ingredientsList.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootIngredientsList);

		initializeIngredientsTableViewAdm();

	}

	public void initializeIngredientsTableViewAdm() {
		
		Collections.sort(restaurant.getIngredients(),Collections.reverseOrder());
		
		ObservableList<Ingredient> ingredientsList = FXCollections.observableArrayList(restaurant.sortIngredientsByName());

		columnIngredientName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
		columnIngredientCondition.setCellValueFactory(new PropertyValueFactory<Ingredient, Condition>("condition"));

		tableViewIngredients.setRowFactory(tv -> {
			TableRow<Ingredient> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {

					try {

						FXMLLoader updateClientFxml = new FXMLLoader(
								getClass().getResource("update-IngredientAdm.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_AdministratorOptionsWindow.getChildren().setAll(root);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			return row;
		});

		tableViewIngredients.setItems(ingredientsList);
	}


	@FXML
	public void updateIngredientAdm(ActionEvent event) {
		String empty = "";
		if (!txtIngredientLastNameAdm.getText().equals(empty) && !txtIngredientNewNameAdm.getText().equals(empty)) {
			Ingredient ingredient = restaurant.returnIngredient(txtIngredientLastNameAdm.getText());

			if (ingredient != null) {

				try {
					ingredient.setName(txtIngredientNewNameAdm.getText());
					restaurant.saveIngredientsData();
					restaurant.updateIngredientOfProduct(txtIngredientLastNameAdm.getText(),
							txtIngredientNewNameAdm.getText());
					ingredientsOptions.clear();
					ingredientsOptions.addAll(restaurant.getStringIngredients());
					ingredient.setEditedByUser(restaurant.returnUser(empleadoUsername));
					Dialog<String> dialog = createDialog();
					dialog.setContentText("Ingrediente actualizado satisfactoriamente");
					dialog.setTitle("Proceso Satisfactorio");
					dialog.show();

					txtIngredientLastNameAdm.setText("");
					txtIngredientNewNameAdm.setText("");

				} catch (IOException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo guardar la actualizaci�n de los datos");
					dialog.setTitle("Error al guardar datos");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setTitle("Error");
				dialog.setContentText("El ingrediente " + txtIngredientLastName.getText() + " no existe");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setTitle("Error");
			dialog.setContentText("Debes ingresar el antiguo y nuevo nombre del ingrediente");
			dialog.show();
		}
	}



	public void initializeUserIngredientsTableView() {
		Collections.sort(restaurant.getIngredients(),Collections.reverseOrder());
		ObservableList<Ingredient> ingredientsList = FXCollections.observableArrayList(restaurant.sortIngredientsByName());

		columnIngredientName.setCellValueFactory(new PropertyValueFactory<Ingredient, String>("name"));
		columnIngredientCondition.setCellValueFactory(new PropertyValueFactory<Ingredient, Condition>("condition"));

		tableViewIngredients.setItems(ingredientsList);

		tableViewIngredients.setRowFactory(tv -> {
			TableRow<Ingredient> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {

					try {
						FXMLLoader updateClientFxml = new FXMLLoader(getClass().getResource("update-ingredient.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_OptionsWindow.getChildren().setAll(root);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			return row;
		});
	}

	@FXML
	public void openLoginScreen(ActionEvent event) throws IOException {
		FXMLLoader login = new FXMLLoader(getClass().getResource("login.fxml"));
		login.setController(this);
		Parent rootLogin = login.load();

		paneToChange_AdministratorWindow.getChildren().setAll(rootLogin);

	}

	@FXML
	public void openSeeOrders(ActionEvent event) throws IOException {
		FXMLLoader ordersList = new FXMLLoader(getClass().getResource("orders-List.fxml"));
		ordersList.setController(this);
		Parent rootOrdersList = ordersList.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootOrdersList);

		initializeOrdersTableViewAdm();
	}
	
	public void initializeOrdersTableViewAdm() {
		
		ObservableList<Order> allOrders = FXCollections.observableArrayList(); //Las ordenes de todos los usuarios
		
		for(int i=0;i<restaurant.getWorkers().size();i++) {
			SystemUser user=(SystemUser)restaurant.getWorkers().get(i);
			
			if(!user.getOrders().isEmpty()) {
				ObservableList<Order> userOrders = FXCollections.observableArrayList(user.getOrders()); //Todas las ordenes de un usuario
				allOrders.addAll(userOrders);
			}
			
			
		}
		
		tableViewOrders.setItems(allOrders);
		
		columnOrderCode.setCellValueFactory(new PropertyValueFactory<Order, String>("code"));
		columnOrderState.setCellValueFactory(new PropertyValueFactory<Order, State>("state"));
		columnOrderEmployee.setCellValueFactory(new PropertyValueFactory<Order, String>("employeeName"));
		columnOrderClient.setCellValueFactory(new PropertyValueFactory<Order, String>("clientName"));
		columnOrderProducts.setCellValueFactory(new PropertyValueFactory<Order, String>("products"));
		columnOrderCant.setCellValueFactory(new PropertyValueFactory<Order, String>("stringQuantity"));
		columnOrderDate.setCellValueFactory(new PropertyValueFactory<Order, String>("date"));
		columnOrderHour.setCellValueFactory(new PropertyValueFactory<Order, String>("hour"));
		columnOrderObservations.setCellValueFactory(new PropertyValueFactory<Order, String>("observations"));
		
		tableViewOrders.setRowFactory(tv -> {
			TableRow<Order> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					Order order = row.getItem();
					try {
						FXMLLoader updateClientFxml = new FXMLLoader(
								getClass().getResource("update-OrderStateAdm.fxml"));
						updateClientFxml.setController(this);
						Parent root = updateClientFxml.load();
						mainPane_AdministratorOptionsWindow.getChildren().setAll(root);

						labelOrderCodeAdm.setText(order.getCode());
						
						ObservableList<State> statesOrder; 
						if (order.getState().equals(State.REQUESTED)) {
							statesOrder = FXCollections.observableArrayList(State.IN_PROCESS);							
						}else if (order.getState().equals(State.IN_PROCESS)) {
							statesOrder = FXCollections.observableArrayList(State.SENT);							
						}else if (order.getState().equals(State.SENT)) {
							statesOrder = FXCollections.observableArrayList(State.DELIVERED);							
						}else {
							statesOrder = FXCollections.observableArrayList(State.DELIVERED);
						}
						
						initializeChoiceStateAdm(statesOrder);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			});
			return row;
		});
	}

	public void initializeChoiceStateAdm(ObservableList<State> statesOrder) {
		choiceStateAdm.setItems(statesOrder);
	}

	@FXML
	public void buttonUpdateOrderStateAdm(ActionEvent event) {
		boolean exit = false;
		State state = choiceStateAdm.getValue();
		Employee user = restaurant.findUserWithOrderCode(labelOrderCodeAdm.getText());
		try {
			if (user != null) {
				for (int i = 0; i < user.getOrders().size() && !exit; i++) {
					if (user.getOrders().get(i).getCode().equals(labelOrderCodeAdm.getText())) {
						user.getOrders().get(i).setState(state);
						exit = true;
					}
				}
				user.saveUsersOrdersData(user.getNames());
			}

			FXMLLoader ordersList = new FXMLLoader(getClass().getResource("Administrator-Options-window.fxml"));
			ordersList.setController(this);
			Parent root = ordersList.load();
			mainPaneLogin.getChildren().setAll(root);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Orders FXML things
	@FXML
	public void openOrders(ActionEvent event) throws IOException {
		FXMLLoader OrdersFxml = new FXMLLoader(getClass().getResource("orders.fxml"));
		OrdersFxml.setController(this);
		Parent root = OrdersFxml.load();
		mainPane_OptionsWindow.getChildren().setAll(root);
		LabelFecha.setText(formatter.format(fechaActual));
		txtOrderEmployee.setText(empleadoUsername);
		txtOrderCode.setText(empleadoUsername + restaurant.returnUser(empleadoUsername).getOrders().size());

		initializeComboProducts();
		selectedProducts.clear();
		productsQuantity.clear();

		hora = new Thread(new Runnable() {
			public void run() {
				while (true) {
					updateHour();
				}
			}
		});
		hora.start();
	}


	@FXML
	public void orderSearchClient(ActionEvent event) {
		if (txtOrderClientId.getText() != null && !txtOrderClientId.getText().equals("")) {
			Client searchedClient = restaurant.returnClientId(txtOrderClientId.getText());
			if (searchedClient != null) {
				txtOrderClientName.setText(searchedClient.getNames());
				Dialog<String> dialog = createDialog();
				dialog.setContentText("El cliente fue encontrado exitosamente");
				dialog.setTitle("Cliente encontrado");
				dialog.show();
			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText(
						"El cliente no fue encontrado, si desea crear uno presione en el boton create Client");
				dialog.setTitle("Error, Cliente no encontrado");
				dialog.show();
				txtOrderClientId.setText(null);
				txtOrderClientName.setText(null);
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error, datos incompletos");
			dialog.show();
		}
	}

	@FXML
	public void orderAddProduct(ActionEvent event) {
		if (ComboProducts.getValue() != null && !txtOrderProductQuantity.getText().equals("")) {
			try {
				int productQuantity = Integer.parseInt(txtOrderProductQuantity.getText());
				selectedProducts.add(ComboProducts.getValue());
				productsQuantity.add(productQuantity);
				Dialog<String> dialog = createDialog();
				dialog.setContentText("Producto " + ComboProducts.getValue() + " ha sido a�adido a la orden");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
				ComboProducts.setValue("");
				txtOrderProductQuantity.setText("");

			} catch (NumberFormatException e) {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("La cantidad del producto debe ser num�rica");
				dialog.setTitle("Error al guardar datos");
				dialog.show();
			}

		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Todos los campos deben de ser llenados");
			dialog.setTitle("Error al guardar datos");
			dialog.show();
		}
	}

	@FXML
	public void createOrder(ActionEvent event) {
		SystemUser user = restaurant.returnUser(txtSystemUserUsername.getText());

		if (!selectedProducts.isEmpty() && !productsQuantity.isEmpty()) {
			if (!txtOrderClientName.getText().equals("")) {
				String code = txtOrderCode.getText();
				String date = LabelFecha.getText();
				String hour = LabelHora.getText();
				String observations = txtOrderObservations.getText();
				Client client = restaurant.returnClientId(txtOrderClientId.getText());
				List<Product> productList = convertStringListToProduct(selectedProducts);

				try {
					user.addOrder(code, date, hour, observations, client, user, productList, productsQuantity);
					FXMLLoader optionsFxml = new FXMLLoader(getClass().getResource("Options-window.fxml"));
					optionsFxml.setController(this);
					Parent opWindow = optionsFxml.load();
					mainPaneLogin.getChildren().setAll(opWindow);
				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
					Dialog<String> dialog = createDialog();
					dialog.setContentText("No se pudo hacer la serializaci�n de las ordenes");
					dialog.setTitle("Error");
					dialog.show();
				}

			} else {
				Dialog<String> dialog = createDialog();
				dialog.setContentText("El pedido debe tener el cliente que lo realiz�");
				dialog.setTitle("Error, pedido sin cliente");
				dialog.show();
			}
		} else {
			Dialog<String> dialog = createDialog();
			dialog.setContentText("Al menos un producto debe ser a�adido a la orden");
			dialog.setTitle("Error, pedido sin productos");
			dialog.show();
		}

	}

	ObservableList<String> productOptions = FXCollections.observableArrayList();
	List<String> selectedProducts = new ArrayList<>();
	List<Integer> productsQuantity = new ArrayList<>();

	private LocalDate fechaActual = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	private Thread hilo;
	private Thread hora;

	// this method creates a new thread so it doesnt get in trouble with the thread
	// of the ui javafx
	public void updateHour() {
		hilo = new Thread(new Runnable() {
			public void run() {
				LabelHora.setText(calculateHour());
			}
		});
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
			}

			// UI update is run on the Application thread
			Platform.runLater(hilo);
		}
	}

	// This method helps to calculate the hour in a military hour
	public String calculateHour() {
		String hora;
		String min;
		String seg;
		String message;
		Calendar calendario = new GregorianCalendar();
		Date horaActual = new Date();
		calendario.setTime(horaActual);

		hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY)
				: "0" + calendario.get(Calendar.HOUR_OF_DAY);
		min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE)
				: "0" + calendario.get(Calendar.MINUTE);
		seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND)
				: "0" + calendario.get(Calendar.SECOND);

		message = hora + ":" + min + ":" + seg;
		return message;

	}

	public void initializeComboProducts() {
		ComboProducts.setItems(productOptions);
	}

	public List<Product> convertStringListToProduct(List<String> strProducts) {
		List<Product> productsList = new ArrayList<>();
		for (int i = 0; i < strProducts.size(); i++) {
			Product product = restaurant.findProductWithReferencedId(strProducts.get(i));
			if (product != null) {
				productsList.add(product);
			}

		}

		return productsList;

	}
	
    @FXML
    public void buttonGenerateReport(ActionEvent event) throws FileNotFoundException {

    	try {
    		DateFormat dateFormat = new SimpleDateFormat ("hh:mm:ss");
    		@SuppressWarnings("unused")
			Date hora1 = dateFormat.parse(InitialHour.getText());
    		@SuppressWarnings("unused")
			Date hora2 = dateFormat.parse(FinalHour.getText());

    		if(!txtReportSeparator.getText().equals("")&&!InitialHour.getText().equals("")&&!FinalHour.getText().equals("")&&InitialDate.getValue()!=null&&FinalDate.getValue()!=null) {
    			if(LabelReportType.getText().equals("Generar Reporte de Pedidos")) {
    				String strInitialDate= formatter.format(InitialDate.getValue());
    				String strFinalDate= formatter.format(FinalDate.getValue());
    				try {
    					exportData("data/reporte Pedidos.csv", txtReportSeparator.getText(), strInitialDate, strFinalDate, InitialHour.getText(), FinalHour.getText());
    				}
    				catch(Exception e) {
    					Dialog<String> dialog = createDialog();
    					dialog.setContentText("reporte Pedidos.csv est� en uso, debe cerrar el archivo para que se pueda realizar el proceso");
    					dialog.setTitle("Error al exportar datos");
    					dialog.show();
    				}
    			}

    			else if(LabelReportType.getText().equals("Generar Reporte de Empleados")){//que me haga generar reporte de empleados
    				String strInitialDate= formatter.format(InitialDate.getValue());
    				String strFinalDate= formatter.format(FinalDate.getValue());
    				try {
    					exportEmployeesData("data/reporte Empleados.csv", txtReportSeparator.getText(), strInitialDate, strFinalDate, InitialHour.getText(), FinalHour.getText());
    				}
    				catch(Exception e) {
    					Dialog<String> dialog = createDialog();
    					dialog.setContentText("reporte Empleados.csv est� en uso, debe cerrar el archivo para que se pueda realizar el proceso");
    					dialog.setTitle("Error al exportar datos");
    					dialog.show();
    				}
    			}
    			else {//que haga reporte de productos
    				String strInitialDate= formatter.format(InitialDate.getValue());
    				String strFinalDate= formatter.format(FinalDate.getValue());
    				try {
    					exportProductsData("data/reporte Productos.csv", txtReportSeparator.getText(), strInitialDate, strFinalDate, InitialHour.getText(), FinalHour.getText());
    				}
    				catch(Exception e) {
    					Dialog<String> dialog = createDialog();
    					dialog.setContentText("reporte Productos.csv est� en uso, debe cerrar el archivo para que se pueda realizar el proceso");
    					dialog.setTitle("Error al exportar datos");
    					dialog.show();
    				}

    			}
    		}
    		else {
    			Dialog<String> dialog = createDialog();
    			dialog.setContentText("Todos los campos deben ser llenados");
    			dialog.setTitle("Error al exportar datos");
    			dialog.show();
    		}
    	}
    	catch(Exception e){
    		Dialog<String> dialog = createDialog();
    		dialog.setContentText("Los campos de horas deben estar en el formato hh:mm:ss");
    		dialog.setTitle("Error al leer Horas");
    		dialog.show();
    	}
    }
	
    //EXPORT CSV DATA
    public void exportData(String fileName, String sep, String initialDate, String finalDate, String initialHour, String finalHour) throws FileNotFoundException {
    	PrintWriter pw= new PrintWriter(fileName);

    	pw.println("Nombre Cliente"+sep+"Direccion Cliente"+sep+"Telefono Cliente"+sep+"Nombre Empleado"+sep+"Estado Pedido"+sep+"Fecha Pedido"+sep+"Hora Pedido"+sep+"Observaciones Pedido");

    	List<Order> ordersInRange= new ArrayList<>();

    	for(int i=0;i<restaurant.getWorkers().size();i++) {

    		SystemUser worker= (SystemUser)restaurant.getWorkers().get(i);

    		if(!worker.getOrders().isEmpty()) {

    			for(int j=0;j<worker.getOrders().size();j++) {
    				Order order= worker.getOrders().get(j);

    				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    				LocalDate orderLD= LocalDate.parse(order.getDate(), formatter);
    				LocalDate initialLD= LocalDate.parse(initialDate, formatter);
    				LocalDate finalLD= LocalDate.parse(finalDate, formatter);
    				int comparationWithInitial=comparateDates(orderLD, initialLD);
    				int comparationWithFinal=comparateDates(orderLD, finalLD);
    				int comparationHourInitial=compareHours(order.getHour(),initialHour);
    				int comparationHourFinal=compareHours(order.getHour(),finalHour);

    			
    				if(comparationWithInitial>=0 && comparationWithFinal<=0) { //ESTA ORDEN TIENE UNA FECHA DENTRO DEL RANGO

    					if(comparationHourInitial>=0 && comparationHourFinal<=0) { //ESTA ORDEN TIENE UNA HORA DENTRO DEL RANGO	 

    						ordersInRange.add(order);

    						//String message=order.getClientName()+sep+order.getClient().getAdress()+sep+order.getClient().getPhoneNumber()+sep+order.getEmployeeName()+sep+order.getState()+sep+order.getDate()+sep+order.getHour()+sep+order.getObservations();

    					}
    				}

    			}
    		}
    	}

    	Collections.sort(ordersInRange, new SortOrdersByDateHour());

    	for(int i=0;i<ordersInRange.size();i++) {
    		Order order= ordersInRange.get(i);	 
    		String message=order.getClientName()+sep+order.getClient().getAdress()+sep+order.getClient().getPhoneNumber()+sep+order.getEmployeeName()+sep+order.getState()+sep+order.getDate()+sep+order.getHour()+sep+order.getObservations();
    		for(int k=0;k<order.getProductsList().size();k++) {
    			Product product=order.getProductsList().get(k);
    			message+=sep+product.getName()+sep+order.getProductsQuantity().get(k)+sep+product.getPrice();
    		}
    		pw.println(message);

    	}
    	pw.close();

    }

    @FXML
    public void exportData(ActionEvent event) throws IOException {
    	FXMLLoader OrdersFxml = new FXMLLoader(getClass().getResource("generate-Report.fxml"));
    	OrdersFxml.setController(this);
    	Parent root = OrdersFxml.load();
    	mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
    	LabelReportType.setText("Generar Reporte de Pedidos");
    }
    @FXML
    public void exportDataEmployees(ActionEvent event) throws IOException {
    	FXMLLoader OrdersFxml = new FXMLLoader(getClass().getResource("generate-Report.fxml"));
    	OrdersFxml.setController(this);
    	Parent root = OrdersFxml.load();
    	mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
    	LabelReportType.setText("Generar Reporte de Empleados");
    }
    @FXML
    public void exportDataProducts(ActionEvent event) throws IOException {
    	FXMLLoader OrdersFxml = new FXMLLoader(getClass().getResource("generate-Report.fxml"));
    	OrdersFxml.setController(this);
    	Parent root = OrdersFxml.load();
    	mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
    	LabelReportType.setText("Generar Reporte de Productos");
    }

    public void exportEmployeesData(String fileName, String sep, String initialDate, String finalDate, String initialHour, String finalHour) throws FileNotFoundException {

    	PrintWriter pw= new PrintWriter(fileName);

    	pw.println("Nombre Empleado"+sep+"Numero de Ordenes entregadas"+sep+"Valor total de las ordenes");

    	for(int i=0;i<restaurant.getWorkers().size();i++) {
    		SystemUser worker= (SystemUser)restaurant.getWorkers().get(i);
    		int numberOfOrders=0;
    		double valueOfOrders=0;
    		for(int j=0;j<worker.getOrders().size();j++) {
    			Order order=worker.getOrders().get(j);

    			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    			LocalDate orderLD= LocalDate.parse(order.getDate(), formatter);
    			LocalDate initialLD= LocalDate.parse(initialDate, formatter);
    			LocalDate finalLD= LocalDate.parse(finalDate, formatter);
    			int comparationWithInitial=comparateDates(orderLD, initialLD);
    			int comparationWithFinal=comparateDates(orderLD, finalLD);
    			int comparationHourInitial=compareHours(order.getHour(),initialHour);
    			int comparationHourFinal=compareHours(order.getHour(),finalHour);

    			if(comparationWithInitial>=0 && comparationWithFinal<=0) { //ESTA ORDEN TIENE UNA FECHA DENTRO DEL RANGO

    				if(comparationHourInitial>=0 && comparationHourFinal<=0) { //ESTA ORDEN TIENE UNA HORA DENTRO DEL RANGO

    					if(order.getState().toString().equals("DELIVERED")) { //SI LA ORDEN YA FUE ENTREGADA
    						numberOfOrders++;
    						valueOfOrders+=order.getValueOfOrder();
    					}
    				}
    			}
    		}
    		pw.println(worker.getName()+sep+numberOfOrders+sep+valueOfOrders);		 
    	}
    	pw.close();
    }

    public void exportProductsData(String fileName, String sep, String initialDate, String finalDate, String initialHour, String finalHour) throws FileNotFoundException {

    	PrintWriter pw= new PrintWriter(fileName);

    	pw.println("Nombre Producto"+sep+"Numero de veces Ordenado");

    	for(int i=0;i<restaurant.getProducts().size();i++) {
    		Product product= restaurant.getProducts().get(i);

    		int numberOfTimes=0;

    		for(int j=0;j<restaurant.getWorkers().size();j++) {//recorrer los empleado
    			SystemUser worker=(SystemUser)restaurant.getWorkers().get(j);

    			for(int k=0;k<worker.getOrders().size();k++) {//recorrer las ordenes del empleado
    				Order order=worker.getOrders().get(k);

    				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    				LocalDate orderLD= LocalDate.parse(order.getDate(), formatter);
    				LocalDate initialLD= LocalDate.parse(initialDate, formatter);
    				LocalDate finalLD= LocalDate.parse(finalDate, formatter);
    				int comparationWithInitial=comparateDates(orderLD, initialLD);
    				int comparationWithFinal=comparateDates(orderLD, finalLD);
    				int comparationHourInitial=compareHours(order.getHour(),initialHour);
    				int comparationHourFinal=compareHours(order.getHour(),finalHour);

    				if(comparationWithInitial>=0 && comparationWithFinal<=0) { //ESTA ORDEN TIENE UNA FECHA DENTRO DEL RANGO

    					if(comparationHourInitial>=0 && comparationHourFinal<=0) { //ESTA ORDEN TIENE UNA HORA DENTRO DEL RANGO

    						for(int w=0;w<order.getProductsList().size();w++) {//recorrer los productos de la orden
    							Product productx=order.getProductsList().get(w);

    							if(productx.getName().equals(product.getName())) {
    								numberOfTimes+=order.getProductsQuantity().get(w); //A�adir la cantidad de veces que se compro el productox
    							}

    						}

    					}
    				}


    			}
    		}
    		pw.println(product.getName()+sep+numberOfTimes);
    	}
    	pw.close();
    }

//This method compares hours in format hh:mm:ss
    public int compareHours(String hora1, String hora2) {
    	String[] strph1=hora1.split(":");
    	String[] strph2=hora2.split(":");
    	Integer[] ph1= new Integer[3];
    	Integer[] ph2= new Integer[3];

    	for(int i=0;i<strph1.length;i++) {
    		ph1[i]=Integer.parseInt(strph1[i]);
    	}
    	for(int i=0;i<strph2.length;i++) {
    		ph2[i]=Integer.parseInt(strph2[i]);
    	}

    	if(ph1[0]>ph2[0]) {
    		return 1;
    	}
    	else if(ph1[0]<ph2[0]) {
    		return -1;
    	}
    	else{//si las horas son iguales
    		if(ph1[1]>ph2[1]) {
    			return 1; 
    		}
    		else if(ph1[1]<ph2[1]) {
    			return -1;
    		}
    		else{//si los minutos son iguales
    			if(ph1[2]>ph2[2]) {
    				return 1;
    			}
    			else if(ph1[1]<ph2[1]) {
    				return -1;
    			}
    			else {
    				return 0;
    			}
    		}
    	}

    }

    public int comparateDates(LocalDate fecha1, LocalDate fecha2) {

    	if(fecha1.compareTo(fecha2)<0) {
    		return -1;
    	}
    	else if(fecha1.compareTo(fecha2)==0){
    		return 0;	 
    	}
    	else{
    		return 1;
    	}

    }


    public void importProductsData(String fileName) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(fileName));
    	String line = br.readLine();
    	while(line!=null){
    		String[] parts = line.split(";");
    		List<String> ingredients= new ArrayList<>();
    		for(int j=4;j<parts.length;j++) {
    			restaurant.addIngredient(new Ingredient(parts[j]));//primero creo el ingrediente en el restaurante
    			ingredients.add(parts[j]);//a�ado el str ingrediente a la lista
    		}
    		String price= parts[2];
    		if(price.charAt(0)=='$'){
    			price=price.substring(1, price.length());//Elimino el primer elemento ($) del string para evitar error al parse
    		}
    		restaurant.addProduct((new Product(parts[0],parts[1],price,parts[3], ingredients)),"ADMINISTRATOR");
    		line = br.readLine();
    	}
    	br.close();
    }
    public void importClientsData(String fileName) throws IOException{
    	BufferedReader br = new BufferedReader(new FileReader(fileName));
    	String line = br.readLine();
    	while(line!=null){
    		String[] parts = line.split(",");
    		restaurant.addClient(parts[0],parts[1],parts[2],parts[3],parts[4], parts[5], -1);
    		line = br.readLine();
    	}
    	br.close();
    }
    @FXML
    public void importClientsData(ActionEvent event) throws IOException {
    	importClientsData("data/datos Clientes.csv");
    }
    @FXML
    public void importProductsData(ActionEvent event) throws IOException {
    	importProductsData("data/data Products.txt");
    }
    

    
    //***********************************************************************************************
    //Nuevas funcionalidades de la ventana del administrador
    
    //***Cliente
    
    public void openAddClientAdm(ActionEvent event) throws IOException {
		FXMLLoader addClientFxml = new FXMLLoader(getClass().getResource("Add-Client.fxml"));
		addClientFxml.setController(this);
		Parent addRoot = addClientFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(addRoot);
	}

	@FXML
	public void openDeleteClientAdm(ActionEvent event) throws IOException {
		FXMLLoader deleteClientFxml = new FXMLLoader(getClass().getResource("Delete-Client.fxml"));
		deleteClientFxml.setController(this);
		Parent deleteRoot = deleteClientFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(deleteRoot);
	}
	
	@FXML
	public void openDisableClientAdm(ActionEvent event) throws IOException {
		FXMLLoader disableClientFxml = new FXMLLoader(getClass().getResource("Disable-Client.fxml"));
		disableClientFxml.setController(this);
		Parent root = disableClientFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openSearchClientAdm(ActionEvent event) throws IOException {
		FXMLLoader findClientBS = new FXMLLoader(getClass().getResource("Client-BinarySearch.fxml"));
		findClientBS.setController(this);
		Parent root = findClientBS.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);

		FXMLLoader searchClient = new FXMLLoader(getClass().getResource("findClient-BinarySearch.fxml"));
		searchClient.setController(this);
		Parent searchClientBS = searchClient.load();
		paneBinarySearch.getChildren().setAll(searchClientBS);
	}
	
	
	//***Producto   
	@FXML
	public void openAddProductAdm(ActionEvent event) throws IOException {
		FXMLLoader addProductFxml = new FXMLLoader(getClass().getResource("create-ProductAdm.fxml"));
		addProductFxml.setController(this);
		Parent root = addProductFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
		sizeOptions.clear();
		selectedIngredients.clear();
		initializeComboSize();
		initializeComboType();
		initializeChoiceIngredient();
	}
	
	@FXML
	public void openCreateSizeAdm(ActionEvent event) throws IOException {
		FXMLLoader createSizeFxml = new FXMLLoader(getClass().getResource("create-Size.fxml"));
		createSizeFxml.setController(this);
		Parent rootTypeList = createSizeFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootTypeList);
	}

	@FXML
	public void openDeleteProductAdm(ActionEvent event) throws IOException {
		FXMLLoader deleteProductFxml = new FXMLLoader(getClass().getResource("Delete-Product.fxml"));
		deleteProductFxml.setController(this);
		Parent root = deleteProductFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}


	@FXML
	public void openDisableProductAdm(ActionEvent event) throws IOException {
		FXMLLoader disableProductFxml = new FXMLLoader(getClass().getResource("Disable-Product.fxml"));
		disableProductFxml.setController(this);
		Parent root = disableProductFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}
	
	
	//***Ingredient	
	@FXML
	public void openAddIngredientAdm(ActionEvent event) throws IOException {
		FXMLLoader addIngredientFxml = new FXMLLoader(getClass().getResource("create-ingredient.fxml"));
		addIngredientFxml.setController(this);
		Parent root = addIngredientFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDeleteIngredientAdm(ActionEvent event) throws IOException {
		FXMLLoader deleteIngredientFxml = new FXMLLoader(getClass().getResource("Delete-Ingredient.fxml"));
		deleteIngredientFxml.setController(this);
		Parent root = deleteIngredientFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDisableIngredientAdm(ActionEvent event) throws IOException {
		FXMLLoader disableIngredientFxml = new FXMLLoader(getClass().getResource("Disable-Ingredient.fxml"));
		disableIngredientFxml.setController(this);
		Parent root = disableIngredientFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}
	
	
	//***Product type
	@FXML
	public void openAddProductTypeAdm(ActionEvent event) throws IOException {
		FXMLLoader addTypeFxml = new FXMLLoader(getClass().getResource("create-productType.fxml"));
		addTypeFxml.setController(this);
		Parent root = addTypeFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDeleteProductTypeAdm(ActionEvent event) throws IOException {
		FXMLLoader deleteProductTypeFxml = new FXMLLoader(getClass().getResource("Delete-ProductType.fxml"));
		deleteProductTypeFxml.setController(this);
		Parent root = deleteProductTypeFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}

	@FXML
	public void openDisableProductTypeAdm(ActionEvent event) throws IOException {
		FXMLLoader disableProductTypeFxml = new FXMLLoader(getClass().getResource("Disable-ProductType.fxml"));
		disableProductTypeFxml.setController(this);
		Parent root = disableProductTypeFxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(root);
	}
	
	
	//***Users
    @FXML
    public void openAddUserAdm(ActionEvent event) throws IOException{
		FXMLLoader addUserfxml = new FXMLLoader(getClass().getResource("Add-User.fxml"));
		addUserfxml.setController(this);
		Parent addUser = addUserfxml.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(addUser);
    }
    

    @FXML
    public void openDeleteUserAdm(ActionEvent event) throws IOException {
    	FXMLLoader deleteUser = new FXMLLoader(getClass().getResource("Delete-User.fxml"));
		deleteUser.setController(this);
		Parent rootUser = deleteUser.load();
		mainPane_AdministratorOptionsWindow.getChildren().setAll(rootUser);
    }
    
    @FXML
    public void openDisableUserAdm(ActionEvent event) throws IOException {
    	FXMLLoader disableUser = new FXMLLoader(getClass().getResource("Disable-User.fxml"));
    	disableUser.setController(this);
    	Parent rootDisableUser = disableUser.load();
    	mainPane_AdministratorOptionsWindow.getChildren().setAll(rootDisableUser);
    }

    
}