package entities.enums;

//TODO: piece type NONE is not used
public enum PieceType {
	WHITE_KING("\u2654"),
	WHITE_QUEEN("\u2655"),
	WHITE_ROOK("\u2656"),
	WHITE_BISHOP("\u2657"),
	WHITE_KNIGHT("\u2658"),
	WHITE_PAWN("\u2659"),
	BLACK_KING("\u265A"),
	BLACK_QUEEN("\u265B"),
	BLACK_ROOK("\u265C"),
	BLACK_BISHOP("\u265D"),
	BLACK_KNIGHT("\u265E"),
	BLACK_PAWN("\u265F"),
	NONE(" ");
	
	private String pieceString;
	
	private PieceType(String pieceString) {
		this.pieceString = pieceString;
	}
	
	public String getPieceString() {
		return this.pieceString;
	}
	
}
