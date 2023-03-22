package entities.pieces;

import entities.Board;
import entities.Space;
import entities.enums.Color;


public abstract class Piece {
	private Board board;
	private Space currentSpace;
	private Color color;

	public Piece(Space currentSpace, Color color, Board board) {
		this.board = board;
		this.currentSpace = currentSpace;
		this.color = color;
	}
	
	public abstract void move(Space space);
	
	public abstract boolean isMoveValid(Space space);
	
	public Board getBoard() {
		return this.board;
	}
	
	public Space getSpace() {
		return this.currentSpace;
	}
	
	public void setSpace(Space space) {
		this.currentSpace = space;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
