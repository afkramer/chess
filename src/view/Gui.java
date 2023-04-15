package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Gui implements MouseListener {
	private JFrame frame;
	private Font f = new Font("serif", Font.PLAIN, 36);
	private JLabel space;
	
	public Gui() {
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
		
		space = new JLabel("\u265B", JLabel.CENTER);
		space.setSize(20, 20);
		//space.setBackground(Color.MAGENTA);
		space.setBackground(Color.MAGENTA);
		space.setFont(f);
		space.setOpaque(true);
		space.addMouseListener(this);
		//space.setText("\u265B");
		frame.getContentPane().add(space);
		
		
		/*
		JButton button = new JButton("\u265B");
		button.setBackground(Color.MAGENTA);
		button.setOpaque(true);
		button.setFont(Font.getFont("Helvetica"));
		button.setSize(20, 20);
		frame.getContentPane().add(button);
		*/
	}
	
	/*
	public void actionPerformed(ActionEvent event) {
		space.setText("\u2655");
	}
	*/
	
	public void mouseEntered(MouseEvent event) {
		space.setText("entered");
	}
	
	public void mousePressed(MouseEvent event) {
		space.setText("pressed");
	}
	
	public void mouseClicked(MouseEvent event) {
		space.setText("clicked at x: " + event.getX() + " y: " + event.getY());
	}
	
	public void mouseReleased(MouseEvent event) {
		space.setText("released");
	}
	
	public void mouseExited(MouseEvent event) {
		space.setText("exited");
	}
	
	public void updateBoard() {
		
	}
}
