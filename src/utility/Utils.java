package utility;

import entities.Board;
import entities.Space;
import entities.pieces.Piece;

public class Utils {
	public static final int TOTAL_SPACES = 64;
	public static final int MINIMUM_COORDINATE = 0;
	public static final int MAXIMUM_COORDINATE = 7;
	
	private Utils() {}
	
	/**
	 * Determines if a move is diagonal and not on same space.
	 * We know it is diagonal if the difference between X-Coordinates is the same 
	 * as the difference in Y-Coordinates.
	 * 
	 * @param 		currentSpace
	 * @param 		targetSpace
	 * @return
	 */
	public static boolean isDiagonalMove(Space currentSpace, Space targetSpace) {
		int xShift = Math.abs(currentSpace.getXCoord() - targetSpace.getXCoord());
		int yShift = Math.abs(currentSpace.getYCoord() - targetSpace.getYCoord());
		
		return xShift == yShift && !isSameSpace(currentSpace, targetSpace);
	}
	
	/**
	 * Determines if a move is horizontal and not on same space.
	 * We know it is diagonal if the move start and end are either in same row or column.
	 * 
	 * @param currentSpace
	 * @param targetSpace
	 * @return
	 */
	public static boolean isHorizontalMove(Space currentSpace, Space targetSpace) {
		int xShift = Math.abs(currentSpace.getXCoord() - targetSpace.getXCoord());
		int yShift = Math.abs(currentSpace.getYCoord() - targetSpace.getYCoord());
		
		return xShift == 0 || yShift == 0 && !isSameSpace(currentSpace, targetSpace);
	}
	
	/**
	 * Determines if the start space and end space are the same.
	 * 
	 * @param currentSpace
	 * @param targetSpace
	 * @return
	 */
	
	public static boolean isSameSpace(Space currentSpace, Space targetSpace) {
		boolean xIsSame = currentSpace.getXCoord() == targetSpace.getXCoord();
		boolean yIsSame = currentSpace.getYCoord() == targetSpace.getYCoord();
		return xIsSame && yIsSame;
	}
	
	public static boolean areValidCoords(int xCoord, int yCoord) {
		return xCoord >= Utils.MINIMUM_COORDINATE && xCoord <= Utils.MAXIMUM_COORDINATE
				&& yCoord >= Utils.MINIMUM_COORDINATE && yCoord <= Utils.MAXIMUM_COORDINATE;
	}
	
	//TODO: START HERE! How to determine whether a piece is in the path?
	// It's OK to be naive ;)
	// Is there a better way to access the board? 
	public static boolean isPieceInDiagonalPath(Space currentSpace, Space targetSpace, Board board) {
		while (currentSpace.getXCoord() != targetSpace.getXCoord() && currentSpace.getYCoord() != targetSpace.getYCoord()) {
			currentSpace = moveOneSpaceDiagonal(currentSpace, targetSpace, board);
			if (!currentSpace.getIsFree()) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isPieceInHorizontalPath(Space currentSpace, Space targetSpace, Board board) {
		while (currentSpace.getXCoord() != targetSpace.getXCoord() && currentSpace.getYCoord() != targetSpace.getYCoord()) {
			currentSpace = moveOneSpaceHorizontal(currentSpace, targetSpace, board);
			if (!currentSpace.getIsFree()) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Space moveOneSpaceDiagonal(Space currentSpace, Space targetSpace, Board board) {
		int totalXShift = targetSpace.getXCoord() - currentSpace.getXCoord();
		int totalYShift = targetSpace.getYCoord() - currentSpace.getYCoord();
		int shiftedXCoord = currentSpace.getXCoord();
		int shiftedYCoord = currentSpace.getYCoord();
		
		if (totalXShift > 0) {
			shiftedXCoord++;
		} else {
			shiftedXCoord--;
		}
		
		if (totalYShift > 0) {
			shiftedYCoord++;
		} else {
			shiftedYCoord--;
		}
		
		return board.getSpaceByCoords(shiftedXCoord, shiftedYCoord);
	}
	
	public static Space moveOneSpaceHorizontal(Space currentSpace, Space targetSpace, Board board) {
		int totalXShift = targetSpace.getXCoord() - currentSpace.getXCoord();
		int totalYShift = targetSpace.getYCoord() - currentSpace.getYCoord();
		int shiftedXCoord = currentSpace.getXCoord();
		int shiftedYCoord = currentSpace.getYCoord();
		
		if (totalXShift > 0) {
			shiftedXCoord++;
		} else if (totalXShift < 0) {
			shiftedXCoord--;
		}
		
		if (totalYShift > 0) {
			shiftedYCoord++;
		} else if (totalYShift < 0) {
			shiftedYCoord--;
		}
		
		return board.getSpaceByCoords(shiftedXCoord, shiftedYCoord);
	}
}
