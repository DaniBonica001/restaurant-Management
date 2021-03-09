package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application {
	
	//Relations
	private Restaurant restaurant;
	private RestaurantGUI laCasaDorada;
	
	public Main() {
		restaurant = new Restaurant();
		laCasaDorada=new RestaurantGUI(restaurant);
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
