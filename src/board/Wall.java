package board;

public class Wall {
	public char id;
	public Orientation ori;
	
	public enum Orientation {
	    RIGHT, LEFT, UP, DOWN
	}
	
	public Wall(Orientation ori) {
		this.ori = ori;
		
		switch(this.ori) {
		case RIGHT:
			id = '|';
		case LEFT:
			id = '|';
		case UP:
			id = '_';
		case DOWN:
			id = '_';	
		}
	}
	
	public char getID() {
		return this.id;
	}
	
	public void setID(char id) {
		this.id = id;
	}
	
	public Orientation getOrientation() {
		return ori;
	}
}
