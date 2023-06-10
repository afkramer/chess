package chess.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entities.Board;
import entities.Space;
import entities.enums.SpaceColor;

public class BoardTest {
	
	private static Board board;
	
	@BeforeAll
	public static void setUp() {
		board = new Board();
		board.getSpaceByCoords(4, 3).setIsFree(false);
		board.getSpaceByCoords(4, 4).setIsFree(false);
	}

	@Test
	public void isPieceInDiagonalPathFalseTest() {
		// TODO: update these tests to actually put a piece of a certain color in the path
		Space currentSpace = new Space(5, 1);
		Space targetSpace = new Space(2, 4);
		Assertions.assertFalse(board.isPieceInDiagonalPath(SpaceColor.BLACK, currentSpace, targetSpace));
	}
	
	@Test
	public void isPieceInDiagonalPathTrueTest() {
		Space currentSpace = new Space(5, 2);
		Space targetSpace = new Space(2, 5);
		Assertions.assertTrue(board.isPieceInDiagonalPath(SpaceColor.WHITE, currentSpace, targetSpace));
	}
	
}
