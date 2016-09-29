package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import algo.AdjacencyFinder;

public class MainFrame extends JFrame {
	
	private JPanel infoPanel;
	private JPanel cellPanel;
	private Cell[][] cells;
	private GridLayout cellGrid;
	private JTextField inputField;
	private JButton goButton;
	private JLabel resultLabel;
	private JPanel inputPanel;
	
	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		// Call JFrame constructor
		super("Adjacent Colors");
		
		// Make the app look nice and pretty (I'm sorry, swing is hideous though)
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		// Make some constants for convenience 
		final int rows = AdjacentColors.rows;
		final int columns = AdjacentColors.columns;
		final int total = rows * columns;
		
		// Initialize the cell grid
		cells = new Cell[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cells[i][j] = new Cell(columns*i+j);
			}
		}
		
		// Setup GUI elements
		this.setLayout(new BorderLayout());
		
		infoPanel = new JPanel();
		infoPanel.setBackground(Color.gray);
		infoPanel.setLayout(new BorderLayout());
		this.add(infoPanel, BorderLayout.NORTH);
		
		inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout());
		inputField = new JTextField("", 5);
		inputPanel.add(inputField, BorderLayout.WEST);
		goButton = new JButton("Go!");
		inputPanel.add(goButton, BorderLayout.EAST);
		infoPanel.add(inputPanel, BorderLayout.WEST);
		resultLabel = new JLabel("Enter an index to find # of adjacent colored cells.");
		infoPanel.add(resultLabel, BorderLayout.EAST);
		
		cellPanel = new JPanel();
		cellPanel.setBackground(Color.black);
		this.add(cellPanel, BorderLayout.CENTER);
		
		cellGrid = new GridLayout(rows, columns);
		cellPanel.setLayout(cellGrid);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				cellPanel.add(cells[i][j]);
			}
		}
		
		goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String input = inputField.getText();
				int cellNum;
				try {
					cellNum = Integer.parseInt(input);
				} catch (NumberFormatException ex) {
					resultLabel.setText("Please enter a valid input.");
					return;
				}
				
				if (cellNum < 0 || cellNum > total) {
					resultLabel.setText("Please enter a valid input.");
					return;
				}
				
				final int row = (int) Math.floor(cellNum / columns);
				final int column = cellNum - (row * columns);
				System.out.println("Row: " + row + " Column: " + column);
				
				AdjacencyFinder adjFinder = new AdjacencyFinder(cells, row, column);
				int adjCells = adjFinder.getResultSet().size() - 1;
				resultLabel.setText(cellNum + " has " + adjCells + " adjacent cells of the same color.");
			}
		});
	}

}
