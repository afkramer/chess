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
			}
			
			// Need to switch colors again
			// Last square of row below is same color as first square of row above
			color = color.switchColor();
		}
	}

	//TODO:
	public void initPieces() {
		
	}
	
	public boolean isSpaceFree(int xCoord, int yCoord) {
		for(Space space : spaces) {
			if (space.getXCoord() == xCoord && space.getYCoord() == yCoord && space.getIsFree()) {
				return true;
			}
		}
		return false;
	}
}
