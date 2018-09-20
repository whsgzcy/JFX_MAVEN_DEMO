package com.iwant.canvas;

import java.io.File;
import java.io.InputStream;

import com.iwant.canvas.interf.DownLoadListener;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CanvasController {

	@FXML
	private Button click;
	@FXML
	private Button drawPoint;
	@FXML
	private Canvas canvas1;
	@FXML
	private Canvas canvas2;
	@FXML
	private TextField x_;
	@FXML
	private TextField y_;
	@FXML
	private Pane pane;

	private Image mPoint;

	double lx = -1;
	double ly = -1;

	double cx = -1;
	double cy = -1;

	DownloadUtil mDownloadUtil;

	@FXML
	public void OnClick() {

		if (mDownloadUtil == null) {
			mDownloadUtil = new DownloadUtil();
		}

		mDownloadUtil.downloadFile("img/loongman_4.png", new DownLoadListener() {
			@Override
			public void onStart() {

			}

			@Override
			public void onProgress(final int currentLength) {
				System.out.println("currentLength = " + currentLength);
			}

			@Override
			public void onFinish(InputStream is) {

//				Image image = new Image(is, 600, 600, true, true);
//				GraphicsContext gc = canvas1.getGraphicsContext2D();
//				gc.drawImage(image, 0, 0);

				System.out.println("InputStream = " + is);
			}

			@Override
			public void onFailure() {

			}
		});

//		 GraphicsContext gc = canvas1.getGraphicsContext2D();
//		 Image bg = new Image(getClass().getResource("map3.png").toString());
//		 gc.drawImage(bg, 0, 0);

		 GraphicsContext gc = canvas1.getGraphicsContext2D();
		 Image bg = new Image("http://192.168.3.19:8080/img/loongman_4.png");
		 gc.drawImage(bg, 0, 0);

		if (mPoint == null) {
			mPoint = new Image(getClass().getResource("center.png").toString());
		}
	}

	@FXML
	public void onDrawPoint() {

		if (mPoint == null)
			return;

		String x = x_.getText();
		String y = y_.getText();

		if (x.equals("") || y.equals("")) {
			return;
		}

		// 按照自己的需求进行绘制
		// 真实数据的坐标系原点是此canvas的中心点
		cx = Double.parseDouble(x) * 40 + 300;
		cy = 300 - Double.parseDouble(y) * 40;

		GraphicsContext gc = canvas2.getGraphicsContext2D();

		if (lx != -1 && ly != -1) {

			gc.clearRect(lx, ly, mPoint.getWidth(), mPoint.getHeight());
		}

		gc.drawImage(mPoint, cx, cy);

		gc.rect(lx, ly, mPoint.getWidth(), mPoint.getHeight());

		lx = cx;
		ly = cy;
	}

	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(5);
		gc.strokeLine(400, 400, 400, 400);
		gc.fillOval(10, 60, 30, 30);
		gc.strokeOval(60, 60, 30, 30);
		gc.fillRoundRect(110, 60, 30, 30, 10, 10);
		gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
		gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
		gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
		gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
		gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
		gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
		gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
		gc.fillPolygon(new double[] { 10, 40, 10, 40 }, new double[] { 210, 210, 240, 240 }, 4);
		gc.strokePolygon(new double[] { 60, 90, 60, 90 }, new double[] { 210, 210, 240, 240 }, 4);
		gc.strokePolyline(new double[] { 110, 140, 110, 140 }, new double[] { 210, 210, 240, 240 }, 4);
	}
}