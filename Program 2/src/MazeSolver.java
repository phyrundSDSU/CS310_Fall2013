/*	MazeGrid.java
    The GUI for the MazeSolver class
	Phyrun Diep
	CS310 Fall 2013
*/  


import javax.swing.JOptionPane;

import data_structures.*;

public class MazeSolver {
	
	private MazeGrid grid;
	private Queue<GridCell> queuCell = new Queue<GridCell>();
	private Stack<GridCell> stackCell = new Stack<GridCell>();
	

	
	public MazeSolver(int dim){
		grid = new MazeGrid(this, dim);
	}
	
	public void mark(){
		
		//grid.markDistance();

		System.out.print("Mark button was pressed");
		 
		 
	}
	
	public boolean move(){
		
		queuCell.enqueue(null);
		//grid.isValidMove(null);
		return false;
	}
	
	public void reset(){
		
		// Add makeEmpty() functions for Stack and Queues
		if(!queuCell.isEmpty()){
			System.out.print("Reset button was pressed + queue is empty");
		}
		else
			queuCell.makeEmpty();
		
	}
	
	//Beginning Main method inside MazeSolver class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MazeSolver(20);
		
	}
	

}
