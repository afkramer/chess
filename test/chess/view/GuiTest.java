package chess.view;

import org.junit.jupiter.api.Test;

import entities.Board;
import view.Gui;

public class GuiTest {
	
	Board board = new Board();
	
	@Test
	public void guiInitializes() {
		Gui gui = new Gui(board);
	}
}
