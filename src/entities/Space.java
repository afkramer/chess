package entities;

import java.util.List;

import entities.enums.Color;

public class Space {
	private int xCoord;
	private int yCoord;
	private List<Space> linearAdjacents;
	private List<Space> diagonalAdjacents;
	private Color color;
	private boolean isFree;
	
	public Space(int xCoord, int yCoord, List<Space> linearAdjacents, List<Space> diagonalAdjacents, Color color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.linearAdjacents = linearAdjacents;
		this.diagonalAdjacents = diagonalAdjacents;
		this.color = color;
		this.isFree = true;
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
	
	public List<Space> getLinearAdjacents() {
		return this.linearAdjacents;
	}
	
	public void setLinearAdjacents(List<Space> linearAdjacents) {
		this.linearAdjacents = linearAdjacents;
	}
	
	public List<Space> getDiagonalAdjacents() {
		return this.diagonalAdjacents;
	}
	
	public void setDiagonalAdjacents(List<Space> diagonalAdjacents) {
		this.diagonalAdjacents = diagonalAdjacents;
	}

	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public boolean getIsFree() {
		return this.isFree;
	}
	
	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}
}
