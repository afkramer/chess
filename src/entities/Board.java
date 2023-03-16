package entities;

public class Board {
	private Space[] spaces = new Space[64];
	
	public Board() {
		
	}
	
	public void initBoard() {
		int xCoord = 0;
		int yCoord = 0;
		Color color = Color.BLACK;
		for (Space space : spaces) {
			space = new Space(xCoord, yCoord, color);
		}
	}
	
	public boolean isSpaceFree(int xCoord, int yCoord) {
		for(Space space : spaces) {
			if (space.getXCoord() == xCoord && space.getYCoord() == yCoord && !space.getIsOccupied()) {
				return true;
			}
		}
		return false;
	}
}
