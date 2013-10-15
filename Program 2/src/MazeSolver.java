/*	MazeGrid.java
    The GUI for the MazeSolver class
	Phyrun Diep
	CS310 Fall 2013
*/  


import data_structures.*;

public class MazeSolver {
	
	private MazeGrid grid;

	
	public MazeSolver( int dim){
		grid = new MazeGrid(this, dim);
	}
	
	public void mark(){
		grid.markDistance(null);
	}
	
	public boolean move(){
		
		return false;
	}
	
	public void reset(){
		
	}
	
	//Beginning Main method inside MazeSolver class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MazeSolver(25);
		
	}
	

}
