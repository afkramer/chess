package entities.pieces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Board;
import entities.Player;
import entities.Space;
import entities.enums.SpaceColor;
import entities.enums.PieceType;


public abstract class Piece {
	private Board board;
	private Space currentSpace;
	private SpaceColor color;
	private PieceType pieceType;
	private final Logger LOGGER = LoggerFactory.getLogger(Piece.class);

	public Piece(Space currentSpace, SpaceColor color, Board board) {
		this.board = board;
		this.currentSpace = currentSpace;
		this.color = color;
	}
	
	public void move(Space targetSpace) {
		log(String.format("Moved from %d, %d", 
				getCurrentSpace().getXCoord(), getCurrentSpace().getYCoord()));
		getCurrentSpace().setIsFree(true);
		getCurrentSpace().setPiece(null);
		setCurrentSpace(targetSpace);
		targetSpace.setIsFree(false);
		targetSpace.setPiece(this);
		log(String.format("Moved to %d, %d", targetSpace.getXCoord(), targetSpace.getYCoord()));
		targetSpace.setIsFree(false);
	}
	
	public abstract boolean isMoveValid(Space targetSpace);
	
	public void log(String message) {
		this.LOGGER.debug(message);
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	public Space getCurrentSpace() {
		return this.currentSpace;
	}
	
	public void setCurrentSpace(Space space) {
		this.currentSpace = space;
	}
	
	public SpaceColor getColor() {
		return this.color;
	}
	
	public void setColor(SpaceColor color) {
		this.color = color;
	}
	
	public PieceType getPieceType() {
		return this.pieceType;
	}
	
	public void setPieceType(PieceType pieceType) {
		this.pieceType = pieceType;
	}
}
