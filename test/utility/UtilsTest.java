package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entities.Board;
import entities.Space;

public class UtilsTest {
	
	private static Board board;
	
	@BeforeAll
	public static void setUp() {
		board = new Board();
		board.getSpaceByCoords(4, 3).setIsFree(false);
		board.getSpaceByCoords(4, 4).setIsFree(false);
	}
	
	@Test
	public void isDiagonalMoveHappyPathTest() {
		Space currentSpace = new Space(0, 3);
		Space targetSpace = new Space(4, 7);
		Assertions.assertTrue(Utils.isDiagonalMove(currentSpace, targetSpace));
	}
	
	@Test
	public void isDiagonalMoveNotDiagonalTest() {
		Space currentSpace = new Space(0, 3);
		Space targetSpace = new Space(6, 3);
		Assertions.assertFalse(Utils.isDiagonalMove(currentSpace, targetSpace));
	}
	
	@Test
	public void isDiagonalMoveSameSpaceTest() {
		Space currentSpace = new Space(5, 6);
		Space targetSpace = new Space(5, 6);
		Assertions.assertFalse(Utils.isDiagonalMove(currentSpace, targetSpace));
	}
	
	@Test
	public void isHorizontalMoveHappyPathTest() {
		Space currentSpace = new Space(0, 2);
		Space targetSpace = new Space(6, 2);
		Assertions.assertTrue(Utils.isHorizontalMove(currentSpace, targetSpace));
	}
	
	@Test
	public void isHorizontalMoveNotHorizontalTest() {
		Space currentSpace = new Space(3, 6);
		Space targetSpace = new Space(4, 1);
		Assertions.assertFalse(Utils.isHorizontalMove(currentSpace, targetSpace));
	}
	
	// START HERE WITH TESTING!
	@Test
	public void isPieceInDiagonalPathFalseTest() {
		Space currentSpace = new Space(5, 1);
		Space targetSpace = new Space(2, 4);
		Assertions.assertFalse(Utils.isPieceInDiagonalPath(currentSpace, targetSpace, board));
	}
	
	@Test
	public void isPieceInDiagonalPathTrueTest() {
		Space currentSpace = new Space(5, 2);
		Space targetSpace = new Space(2, 5);
		Assertions.assertTrue(Utils.isPieceInDiagonalPath(currentSpace, targetSpace, board));
	}
}
