package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application {
	
	//Relations
	private Restaurant restaurant;
	private RestaurantGUI laCasaDorada;
	
	public Main() {
		restaurant = new Restaurant();
		laCasaDorada=new RestaurantGUI(restaurant);
		
		try {
			restaurant.loadClientsData();		
		}catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Restaurant");
    		alert.setContentText("Error loading clients data from file");
			alert.showAndWait();
		}
		
		try {
			restaurant.loadProductTypeData();
		}catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Restaurant");
			alert.setContentText("Error loading products types data from file");
			alert.showAndWait();					
		}
		
		try {
			restaurant.loadIngredientsData();			
		}catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Restaurant");
			alert.setContentText("Error loading ingredients data from file");
			alert.showAndWait();		
		}
		
		try {
			restaurant.loadProductsData();
		}catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Restaurant");
			alert.setContentText("Error loading products data from file");
			alert.showAndWait();		
		}
		
	
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(laCasaDorada);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("La Casa Dorada");	
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}
