package friedman_p2;

import java.util.Scanner;

public class BMICalculator {
	public static class Global {
		public static int unitType;
		public static int weight, height;
		public static double bmi;
	}
	
	public static void main(String[] args) {
		BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
	
	public static int getInt() {
		Scanner in = new Scanner(System.in);
		int value = in.nextInt();
		//in.close();
		
		return value;
	}
	//Main method for getting user data
	public static void readUserData() {
		Global.unitType = readUnitType();
		readMeasurementData(Global.unitType);
	}
	//Asks the user to enter 1 or 2 and asks again if anything else is entered
	private static int readUnitType() {
		int unitType;
		
		do {
			System.out.print("Enter 1 to use metric units\nEnter 2 to use imperial units\n");
			
			unitType = getInt();
			
			if (unitType != 1 && unitType != 2) {
				System.out.print("Invalid entry. Enter a 1 or a 2.\n\n");
			}
		} while(unitType != 1 && unitType != 2);
		
		return unitType;
	}
	//Uses metric or imperial units depending on what the user entered
	public static void readMeasurementData(int unitType) {
		if (unitType == 1) {
			readMetricData();
		}
		else {
			readImperialData();
		}
	}
	
	private static void readMetricData() {
		
		System.out.print("Please enter your weight in kilograms: ");
		
		getWeight();
		
		System.out.print("Please enter your height in meters: ");

		getHeight();
	}
	
	private static void readImperialData() {
		
		System.out.print("Please enter your weight in pounds: ");
		
		getWeight();
		
		System.out.print("Please enter your height in inches: ");

		getHeight();
	}
	
	public static void getWeight() {
		int weight;
		
		weight = getInt();
		
		if(weight < 0) {
			System.exit(0);
		}
		else {
			setWeight(weight);
		}
	}
	
	private static void setWeight(int weight) {
		Global.weight = weight;
	}
	
	public static void getHeight() {
		int height;
		
		height = getInt();
		
		if(height < 0) {
			System.exit(0);
		}
		else {
			setHeight(height);
		}
	}
	
	private static void setHeight(int height) {
		Global.height = height;
	}
	//Main method for calculating bmi
	public static void calculateBmi() {
		calculateBmiCategory();
	}
	
	private static void calculateBmiCategory() {
		if (Global.unitType == 1) {
			calculateMetricBmi();
		}
		else {
			calculateImperialBmi();
		}
	}
	
	//performs the calculation for metric units
	public static void calculateMetricBmi() {
		Global.bmi = Global.weight/Math.pow(Global.height,2);
	}
	//performs the calculation for imperial units
	public static void calculateImperialBmi() {
		Global.bmi = 703*Global.weight/Math.pow(Global.height,2);
	}
	//main method for end display
	public static void displayBmi() {
		getBmi();
		getBmiCategory();
	}
	
	public static void getBmi() {
		System.out.print("Your BMI value is " + Global.bmi + "\n\n");
	}
	
	public static void getBmiCategory() {
		System.out.print("BMI Categories:\nUnderweight = <18.5\nNormal weight = 18.5–24.9\nOverweight = 25–29.9\nObesity = BMI of 30 or greater\n");
	}
}