package entities.pieces;

import entities.Space;
import entities.enums.Color;


public abstract class Piece {
	private Space currentSpace;
	private Color color;

	public Piece(Space currentSpace) {
		this.currentSpace = currentSpace;
	}
	
	public abstract void move(Space space);
	
	public Space getSpace() {
		return this.currentSpace;
	}
	
	public void setSpace(Space space) {
		this.currentSpace = space;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
