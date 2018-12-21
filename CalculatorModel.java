/*
File name: CalculatorModel.java
Author: Exequiel Repetto
Course: CST8221 Java Application Programming, Lab Section: 301
Assignment: #1 part 2
Date: 06/11/2018
Professor: Svillen Ranev
Purpose: Class contain main method where program is going to run
 */
package calculator;


/**
 * This class will create the calculator model and performs all the calculations that the calculator is required to do
 * 
 * @author Exequiel Repetto
 * @version 1.0
 * @see Calculator
 * @since 1.8.0_131
 */
public class CalculatorModel {

	public static final short INTEGER = 0;
	public static final short FLOAT_0 = 1;
	public static final short FLOAT_00 = 2;
	public static final short FLOAT_SCI = 3;

	private String operandOne;
	private String operandTwo;
	private String mathOperation;
	private String result;
	private String errorMessage;
	private short mode;
	private boolean errorState;

	public CalculatorModel() {
		errorState = false;
		operandOne = "";
		operandTwo = "0";
		mode = FLOAT_00;
	}
	
	/** 
	 * method will set the operand one
	 * @param operand takes the value of operand one
	 * */
	public void setOperandOne(String operand) {
		operandOne = operand;
	}

	/** 
	 * method will set the operand two
	 * @param  operand takes the value of operand two
	 * */
	public void setOperandTwo(String operand) {
		operandTwo = operand;
	}

	/** 
	 * method will set the math operation
	 * @param operation gets the mathematical operation in string format
	 * */
	public void setMathOperation(String operation) {
		mathOperation = operation;
	}

	/** 
	 *method will return the current math operation
	 *@return mathOperation returns the current math operation
	 * */
	public String getMathOperation() {
		return mathOperation;
	}

	/** 
	 * method will set the mode of the calculator
	 * @param mode take an string parameter that wills set the mode
	 * */
	public void setMode(short mode) {
		this.mode = mode;
	}
	/** 
	 * method will return the current mode of the calculator
	 * @return mode returns the current mode of the calculator
	 * */
	public short getMode() {
		return mode;
	}
	
	/** 
	 * method it will return the error message
	 * @return errorMessage return the error message
	 * */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/** 
	 * method will set error state of the calculator
	 * @param error takes a boolean to set the error state
	 * */
	public void setErrorState(boolean error) {
		errorState = error;
	}
	
	/** 
	 *return the error state
	 *@return errorState returns the error state of the calculator
	 * */
	public boolean getErrorState() {
		return errorState;
		}
	
	/** 
	 * method will get the result of the calculations
	 * @return result returns the final result calculated
	 * */
	public String getResult() {
		calculate();
		return result;
	}
	/** 
	 * method will do the calculations of numbers entered by the user
	 * */
	private void calculate() {

		float temp = 0.0f;
		float operandOneF;
		float operandTwoF;
		int operandOneI;
		int operandTwoI;
		/*converts value according its mode*/
		try {

			operandOneF = Float.parseFloat(operandOne);
			operandTwoF = Float.parseFloat(operandTwo);
			operandOneI = (int) operandOneF;
			operandTwoI = (int) operandTwoF;
		} catch (NumberFormatException ex) {
			errorState = true;
			return;
		}
		
		/*if mode is integer and division is by 0 set the error message*/
		if (mode == INTEGER) {

			if (operandTwoI == 0 && mathOperation.equals("/")) {
				setErrorState(true);
				errorMessage = "Cannot devide by zero";
				return;

			} else if (operandOneI == 0 && operandTwoI == 0 && mathOperation.equals("/")) {
				setErrorState(true);
				errorMessage = "Result is undefined";
				return;
			}
			/*makes the calculation according the math operation*/
			switch (mathOperation) {

			case "+":
				result = Integer.toString(operandOneI + operandTwoI);
				return;
			case "-":
				result = Integer.toString(operandOneI - operandTwoI);
				return;
			case "*":
				result = Integer.toString(operandOneI * operandTwoI);
				return;
			case "/":
				result = Integer.toString(operandOneI / operandTwoI);
				return;
			}

		}
		/* else mode is floating point */
		else {

			/*if mode is floating point and division is by 0 set the error message*/
			if (operandOneF == 0 && operandTwoF == 0 && mathOperation.equals("/")) {
				setErrorState(true);
				errorMessage = "Result is undefined";
				return;
			}

			else if (operandTwoF == 0 && mathOperation.equals("/")) {
				setErrorState(true);
				errorMessage = "Cannot devide by zero";
				return;

			}
			/*makes calcualtion according the math operation*/
			switch (mathOperation) {
			case "+":
				temp = operandOneF + operandTwoF;
				break;
			case "-":
				temp = operandOneF - operandTwoF;
				break;
			case "*":
				temp = operandOneF * operandTwoF;
				break;
			case "/":
				temp = operandOneF / operandTwoF;
				break;
			}
			
			/*sets the result according the mode*/
			switch (mode) {

			case FLOAT_0:
				result = String.format("%.1f", temp);
				break;
			case FLOAT_00:
				result = String.format("%.2f", temp);
				break;
			case FLOAT_SCI:
				result = String.format("%E", temp);
				break;

			}

		}

	}
	/** 
	 * method will return the proper display of the number according the mode
	 * @param numbers takes an string with the value of the numbers to convert
	 * @return tempI method will return the number converted to integer of the mode is integer else it will be float
	 * */
	public String getDisplay(String numbers) {

		int tempI = 0;
		float tempF = 0.0f;

		if (mode == INTEGER) {
			tempI = Integer.parseInt(numbers);
			return Integer.toString(tempI);
		}

		else
			tempF = Float.parseFloat(numbers);
		return Float.toString(tempF);

	}

}
