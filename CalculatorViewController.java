/*
File name: CalculatorViewController.java
Author: Exequiel Repetto
Course: CST8221 Java Application Programming, Lab Section: 301
Assignment: #1 part 2
Date: 06/11/2018
Professor: Svillen Ranev
Purpose: This class is going to created the GUI
Class list: CalculatorViewController, Controller
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

/**
 * This class will create the calculator GUI
 * 
 * @author Exequiel Repetto
 * @version 1.0
 * @see Calculator
 * @since 1.8.0_131
 */
public class CalculatorViewController extends JPanel {

	/**
	 * {@value serialVersionUID} serialVersionUID*
	 */
	private static final long serialVersionUID = 1L;

	/** the calculator display1 field reference */
	private JTextField display1;

	/** the calculator display2 field reference */
	private JTextField display2;

	/** the mode error display label reference */
	private JLabel error;

	/** the decimal point (dot) button reference */
	private JButton dotButton;

	/** array for calculator keypad */
	private static final String Numbers[] = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".",
			"\u00B1", "+" };
	/** the calculator 0.0 button*/
	private JRadioButton middle = new JRadioButton(".00", true);
	/**
	 * Constructor of the class
	 */
	public CalculatorViewController() {
		createGui();
	}

	/**
	 * This method will create a new JButton
	 * 
	 * @param text    Button text label
	 * @param ac      action command string for the button
	 * @param fg      foreground color of the button
	 * @param bg      background color of the button
	 * @param handler reference to instance of the event handler class
	 * @return JButton
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler) {
		/** creates a new JButton */
		JButton button = new JButton(text);

		/** store the default font from dotButton */
		String defaultFont = button.getFont().getName();

		button.setBackground(bg);
		button.setForeground(fg);

		if (!ac.equals(null)) {
			button.setActionCommand(ac);
		}
		button.setFont(new Font(defaultFont, button.getFont().getStyle(), 20));
		button.addActionListener(handler);

		return button;
	}

	/**
	 * This method will create the GUI
	 */
	private void createGui() {

		/* creates a new instance of Controller */
		ActionListener controller = new Controller();

		/* set a BorderLayout and create a border for the frame */
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));

		/* creates a new JLabel */
		error = new JLabel("F", JLabel.CENTER);
		error.setForeground(Color.black);
		error.setOpaque(true);
		error.setBorder(new MatteBorder(0, 1, 0, 5, Color.BLACK));
		error.setBackground(Color.YELLOW);
		error.setPreferredSize(new Dimension(46, 55));
		error.setFont(new Font(error.getFont().getName(), error.getFont().getStyle(), 20));


		/* creates a new JButton and setup the backSpace jButton */
		JButton backSpace = new JButton("\u21DA");
		backSpace.setPreferredSize(new Dimension(45, 55));
		backSpace.setFont(new Font(backSpace.getFont().getName(), backSpace.getFont().getStyle(), 20));
		backSpace.setForeground(Color.BLACK);
		backSpace.setContentAreaFilled(false);
		backSpace.setBorder(new MatteBorder(0, 5, 0, 1, Color.BLACK));
		backSpace.setToolTipText("BackSpace (Alt-B)");
		backSpace.setActionCommand("\u21DA");
		backSpace.addActionListener(controller);
		backSpace.setMnemonic('b');

		/* creates a new JTextField and setup the display1 */
		display1 = new JTextField();
		display1.setPreferredSize(new Dimension(16, 30));
		display1.setBackground(Color.white);
		display1.setEditable(false);
		display1.setHorizontalAlignment(SwingConstants.RIGHT);
		display1.setBorder(null);

		/* Creates a new JTextField and setup the display2 */
		display2 = new JTextField("0.0");
		display2.setPreferredSize(new Dimension(16, 30));
		display2.setBackground(Color.white);
		display2.setEditable(false);
		display2.setAlignmentX(RIGHT_ALIGNMENT);
		display2.setHorizontalAlignment(SwingConstants.RIGHT);
		display2.setBorder(null);

		/* creates a JPanel to add the 2 JTextField */
		JPanel display = new JPanel(new BorderLayout());
		display.add(display1, BorderLayout.NORTH);
		display.add(display2, BorderLayout.SOUTH);

		/* creates a JPanel to add the radioButtons */
		JPanel radioGroup = new JPanel(new GridLayout(1, 3, 1, 1));

		/* creates a new JRadioButton */
		JRadioButton left = new JRadioButton(".0", false);
		left.setActionCommand(".0");
		left.addActionListener(controller);
		left.setBackground(Color.yellow);

		/* creates a new JRadioButton */
		
		middle.setActionCommand(".00");
		middle.addActionListener(controller);
		middle.setBackground(Color.yellow);

		/* creates a new JRadioButton */
		JRadioButton right = new JRadioButton("Sci", false);
		right.setActionCommand("Sci");
		right.addActionListener(controller);
		right.setBackground(Color.yellow);

		/* adds the Radio Buttons to the radioGroup JPanel */
		radioGroup.add(left);
		radioGroup.add(middle);
		radioGroup.add(right);

		/* creates a new JCheckBox */
		JCheckBox checkBox = new JCheckBox("int");
		checkBox.setBackground(Color.GREEN);
		checkBox.setActionCommand("int");
		checkBox.addActionListener(controller);
		checkBox.setPreferredSize(new Dimension(40, 0));

		/*
		 * creates a new JPanel and adds the radioGroup and checkBox to its specific
		 * location
		 */
		JPanel mode = new JPanel(new BorderLayout());
		mode.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 1));
		mode.setBackground(Color.black);
		mode.add(radioGroup, BorderLayout.EAST);
		mode.add(checkBox, BorderLayout.WEST);

		/* creates a buttonGroup and adds radioButtons created and the checkBox */
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(left);
		buttonGroup.add(middle);
		buttonGroup.add(right);
		buttonGroup.add(checkBox);

		/* adds backSpace, error, display and mode JPanel to the top JPanel */
		JPanel top = new JPanel(new BorderLayout());
		top.setBackground(Color.YELLOW);
		top.add(backSpace, BorderLayout.EAST);
		top.add(error, BorderLayout.WEST);
		top.add(display, BorderLayout.CENTER);
		top.add(mode, BorderLayout.SOUTH);

		/* creates a new JPanel */
		JPanel center = new JPanel(new BorderLayout());

		/* creates a new JPanel for the keyPad */
		JPanel keyPad = new JPanel();
		keyPad.setLayout(new GridLayout(4, 4, 3, 3));
		keyPad.setBackground(Color.white);
		keyPad.setBorder(BorderFactory.createEmptyBorder(2, 3, 2, 3));

		/* creates an the equal button */
		JButton equal = createButton("=", "=", Color.BLACK, Color.YELLOW, controller);
		equal.setPreferredSize(new Dimension(46, 55));
		equal.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));

		/* creates a second equal button */
		JButton equalTwo = createButton("=", "=", Color.black, Color.yellow, controller);
		equalTwo.setPreferredSize(new Dimension(46, 55));
		equalTwo.setBorder(new MatteBorder(0, 5, 0, 1, Color.BLACK));

		/* creates a new JButton for the C button */
		JButton cNorth = createButton("C", "C", Color.black, Color.red, controller);
		cNorth.setPreferredSize(new Dimension(0, 45));

		/* creates a new JButton for a second C button */
		JButton cSouth = createButton("C", "C", Color.black, Color.red, controller);
		cSouth.setPreferredSize(new Dimension(0, 45));

		/* adds cNorth,cSouth buttons and keyPad JPanel to the center JPanel */
		center.add(cNorth, BorderLayout.NORTH);
		center.add(cSouth, BorderLayout.SOUTH);
		center.add(keyPad, BorderLayout.CENTER);

		/* for loop will create all keypads numbers */
		for (int i = 0; i < Numbers.length; i++) {
			/* creates button for the math operation buttons */
			if ((i + 1) % 4 == 0)
				keyPad.add(createButton(Numbers[i], Numbers[i], Color.black, Color.cyan, controller));
			/* creates button for the (dot) */
			else if (i == 13) {
				dotButton = createButton(Numbers[i], Numbers[i], Color.black, Color.blue, controller);
				keyPad.add(dotButton);
			} /* creates button for the (\u00B1) button ) */
			else if (i == 14)
				keyPad.add(createButton(Numbers[i], Numbers[i], Color.black, Color.pink, controller));
			/* creates a button for the rest of the numbers */
			else
				keyPad.add(createButton(Numbers[i], Numbers[i], Color.black, Color.blue, controller));
		}

		/* adds equalTwo, equal, top and center to the principal panel */
		add(equalTwo, BorderLayout.EAST);
		add(equal, BorderLayout.WEST);
		add(top, BorderLayout.NORTH);
		add(center);
	}

	/**
	 * Anonymous class is used to handle the events
	 * 
	 * @author Exequiel Repetto
	 * @version 1.0
	 * @see Calculator
	 * @since 1.8.0_131
	 */
	private class Controller implements ActionListener {
		/**variable used to hold the value of operand one*/
		String operandOne = "0";
		
		/**variable used to hold the value of operand one*/
		String operandTwo = "0";
		
		/**variable will be used to hold the operation pressed by the user*/
		String operation = "";
		
		/**variable will hold the result of the operation*/
		String result = "";
		
		/**variable used to know if error mode is true or false*/
		boolean errorMode = false;
		
		/**if first operand has been set variable will be true */
		boolean firstOperand = false;
		
		/**if equal button is pressed */
		boolean equalPressed = false;
		
		/**variable used to be able to pressed equal multiple times and change value of result */
		boolean multipleEqual = false;
		
		/**variable used to know if mode is set */
		boolean mode = false;
		
		/**variable used to know if there is a 0 been display*/
		boolean displayCero = false;
		
		/** variable used to know if the dot button has been pressed*/
		boolean dotPressed = false;
		
		/** variable used to know if value is negative*/
		boolean negative = false;
		
		/**variable used to know if the second operand is null */
		boolean secondOperandNull = true;
		
		/**variable used to know if the math operation has been set */
		boolean mathOperation = false;
		
		boolean checkBox = false;

		CalculatorModel calculatorModel = new CalculatorModel();

		@Override
		public void actionPerformed(ActionEvent e) {

			switch (e.getActionCommand()) {

			/* checks if radioButtons or checkBox have been selected */
			case "int":				
					
				if (!mode && !errorMode && !checkBox) {
					calculatorModel.setMode(CalculatorModel.INTEGER);
					error.setText("I");
					error.setBackground(Color.GREEN);
					clearValues();
					dotButton.setEnabled(false);
					dotButton.setBackground(new Color(178, 156, 250));
					checkBox =true;
					break;
				}
				
				if (checkBox)
					checkBox = false;
			case ".00":
				if (!mode && !errorMode) {
					calculatorModel.setMode(CalculatorModel.FLOAT_00);
					error.setText("F");
					clearValues();
					error.setBackground(Color.YELLOW);
					dotButton.setEnabled(true);
					dotButton.setBackground(Color.BLUE);
					checkBox = false;
					middle.setSelected(true);;
				}
				break;
			case ".0":
				if (!mode && !errorMode) {
					calculatorModel.setMode(CalculatorModel.FLOAT_0);
					error.setText("F");
					error.setBackground(Color.YELLOW);
					clearValues();
					dotButton.setEnabled(true);
					dotButton.setBackground(Color.BLUE);
					checkBox = false;
				}
				break;
			
			case "Sci":
				if (!mode && !errorMode) {
					calculatorModel.setMode(CalculatorModel.FLOAT_SCI);
					error.setText("F");
					clearValues();
					error.setBackground(Color.YELLOW);
					dotButton.setEnabled(true);
					dotButton.setBackground(Color.BLUE);
					checkBox = false;
				}
				break;
			/* check if any keyPad Number has been pressed */
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				/*if errorMode is false statement will run */
				if (!errorMode) {
					
					/*if first operand has not been set yet it will run this statement and display it in display2 */
					if (!firstOperand) {
						if (operandOne.equals("0"))
							operandOne = "";
						operandOne += e.getActionCommand();					
						display2.setText(operandOne);
						
						/* if first operand has already been set statement is going to run*/
					} else {
						if (operandTwo.equals("0"))
							operandTwo = "";
						operandTwo += e.getActionCommand();
						display2.setText(operandTwo);
						secondOperandNull = false;
					}
					equalPressed = false;
				}
				// negative = true; // cannot be use;
				displayCero = false;
				break;
				/*Check if any mathematical operator have been pressed*/
			case "*":
			case "/":
			case "+":
			case "-":

				/* when user press a math operator for first time */
				if (!errorMode) {

					/* is statement to add to the result if i want to continue calculating */
					if (mathOperation && equalPressed) {
						operation = e.getActionCommand();
						calculatorModel.setMathOperation(operation);
						operandOne = result;
						operandTwo = "0";
						break;
					}

					firstOperand = true;
					negative = false;
					operation = e.getActionCommand();
					calculatorModel.setMathOperation(operation);

					dotPressed = false;
					mathOperation = true;
				}
				break;
				
				/*if equal (=) Symbol has been pressed*/
			case "=":
				
				/* if first operand and second operand are set statement is going to run*/
				if (firstOperand && secondOperandNull) {

					if (!multipleEqual) {
						calculatorModel.setOperandOne(operandOne);
						calculatorModel.setOperandTwo(operandOne);
						multipleEqual = true;
					}

					else if (calculatorModel.getMathOperation() == "/" || calculatorModel.getMathOperation() == "-") {

						calculatorModel.setOperandOne(result);
						calculatorModel.setOperandTwo(operandOne);
					} else {
						calculatorModel.setOperandTwo(result);
					}

					display2.setText(calculatorModel.getResult());
					result = calculatorModel.getResult();

				}
				/*if first operand is the only one been set statement is going to run */
				else if (firstOperand) {
					calculatorModel.setOperandOne(operandOne);
					calculatorModel.setOperandTwo(operandTwo);
					result = calculatorModel.getResult();
					equalPressed = true;
				}
				/*if equal is pressed again it will display a new result*/
				if (equalPressed) {
					if (!calculatorModel.getErrorState()) {
						display1.setText("");
						display2.setText(result);
						/*if error state is true statement will run*/
					} else {
						error.setText("E");
						error.setBackground(Color.RED);
						errorMode = true;
						display1.setText(operandOne + " /");
						display2.setText(calculatorModel.getErrorMessage());
					}
				}

				break;
				/* if clear button has been pressed*/
			case "C":
				clearValues();
				errorMode = false;
				error.setBackground(Color.YELLOW);
				break;
				/*if backSpace button is pressed*/
			case "\u21DA":
				if (equalPressed)
					break;

				if (!errorMode) {
					backSpacePressed();
					if (displayCero)
						break;
					if (!firstOperand)
						display2.setText(operandOne);
					else
						display2.setText(operandTwo);
				}
				break;
				/*if dot button has been pressed*/
			case ".":
				if (dotPressed)
					break;
				if (!firstOperand) {
					operandOne = operandOne + ".";
					dotPressed = true;
					break;
				} else {
					operandTwo = operandTwo + ".";
					dotPressed = true;
					break;
				}
				/*if symbol \u00B1 has been pressed*/
			case "\u00B1":
				if (!negative) {
					if (operandOne.equals("0"))
						operandOne = "";
					if (!firstOperand) {
						operandOne = "-" + operandOne;
						display2.setText(operandOne);
					} else {
						operandTwo = "-" + operandTwo;
						display2.setText(operandTwo);
					}
					negative = true;

					break;

				} else {
					if (!firstOperand) {
						operandOne = getAbsoluteValue(operandOne);
						display2.setText(operandOne);
					} else {
						operandTwo = getAbsoluteValue(operandTwo);
						display2.setText(operandTwo);
					}
					negative = false;

				}

			}

			if (operation != "") {
				display1.setText(operandOne + operation);
				operation = "";
			}

		}
		
		/**
		 * method will clear all the values to its default value
		 * 
		 */
		public void clearValues() {

			/* if mode is integer it will set the display to 0 and the label to I*/
			if (calculatorModel.getMode() == CalculatorModel.INTEGER) {
				display2.setText("0");
				error.setText("I");
				/*if mode is floating point it will set the display to 0.0 and the label to F */
			} else {
				error.setText("F");
				display2.setText("0.0");
			}
			
			display1.setText("");
			operandOne = "0";
			operandTwo = "0";
			operation = "";
			result = "";
			firstOperand = false;
			equalPressed = false;
			dotPressed = false;
			negative = false;
			mathOperation = false;
			secondOperandNull = true;
			multipleEqual = false;
			calculatorModel.setErrorState(false);

		}
		
		/**
		 * method will run when backSpace button is pressed
		 */
		public void backSpacePressed() {

			String temp = "";
			int lenght = 0;

			if (!firstOperand) {

				lenght = operandOne.length();
				for (int i = 0; i < lenght - 1; i++)
					temp += operandOne.charAt(i);
				operandOne = temp;
				if (temp.equals("") || temp.equals("-")) {
					if (calculatorModel.getMode() == CalculatorModel.INTEGER) {
						display2.setText("0");
						operandOne = "";
					} else {
						display2.setText("0.0");
						operandOne = "";
					}
					displayCero = true;
					return;
				}

			}

			else {

				lenght = operandTwo.length();
				for (int i = 0; i < lenght - 1; i++)
					temp += operandTwo.charAt(i);

				if (temp.equals("") || temp.equals("-")) {
					if (calculatorModel.getMode() == CalculatorModel.INTEGER) {
						display2.setText("0");
						operandTwo = "";
					} else {
						display2.setText("0.0");
						operandTwo = "";
					}
					displayCero = true;
					return;
				}

				operandTwo = temp;
			}
		}
		/**
		 * method will convert the value passed to it to its positive value
		 * @param value get the string value to convert
		 * @return temp return the converted value
		 */
		public String getAbsoluteValue(String value) {

			int lenght = value.length();
			String temp = "";

			for (int i = 1; i < lenght; i++)
				temp += value.charAt(i);

			return temp;

		}

	}

}
