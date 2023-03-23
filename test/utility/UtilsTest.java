package utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entities.Board;
import entities.Space;

public class UtilsTest {
	
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
}
