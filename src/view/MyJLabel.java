package view;

import javax.swing.JLabel;
import javax.swing.border.Border;

public class MyJLabel extends JLabel {

	private static final long serialVersionUID = 3962219754901511244L;
	private final int xCoord;
	private final int yCoord;
	
	public MyJLabel(String labelText, int textPosition, int boardXCoordinate, int boardYCoordinate) {
		super(labelText, textPosition);
		this.xCoord = boardXCoordinate;
		this.yCoord = boardYCoordinate;
		this.setOpaque(true);
	}
	
	public MyJLabel(String labelText, int x, int y) {
		this(labelText, JLabel.CENTER, x, y);
	}
	
	public MyJLabel(int x, int y) {
		this("", JLabel.CENTER, x, y);
	}
	
	public MyJLabel(String labelText, int position) {
		this(labelText, position, 0, 0);
	}
	
	public MyJLabel(String labelText) {
		this(labelText, JLabel.CENTER, 0, 0);
	}
	
	public MyJLabel() {
		this("", JLabel.CENTER, 0, 0);
	}

	public String toString() {
		return "Label: " + this.getText() + "Board x: " + this.xCoord + " Board y: " + this.yCoord;
	}

}
