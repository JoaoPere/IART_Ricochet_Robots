package board;

import java.util.Random;

import board.Wall.Orientation;

public class Board {
	public Robot [] robots;
	public BoardPosition[][] board_pos;
	public Wall[] walls;
	
	Wall right = new Wall(Wall.Orientation.RIGHT);
	Wall left = new Wall(Wall.Orientation.LEFT);
	Wall down = new Wall(Wall.Orientation.DOWN);
	Wall up = new Wall(Wall.Orientation.UP);
	
	public Board() {
		board_pos = new BoardPosition[16][16];
		robots = new Robot[4];
		
		generateBoardPositions();	
	}
	
	public void generateBoardPositions() {
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {
				this.board_pos[i][j] = new BoardPosition(new Position(i,j));
			}
		}
		
		board_pos[7][7].setCenter();
		board_pos[7][8].setCenter();
		board_pos[8][7].setCenter();
		board_pos[8][8].setCenter();
		
		System.out.println("Generating a random board\n");
		
		Random r = new Random();
		int num = r.nextInt(2);
		
		generateBoard(0);
	}
	
 	public void moveRobot(BoardPosition start, Robot robot, Orientation ori) {
 		int tempX, tempY;
 		
 		tempX = start.getPosition().getX();
 		tempY = start.getPosition().getY();
 		
 		boolean placed = false;
 		
 		while(!placed) {
 			System.out.println("POS: " + tempX + "," + tempY);
 			
 	 		for(Wall wall : board_pos[tempX][tempY].getWalls()) {
 	 			if(wall.getOrientation().equals(ori)) {
 	 				System.out.println("Placed");
 	 				
 	 				board_pos[tempX][tempY].setRobot(robot);
 	 				board_pos[start.getPosition().getX()][start.getPosition().getY()].setRobot(null);
 	 				placed = true;
 	 				
 	 				break;
 	 			}	 			
 	 		}
 			if((ori.equals(Wall.Orientation.RIGHT) && board_pos[tempY++][tempX].hasRobot()) || 
 				ori.equals(Wall.Orientation.LEFT) && board_pos[tempY--][tempX].hasRobot() ||
 				ori.equals(Wall.Orientation.DOWN) && board_pos[tempY][tempX++].hasRobot() ||
 				ori.equals(Wall.Orientation.UP) && board_pos[tempY][tempX--].hasRobot()) {
 				
 				System.out.println("Placed");
 				
 				board_pos[tempX][tempY].setRobot(robot);
 				board_pos[start.getPosition().getX()][start.getPosition().getY()].setRobot(null);
 				placed = true;
 				
 				break;
 			}	 	
 	 		
 			if(placed == false) {
 				if(ori.equals(Wall.Orientation.RIGHT)) tempY++;
 				else if(ori.equals(Wall.Orientation.LEFT)) tempY--;
 				else if(ori.equals(Wall.Orientation.DOWN)) tempX++;
 				else if(ori.equals(Wall.Orientation.LEFT)) tempX--;
 			}
 		}
 	}
	
	public void generateBoard(int num) {
		TargetChip blueChip = new TargetChip('b');
		TargetChip greenChip = new TargetChip('g');
		TargetChip yellowChip = new TargetChip('y');
		TargetChip redChip = new TargetChip('r');
		
		TargetChip multiChip = new TargetChip('m');
	
		
		switch(num) {
		case 0:
			board_pos[0][0].setRobot(new Robot('4'));
			board_pos[2][1].setRobot(new Robot('2'));
			board_pos[4][7].setRobot(new Robot('3'));
			board_pos[5][12].setRobot(new Robot('1'));
			
			board_pos[0][0].setStartSpaceMarker(new StartSpaceMarker('R'));
			board_pos[2][1].setStartSpaceMarker(new StartSpaceMarker('B'));
			board_pos[4][7].setStartSpaceMarker(new StartSpaceMarker('Y'));
			board_pos[5][12].setStartSpaceMarker(new StartSpaceMarker('G'));
			
			board_pos[2][5].setTargetChip(blueChip);
			board_pos[3][9].setTargetChip(blueChip);
			board_pos[10][6].setTargetChip(blueChip);
			board_pos[9][13].setTargetChip(blueChip);
			
			board_pos[1][13].setTargetChip(greenChip);
			board_pos[4][2].setTargetChip(greenChip);
			board_pos[14][10].setTargetChip(greenChip);
			board_pos[14][3].setTargetChip(greenChip);
			
			board_pos[6][1].setTargetChip(yellowChip);
			board_pos[9][4].setTargetChip(yellowChip);
			board_pos[11][9].setTargetChip(yellowChip);
			board_pos[6][12].setTargetChip(yellowChip);
			
			board_pos[4][14].setTargetChip(redChip);
			board_pos[5][7].setTargetChip(redChip);
			board_pos[13][1].setTargetChip(redChip);
			board_pos[13][14].setTargetChip(redChip);
			
			board_pos[12][7].setTargetChip(multiChip);
			
			board_pos[0][3].addWall(right);
			board_pos[0][4].addWall(left);
			
			board_pos[0][9].addWall(right);
			board_pos[0][10].addWall(left);
			
			board_pos[1][13].addWall(right);
			board_pos[1][14].addWall(left);
			
			board_pos[2][5].addWall(right);
			board_pos[2][6].addWall(left);
			
			board_pos[3][8].addWall(right);
			board_pos[3][9].addWall(left);
			
			board_pos[4][2].addWall(right);
			board_pos[4][3].addWall(left);
			
			board_pos[4][14].addWall(right);
			board_pos[4][15].addWall(left);
			
			board_pos[5][6].addWall(right);
			board_pos[5][7].addWall(left);
			
			board_pos[6][0].addWall(right);
			board_pos[6][1].addWall(left);
			
			board_pos[6][11].addWall(right);
			board_pos[6][12].addWall(left);
			
			board_pos[9][3].addWall(right);
			board_pos[9][4].addWall(left);
			
			board_pos[9][12].addWall(right);
			board_pos[9][13].addWall(left);
			
			board_pos[10][5].addWall(right);
			board_pos[10][6].addWall(left);
			
			board_pos[11][9].addWall(right);
			board_pos[11][10].addWall(left);
			
			board_pos[13][1].addWall(right);
			board_pos[13][2].addWall(left);
			
			board_pos[13][14].addWall(right);
			board_pos[13][15].addWall(left);
			
			board_pos[14][3].addWall(right);
			board_pos[14][4].addWall(left);
			
			board_pos[14][9].addWall(right);
			board_pos[14][10].addWall(left);
			
			board_pos[15][4].addWall(right);
			board_pos[15][5].addWall(left);
			
			board_pos[15][11].addWall(right);
			board_pos[15][12].addWall(left);
			
			board_pos[1][13].addWall(down);
			board_pos[2][13].addWall(up);
			
			board_pos[1][15].addWall(down);
			board_pos[2][15].addWall(up);
			
			board_pos[2][5].addWall(down);
			board_pos[3][5].addWall(up);
			
			board_pos[2][9].addWall(down);
			board_pos[3][9].addWall(up);
			
			board_pos[3][2].addWall(down);
			board_pos[4][2].addWall(up);
			
			board_pos[3][14].addWall(down);
			board_pos[4][14].addWall(up);
		
			board_pos[4][0].addWall(down);
			board_pos[5][0].addWall(up);
			
			board_pos[5][1].addWall(down);
			board_pos[6][1].addWall(up);
			
			board_pos[5][7].addWall(down);
			board_pos[6][7].addWall(up);
			
			board_pos[6][12].addWall(down);
			board_pos[7][12].addWall(up);
			
			board_pos[9][4].addWall(down);
			board_pos[10][4].addWall(up);
			
			board_pos[9][6].addWall(down);
			board_pos[10][6].addWall(up);
		
			board_pos[9][13].addWall(down);
			board_pos[10][13].addWall(up);
			
			board_pos[10][0].addWall(down);
			board_pos[11][0].addWall(up);
			
			board_pos[11][7].addWall(down);
			board_pos[12][7].addWall(up);
			
			board_pos[11][9].addWall(down);
			board_pos[12][9].addWall(up);
		
			board_pos[11][15].addWall(down);
			board_pos[12][15].addWall(up);
			
			board_pos[12][1].addWall(down);
			board_pos[13][1].addWall(up);
			
			board_pos[12][14].addWall(down);
			board_pos[13][14].addWall(up);
			
			board_pos[13][10].addWall(down);
			board_pos[14][10].addWall(up);
			
			board_pos[14][3].addWall(down);
			board_pos[15][3].addWall(up);
			
			board_pos[6][7].addWall(down);
			board_pos[7][7].addWall(up);
			
			board_pos[6][8].addWall(down);
			board_pos[7][8].addWall(up);
			
			board_pos[8][7].addWall(down);
			board_pos[9][7].addWall(up);
			
			board_pos[8][8].addWall(down);
			board_pos[9][8].addWall(up);
			
			board_pos[7][6].addWall(right);
			board_pos[7][7].addWall(left);
			
			board_pos[8][6].addWall(right);
			board_pos[8][7].addWall(left);
			
			board_pos[7][8].addWall(right);
			board_pos[7][9].addWall(left);
			
			board_pos[8][8].addWall(right);
			board_pos[8][9].addWall(left);
			
			for(int i = 0; i<16; i++) {
				for (int j=0; j<16; j++) {
					if(i == 0) board_pos[i][j].addWall(up);
					if(i==15) board_pos[i][j].addWall(down);
					if(j==0) board_pos[i][j].addWall(left);
					if(j==15) board_pos[i][j].addWall(right);
				}
			}
		}	
	}
	
	@Override
	public String toString(){
		String res = "";
		String aux = "";
		
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {	
				if(board_pos[i][j].getWalls().contains(down)) 
					aux += " _  ";
				else 
					aux+="    ";
				
				res += " " + board_pos[i][j].getChar() + " ";
				
				if(board_pos[i][j].getWalls().contains(right)) 
					res += "|";
				else 
					res += " ";
			}
			res +="\n" + aux + "\n";
			aux = "";
		}
		return res;
	}
	
	public void printRobotPositions() {
		for(int i=0; i<board_pos.length; i++) {
			for(int j=0; j<board_pos[i].length; j++) {
				if(board_pos[i][j].getRobot() != null) 
					System.out.println("Robot with color " + board_pos[i][j].getRobot().getColor() + " on position " + board_pos[i][j].getPosition().getX() +"," + board_pos[i][j].getPosition().getY());
			}
		}
	}
}
