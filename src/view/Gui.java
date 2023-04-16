package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Board;
import entities.Space;
import utility.Utils;

//TODO: the way things stand, all the labels are kind of bunched up.. I'm not sure how the spacing is working or why they aren't visible

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
		drawEmptyBoard();
		frame.setVisible(true);
	}
	
	public void drawEmptyBoard() {
		spacesPanel = new JPanel();
		spacesPanel.setLayout(new GridLayout(9, 9));
		//spacesPanel.addMouseListener(this);
		
		//frame.addMouseListener(this);
		Space boardSpace;
		
		String[] columnLabels = {" ", "A", "B", "C", "D", "E", "F", "G", "H"};
		for (String label : columnLabels) {
			
			JLabel guiSpace = new JLabel(label, JLabel.CENTER);
			guiSpace.setFont(f);
			spacesPanel.add(guiSpace);
			
		}
		
		//TODO: a lot of repeated code because text alignment wasn't working correctly if text was added after object instantiation
		//TODO: how to determine where the user clicked to be able to then move their desired piece?
		for (int x = 0; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = 0; y <= Utils.MAXIMUM_COORDINATE + 1; y++) {
				MyJLabel guiSpace = new MyJLabel();
				guiSpace.setFont(f);
				
				
				if (y == 0) {
					//JLabel guiSpace = new JLabel("" + x, JLabel.CENTER);
					//guiSpace.setFont(f);
					guiSpace.setText("" + x);
					//spacesPanel.add(guiSpace);
					
				} else {
					boardSpace = board.getSpaceByCoords(x, y - 1);
					guiSpace.setBackground(boardSpace.getColor().getColor());
					guiSpace.addMouseListener(this);
					guiSpace.setX(x);
					guiSpace.setY(y);
					
					if (boardSpace.getPiece() == null) {
						//JLabel guiSpace = new JLabel();
						//guiSpace.setBackground(boardSpace.getColor().getColor());
						//guiSpace.setOpaque(true);
						//guiSpace.setFont(f);
						//guiSpace.addMouseListener(this);
						//spacesPanel.add(guiSpace);
						
					} else {
						String pieceString = boardSpace.getPiece().getPieceType().getPieceString();
						guiSpace.setText(pieceString);
						//JLabel guiSpace = new JLabel(pieceString, JLabel.CENTER);
						//guiSpace.setBackground(boardSpace.getColor().getColor());
						//guiSpace.setOpaque(true);
						//guiSpace.setFont(f);
						//guiSpace.addMouseListener(this);
						//spacesPanel.add(guiSpace);
					}
					spacesPanel.add(guiSpace);
					
				}
				
			}
		}
		
		frame.getContentPane().add(BorderLayout.CENTER, spacesPanel);
		//guiSpace = new JLabel("\u265B", JLabel.CENTER);
		
		
		//space.addMouseListener(this);
		//space.setText("\u265B");
		//frame.getContentPane().add(BorderLayout.CENTER, space);

	}
	
	/*
	public void actionPerformed(ActionEvent event) {
		space.setText("\u2655");
	}
	*/
	
	public void mouseEntered(MouseEvent event) {
	}
	
	public void mousePressed(MouseEvent event) {
	}
	
	public void mouseClicked(MouseEvent event) {
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
