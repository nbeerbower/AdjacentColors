package gui;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public class AdjacentColors {
	
	// Define static grid size
	public static final int rows = 5;
	public static final int columns = 5;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// Start a new window
		MainFrame mainFrame = new MainFrame();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		mainFrame.setSize(650,650); 
		mainFrame.setVisible(true); 
	}

}
