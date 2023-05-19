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
	
	@Override
	public boolean isMoveValid(Space targetSpace) {
		boolean isValidMove = false;
		
		boolean isValidFirstMove = isValidFirstMove(targetSpace);
		boolean isValidCapturingMove = isValidCapturingMove(targetSpace);
		
		if (isValidFirstMove || isValidCapturingMove) {
			isValidMove = true;
		}
		
		return isValidMove;
	}
	
	public boolean isValidFirstMove(Space targetSpace) {
		boolean isValidMove = false;
		
		boolean isVertical = Utils.isVerticalMove(this.getCurrentSpace(), targetSpace);
		boolean isValidNumOfSpaces = Utils.numberOfSpacesMoved(this.getCurrentSpace(), targetSpace) == 1 
				|| Utils.numberOfSpacesMoved(targetSpace, targetSpace) == 2;
		boolean isPieceCaptured = this.getBoard().isPieceCaptured(this.getColor(), targetSpace);
		
		if (this.isFirstMove && isVertical && isValidNumOfSpaces && !isPieceCaptured) {
			isValidMove = true;
		}
		
		return isValidMove;
	}
	
	public boolean isValidCapturingMove(Space targetSpace) {
		boolean isValidMove = false;
		
		boolean isDiagonal = Utils.isDiagonalMove(this.getCurrentSpace(), targetSpace);
		boolean isValidNumOfSpaces = Utils.numberOfSpacesMoved(this.getCurrentSpace(), targetSpace) == 1;
		boolean isPieceCaptured = this.getBoard().isPieceCaptured(this.getColor(), targetSpace);
		
		if (isDiagonal && isValidNumOfSpaces && isPieceCaptured) {
			isValidMove = true;
		}
		
		return isValidMove;
	}
	
	@Override
	public void moved() {
		this.setFirstMove(false);
	}
}
