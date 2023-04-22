package chess.view;

import org.junit.jupiter.api.Test;

import entities.Board;
import entities.Player;
import entities.enums.SpaceColor;
import view.Gui;

public class GuiTest {
	
	private Board board = new Board();
	private Player player1 = new Player(SpaceColor.WHITE, true);
	private Player player2 = new Player(SpaceColor.BLACK, false);
	
	@Test
	public void guiInitializes() {
		Gui gui = new Gui(board, player1);
	}
}
