/*
File name: CalculatorSplashScreen.java
Author: Exequiel Repetto
Course: CST8221 Java Application Programming, Lab Section: 301
Assignment: #1 part 2
Date: 06/11/2018
Professor: Svillen Ranev
Purpose: splash screen is going to be created in this class
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;

/**
 * This class will create the splash window that will be display before the
 * calculator starts
 * 
 * @author Exequiel Repetto
 * @version 1.0
 * @see Calculator
 * @since 1.8.0_131
 */
public class CalculatorSplashScreen extends JWindow {

	/** {@value serialVersionUID} serialVersionUID */
	private static final long serialVersionUID = 1L;
	/** duration of splash screen */
	private final int duration;
	private JProgressBar progressBar;
	public static final int PB_MINIMUM = 0;
	public static final int PB_MAXIMUM = 100;

	public CalculatorSplashScreen(int duration) {
		this.duration = duration;
	}

	/**
	 * Constructor of the class
	 */
	public void showSplashWindow() {

		progressBar = new JProgressBar();
		progressBar.setMinimum(PB_MINIMUM);
		progressBar.setMaximum(PB_MAXIMUM);
		progressBar.setPreferredSize(new Dimension(80, 20));
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		createSplash();
	}

	/**
	 * method will create the splash window
	 * 
	 */
	private void createSplash() {

		/* creates a new JPanel */
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(Color.WHITE);
		/* Positions windows in the center of the screen */
		int width = 534 + 10;
		int height = 520 + 10;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		setBounds(x, y, width, height);

		/* creates new JLabel with image */
		JLabel label = new JLabel(new ImageIcon(getClass().getResource("calculator.gif")));
		JLabel splash = new JLabel("Exequiel Repetto 040885774", JLabel.CENTER);
		splash.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 20));
		content.add(label, BorderLayout.CENTER);
		content.add(splash, BorderLayout.SOUTH);
		content.add(progressBar, BorderLayout.NORTH);

		Color customColor = new Color(44, 197, 211);
		content.setBorder(BorderFactory.createLineBorder(customColor, 0));
		setContentPane(content);
		setVisible(true);

		for (int i = PB_MINIMUM; i <= duration; i++) {
			int percent = i;

			progressBar.setStringPainted(true);

			try {

				SwingUtilities.invokeLater(new Runnable() {
					public void run() {

						
							
							if( percent < 30) {
							progressBar.setValue(percent);
							progressBar.setString("Loading Calculator. Please wait…");	
							}
							else {
								progressBar.setValue(percent);
								progressBar.setString(percent + "%");
							}
						
						
					}
				});

				java.lang.Thread.sleep(31);

			} catch (InterruptedException e) {
				;
			}

		}

		dispose();

	}

}
