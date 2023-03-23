package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.Color;
import utility.Utils;

public class Bishop extends Piece {
	
	public Bishop(Space currentSpace, Color color, Board board) {
		super(currentSpace, color, board);
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		boolean isValid = false;
		if (Utils.isDiagonalMove(this.getSpace(), targetSpace)) {
			// only if the move is diagonal, check if there are pieces in the path
			if (this.getBoard().isPieceInDiagonalPath(targetSpace, targetSpace)) {
				isValid = true;
			} 
		}
		
		return isValid;
	}
	
	
}
