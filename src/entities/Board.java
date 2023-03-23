package entities;

import entities.enums.Color;
import utility.Utils;

public class Board {
	private Space[] spaces = new Space[Utils.TOTAL_SPACES];
	
	public Board() {
		this.initBoard();
		this.initPieces();
	}
	
	public void initBoard() {
		Color color = Color.BLACK;
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

	//TODO
	public void initPieces() {
		
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
	}
	
	public Space moveOneSpaceHorizontal(Space currentSpace, Space targetSpace) {
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
	}

}
