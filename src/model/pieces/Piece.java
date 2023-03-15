package model.pieces;

import model.Space;
import model.pieces.Color;


public abstract class Piece {
	private Space currentSpace;
	
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
}
