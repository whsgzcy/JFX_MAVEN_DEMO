package com.iwant.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ListViewApp extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ListViewAppController.fxml"));
		primaryStage.setTitle("xxxx");
		primaryStage.setScene(new Scene(root, 480, 360));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
