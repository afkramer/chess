package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.Color;

public class Queen extends Piece {
	
	public Queen(Space space, Color color, Board board) {
		super(space, color, board);
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		return false;
	}
}
