package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.SpaceColor;
import utility.Utils;
import entities.enums.PieceType;

public class Pawn extends Piece {
	private boolean isFirstMove = true;
	
	public Pawn(Space currentSpace, SpaceColor color, Board board) {
		super(currentSpace, color, board);
		if (color == SpaceColor.WHITE) {
			this.setPieceType(PieceType.WHITE_PAWN);
		} else {
			this.setPieceType(PieceType.BLACK_PAWN);
		}
	}
	
	public boolean isFirstMove() {
		return isFirstMove;
	}

	public void setFirstMove(boolean isFirstMove) {
		this.isFirstMove = isFirstMove;
	}
	
	public boolean isMoveValid(Space targetSpace) {
		boolean isValidMove = false;
		
		boolean isValidFirstMove = isValidFirstMove(targetSpace);
		
		if (isValidFirstMove) {
			isValidMove = true;
		}
		
		return isValidMove;
	}
	
	public boolean isValidFirstMove(Space targetSpace) {
		boolean isValidMove = false;
		
		boolean isVertical = Utils.isVerticalMove(this.getCurrentSpace(), targetSpace);
		boolean isValidNumOfSpaces = Utils.numberOfSpacesMoved(this.getCurrentSpace(), targetSpace) == 1 
				|| Utils.numberOfSpacesMoved(targetSpace, targetSpace) == 2;
		//TODO: update this after method is updated in Utils class
		boolean isPieceCaptured = false;
		
		if (this.isFirstMove && isVertical && isValidNumOfSpaces && !isPieceCaptured) {
			isValidMove = true;
		}
		
		return isValidMove;
	}
	
	public boolean isValidCapturingMove(Space targetSpace) {
		boolean isValidMove = false;
		
		boolean isDiagonal = Utils.isDiagonalMove(this.getCurrentSpace(), targetSpace);
		boolean isValidNumOfSpaces = Utils.numberOfSpacesMoved(this.getCurrentSpace(), targetSpace) == 1;
		//TODO: update this after method is updated in Utils class
		boolean isPieceCaptured = true;
		
		return isValidMove;
	}
}
