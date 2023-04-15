package entities;

import java.util.List;

import entities.enums.SpaceColor;
import entities.pieces.Piece;

public class Space {
	private int xCoord;
	private int yCoord;
	private List<Space> linearAdjacents;
	private List<Space> diagonalAdjacents;
	private SpaceColor color;
	private boolean isFree;
	private Piece piece;
	
	public Space(int xCoord, int yCoord, List<Space> linearAdjacents, List<Space> diagonalAdjacents, SpaceColor color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.linearAdjacents = linearAdjacents;
		this.diagonalAdjacents = diagonalAdjacents;
		this.color = color;
		this.isFree = true;
		this.piece = null;
	}
	
	public Space(int xCoord, int yCoord, SpaceColor color) {
		this(xCoord, yCoord, null, null, color);
	}
	
	public Space(int xCoord, int yCoord) {
		this(xCoord, yCoord, null, null, null);
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
	
	public void addLinearAdjacent(Space space) {
		this.linearAdjacents.add(space);
	}
	
	public List<Space> getDiagonalAdjacents() {
		return this.diagonalAdjacents;
	}
	
	public void setDiagonalAdjacents(List<Space> diagonalAdjacents) {
		this.diagonalAdjacents = diagonalAdjacents;
	}

	public void addDiagonalAdjacent(Space space) {
		this.diagonalAdjacents.add(space);
	}
	
	public SpaceColor getColor() {
		return this.color;
	}
	
	public void setColor(SpaceColor color) {
		this.color = color;
	}

	public boolean getIsFree() {
		return this.isFree;
	}
	
	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
