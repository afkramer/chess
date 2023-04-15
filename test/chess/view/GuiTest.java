package chess.view;

import org.junit.jupiter.api.Test;

import entities.Board;
import entities.enums.Color;
import entities.pieces.Bishop;
import view.CLIGui;

public class GuiTest {
	
	private Board board = new Board();
	private Bishop bishop = new Bishop(board.getSpaceByCoords(0, 2), Color.BLACK, board);
	
	@Test
	public void printBoardTest() {
		CLIGui.printBoard(board);
	}
	
	@Test
	public void showBishop() {
		System.out.println(bishop.getPieceType().getPieceString());
	}
	
	@Test
	public void printPieces() {
		StringBuilder sb = new StringBuilder();
		sb.append("\u2654\n");
		sb.append("\u2655\n");
		sb.append("\u2656\n");
		sb.append("\u2657\n");
		sb.append("\u2658\n");
		sb.append("\u2659\n");
		sb.append("\u265A\n");
		sb.append("\u265B\n");
		sb.append("\u265C\n");
		sb.append("\u265D\n");
		sb.append("\u265E\n");
		sb.append("\u265F\n");
		System.out.println(sb);
	}
	
}
