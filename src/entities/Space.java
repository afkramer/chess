package entities;

import entities.Color;

public class Space {
	private int xCoord;
	private int yCoord;
	private Space neighborNorth;
	private Space neighborEast;
	private Space neighborSouth;
	private Space neighborWest;
	private Color color;
	private boolean isOccupied;
	
	public Space(int xCoord, int yCoord, Space neighborNorth, Space neighborEast,
					Space neighborSouth, Space neighborWest, Color color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.neighborNorth = neighborNorth;
		this.neighborEast = neighborEast;
		this.neighborSouth = neighborSouth;
		this.neighborWest = neighborWest;
		this.color = color;
	}
	
	public Space(int xCoord, int yCoord, Color color) {
		this(xCoord, yCoord, null, null, null, null, color);
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
	
	public Space getNeighborNorth() {
		return neighborNorth;
	}

	public void setNeighborNorth(Space neighborNorth) {
		this.neighborNorth = neighborNorth;
	}

	public Space getNeighborEast() {
		return neighborEast;
	}

	public void setNeighborEast(Space neighborEast) {
		this.neighborEast = neighborEast;
	}

	public Space getNeighborSouth() {
		return neighborSouth;
	}

	public void setNeighborSouth(Space neighborSouth) {
		this.neighborSouth = neighborSouth;
	}

	public Space getNeighborWest() {
		return neighborWest;
	}

	public void setNeighborWest(Space neighborWest) {
		this.neighborWest = neighborWest;
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
