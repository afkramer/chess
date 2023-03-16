package entities;

import entities.Color;

public class Space {
	private int xCoord;
	private int yCoord;
	private Color color;
	private boolean isOccupied;
	
	public Space(int xCoord, int yCoord, Color color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
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
