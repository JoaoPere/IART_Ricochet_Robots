package board;

public class BoardPosition {
	public StartSpaceMarker start;
	public TargetChip targetChip;
	public Position pos;
	public boolean center;
	public char id;
	
	public Wall wallRight;
	public Wall wallLeft;
	public Wall wallUp;
	public Wall wallDown;
	
	BoardPosition(Position pos, StartSpaceMarker start) {
		this.pos = pos;
		this.start = start;
		this.targetChip = null;
		this.center = false;
		
		this.id = start.getColor();
	}
	
	BoardPosition(Position pos, TargetChip targetChip) {
		this.pos = pos;
		this.targetChip = targetChip;
		this.start = null;
		this.center = false;
		
		this.id = targetChip.getColor();
	}
	
	BoardPosition(Position pos) {
		this.pos = pos;
		this.start = null;
		this.targetChip = null;
		this.center = false;
		
		this.id = '.';
	}
	
	public void setCenter() {
		this.center = true;
		
		this.id = 'C';
	}
	
	public boolean isCenter() {
		return center;
	}
	
	public void setTargetChip(TargetChip targetChip) {
		this.targetChip = targetChip;
		
		this.id = targetChip.getColor();
	}
	
	public TargetChip getTargetChip() {
		return this.targetChip;
	}
	
	public void setStartSpaceMarker(StartSpaceMarker start) {
		this.start = start; 
		
		this.id = start.getColor();
	}
	
	public StartSpaceMarker getSpaceMarker() {
		return this.start;
	}
	
	public char getChar() {
		return id;
	}
	
	public Wall getWallRight() {
		return this.wallRight;
	}
	
	public void setWallRight(Wall wall) {
		this.wallRight = wall;
	}
	
	public Wall getWallLeft() {
		return this.wallLeft;
	}
	
	public void setWallLeft(Wall wall) {
		this.wallLeft = wall;
	}
	
	public Wall getWallDown() {
		return this.wallDown;
	}
	
	public void setWallDown(Wall wall) {
		this.wallDown = wall;
	}
	
	public Wall getWallUp() {
		return this.wallUp;
	}
	
	public void setWallUp(Wall wall) {
		this.wallUp = wall;
	}
}
