package board;

import pieces.*;
import java.util.Random;


public class Board {
	public Robot[] robots;
	public BoardPosition[][] board_pos;
	public Wall[] walls;
	
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
		int num = r.nextInt(5);
		
		generateBoard(0);
	}
	
	public void generateBoard(int num) {
		TargetChip blueChip = new TargetChip('b');
		TargetChip greenChip = new TargetChip('g');
		TargetChip yellowChip = new TargetChip('y');
		TargetChip redChip = new TargetChip('r');
		
		TargetChip multiChip = new TargetChip('m');
		
		Wall horWall = new Wall('|');
		Wall verWall = new Wall('_');
		
		switch(num) {
		case 0:
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
			
			board_pos[0][3].setWallRight(horWall);
			board_pos[0][4].setWallLeft(horWall);
			board_pos[0][9].setWallRight(horWall);
			board_pos[0][10].setWallLeft(horWall);
			board_pos[1][13].setWallRight(horWall);
			board_pos[1][14].setWallLeft(horWall);
			
			board_pos[1][13].setWallDown(verWall);
			board_pos[2][13].setWallUp(verWall);
			board_pos[1][15].setWallDown(verWall);
			board_pos[2][15].setWallUp(verWall);
		}
	}
	
	@Override
	public String toString(){
		String res = "";
		String aux = "";
		
		for(int i=0; i<16; i++) {
			for(int j=0; j<16; j++) {				
				if(board_pos[i][j].getWallDown() != null) aux += " " + board_pos[i][j].getWallDown().getID() + "  ";
				else aux+="    ";
				
				res += " " + board_pos[i][j].getChar() + " ";
				
				if(board_pos[i][j].getWallRight() != null) res += board_pos[i][j].getWallRight().getID();
				else res += " ";
			}
			res +="\n" + aux + "\n";
			aux = "";
		}
		return res;
	}
}
