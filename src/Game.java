import entities.Board;
import entities.Player;
import view.Gui;

public class Game {
	private Gui gui;
	private Board board;
	private Player player1;
	private Player player2;
	
	public Game() {
		board = new Board();
		gui = new Gui(board);
	}
	
	public void startGame() {
		
	}
}
