package com.iwant.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FontApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("FontAppController.fxml"));
		primaryStage.setTitle("xxxx");
		primaryStage.setScene(new Scene(root, 480, 360));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
