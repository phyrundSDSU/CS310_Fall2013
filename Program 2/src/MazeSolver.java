/*	MazeGrid.java
    The GUI for the MazeSolver class
	Phyrun Diep
	CS310 Fall 2013
*/  


import javax.swing.JOptionPane;

import data_structures.*;

public class MazeSolver {
	
	private MazeGrid grid;
	private Stack<GridCell> distance = new Stack<GridCell>();

	
	public MazeSolver(int dim){
		grid = new MazeGrid(this, dim);
	}
	
	public void mark(){
		//distance.push(50,20);
		System.out.print("Mark button was pressed");
		 
		 
	}
	
	public boolean move(){
		
		return false;
	}
	
	public void reset(){
		
		// Add makeEmpty() functions for Stack and Queues
		System.out.print("Reset button was pressed");
	}
	
	//Beginning Main method inside MazeSolver class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MazeSolver(20);
		
	}
	

}
