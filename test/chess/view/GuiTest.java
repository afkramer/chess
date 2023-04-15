package chess.view;

import org.junit.jupiter.api.Test;

import entities.Board;
import view.Gui;

public class GuiTest {
	
	private Board board = new Board();
	
	@Test
	public void printBoardTest() {
		Gui.printBoard(board);
	}
	
}
