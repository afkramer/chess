package entities.pieces;

import entities.Space;
import entities.enums.Color;

public class Bishop extends Piece {
	int[][] allowableMoves = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	
	public Bishop(Space currentSpace, Color color) {
		super(currentSpace, color);
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		return false;
	}
	
	
}
