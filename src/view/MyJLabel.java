package view;

import javax.swing.JLabel;
import javax.swing.border.Border;

public class MyJLabel extends JLabel {

	private static final long serialVersionUID = 3962219754901511244L;
	private int xCoord;
	private int yCoord;
	private boolean isSelected;
	
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

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String toString() {
		return "Label: " + this.getText() + "Board x: " + this.xCoord + " Board y: " + this.yCoord;
	}

}
