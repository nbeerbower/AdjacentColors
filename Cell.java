package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class Cell extends JLabel implements MouseListener {
	private final Color[] colors = {Color.white, Color.blue, Color.red, Color.orange,
									Color.yellow, Color.green, Color.blue};
	
	private int id;
	private int colorIndex;
	private Color color;
	
	public Cell(int id) {
		super(Integer.toString(id));
		this.id = id;
		this.colorIndex = 0;
		this.color = Color.white;
		this.setOpaque(true);
		this.setBackground(color);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.addMouseListener(this);
	}

	public int getId() {
		return id;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		this.setBackground(color);
	}
	
	private void cycleColor() {
		colorIndex = (++colorIndex) % colors.length;
		color = colors[colorIndex];
		this.setBackground(color);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		cycleColor();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
