package entities.pieces;

import entities.Space;
import entities.enums.Color;

public class Queen extends Piece {
	
	public Queen(Space space, Color color) {
		super(space, color);
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		return false;
	}
}
