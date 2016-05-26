package board;

public class Robot {
	public char color;
	
	//1 - VERDE, 2 - AZUL, 3 - AMARELO, 4 - VERMELHO
	Robot(char color) {
		this.color = color;
	}
	
	public char getColor() {
		return this.color;
	}
	public void setColor(char color) {
		this.color = color;
	}		
}