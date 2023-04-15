package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.SpaceColor;

public class Queen extends Piece {
	
	public Queen(Space space, SpaceColor color, Board board) {
		super(space, color, board);
	}
	
	public void move(Space targetSpace) {
		
	}
	
	public boolean isMoveValid(Space targetSpace) {
		return false;
	}
}
