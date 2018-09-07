package com.iwant.test;

import java.awt.GraphicsEnvironment;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;

public class StudentListViewCell extends ListCell<Student> {

	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private Label label3;
	@FXML
	private Label label4;
	@FXML
	private Label label5;
	@FXML
	private BorderPane layout;

	private FXMLLoader mLLoader;

	@Override
	protected void updateItem(Student student, boolean empty) {
		super.updateItem(student, empty);
		
		 // 获取系统字体列表
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();

		if (empty || student == null) {

			setText(null);
			setGraphic(null);

		} else {
			if (mLLoader == null) {
				mLLoader = new FXMLLoader(getClass().getResource("ListCell.fxml"));
				mLLoader.setController(this);
				try {
					mLLoader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			label1.setText("1111");
			label2.setText("2222");
			label3.setText("3333");
			label4.setText("4444");
			label5.setText("5555");

			setText(null);
			setGraphic(layout);
		}

	}

}
