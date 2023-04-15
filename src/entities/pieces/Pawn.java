package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.Color;
import entities.enums.PieceType;

public class Pawn extends Piece {
	
	public Pawn(Space currentSpace, Color color, Board board) {
		super(currentSpace, color, board);
		if (color == Color.WHITE) {
			this.setPieceType(PieceType.WHITE_PAWN);
		} else {
			this.setPieceType(PieceType.BLACK_PAWN);
		}
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		return false;
	}
}
