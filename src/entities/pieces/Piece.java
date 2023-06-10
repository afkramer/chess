package entities.pieces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.Board;
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
		
		if (board.isPieceCaptured(this.color, targetSpace)) {
			LOGGER.debug(this + " is capturing " + targetSpace.getPiece());
			board.capturePiece(targetSpace.getPiece());
		}
		
		getCurrentSpace().clearSpace();
		setCurrentSpace(targetSpace);
		log(String.format("Moved to %d, %d", targetSpace.getXCoord(), targetSpace.getYCoord()));
	}
	
	public abstract boolean isMoveValid(Space targetSpace);
	
	// This method is so that we can track the pawns' first moves
	public abstract void moved();
	
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
		space.setPiece(this);
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
