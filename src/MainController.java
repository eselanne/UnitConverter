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
	private MenuItem mile;
	@FXML
	private MenuItem yard;
	@FXML
	private MenuItem foot;
	@FXML
	private TextField txtMetricLength;
	@FXML
	private TextField txtImperialLength;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void CloseApp (ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}
	
	
	// ******************LENGHT LABEL CHANGES********************
	
	@FXML
	public void ChangeLabelToKm (ActionEvent event) {
		
		lab1.setText(kilometer.getText());
		
	}
	@FXML
	public void ChangeLabelToM (ActionEvent event) {
		
		lab1.setText(meter.getText());
		
	}
	@FXML
	public void ChangeLabelToCm(ActionEvent event) {
		
		lab1.setText(centimeter.getText());
		
	}
	
	@FXML
	public void ChangeLabelToMile(ActionEvent event) {
		
		lab2.setText(mile.getText());
		
	}
	
	@FXML
	public void ChangeLabelToYard(ActionEvent event) {
		
		lab2.setText(yard.getText());
		
	}
	
	@FXML
	public void ChangeLabelToFoot(ActionEvent event) {
		
		lab2.setText(foot.getText());
		
	}
	
	
	//**********************************************************
	
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
		
		
		
		// Imperial to Metric
		if (txtMetricLength.getLength() == 0) {
			double valueImp = Double.parseDouble(txtImperialLength.getText());
			// Mile to Kilometer
			if (labelMetric.equals(kilometer.getText()) && labelImperial.equals(mile.getText())) {
				convertMileToKm(valueImp);
			}
			// Mile to Meter
			if (labelMetric.equals(meter.getText()) && labelImperial.equals(mile.getText())) {
				convertMileToM(valueImp);
			}
			
			// Mile to Centimeter
			if (labelMetric.equals(centimeter.getText()) && labelImperial.equals(mile.getText())) {
				convertMileToCm(valueImp);
			}
			
			/////////////////////////
			
			//Yard to Km
			if (labelMetric.equals(kilometer.getText()) && labelImperial.equals(yard.getText())) {
				convertYardToKm(valueImp);
			}
			// Yard to Meter
			if (labelMetric.equals(meter.getText()) && labelImperial.equals(yard.getText())) {
				convertYardToM(valueImp);
			}
			
			// Yard to Centimeter
			if (labelMetric.equals(centimeter.getText()) && labelImperial.equals(yard.getText())) {
				convertYardToCm(valueImp);
			}
			
			/////////////////////////////
			
			// Foot to Km 
			if (labelMetric.equals(kilometer.getText()) && labelImperial.equals(foot.getText())) {
				convertFootToKm(valueImp);
			}
			// Foot to Meter
			if (labelMetric.equals(meter.getText()) && labelImperial.equals(foot.getText())) {
				convertFootToM(valueImp);
			}
			
			// Foot to Centimeter
			if (labelMetric.equals(centimeter.getText()) && labelImperial.equals(foot.getText())) {
				convertFootToCm(valueImp);
			}
			
		} if (txtImperialLength.getLength() == 0){
			
			double valueMet = Double.parseDouble(txtMetricLength.getText());
			
			//Metric to Imperial
			//Kilometers to Miles
			if (labelMetric.equals(kilometer.getText()) && labelImperial.equals(mile.getText())) {
				convertKmToMile(valueMet);
			}
			//Kilometers to Yards
			if (labelMetric.equals(kilometer.getText()) && labelImperial.equals(yard.getText())) {
				convertKmToYard(valueMet);
			}
			//Kilometers to Foot
			if (labelMetric.equals(kilometer.getText()) && labelImperial.equals(foot.getText())) {
				convertKmToFoot(valueMet);
			}
			
			///////////////
			
			//Meters to Miles
			if (labelMetric.equals(meter.getText()) && labelImperial.equals(mile.getText())) {
				convertMeterToMile(valueMet);
			}
			//Meters to Yards
			if (labelMetric.equals(meter.getText()) && labelImperial.equals(yard.getText())) {
				convertMeterToYard(valueMet);
			}
			//Meters to Feet
			if (labelMetric.equals(meter.getText()) && labelImperial.equals(foot.getText())) {
				convertMeterToFoot(valueMet);
			}
			
			////////////////
			
			//Cm to Miles
			if (labelMetric.equals(centimeter.getText()) && labelImperial.equals(mile.getText())) {
				convertCmToMile(valueMet);
			}
			//Cm to Yards
			if (labelMetric.equals(centimeter.getText()) && labelImperial.equals(yard.getText())) {
				convertCmToYard(valueMet);
			}
			//Cm to Feet
			if (labelMetric.equals(centimeter.getText()) && labelImperial.equals(foot.getText())) {
				convertCmToFoot(valueMet);
			}
			
		}
	}
	
	@FXML
	public void ClearLengthFields (ActionEvent event) {
		txtMetricLength.setText("");
		txtImperialLength.setText("");
	}
	
	//************** CONVERT METHODS **********************
	
	// Mile to Metric system
	public void convertMileToKm(double a) {
		double result = a * 1.609344;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	public void convertMileToM(double a) {
		double result = a * 1.609344 * 1000;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	public void convertMileToCm(double a) {
		double result = a * 1.609344 * 1000 * 100;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	// Yard in Metric system
	public void convertYardToKm(double a) {
		double result = a * 0.0009144;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	public void convertYardToM(double a) {
		double result = a * 0.9144;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	public void convertYardToCm(double a) {
		double result = a * 91.44;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));

	}

	// Foot to Metric system
	public void convertFootToKm(double a) {
		double result = a * 0.0003048;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	public void convertFootToM(double a) {
		double result = a * 0.3048;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));
	}

	public void convertFootToCm(double a) {
		double result = a * 30.48;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtMetricLength.setText(String.valueOf(answer));

	}
	
	//Km to Imperial system
	public void convertKmToMile(double a) {
		double result = a / 1.609344;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	public void convertKmToYard(double a) {
		double result = a * 1093.6133;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	public void convertKmToFoot(double a) {
		double result = a * 3280.8399;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	//Metre to Imperial system
	
	public void convertMeterToMile(double a) {
		double result = (a / 1.609344) / 1000;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	public void convertMeterToYard(double a) {
		double result = a * 1.0936133;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	public void convertMeterToFoot(double a) {
		double result = a * 3.2808399;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}

	// Cm to Imperial system
	
	public void convertCmToMile(double a) {
		double result = (a / 1.609344) / 1000 / 1000;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	public void convertCmToYard(double a) {
		double result = a * 1.0936133 / 100;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	public void convertCmToFoot(double a) {
		double result = a * 3.2808399 / 100;
		String answer;
		result = Math.round(result * 100.0) / 100.0;
		answer = String.valueOf(result);
		txtImperialLength.setText(String.valueOf(answer));
	}
	
	
	
	
}
