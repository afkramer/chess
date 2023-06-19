package entities;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.enums.SpaceColor;
import entities.pieces.Bishop;
import entities.pieces.King;
import entities.pieces.Pawn;
import entities.pieces.Piece;
import entities.pieces.Queen;
import entities.pieces.Rook;
import utility.Utils;

public class Board {
	private Space[] spaces = new Space[Utils.TOTAL_SPACES];
	private List<Piece> activePieces = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	private Piece blackKing;
	private Piece whiteKing;
	private final Logger LOGGER = LoggerFactory.getLogger(Board.class);
	
	
	// These methods should be private
	public Board() {
		this.initBoard();
		this.initPieces();
	}
	
	public Space[] getSpaces() {
		return this.spaces;
	}
	
	public void initBoard() {
		SpaceColor color = SpaceColor.BLACK;
		int currentSpace = 0;
		for (int x = Utils.MINIMUM_COORDINATE; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = Utils.MINIMUM_COORDINATE; y <= Utils.MAXIMUM_COORDINATE; y++) {
				spaces[currentSpace] = new Space(x, y, color);
				color = color.switchColor();
				currentSpace++;
			}
			
			// Need to switch colors again
			// Last square of row below is same color as first square of row above
			color = color.switchColor();
		}
	}

	//TODO when all the pieces are available
	//TODO: I hard code a lot of the coordinates for where pieces should be
	// Is there a better way to set up the pieces?
	// This method also got pretty long
	//TODO: you could try making a factory with builder -> but this is more code and so just for practicing!!
	// Factory -> decides which piece to generate based on PieceType -> this would be the director -> I need a pawn
	// Builder -> in the factory -> sets the actual variables that are needed for the piece -> It should be black
	public void initPieces() {
		Piece piece = null;
		Space space;
		for (int x = 0; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = 0; y <= Utils.MAXIMUM_COORDINATE; y++) {
				space = this.getSpaceByCoords(x, y);
				if (x == 1) {
					piece = new Pawn(space, SpaceColor.BLACK, this);
				} else if (x == 6) {
					//piece = new Pawn(space, SpaceColor.WHITE, this);
					piece = null;
				} else if ((y == 0 || y == 7) && x == 0) {
					piece = new Rook(space, SpaceColor.BLACK, this);
				} else if ((y == 0 || y == 7) && x == 7) {
					piece = new Rook(space, SpaceColor.WHITE, this);
				} else if ((y == 1 || y == 6) && x == 0) {
					//TODO: Black knight
					piece = null;
				} else if ((y == 1 || y == 6) && x == 7) {
					//TODO: White knight
					piece = null;
				} else if ((y == 2 || y == 5) && x == 0) {
					piece = new Bishop(space, SpaceColor.BLACK, this);
				} else if ((y == 2 || y == 5) && x == 7) {
					piece = new Bishop(space, SpaceColor.WHITE, this);
				} else if (y == 3 && x == 0) {
					piece = new King(space, SpaceColor.BLACK, this);
					blackKing = piece;
				} else if (y == 3 && x == 7) {
					piece = new King(space, SpaceColor.WHITE, this);
					whiteKing = piece;
				} else if (y == 4 && x == 0) {
					piece = new Queen(space, SpaceColor.BLACK, this);
				} else if (y == 4 && x == 7) {
					piece = new Queen(space, SpaceColor.WHITE, this);
				} else {
					piece = null;
				}
				
				if (piece != null) {
					activePieces.add(piece);
					space.setPiece(piece);
					space.setIsFree(false);
				}
			}
		}
	}
	
	public void initSpaces() {
		for (Space space : spaces) {
			setDiagonalAdjacents(space);
			setLinearAdjacents(space);
		}
	}
	
	/**
	 * Determines whether the king is under check
	 * 
	 * @param currentPlayer
	 * @return	true if the king is under check, false if not
	 */
	public boolean isKingUnderCheck(SpaceColor playerColor) {
		Piece currentKing = playerColor == SpaceColor.BLACK ? blackKing : whiteKing;
		
		for (Piece piece : activePieces) {
			if (piece.isMoveValid(currentKing.getCurrentSpace())) {
				return true;
			}
		}
		return false;
	}
	
	//TODO
	public boolean isKingUnderCheckmate(SpaceColor playerColor) {
		Piece currentKing = playerColor == SpaceColor.BLACK ? blackKing : whiteKing;
		Space currentSpace = currentKing.getCurrentSpace();
		List<Space> allPossibleMoves = new ArrayList<>();
		allPossibleMoves.addAll(currentSpace.getDiagonalAdjacents());
		allPossibleMoves.addAll(currentSpace.getLinearAdjacents());
		
		return allPossibleMoves.stream().allMatch(space -> this.reachableByOpponent(space));
	}
	
	// Refactor possibility: Both of the following methods use the same code!
	// Are they even used??
	//TODO: TEST
	public void setDiagonalAdjacents(Space space) {
		int[][] possibleDiagonalAdjacents = {{1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
		for (int[] adjacents : possibleDiagonalAdjacents) {
			int xCoord = adjacents[0];
			int yCoord = adjacents[1];
			
			if (Utils.areValidCoords(xCoord, yCoord)) {
				space.addDiagonalAdjacent(getSpaceByCoords(xCoord, yCoord));
			}
		}
	}
	
	public void setLinearAdjacents(Space space) {
		int[][] possibleLinearAdjacents = {{0, -1}, {1, 0}, {0, 1}, {-1,0}};
		for (int[] adjacents : possibleLinearAdjacents) {
			int xCoord = adjacents[0];
			int yCoord = adjacents[1];
			
			if (Utils.areValidCoords(xCoord, yCoord)) {
				space.addLinearAdjacent(getSpaceByCoords(xCoord, yCoord));
			}
		}
	}
	
	public boolean reachableByOpponent(Space space) {
		boolean reachableByOpponent = false;
		Piece pieceOnSpace = space.getPiece();
		
		if (pieceOnSpace != null) {
			for (Piece piece : activePieces) {
				if (piece.isMoveValid(space)) {
					reachableByOpponent = true;
				}
			}
		}
		return reachableByOpponent;
	}
	
	
	public Space getSpaceByCoords(int xCoord, int yCoord) {
		for (Space space : spaces) {
			if (space.getXCoord() == xCoord && space.getYCoord() == yCoord) {
				return space;
			}
		}
		
		return null;
	}
	
	public boolean isSpaceFreeByCoords(int xCoord, int yCoord) {
		for(Space space : spaces) {
			if (space.getXCoord() == xCoord && space.getYCoord() == yCoord && space.getIsFree()) {
				return true;
			}
		}
		return false;
	}
	
	//TODO: is there a way to combine isPieceInDiagonalPath and isPieceInStraightPath?
	// The only difference is how the space is moved forward to be checked for a piece in the path
	public boolean isPieceInDiagonalPath(SpaceColor currentColor, Space currentSpace, Space targetSpace) {
		while (currentSpace.getXCoord() != targetSpace.getXCoord() && currentSpace.getYCoord() != targetSpace.getYCoord()) {
			currentSpace = moveOneSpaceDiagonal(currentSpace, targetSpace);
			// It is only not allowed for the piece to be in the path
			// If a piece is on targetSpace then the piece will be captured
			if (!currentSpace.getIsFree() && currentSpace != targetSpace) {
				return true;
			} else if (currentSpace == targetSpace && currentSpace.getPiece() != null) {
				// A player may not land on his or her own piece
				if (currentSpace.getPiece().getColor() == currentColor) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isPieceInStraightPath(SpaceColor currentColor, Space currentSpace, Space targetSpace) {
		while (currentSpace.getXCoord() != targetSpace.getXCoord() && currentSpace.getYCoord() != targetSpace.getYCoord()) {
			currentSpace = moveOneSpaceStraight(currentSpace, targetSpace);
			// It is only not allowed for the piece to be in the path
			// If a piece is on targetSpace then the piece will be captured
			if (!currentSpace.getIsFree() && currentSpace != targetSpace) {
				return true;
			} else if (currentSpace == targetSpace && currentSpace.getPiece() != null) {
				if (currentSpace.getPiece().getColor() == currentColor) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isPieceCaptured(SpaceColor currentColor, Space targetSpace) {
		if (targetSpace.getPiece() != null && targetSpace.getPiece().getColor() != currentColor) {
			return true;
		}
		return false;
	}
	
	public Space moveOneSpaceDiagonal(Space currentSpace, Space targetSpace) {
		if (Utils.areValidCoords(targetSpace.getXCoord(), targetSpace.getYCoord())) {
			int totalXShift = targetSpace.getXCoord() - currentSpace.getXCoord();
			int totalYShift = targetSpace.getYCoord() - currentSpace.getYCoord();
			int shiftedXCoord = currentSpace.getXCoord();
			int shiftedYCoord = currentSpace.getYCoord();
			
			if (totalXShift > 0) {
				shiftedXCoord++;
			} else {
				shiftedXCoord--;
			}
			
			if (totalYShift > 0) {
				shiftedYCoord++;
			} else {
				shiftedYCoord--;
			}
			
			return getSpaceByCoords(shiftedXCoord, shiftedYCoord);
			
		} else {
			return currentSpace;
		}
		
	}
	
	public Space moveOneSpaceStraight(Space currentSpace, Space targetSpace) {
		if (Utils.areValidCoords(targetSpace.getXCoord(), targetSpace.getYCoord())) {
			int totalXShift = targetSpace.getXCoord() - currentSpace.getXCoord();
			int totalYShift = targetSpace.getYCoord() - currentSpace.getYCoord();
			int shiftedXCoord = currentSpace.getXCoord();
			int shiftedYCoord = currentSpace.getYCoord();
			
			if (totalXShift > 0) {
				shiftedXCoord++;
			} else if (totalXShift < 0) {
				shiftedXCoord--;
			}
			
			if (totalYShift > 0) {
				shiftedYCoord++;
			} else if (totalYShift < 0) {
				shiftedYCoord--;
			}
			
			return getSpaceByCoords(shiftedXCoord, shiftedYCoord);
			
		} else {
			return currentSpace;
		}
		
	}
	
	public void capturePiece(Piece piece) {
		LOGGER.debug("Adding piece " + piece + " to the captured pieces list.");
		this.capturedPieces.add(piece);
		LOGGER.debug("Removing piece " + piece + " from the active pieces list.");
		this.activePieces.remove(piece);
	}

}
