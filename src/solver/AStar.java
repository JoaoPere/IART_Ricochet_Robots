package solver;

import java.util.*;

import board.*;

public class AStar { 
	Board board;
	PriorityQueue<Cell> open;
    boolean closed[][];
    
    int startI, startJ;
    int endI, endJ;
    Cell [][] grid = new Cell[16][16];
    int pre[][] = new int[16][16];
            
    public void setBlocked(int i, int j){
        grid[i][j] = null;
    }
    
    public void setStartCell(int i, int j){
        startI = i;
        startJ = j;
    }
    
    public void setEndCell(int i, int j){
        endI = i;
        endJ = j; 
    }
    
    void checkAndUpdateCost(Cell current, Cell t, int cost){
        if(t == null || closed[t.i][t.j])return;
        int t_final_cost = t.heuristicCost+cost;
        
        boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.finalCost){
            t.finalCost = t_final_cost;
            t.parent = current;
            if(!inOpen)open.add(t);
        }
    }
    
    public int numberOfZerosInArray(){
    	int res = 0;
    	
    	for(int i=0; i<pre.length; i++){
    		for(int j=0; j<pre[i].length; j++) {
    			if(pre[i][j] < 0) res++;
    		}
    	}
    	
    	System.out.println("NUMBER OF ZEROS: " + res);
    	
    	return res;
    }
    
    public void precompute_costs(BoardPosition end) {
    	int tempX;
    	int tempY;
    	
    	boolean found = false;
    	
    	int num = 0;
    	
    	while(numberOfZerosInArray()>4) {	
    		for(int l=0; l<16; l++) {
    			for(int p=0; p<16; p++) {
    				if(pre[l][p] == num) {
    					tempX = l;
    					tempY = p;
    					
    					for(int i=p; i<16; i++) {
    		        		for(Wall wall : board.board_pos[tempX][tempY].getWalls()) 
    		        			if(wall.getOrientation().equals(Wall.Orientation.RIGHT)) found = true;
    		        		
    		        		if(!found) {
    		        			tempY += 1;
    		            		if(tempY<16 && pre[tempX][tempY] == -5) pre[tempX][tempY] = num+1;
    		        		}
    		        		else 
    		        			break;
    		        	}
    		    		
    		        	tempX = l;
    		        	tempY = p;
    		        	found = false;
    		        	
    		        	for(int i=p; i>=0; i--) {	    		
    		        		for(Wall wall : board.board_pos[tempX][tempY].getWalls()) {
    		            		if(wall.getOrientation().equals(Wall.Orientation.LEFT)) 
    		            			found = true;
    		        		}
    		        		
    		        		if(!found) {
    		        			tempY -= 1;
    		            		if(tempY>=0 && pre[tempX][tempY] == -5) pre[tempX][tempY] = num+1;
    		        		}
    		        		else 
    		        			break;
    		        	}
    		        	
    		        	
    		        	tempX = l;
    		        	tempY = p;
    		        	found = false;
    		        	
    		        	for(int i=l; i<16; i++) {
    		        		for(Wall wall : board.board_pos[tempX][tempY].getWalls()) {
    		            		if(wall.getOrientation().equals(Wall.Orientation.DOWN)) found = true;
    		        		}
    		        		
    		        		if(!found) {
    		        			tempX += 1;
    		            		if(tempY<16 && pre[tempX][tempY] == -5) pre[tempX][tempY] = num+1;
    		        		}
    		        		else 
    		        			break;
    		        	}
    		        	
    		        	tempX = l;
    		        	tempY = p;
    		        	found = false;
    		        	
    		        	for(int i=l; i>=0; i--) {	    		
    		        		for(Wall wall : board.board_pos[tempX][tempY].getWalls()) {
    		            		if(wall.getOrientation().equals(Wall.Orientation.UP)) 
    		            			found = true;
    		        		}
    		        		
    		        		if(!found) {
    		        			tempX -= 1;
    		            		if(tempX>=0 && pre[tempX][tempY] == -5) pre[tempX][tempY] = num+1;
    		        		}
    		        		else 
    		        			break;
    		        	}
    		        	
    		        	tempX = l;
    		        	tempY = p;
    		        	found = false;
    		        	
    		        	printPre();
    				}
    			}
    		}
    		
    		num++;
    	}
 
    	
	
    }
    
    public void printPre() {
    	for (int i=0; i<16; i++) {
    		for (int j=0; j<16; j++) {
    			System.out.print(pre[i][j] + " ");
    			if(j==15) System.out.println();
    		}
    	}
    }
    
    public AStar(Board board, BoardPosition end){ 
    	this.board = board;
    	
    	int x = end.getPosition().getX();
    	int y = end.getPosition().getY();
    	
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				pre[i][j] = -5;
			}
		}
    	
    	pre[x][y] = 0;
    	
    	precompute_costs(end);
    	
        /*open.add(grid[startI][startJ]);
        
        Cell current;
        
        while(true){ 
            current = open.poll();
            if(current==null)break;
            closed[current.i][current.j]=true; 

            if(current.equals(grid[endI][endJ])){
                return; 
            } 

            Cell t;  
            if(current.i-1>=0){
                t = grid[current.i-1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 

                if(current.j-1>=0){                      
                    t = grid[current.i-1][current.j-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }

                if(current.j+1<grid[0].length){
                    t = grid[current.i-1][current.j+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }
            } 

            if(current.j-1>=0){
                t = grid[current.i][current.j-1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 
            }

            if(current.j+1<grid[0].length){
                t = grid[current.i][current.j+1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 
            }

            if(current.i+1<grid.length){
                t = grid[current.i+1][current.j];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 

                if(current.j-1>=0){
                    t = grid[current.i+1][current.j-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }
                
                if(current.j+1<grid[0].length){
                   t = grid[current.i+1][current.j+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }  
            }
        }*/
    }
}
