package view;

import entities.Board;
import entities.Space;

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
			if (space.getIsFree()) {
				sp
				sb.append(EMPTY_SPACE)
			}
		}
	}

}
