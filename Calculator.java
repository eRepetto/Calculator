/*
File name: Calculator.java
Author: Exequiel Repetto
Course: CST8221 Java Application Programming, Lab Section: 301
Assignment: #1 part 2
Date: 06/11/2018
Professor: Svillen Ranev
Purpose: Class contain main method where program is going to run
 */

package calculator;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * This class contain the main method that will run the program
 * 
 * @author Exequiel Repetto
 * @version 1.0
 * @see Calculator
 * @since 1.8.0_131
 */
public class Calculator {

	/**
	 * main method where the program will run
	 * @param args the command line argument
	 */
	public static void main(String[] args) {
		
		/**duration of splashScreen*/
		//int duration = 3400; 
		int duration = 100;
		CalculatorSplashScreen splash = new CalculatorSplashScreen(duration);
		splash.showSplashWindow();
		CalculatorViewController calculator = new CalculatorViewController();

		
		EventQueue.invokeLater(new Runnable() {
			@Override
			/**method is separately executing thread*/
			public void run() {
				JFrame frame = new JFrame("Calculator");
				frame.setMinimumSize(new Dimension(380, 520));
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setContentPane(calculator);
				frame.setVisible(true);			

			}

		});

	}

}
