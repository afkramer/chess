package entities;

import entities.enums.Color;

public class Space {
	private int xCoord;
	private int yCoord;
	private Space[] linearAdjacents;
	private Space[] diagonalAdjacents;
	private Color color;
	private boolean isOccupied;
	
	public Space(int xCoord, int yCoord, Space[] linearAdjacents, Space[] diagonalAdjacents, Color color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.linearAdjacents = linearAdjacents;
		this.diagonalAdjacents = diagonalAdjacents;
		this.color = color;
		// ASK: does it make sense to set instance variable values to the default value?
		this.isOccupied = false;
	}
	
	public Space(int xCoord, int yCoord, Color color) {
		this(xCoord, yCoord, null, null, color);
	}
	
	public int getXCoord() {
		return this.xCoord;
	}
	
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	
	public int getYCoord() {
		return this.yCoord;
	}
	
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public Space[] getLinearAdjacents() {
		return this.linearAdjacents;
	}
	
	public void setLinearAdjacents(Space[] linearAdjacents) {
		this.linearAdjacents = linearAdjacents;
	}
	
	public Space[] getDiagonalAdjacents() {
		return this.diagonalAdjacents;
	}
	
	public void setDiagonalAdjacents(Space[] diagonalAdjacents) {
		this.diagonalAdjacents = diagonalAdjacents;
	}

	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
}
