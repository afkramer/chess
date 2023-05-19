package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.PieceType;
import entities.enums.SpaceColor;

public class King extends Piece {

	public King(Space currentSpace, SpaceColor color, Board board) {
		super(currentSpace, color, board);
		if (color == SpaceColor.WHITE) {
			this.setPieceType(PieceType.WHITE_KING);
		} else {
			this.setPieceType(PieceType.BLACK_KING);
		}
	}

	@Override
	public boolean isMoveValid(Space space) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moved() {}

}
