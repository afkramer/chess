package view;

import javax.swing.JLabel;
import javax.swing.border.Border;

public class MyJLabel extends JLabel {

	private static final long serialVersionUID = 3962219754901511244L;
	private int x;
	private int y;
	
	public MyJLabel(String labelText, int textPosition, int boardXCoordinate, int boardYCoordinate) {
		super(labelText, textPosition);
		this.x = boardXCoordinate;
		this.y = boardYCoordinate;
		this.setOpaque(true);
	}
	
	public MyJLabel(int x, int y) {
		this("", JLabel.CENTER, x, y);
	}
	
	public MyJLabel(String labelText, int position) {
		this(labelText, position, 0, 0);
	}
	
	public MyJLabel() {
		this("", JLabel.CENTER, 0, 0);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "Label: " + this.getText() + "Board x: " + this.x + " Board y: " + this.y;
	}

}
