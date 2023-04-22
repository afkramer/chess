package entities;

import entities.enums.SpaceColor;

public class Player {
	
	private SpaceColor color;
	private boolean hasTurn;

	
	public Player(SpaceColor color, boolean hasTurn) {
		this.color = color;
		this.hasTurn = hasTurn;
	}
	
	public SpaceColor getColor() {
		return this.color;
	}
	
	public void setColor(SpaceColor color) {
		this.color = color;
	}
	
	public boolean getHasTurn() {
		return this.hasTurn;
	}
	
	public void setHasTurn(boolean hasTurn) {
		this.hasTurn = hasTurn;
	}
}
