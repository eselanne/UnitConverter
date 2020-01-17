
public class ConvertMethods {

	public static double MetricToImperial(String m, String i, double d) {
		double a = ConvertBasicToImperial(i, ConvertMetricToBasic(m, d));
		return a;
	}

	public static double ImperialToMetric(String i, String m, double d) {
		double a = ConvertBasicToMetric(m, ConvertImperialToBasic(i, d));
		return a;
	}

	// Muuntaa lukuarvon metreiksi ja metrit jaloiksi
	public static double ConvertMetricToBasic(String s, double d) {
		double a = 3;
		// muunnos metreiksi
		switch (s) {
		case "Millimeter":
			a = d/1000;
			break;
		case "Centimeter":
			a = d / 100;
			break;
		case "Meter":
			a = d;
			break;
		case "Kilometer":
			a = d * 1000;
			break;
		}
		// muunos jaloiksi
		a = a * 3.2808399;
		return a;

	}

	// Muuttaa lukuarvon jaloiksi ja jalat metreiksi
	public static double ConvertImperialToBasic(String s, double d) {
		String test = s;
		double a = 0;
		// muunnos jaloksi
		switch (test) {
		case "Inch":
			a = d * 0.0833333333;
			break;
		case "Foot":
			a = d;
			break;
		case "Yard":
			a = d * 3;
			break;
		case "Mile":
			a = d * 5280;
			break;
		}
		// muunos metreiksi
		a = a * 0.3048;
		return a;

	}

	// Muuttaa jalat haluttuun imperiaali-yksikköön
	public static double ConvertBasicToImperial(String s, double d) {
		double a = 3;
		switch (s) {
		case "Inch":
			a = d * 12;
			break;
		case "Foot":
			a = d;
			break;
		case "Yard":
			a = d / 3;
			break;
		case "Mile":
			a = d / 5280;
			break;
		}
		return a;

	}

	// muuttaa metrit haluttuun metriseen yksikköön
	public static double ConvertBasicToMetric(String s, double d) {
		double a = 0;
		String test = s;
		switch (test) {
		case "Millimeter":
			a = d * 1000;
			break;
		case "Centimeter":
			a = d * 100;
			break;
		case "Meter":
			a = d;
			break;
		case "Kilometer":
			a = d / 1000;
			break;
		}
		return a;

	}

}
