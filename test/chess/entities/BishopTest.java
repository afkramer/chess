package chess.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entities.Board;
import entities.enums.Color;
import entities.pieces.Bishop;

public class BishopTest {
	private static Board board;
	
	@BeforeAll
	public static void setUp() {
		board = new Board();
		board.getSpaceByCoords(6, 1).setIsFree(false);
		board.getSpaceByCoords(5, 5).setIsFree(false);
	}
	
	@Test
	public void isMoveValidHappyPathTest() {
		Bishop bishop = new Bishop(board.getSpaceByCoords(5, 2), Color.WHITE, board);
		Assertions.assertTrue(bishop.isMoveValid(board.getSpaceByCoords(2, 5)));
	}
	
	@Test
	public void isMoveValidPieceInWayTest() {
		Bishop bishop = new Bishop(board.getSpaceByCoords(7,  0), Color.BLACK, board);
		Assertions.assertFalse(bishop.isMoveValid(board.getSpaceByCoords(5, 2)));
	}
	
	@Test
	public void isMoveValidNotDiagonalTest() {
		Bishop bishop = new Bishop(board.getSpaceByCoords(7, 0), Color.WHITE, board);
		Assertions.assertFalse(bishop.isMoveValid(board.getSpaceByCoords(3, 0)));
	}
}
