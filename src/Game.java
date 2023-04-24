import entities.Board;
import entities.Player;
import entities.enums.SpaceColor;
import view.Gui;

public class Game {
	private Gui gui;
	private Board board;
	private Player player1;
	private Player player2;
	
	public Game() {
		setUpGame();
	}
	
	public void setUpGame() {
		board = new Board();
		setUpPlayers();
		gui = new Gui(board, getCurrentPlayer());
	}
	
	public void setUpPlayers() {
		player1 = new Player(SpaceColor.WHITE, true);
		player2 = new Player(SpaceColor.BLACK, false);
	}
	
	public Player getCurrentPlayer() {
		return player1.getHasTurn() ? player1 : player2;
	}
	
	public void switchCurrentPlayer() {
		if (player1.getHasTurn()) {
			player1.setHasTurn(false);
			player2.setHasTurn(true);
		} else {
			player1.setHasTurn(true);
			player2.setHasTurn(false);
		}
	}
	
	public void startGame() {
		
	}
}
