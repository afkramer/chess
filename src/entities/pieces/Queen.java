package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.PieceType;
import entities.enums.SpaceColor;
import utility.Utils;

public class Queen extends Piece {
	
	public Queen(Space space, SpaceColor color, Board board) {
		super(space, color, board);
		if (color == SpaceColor.WHITE) {
			this.setPieceType(PieceType.WHITE_QUEEN);
		} else {
			this.setPieceType(PieceType.BLACK_QUEEN);
		}
	}
	
	public boolean isMoveValid(Space targetSpace) {
		boolean isValid = false;
		if (Utils.isDiagonalMove(this.getCurrentSpace(), targetSpace)) {
			if (!this.getBoard().isPieceInDiagonalPath(this.getColor(), this.getCurrentSpace(), targetSpace)) {
				isValid = true;
			}
		} else if (Utils.isStraightMove(this.getCurrentSpace(), targetSpace)) {
			if (!this.getBoard().isPieceInStraightPath(this.getColor(), this.getCurrentSpace(), targetSpace)) {
				isValid = true;
			}
		}
		
		return isValid;
	}

}
