package view;

import javax.swing.JLabel;

public class MyJLabel extends JLabel {

	private static final long serialVersionUID = 3962219754901511244L;
	private int x;
	private int y;
	
	public MyJLabel(int x, int y) {
		super("", JLabel.CENTER);
		this.x = x;
		this.y = y;
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

}
