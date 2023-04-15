package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.SpaceColor;
import entities.enums.PieceType;
import utility.Utils;

public class Bishop extends Piece {
	
	public Bishop(Space currentSpace, SpaceColor color, Board board) {
		super(currentSpace, color, board);
		if (color == SpaceColor.WHITE) {
			this.setPieceType(PieceType.WHITE_BISHOP);
		} else {
			this.setPieceType(PieceType.BLACK_BISHOP);
		}
	}
	
	public void move(Space targetSpace) {
		this.getSpace().setIsFree(true);
		this.setSpace(targetSpace);
		targetSpace.setIsFree(false);
	}
	
	public boolean isMoveValid(Space targetSpace) {
		boolean isValid = false;
		if (Utils.isDiagonalMove(this.getSpace(), targetSpace)) {
			// only if the move is diagonal, check if there are pieces in the path
			if (!this.getBoard().isPieceInDiagonalPath(this.getSpace(), targetSpace)) {
				isValid = true;
			} 
		}
		
		return isValid;
	}
	
	
}
