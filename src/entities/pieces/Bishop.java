package entities.pieces;

import entities.Space;
import entities.enums.Color;
import utility.Utils;

public class Bishop extends Piece {
	int[][] allowableMoves = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
	
	public Bishop(Space currentSpace, Color color) {
		super(currentSpace, color);
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		boolean isValid = false;
		if (Utils.isDiagonalMove(this.getSpace(), targetSpace)) {
			// only if the move is diagonal, check if there are pieces in the path 
		}
		
		return isValid;
	}
	
	
}
