package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.SpaceColor;
import entities.enums.PieceType;
import utility.Utils;

public class Bishop extends Piece {
	
	//TODO: instead of setters, use super.constructor()
	public Bishop(Space currentSpace, SpaceColor color, Board board) {
		super(currentSpace, color, board);
		if (color == SpaceColor.WHITE) {
			this.setPieceType(PieceType.WHITE_BISHOP);
		} else {
			this.setPieceType(PieceType.BLACK_BISHOP);
		}
	}
	
	public boolean isMoveValid(Space targetSpace) {
		boolean isValid = false;
		if (Utils.isDiagonalMove(this.getCurrentSpace(), targetSpace)) {
			// only if the move is diagonal, check if there are pieces in the path
			if (!this.getBoard().isPieceInDiagonalPath(this.getColor(), this.getCurrentSpace(), targetSpace)
					&& Utils.areValidCoords(targetSpace.getXCoord(), targetSpace.getYCoord())) {
				isValid = true;
			} 
		}
		log(String.format("Was the move valid: %b", isValid));
		return isValid;
	}
	
	@Override
	public void moved() {}
	
}
