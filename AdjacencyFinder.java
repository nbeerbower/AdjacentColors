package algo;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import gui.Cell;
import gui.AdjacentColors;

public class AdjacencyFinder {
	private Set<Cell> results;
	private Cell[][] cells;
	private Cell startingCell;
	private Color targetColor;
	private boolean trace;
	
	public AdjacencyFinder(Cell[][] cells, final int x, final int y) {
		this.cells = cells;
		this.startingCell = cells[x][y];
		this.targetColor = startingCell.getColor();
		this.trace = false;
		
		this.results = new HashSet<Cell>();
		checkAdjacentCells(startingCell, x, y);
	}
	
	public Set<Cell> getResultSet() {
		return results;
	}
	
	private void checkAdjacentCells(Cell root, int x, int y) {
		if (root.getColor() == targetColor && !results.contains(root)) {
			results.add(root);
			if (trace) root.setColor(Color.pink);
			if (x-1 > -1) checkAdjacentCells(cells[x-1][y], x-1, y);
			if (x+1 < AdjacentColors.columns) checkAdjacentCells(cells[x+1][y], x+1, y);
			if (y-1 > -1) checkAdjacentCells(cells[x][y-1], x, y-1);
			if (y+1 < AdjacentColors.rows) checkAdjacentCells(cells[x][y+1], x, y+1);
		}
	}
	
}
