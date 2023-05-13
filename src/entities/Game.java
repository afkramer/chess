package entities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.enums.SpaceColor;
import entities.pieces.Piece;
import view.Gui;
import view.MyJLabel;

public class Game {
	private Logger LOGGER = LoggerFactory.getLogger(Game.class);
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
		gui = new Gui(this, board, getCurrentPlayer());
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
			gui.setCurrentPlayer(player2);
		} else {
			player1.setHasTurn(true);
			player2.setHasTurn(false);
			gui.setCurrentPlayer(player1);
		}
	}
	
	public void startGame() {
		
	}
	
	public void makeMove(Space origin, Space destination) {
		//TODO: move more of the game logic from the Gui to here so that concerns are better separated
	}

}
