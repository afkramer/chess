package model;

import model.pieces.Piece;
import model.pieces.Color;

public class Space {
	private int xCoord;
	private int yCoord;
	private Color color;
	private Piece piece;
	
	public Space(int xCoord, int yCoord, Color color, Piece piece) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
		this.piece = piece;
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
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public void shift(int xShift, int yShift) {
		this.xCoord += xShift;
		this.yCoord += yShift;
	}
}
