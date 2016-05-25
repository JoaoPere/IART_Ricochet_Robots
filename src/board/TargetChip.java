package board;

public class TargetChip {
	public char color;
	public Type type;
	
	public enum Type {
		T1, T2, T3, T4;
	}
	
	TargetChip(char color){
		this.color = color;
		//this.type = type;
	}
	
	public void setColor(char color) {
		this.color = color;
	}
	
	public char getColor() {
		return this.color;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return this.type;
	}
}
