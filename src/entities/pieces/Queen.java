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
			if (!this.getBoard().isPieceInDiagonalPath(this.getCurrentSpace(), targetSpace)) {
				isValid = true;
			}
		} else if (Utils.isHorizontalMove(this.getCurrentSpace(), targetSpace)) {
			if (!this.getBoard().isPieceInHorizontalPath(this.getCurrentSpace(), targetSpace)) {
				isValid = true;
			}
		}
		
		return isValid;
	}

}
