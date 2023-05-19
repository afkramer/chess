package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.PieceType;
import entities.enums.SpaceColor;
import utility.Utils;

public class Rook extends Piece {

	public Rook(Space currentSpace, SpaceColor color, Board board) {
		super(currentSpace, color, board);
		if (color == SpaceColor.WHITE) {
			this.setPieceType(PieceType.WHITE_ROOK);
		} else {
			this.setPieceType(PieceType.BLACK_ROOK);
		}
	}

	@Override
	public boolean isMoveValid(Space targetSpace) {
		boolean isValid = false;
		if (Utils.isStraightMove(this.getCurrentSpace(), targetSpace)) {
			if (!this.getBoard().isPieceInStraightPath(this.getColor(), this.getCurrentSpace(), targetSpace)) {
				isValid = true;
			}
		}
		log(String.format("Was the move valid: %b", isValid));
		return isValid;
	}
	
	@Override
	public void moved() {}
}
