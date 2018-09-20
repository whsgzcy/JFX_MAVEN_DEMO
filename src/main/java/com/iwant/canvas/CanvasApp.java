package com.iwant.canvas;

import java.io.IOException;
import java.io.InputStream;

import com.iwant.canvas.interf.DownLoadListener;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CanvasApp extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("CanvasController.fxml"));
		primaryStage.setScene(new Scene(root, 800, 800));
		primaryStage.show();


//		downloadPicture();

		// 添加图层的图层
		// https://stackoverrun.com/cn/q/6809673
		// Canvas layer1 = new Canvas(700, 300);
		// Canvas layer2 = new Canvas(700, 300);
		// GraphicsContext gc1 = layer1.getGraphicsContext2D();
		// GraphicsContext gc2 = layer2.getGraphicsContext2D();
		//
		// gc1.setFill(Color.GREEN);
		// gc1.setFont(new Font("Comic sans MS", 100));
		// gc1.fillText("BACKGROUND", 0, 100);
		// gc1.fillText("LAYER", 0, 200);
		// gc1.setFont(new Font(30));
		// gc1.setFill(Color.RED);
		// gc1.fillText("Hold a key", 0, 270);
		//
		// gc2.setFill(Color.BLUE);
		// Pane root = new Pane(layer1, layer2);
		// Scene scene = new Scene(root);
		//
		// primaryStage.setScene(scene);
		// primaryStage.show();
		//
		// scene.setOnKeyPressed((evt) -> {
		// gc2.clearRect(0, 0, layer2.getWidth(), layer2.getHeight());
		// gc2.fillOval(Math.random() * layer2.getWidth(), Math.random() *
		// layer2.getHeight(), 20, 30);
		// });

	}

//	private void downloadPicture() {
//		DownloadUtil mDownloadUtil = new DownloadUtil();
//		mDownloadUtil.downloadFile("img/loongman_4.png", new DownLoadListener() {
//			@Override
//			public void onStart() {
//
//			}
//
//			@Override
//			public void onProgress(final int currentLength) {
//				System.out.println("currentLength = " + currentLength);
//			}
//
//			@Override
//			public void onFinish(InputStream is) {
//				Image image = new Image(is);
//				System.out.println("InputStream = " + is);
//			}
//
//			@Override
//			public void onFailure() {
//
//			}
//		});
//	}

	public static void main(String[] args) {
		launch(args);
	}
}
