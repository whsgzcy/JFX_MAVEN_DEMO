package com.iwant.test;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ListViewAppController implements Initializable {

	@FXML
	private JFXListView<Student> listview;

	private ObservableList<Student> studentObservableList;

	public ListViewAppController() {

		studentObservableList = FXCollections.observableArrayList();
		// add some Students
		studentObservableList.addAll(new Student("John Doe", "", ""), new Student("Jane Doe", "", ""),
				new Student("Donte Dunigan", "", ""), new Student("Gavin Genna", "", ""),
				new Student("Darin Dear", "", ""), new Student("Pura Petty", "", ""),
				new Student("Herma Hines", "", ""));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listview.setItems(studentObservableList);
		listview.setCellFactory(studentListView -> new StudentListViewCell());
	}

}
