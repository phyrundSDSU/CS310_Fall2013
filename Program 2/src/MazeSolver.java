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
		
		//grid.markDistance(grid.getCell(10,2));

		//System.out.print(grid.getCell(5, 1));
		
		/*enqueue cell(0,0)
		while( the queue is not empty ) {
		    dequeue a GridCell from the queue.
		    mark each adjacent neighboring cell and enqueue it
		    }
		 */
		

		queuCell.enqueue(grid.getCell(0, 0));

		while(!queuCell.isEmpty())
		{
			GridCell cell = queuCell.dequeue();
			int cRow = cell.getX();
			int cCol = cell.getY();
			GridCell temp;
			
			//top
			if(grid.isValidMove(grid.getCell(cRow-1,cCol))){
				temp=grid.getCell(cRow-1,cCol);
				
				
				if(!temp.wasVisited()){
					temp.setDistance(1);	
					queuCell.enqueue(temp);
					grid.markDistance(temp);
				}
			}
			//down
			if( grid.isValidMove(grid.getCell(cRow+1,cCol))){
				temp=grid.getCell(cRow+1,cCol);
				
				if(!temp.wasVisited()){
				temp.setDistance(1);
				queuCell.enqueue(temp);
				grid.markDistance(temp);
				}
			}
			//left
			if(grid.isValidMove(grid.getCell(cRow,cCol-1))){
				temp=grid.getCell(cRow,cCol-1);
				
				if(!temp.wasVisited()){
				temp.setDistance(1);
				queuCell.enqueue(temp);
				grid.markDistance(temp);
				}
			}
			//right
			if( grid.isValidMove(grid.getCell(cRow,cCol+1))){
				temp=grid.getCell(cRow,cCol+1);
				
				if(!temp.wasVisited()){
				temp.setDistance(1);
				queuCell.enqueue(temp);
				grid.markDistance(temp);
			}
			}

		}
	}
	
	public boolean move(){
		
		//queuCell.enqueue(null);
		//grid.isValidMove(null);
		/*distance = terminal_cell.getDistance();
		if(distance == -1) return false;  // unreachable, puzzle has no solution
		push terminal cell onto the stack
		while(distance != 0) {
		    get distance from each cell adjacent to the top of the stack
		    select the cell with smallest distance and push on the stack
		    }
		while( stack is not empty ) {
		    pop grid cell off the stack and mark it
		    }*/
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
