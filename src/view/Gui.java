package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import entities.Board;
import entities.Game;
import entities.Player;
import entities.Space;
import utility.Utils;

public class Gui implements MouseListener {
	private final Logger LOGGER = LoggerFactory.getLogger(Gui.class);
	private JFrame frame;
	private JPanel spacesPanel;
	private Font f = new Font("serif", Font.PLAIN, 36);
	private Game game;
	private Board board;
	private Player currentPlayer;
	private MyJLabel originGuiSpace;
	
	public Gui(Game game, Board board, Player currentPlayer) {
		this.game = game;
		this.board = board;
		this.currentPlayer = currentPlayer;
		this.initializeGui();
	}
	
	public void setCurrentPlayer(Player player) {
		this.currentPlayer = player;
		//TODO: update the view so that it's clear whose turn it is
	}
	
	//TODO: make sure that the board stays square when the screen is resized
	public void initializeGui() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 720);
		drawBoard();
		frame.setVisible(true);
	}
	
	public void drawBoard() {
		spacesPanel = new JPanel();
		spacesPanel.setLayout(new GridLayout(9, 9));
		
		Space boardSpace;
		
		String[] columnLabels = {" ", "A", "B", "C", "D", "E", "F", "G", "H"};
		for (String label : columnLabels) {
			
			MyJLabel guiSpace = new MyJLabel(label);
			guiSpace.setFont(f);
			spacesPanel.add(guiSpace);
			
		}
		
		for (int x = 0; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = 0; y <= Utils.MAXIMUM_COORDINATE + 1; y++) {
				MyJLabel guiSpace = new MyJLabel();
				guiSpace.setFont(f);
				
				// It is a label for each row
				if (y == 0) {
					guiSpace.setText("" + (x + 1));
				
				// it is a space and needs the correct color and/or piece
				} else {
					boardSpace = board.getSpaceByCoords(x, y - 1);
					guiSpace.setBackground(boardSpace.getColor().getColor());
					guiSpace.addMouseListener(this);
					guiSpace.setxCoord(x);
					guiSpace.setyCoord(y - 1);
					
					if (boardSpace.getPiece() != null) {
						String pieceString = boardSpace.getPiece().getPieceType().getPieceString();
						guiSpace.setText(pieceString);
					} 
				}
				spacesPanel.add(guiSpace);
			}
		}
		frame.getContentPane().add(BorderLayout.CENTER, spacesPanel);
	}
	
	// TODO: this method should pass on the x and y coordinates
	// First validate whether a piece has been chosen of the color of the current player
		// If no piece has been selected, wait for a piece to be selected
		// If the wrong color piece has been selected, do nothing and wait for the proper piece to be selected
		// If the correct color piece has been selected, set the border so that the player knows it has been selected
		// If the player selects the space again, they are still the current player
		// Wait for them to select the next piece they want to move
		// Otherwise, if they select a free space, validate that it is a valid move
			// If it is valid, move the piece
			// If it is not valid, flash red that the move is not allowed and/or display a message
	
	
	// Where should this logic all take place?? How to connect the Gui and Game classes???
	// TODO: call this method from the Game class 
		// Change return type to int[] 
		// If a current space and destination space have been selected, return those coords as int[]
		// Otherwise return null if the player is still selecting a destination space
	public void processSelectedGuiSpace(MyJLabel guiSpace) {
		Space chosenSpace = board.getSpaceByCoords(guiSpace.getxCoord(), guiSpace.getyCoord());
		
		if (!chosenSpace.getIsFree() && this.originGuiSpace == null 
				&& chosenSpace.getPiece().getColor() == this.currentPlayer.getColor()) {
			LOGGER.debug(String.format("Selecting Gui space: %s", guiSpace.toString()));
			selectOriginGuiSpace(guiSpace);	
		} else if (this.originGuiSpace == guiSpace) {
			LOGGER.debug(String.format("Unselecting Gui space: %s", guiSpace.toString()));
			unselectOriginGuiSpace(guiSpace);
		} else if (this.originGuiSpace != null && 
				(chosenSpace.getIsFree() || board.isPieceCaptured(currentPlayer.getColor(), chosenSpace))) {
			LOGGER.debug(String.format("Passing on to process a move: %s", guiSpace.toString()));
			processMove(guiSpace);
			// return int[] with start and finish spaces
		}
	}
	
	public void selectOriginGuiSpace(MyJLabel guiSpace) {
		guiSpace.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		guiSpace.setSelected(true);
		this.originGuiSpace = guiSpace;
	}
	
	public void unselectOriginGuiSpace(MyJLabel guiSpace) {
		guiSpace.setBorder(BorderFactory.createEmptyBorder());
		guiSpace.setSelected(false);
		this.originGuiSpace = null;
	}
	
	// TODO: this needs to include logic for capturing pieces!
	// Method is too long. How can I break it up into smaller methods
	public void processMove(MyJLabel destinationGuiSpace) {
		LOGGER.debug(String.format("Player wants to move from: %d, %d to %d %d", 
				this.originGuiSpace.getxCoord(), this.originGuiSpace.getyCoord(), 
				destinationGuiSpace.getxCoord(), destinationGuiSpace.getyCoord()));
		Space destBoardSpace = board.getSpaceByCoords(destinationGuiSpace.getxCoord(), destinationGuiSpace.getyCoord());
		Space originBoardSpace = board.getSpaceByCoords(originGuiSpace.getxCoord(), originGuiSpace.getyCoord());
		if (originBoardSpace.getPiece().isMoveValid(destBoardSpace)) {
			destinationGuiSpace.setText(originBoardSpace.getPiece().getPieceType().getPieceString());
			originBoardSpace.getPiece().move(destBoardSpace);
			destBoardSpace.getPiece().moved();
			originGuiSpace.setText("");
			unselectOriginGuiSpace(originGuiSpace);
			game.switchCurrentPlayer();
		}
	}

	
	public void mouseEntered(MouseEvent event) {
	}
	
	public void mousePressed(MouseEvent event) {
	}
	
	public void mouseClicked(MouseEvent event) {
		MyJLabel label = (MyJLabel) event.getSource();
		LOGGER.debug(String.format("Space selected: %s", label.toString()));
		processSelectedGuiSpace(label);
	}
	
	public void mouseReleased(MouseEvent event) {
	}
	
	public void mouseExited(MouseEvent event) {
	}
	
	public void updateBoard() {
		
	}
}
