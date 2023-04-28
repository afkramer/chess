package entities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entities.enums.SpaceColor;
import view.Gui;
import view.MyJLabel;

public class Game implements MouseListener {
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
		} else {
			player1.setHasTurn(true);
			player2.setHasTurn(false);
		}
	}
	
	public void startGame() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		MyJLabel label = (MyJLabel) e.getSource();
		LOGGER.debug(String.format("Space selected: %s", label.toString()));
		gui.processSelectedGuiSpace(label);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
