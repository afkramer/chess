package entities;

import entities.enums.SpaceColor;
import entities.pieces.Bishop;
import entities.pieces.Pawn;
import entities.pieces.Piece;
import utility.Utils;

public class Board {
	private Space[] spaces = new Space[Utils.TOTAL_SPACES];
	
	
	public Board() {
		this.initBoard();
		this.initPieces();
	}
	
	public Space[] getSpaces() {
		return this.spaces;
	}
	
	public void initBoard() {
		SpaceColor color = SpaceColor.BLACK;
		int currentSpace = 0;
		for (int x = Utils.MINIMUM_COORDINATE; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = Utils.MINIMUM_COORDINATE; y <= Utils.MAXIMUM_COORDINATE; y++) {
				spaces[currentSpace] = new Space(x, y, color);
				color = color.switchColor();
				currentSpace++;
			}
			
			// Need to switch colors again
			// Last square of row below is same color as first square of row above
			color = color.switchColor();
		}
	}

	//TODO when all the pieces are available
	//TODO: I hard code a lot of the coordinates for where pieces should be
	// Is there a better way to set up the pieces?
	// This method also got pretty long
	public void initPieces() {
		Piece piece = null;
		Space space;
		for (int x = 0; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = 0; y <= Utils.MAXIMUM_COORDINATE; y++) {
				space = this.getSpaceByCoords(x, y);
				if (x == 1) {
					piece = new Pawn(space, SpaceColor.BLACK, this);
				} else if (x == 6) {
					piece = new Pawn(space, SpaceColor.WHITE, this);
				} else if ((y == 2 || y == 5) && x == 0) {
					piece = new Bishop(space, SpaceColor.BLACK, this);
				} else if ((y == 2 || y == 5) && x == 7) {
					piece = new Bishop(space, SpaceColor.WHITE, this);
				} else {
					piece = null;
				}
				
				if (piece != null) {
					space.setPiece(piece);
					space.setIsFree(false);
				}
			}
		}
	}
	
	public void initSpaces() {
		for (Space space : spaces) {
			setDiagonalAdjacents(space);
			setLinearAdjacents(space);
		}
	}
	
	// Refactor possibility: Both of the following methods use the same code!
	//TODO: TEST
	public void setDiagonalAdjacents(Space space) {
		int[][] possibleDiagonalAdjacents = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
		for (int[] adjacents : possibleDiagonalAdjacents) {
			int xCoord = adjacents[0];
			int yCoord = adjacents[1];
			
			if (Utils.areValidCoords(xCoord, yCoord)) {
				space.addDiagonalAdjacent(getSpaceByCoords(xCoord, yCoord));
			}
		}
	}
	
	public void setLinearAdjacents(Space space) {
		int[][] possibleLinearAdjacents = {{0, -1}, {1, 0}, {0, 1}, {-1,0}};
		for (int[] adjacents : possibleLinearAdjacents) {
			int xCoord = adjacents[0];
			int yCoord = adjacents[1];
			
			if (Utils.areValidCoords(xCoord, yCoord)) {
				space.addLinearAdjacent(getSpaceByCoords(xCoord, yCoord));
			}
		}
	}
	
	
	public Space getSpaceByCoords(int xCoord, int yCoord) {
		for (Space space : spaces) {
			if (space.getXCoord() == xCoord && space.getYCoord() == yCoord) {
				return space;
			}
		}
		
		return null;
	}
	
	public boolean isSpaceFreeByCoords(int xCoord, int yCoord) {
		for(Space space : spaces) {
			if (space.getXCoord() == xCoord && space.getYCoord() == yCoord && space.getIsFree()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isPieceInDiagonalPath(Space currentSpace, Space targetSpace) {
		while (currentSpace.getXCoord() != targetSpace.getXCoord() && currentSpace.getYCoord() != targetSpace.getYCoord()) {
			currentSpace = moveOneSpaceDiagonal(currentSpace, targetSpace);
			if (!currentSpace.getIsFree()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isPieceInHorizontalPath(Space currentSpace, Space targetSpace) {
		while (currentSpace.getXCoord() != targetSpace.getXCoord() && currentSpace.getYCoord() != targetSpace.getYCoord()) {
			currentSpace = moveOneSpaceHorizontal(currentSpace, targetSpace);
			if (!currentSpace.getIsFree()) {
				return true;
			}
		}
		
		return false;
	}
	
	public Space moveOneSpaceDiagonal(Space currentSpace, Space targetSpace) {
		if (Utils.areValidCoords(targetSpace.getXCoord(), targetSpace.getYCoord())) {
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
			
			return getSpaceByCoords(shiftedXCoord, shiftedYCoord);
			
		} else {
			return currentSpace;
		}
		
	}
	
	public Space moveOneSpaceHorizontal(Space currentSpace, Space targetSpace) {
		if (Utils.areValidCoords(targetSpace.getXCoord(), targetSpace.getYCoord())) {
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
			
			return getSpaceByCoords(shiftedXCoord, shiftedYCoord);
			
		} else {
			return currentSpace;
		}
		
	}

}
