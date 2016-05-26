package gui_console;

import board.*;
import solver.*;

public class Console {
	public static void main(String[] args) {
		Board board = new Board();
		
		board.printRobotPositions();
		
		System.out.println('\n');
		
		System.out.println(board);
		
		System.out.println('\n');
		
		board.moveRobot(board.board_pos[0][0], board.board_pos[0][0].getRobot(), Wall.Orientation.DOWN);
		
		board.printRobotPositions();
		
		//AStar astar = new AStar(board,board.board_pos[3][1]);
		
	}

}
