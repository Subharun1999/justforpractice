package com.example.javafx_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	public Label welcomeLabel;

	@FXML
	public ChoiceBox<String> choiceBox;

	@FXML
	public TextField textField;

	@FXML
	public Button convertButton;

	public static final String C_TO_F_TEXT = "Celsius to Fahrenheit";
	public static final String F_TO_C_TEXT = "Fahrenheit to Celsius";
	boolean isC_TO_F = true;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle)
	{

		choiceBox.getItems().add(C_TO_F_TEXT);
		choiceBox.getItems().add(F_TO_C_TEXT);

		choiceBox.setValue(C_TO_F_TEXT);

		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {

			if (t1.equals(C_TO_F_TEXT)) {
				isC_TO_F = true;
			} else {
				isC_TO_F = false;
			}
		});

		convertButton.setOnAction(actionEvent -> {
			convert();
		});
	}

	private void convert() {

		String input = textField.getText();      // Accepts input in String format
		float enteredTemperature = 0.0f;

		try {
			 enteredTemperature = Float.parseFloat(input);  //Converts String type to Float type
		}
		catch (Exception exception)
		{
			warnUser();
			return;
		}


		float newTemperature = 0.0f;
		if(isC_TO_F)
		{
			newTemperature = (enteredTemperature * 9 / 5) + 32;
		}else
		{
			newTemperature = (enteredTemperature - 32) * 9 / 5;
		}
		display(newTemperature);

	}

	private void warnUser() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please Enter a Valid Temperature");
		alert.show();
	}

	private void display(float newTemperature)
	{
		String unit = isC_TO_F ? "F" : "C";
		System.out.println("The new temperature is: " +newTemperature +unit);

		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new temperature is: " +newTemperature +unit);
		alert.show();

	}

}

