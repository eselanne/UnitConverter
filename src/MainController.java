import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class MainController implements Initializable {
	///LENGTH//
	@FXML
	private Label lab1;
	@FXML
	private Label lab2;
	@FXML
	private Label errorlabel;
	@FXML
	private MenuItem kilometer;
	@FXML
	private MenuItem meter;
	@FXML
	private MenuItem centimeter;
	@FXML
	private MenuItem millimeter;
	@FXML
	private MenuItem mile;
	@FXML
	private MenuItem yard;
	@FXML
	private MenuItem foot;
	@FXML
	private MenuItem inch;
	@FXML
	private TextField txtMetricLength;
	@FXML
	private TextField txtImperialLength;
	///TEMPERATURE///
	@FXML
	private Label templab1;
	@FXML
	private Label templab2;
	@FXML
	private Label errorlabeltemp;
	@FXML
	private MenuItem celcius;
	@FXML
	private MenuItem kelvin;
	@FXML
	private MenuItem fahrenheit;
	@FXML
	private TextField txtImperialTemperature;
	@FXML
	private TextField txtMetricTemperature;
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void CloseApp (ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	
	
	//************LENGTH TAB*******////////////////////////
	
	// ******************LENGHT LABEL CHANGES********************
	// Muuttaa labelin nimen, kun valikosta valitaan haluttu yksikk�
	
	@FXML
	public void ChangeMetricLengthLabel(ActionEvent event) {
		MenuItem temp = (MenuItem) event.getSource();
		String label = temp.getText();
		switch (label) {
		case "Kilometer":
			lab1.setText(label);
			break;
		case "Meter":
			lab1.setText(label);
			break;
		case "Centimeter":
			lab1.setText(label);
			break;
		case "Millimeter":
			lab1.setText(label);
			break;
		}
	}
	
	
	// Muuttaa labelin nimen, kun valikosta valitaan haluttu yksikk�
	@FXML
	public void ChangeImperialLengthLabel(ActionEvent event) {
		MenuItem temp = (MenuItem) event.getSource();
		String label = temp.getText();
		switch (label) {
		case "Mile":
			lab2.setText(label);
			break;
		case "Yard":
			lab2.setText(label);
			break;
		case "Foot":
			lab2.setText(label);
			break;
		case "Inch":
			lab2.setText(label);
			break;
		}
	}
	
	
	
	
	
	
	//**********************************************************
	// Muuttaa annetun arvon haluttuun yksikk��n
	@FXML
	public void ConvertLength (ActionEvent event) {
		
		errorlabel.setText("");
		String labelMetric = lab1.getText();
		String labelImperial = lab2.getText();
		
		
		if (labelMetric.length() == 0 || labelImperial.length() == 0) {
			errorlabel.setText("Choose units!");
			return;
		}
		
		if (txtMetricLength.getLength() == 0 && txtImperialLength.getLength() == 0) {
			errorlabel.setText("Set Value!");
			return;
		}
		if (txtMetricLength.getLength() > 0 && txtImperialLength.getLength() > 0) {
			errorlabel.setText("Leave the other field blank!");
			return;
		}
		
		if (txtMetricLength.getLength() == 0) {
			double d = Double.parseDouble(txtImperialLength.getText());
			double ans = ConvertMethods.ImperialToMetric(labelImperial, labelMetric, d);
			double roundOff = Math.round(ans * 100.0) / 100.0;
			txtMetricLength.setText(String.valueOf(roundOff));
		}
		if (txtImperialLength.getLength() == 0) {
			double d = Double.parseDouble(txtMetricLength.getText());
			double ans = ConvertMethods.MetricToImperial(labelMetric, labelImperial, d);
			double roundOff = Math.round(ans * 100.0) / 100.0;
			txtImperialLength.setText(String.valueOf(roundOff));
		}
		
	}
	
	@FXML
	public void ClearLengthFields (ActionEvent event) {
		txtMetricLength.setText("");
		txtImperialLength.setText("");
	}
	
	@FXML
	public void ClearMetricFieldLength (ActionEvent event) {
		txtMetricLength.setText("");
	}
	
	@FXML
	public void ClearImperialFieldLength (ActionEvent event) {
		txtImperialLength.setText("");
	}
	
	////***********LENGHT TAB ENDS****************////
	
	///***********TEMPERATURE*********************///
	
	@FXML
	public void ChangeMetricTempLabel(ActionEvent event) {
		MenuItem temp = (MenuItem) event.getSource();
		String label = temp.getText();
		switch (label) {
		case "Celsius":
			templab1.setText(label);
			break;
		case "Kelvin":
			templab1.setText(label);
			break;
		}
	}
	
	@FXML
	public void ChangeImperialTempLabel(ActionEvent event) {
		MenuItem temp = (MenuItem) event.getSource();
		String label = temp.getText();
		switch (label) {
		case "Fahrenheit":
			templab2.setText(label);
			break;
		case "Kelvin":
			templab2.setText(label);
			break;
		}
	}
	
	@FXML
	public void ConvertTemperature(ActionEvent event) {

		errorlabeltemp.setText("");
		String labelMetric = templab1.getText();
		String labelImperial = templab2.getText();
		
		if (labelMetric.length() == 0 || labelImperial.length() == 0) {
			errorlabeltemp.setText("Choose units!");
			return;
		}
		
		if (txtMetricTemperature.getLength() == 0 && txtImperialTemperature.getLength() == 0) {
			errorlabeltemp.setText("Set Value!");
			return;
		}
		if (txtMetricTemperature.getLength() > 0 && txtImperialTemperature.getLength() > 0) {
			errorlabeltemp.setText("Leave the other field blank!");
			return;
		}

		if (txtImperialTemperature.getLength() == 0) {
			double d = Double.parseDouble(txtMetricTemperature.getText());
			double ans = ConvertMethods.ConvertCelciusKelvinToFahrenheit(labelMetric, labelImperial, d);
			double roundOff = Math.round(ans * 100.0) / 100.0;
			txtImperialTemperature.setText(String.valueOf(roundOff));
		}

		if (txtMetricTemperature.getLength() == 0) {
			double d = Double.parseDouble(txtImperialTemperature.getText());
			double ans = ConvertMethods.ConvertFahrenheitToCelsius(labelMetric, labelImperial, d);
			double roundOff = Math.round(ans * 100.0) / 100.0;
			txtMetricTemperature.setText(String.valueOf(roundOff));
		}
	}

	@FXML
	public void ClearTempFields (ActionEvent event) {
		txtMetricTemperature.setText("");
		txtImperialTemperature.setText("");
	}
	
	@FXML
	public void ClearMetricFieldTemp (ActionEvent event) {
		txtMetricTemperature.setText("");
	}
	
	@FXML
	public void ClearImperialFieldTemp (ActionEvent event) {
		txtImperialTemperature.setText("");
	}
	
}
