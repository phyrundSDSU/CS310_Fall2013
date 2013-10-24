/*	MazeGrid.java
    The GUI for the MazeSolver class
	Phyrun Diep
	CS310 Fall 2013
*/  


import javax.swing.JOptionPane;
import data_structures.*;


public class MazeSolver {
	private final int DIMENSION;
	private MazeGrid grid;
	private int distance;
	private Queue<GridCell> queuCell = new Queue<GridCell>();
	private Stack<GridCell> stackCell = new Stack<GridCell>();
	

	
	public MazeSolver(int dim){
		DIMENSION = dim;
		grid = new MazeGrid(this, dim);
		
	}
	
	public void mark(){
				
		/*enqueue cell(0,0)
		while( the queue is not empty ) {
		    dequeue a GridCell from the queue.
		    mark each adjacent neighboring cell and enqueue it
		    }
		 */
		
		grid.getCell(0, 0).setDistance(0);
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
					temp.setDistance(1+cell.getDistance());	
					queuCell.enqueue(temp);
					grid.markDistance(temp);
				}
			}
			//down
			if( grid.isValidMove(grid.getCell(cRow+1,cCol))){
				temp=grid.getCell(cRow+1,cCol);
				
				if(!temp.wasVisited()){
				temp.setDistance(1+cell.getDistance());
				queuCell.enqueue(temp);
				grid.markDistance(temp);
				}
			}
			//left
			if(grid.isValidMove(grid.getCell(cRow,cCol-1))){
				temp=grid.getCell(cRow,cCol-1);
				
				if(!temp.wasVisited()){
				temp.setDistance(1+cell.getDistance());
				queuCell.enqueue(temp);
				grid.markDistance(temp);
				}
			}
			//right
			if( grid.isValidMove(grid.getCell(cRow,cCol+1))){
				temp=grid.getCell(cRow,cCol+1);
				
				if(!temp.wasVisited()){
				temp.setDistance(1+cell.getDistance());
				queuCell.enqueue(temp);
				grid.markDistance(temp);
			}
			}

		}
	}
	
	public boolean move(){
		
		int cRow=DIMENSION-1;
		int cCol=DIMENSION-1;
		
		GridCell workcell = grid.getCell(cRow,cCol);
		distance = workcell.getDistance();
		
		if(distance==-1)
			return false;
		
		stackCell.push(workcell);
		int workingDistance = distance;
		
		while(distance!=0)
		{
			GridCell temp=null;
			workingDistance = Integer.MAX_VALUE;
			GridCell workingCell = stackCell.iterator().next();
			
			cRow = workingCell.getX();
			cCol = workingCell.getY();
			
			//top
			if(grid.isValidMove(grid.getCell(cRow-1,cCol))){
				temp=grid.getCell(cRow-1,cCol);
					
				if(temp.wasVisited()){
					workingCell = temp;
					workingDistance = temp.getDistance();
				}
			}
			//down
			if( grid.isValidMove(grid.getCell(cRow+1,cCol))){
				temp=grid.getCell(cRow+1,cCol);	
				
				if(temp.wasVisited() && workingCell!=null){
					workingCell = temp.getDistance()<=workingDistance?temp:workingCell;
				}else{
					workingCell = temp;
				}
				workingDistance = workingCell.getDistance()==-1?workingDistance:workingCell.getDistance();
			}
			//left
			if(grid.isValidMove(grid.getCell(cRow,cCol-1))){
				temp=grid.getCell(cRow,cCol-1);
				
				if(temp.wasVisited() && workingCell!=null){
					workingCell = temp.getDistance()<=workingDistance?temp:workingCell;
				}else{
					workingCell = temp;
				}
				workingDistance = workingCell.getDistance()==-1?workingDistance:workingCell.getDistance();
			}
			//right
			if( grid.isValidMove(grid.getCell(cRow,cCol+1))){
				temp=grid.getCell(cRow,cCol+1);
				
				if(temp.wasVisited() && workingCell!=null){
					workingCell = temp.getDistance()<=workingDistance?temp:workingCell;
				}else{
					workingCell = temp;
				}
				workingDistance = workingCell.getDistance()==-1?workingDistance:workingCell.getDistance();				
			}
			
			distance = workingDistance; //need to check if workingCell is Unset/Unvisited cell
			if(distance!=-1)
				stackCell.push(workingCell);
		}
		
		while(!stackCell.isEmpty()){
			
			GridCell tmpCell = stackCell.peek();
			grid.markMove(tmpCell);
			stackCell.pop();
		}
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
		
		
		
		
		
		return true;
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
