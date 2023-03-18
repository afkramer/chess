package entities.enums;

public enum Color {
	WHITE,
	BLACK;
	
	private Color() {}
	
	public Color switchColor() {
		return this == WHITE ? BLACK : WHITE;
	}
}
