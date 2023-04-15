package view;

import entities.Board;
import entities.Space;
import entities.enums.Color;
import utility.Utils;

public class Gui {
	private static final String EMPTY_SPACE = " ";
	
	private static final String BACKGROUND_CREAM = "\u001B[48;5;230m";
	private static final String BACKGROUND_PURPLE = "\u001B[48;5;90m";
	private static final String ANSCI_RESET = "\u001B[0m";
	
	private Gui() {}
	
	public static void testColors() {
		System.out.println(BACKGROUND_CREAM + "    " + BACKGROUND_PURPLE + "    " + ANSCI_RESET);
	}
	
	public static void printBoard(Board board) {
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for (Space space : board.getSpaces()) {
			
			if (space.getColor().equals(Color.BLACK)) {
				sb.append(BACKGROUND_PURPLE);
			} else {
				sb.append(BACKGROUND_CREAM);
			}
			
			if (space.getIsFree()) {
				sb.append(EMPTY_SPACE);
			} else {
				sb.append(space.getPiece().getPieceType().getPieceString());
			}
			
			if (counter == Utils.MAXIMUM_COORDINATE) {
				sb.append("\n");
				counter = Utils.MINIMUM_COORDINATE;
			} else {
				counter++;
			}
		}
		
		System.out.println(sb);
	}

	public static String setSpaceColor() {
		return "";
	}
}
