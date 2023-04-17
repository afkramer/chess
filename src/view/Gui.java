package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entities.Board;
import entities.Space;
import utility.Utils;

public class Gui implements MouseListener {
	private JFrame frame;
	private JPanel spacesPanel;
	private Font f = new Font("serif", Font.PLAIN, 36);
	private Board board;
	
	public Gui(Board board) {
		this.board = board;
		this.initializeGui();
	}
	
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

	
	public void mouseEntered(MouseEvent event) {
	}
	
	public void mousePressed(MouseEvent event) {
	}
	
	public void mouseClicked(MouseEvent event) {
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
		System.out.println(event.getSource());
		System.out.println(event.getComponent().toString());
	
	}
	
	public void mouseReleased(MouseEvent event) {
	}
	
	public void mouseExited(MouseEvent event) {
	}
	
	public void updateBoard() {
		
	}
}
