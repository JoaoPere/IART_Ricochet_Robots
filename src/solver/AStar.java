package solver;

import java.util.*;

import board.*;

public class AStar { 
	PriorityQueue<Cell> open;
    boolean closed[][];
    Board board;
    
    int pre[][] = new int[16][16];
    
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
    					tempX = l; tempY = p;
    					
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
    		    		
    		        	tempX = l; tempY = p;
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
    		        	
    		        	
    		        	tempX = l; tempY = p;
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
    		        	
    		        	tempX = l; tempY = p;
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
    		        	
    		        	tempX = l; tempY = p;
    		        	found = false;
    		        	
    		        	printPre();
    		        	
    		        	System.out.println();
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
    }
}
