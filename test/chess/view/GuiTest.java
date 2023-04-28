package chess.view;

import org.junit.jupiter.api.Test;

import entities.Board;
import entities.Game;
import entities.Player;
import entities.enums.SpaceColor;
import view.Gui;

public class GuiTest {
	
	private Game game = new Game();
	private Board board = new Board();
	private Player player1 = new Player(SpaceColor.WHITE, true);
	private Player player2 = new Player(SpaceColor.BLACK, false);
	
	@Test
	public void guiInitializes() {
		Gui gui = new Gui(game, board, player1);
	}
}
