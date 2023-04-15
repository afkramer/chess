package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(20,  50,  100,  100);
	}
}
