package com.iwant.canvas;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CanvasApp extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("CanvasController.fxml"));
		primaryStage.setScene(new Scene(root, 800, 800));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
