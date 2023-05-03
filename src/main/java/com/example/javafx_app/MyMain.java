package com.example.javafx_app;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args) {
		System.out.println("Main");
		launch(args);

	}

	@Override
	public void init() throws Exception {      //Initialize the application
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {    //Starts the application

		System.out.println("Start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);   //To add the menuBar within the VBox

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();


	}

	private MenuBar createMenu()
	{
		Menu fileMenu = new Menu("File");    //To create a FileMenu
		MenuItem newMenuItems = new MenuItem("New");
		newMenuItems.setOnAction(actionEvent -> System.out.println("New Item clicked"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();  //To draw a seperation line between New and Quit
		MenuItem quitMenuItems = new MenuItem("Quit");
		quitMenuItems.setOnAction(actionEvent -> {
			Platform.exit();
			System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItems, separatorMenuItem, quitMenuItems);

		Menu helpMenu = new Menu("Help");    //To create helpmenu
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(actionEvent -> aboutApp());

		helpMenu.getItems().addAll(aboutApp);

		MenuBar menubar = new MenuBar();
		menubar.getMenus().addAll(fileMenu, helpMenu);
		return menubar;


	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("My First Desktop App");
		alertDialog.setHeaderText("Learning JavaFX");
		alertDialog.setContentText("I am a beginner and have started learning JavaFX app");

		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> btnType = alertDialog.showAndWait();

		if(btnType.isPresent() && btnType.get()==yesBtn)
		{
			System.out.println("Yes Button Clicked!");
		}

		if(btnType.isPresent() && btnType.get()==noBtn)
		{
			System.out.println("No Button Clicked!");
		}

	}

	@Override
	public void stop() throws Exception {   //Called when the application is stopped and about to shut down
		System.out.println("Stop");
		super.stop();
	}
}
