package board;

import java.util.Set;
import java.util.HashSet;

public class BoardPosition {
	public StartSpaceMarker start;
	public TargetChip targetChip;
	public Position pos;
	
	public boolean center;
	public char id;
	
	public Set<Wall> walls;
	
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
		
		walls = new HashSet<Wall>();
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
	
	public Set<Wall> getWalls() {
		return this.walls;
	}
	
	public void setWalls(Set<Wall> wall) {
		this.walls = wall;
	}
	
	public void addWall(Wall wall) {
		walls.add(wall);
	}
	
	public void setPosition(Position pos) {
		this.pos = pos;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public void printWalls() {
		System.out.println("Printing walls");
		
		for(Wall wall : walls) {
			System.out.print("Wall found with dir: ");
			
			if(wall.getOrientation().equals(Wall.Orientation.RIGHT)) System.out.println("RIGHT");
			else if(wall.getOrientation().equals(Wall.Orientation.LEFT)) System.out.println("LEFT");
			else if(wall.getOrientation().equals(Wall.Orientation.DOWN)) System.out.println("DOWN");
			else if(wall.getOrientation().equals(Wall.Orientation.UP)) System.out.println("UP");
		}
	}
}
