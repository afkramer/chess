package entities.enums;

import java.awt.Color;

public enum SpaceColor {
	WHITE(255, 247, 230),
	BLACK(136, 0, 204);
	
	private Color color;
	
	private SpaceColor(int r, int g, int b) {
		this.color = new Color(r, g, b);
	}
	
	public SpaceColor switchColor() {
		return this == WHITE ? BLACK : WHITE;
	}
	
	public Color getColor() {
		return color;
	}
}
