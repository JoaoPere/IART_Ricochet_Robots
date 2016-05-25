package gui;

import board.*;
import solver.*;

public class Console {
	public static void main(String[] args) {
		Board board = new Board();
		
		System.out.println(board);
		
		AStar astar = new AStar(board,board.board_pos[3][1]);
		
	}

}
