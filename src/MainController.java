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
		if (txtMetricLength.getLength() > 0 && txtImperialLength.getLength() > 0) {
			errorlabel.setText("Leave the other field blank!");
			return;
		}
		
		if (txtMetricLength.getLength() == 0) {
			double d = Double.parseDouble(txtImperialLength.getText());
			txtMetricLength.setText(String.valueOf(ConvertMethods.ImperialToMetric(labelImperial, labelMetric, d)));
		}
		if (txtImperialLength.getLength() == 0) {
			double d = Double.parseDouble(txtMetricLength.getText());
			txtImperialLength.setText(String.valueOf(ConvertMethods.MetricToImperial(labelMetric, labelImperial, d)));
		}
		
	}
	
	@FXML
	public void ClearLengthFields (ActionEvent event) {
		txtMetricLength.setText("");
		txtImperialLength.setText("");
	}
	
	@FXML
	public void ClearMetricFiled (ActionEvent event) {
		txtMetricLength.setText("");
	}
	
	@FXML
	public void ClearImperialFiled (ActionEvent event) {
		txtImperialLength.setText("");
	}
	
	
	
}
