package view;

import entities.Board;
import entities.Space;

public class Gui {
	private static final String WHITE_KING = "\u2654";
	private static final String WHITE_QUEEN = "\u2655";
	private static final String WHITE_ROOK = "\u2656";
	private static final String WHITE_BISHOP = "\u2657";
	private static final String WHITE_KNIGHT = "\u2658";
	private static final String WHITE_PAWN = "\u2659";
	private static final String BLACK_KING = "\u265A";
	private static final String BLACK_QUEEN = "\u265B";
	private static final String BLACK_ROOK = "\u265C";
	private static final String BLACK_BISHOP = "\u265D";
	private static final String BLACK_KNIGHT = "\u265E";
	private static final String BLACK_PAWN = "\u265F";
	
	private static final String BACKGROUND_CREAM = "\u001B[48;5;230m";
	private static final String BACKGROUND_PURPLE = "\u001B[48;5;90m";
	private static final String ANSCI_RESET = "\u001B[0m";
	
	private Gui() {}
	
	public static void testColors() {
		System.out.println(BACKGROUND_CREAM + "    " + BACKGROUND_PURPLE + "    " + ANSCI_RESET);
	}
	
	public static void printBoard(Board board) {
		for (Space space : board.getSpaces()) {
			//TODO: start here
		}
	}

}
