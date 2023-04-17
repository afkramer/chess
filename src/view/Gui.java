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
import service.TestListener;
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
		//testMyJLabel();
		frame.setVisible(true);
	}
	
	public void testMyJLabel() {
		spacesPanel = new JPanel();
		spacesPanel.setLayout(new GridLayout(2, 2));
		
		JLabel label1 = new JLabel("JLabel1", JLabel.CENTER);
		label1.setBackground(Color.CYAN);
		label1.setOpaque(true);
		label1.addMouseListener(new TestListener(0,0));
		spacesPanel.add(label1);
		
		MyJLabel label2 = new MyJLabel("MyJLabel2", JLabel.CENTER, 0, 1);
		label2.setBackground(Color.MAGENTA);
		label1.addMouseListener(this);
		spacesPanel.add(label2);
		
		JLabel label3 = new JLabel("", JLabel.CENTER);
		label3.setBackground(Color.MAGENTA);
		label3.setOpaque(true);
		label3.setText("new text");
		label1.addMouseListener(this);
		spacesPanel.add(label3);
		
		MyJLabel label4 = new MyJLabel("", JLabel.CENTER, 1, 1);
		label4.setBackground(Color.CYAN);
		label4.setText("new text");
		label1.addMouseListener(this);
		spacesPanel.add(label4);
		
		frame.getContentPane().add(BorderLayout.CENTER, spacesPanel);
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
	
		
	public void drawEmptyBoardDoesWorkButIsNotCool() {
		spacesPanel = new JPanel();
		spacesPanel.setLayout(new GridLayout(9, 9));
		
		Space boardSpace;
		
		String[] columnLabels = {" ", "A", "B", "C", "D", "E", "F", "G", "H"};
		for (String label : columnLabels) {
			
			MyJLabel guiSpace = new MyJLabel();
			guiSpace.setText(label);
			guiSpace.setOpaque(true);
			guiSpace.setFont(f);
			spacesPanel.add(guiSpace);
			
		}
		
		//TODO: a lot of repeated code because text alignment wasn't working correctly if text was added after object instantiation
		//TODO: how to determine where the user clicked to be able to then move their desired piece?
		for (int x = 0; x <= Utils.MAXIMUM_COORDINATE; x++) {
			for (int y = 0; y <= Utils.MAXIMUM_COORDINATE + 1; y++) {
				
				if (y == 0) {
					MyJLabel guiSpace = new MyJLabel("" + x);
					guiSpace.setFont(f);
					guiSpace.setText("" + x);
					spacesPanel.add(guiSpace);
					
				} else {
					boardSpace = board.getSpaceByCoords(x, y - 1);
					
					if (boardSpace.getPiece() == null) {
						MyJLabel guiSpace = new MyJLabel(x, y);
						guiSpace.setBackground(boardSpace.getColor().getColor());
						guiSpace.setFont(f);
						guiSpace.addMouseListener(this);
						spacesPanel.add(guiSpace);
						
					} else {
						String pieceString = boardSpace.getPiece().getPieceType().getPieceString();
						MyJLabel guiSpace = new MyJLabel(pieceString, x, y);
						guiSpace.setBackground(boardSpace.getColor().getColor());
						guiSpace.setFont(f);
						guiSpace.addMouseListener(this);
						spacesPanel.add(guiSpace);
					}
				}
			}
		}
		
		frame.getContentPane().add(BorderLayout.CENTER, spacesPanel);
	}
	
	// Including all extra steps
	public void drawEmptyBoardOriginal() {
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
					//guiSpace.setX(x);
					//guiSpace.setY(y);
					
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
