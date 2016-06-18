package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import model.Block;
import model.Board;
import model.ModelConstants;
import model.Player;

public class ModelTest implements ModelConstants {
	Block block;
	Player player;
	Board board;

	@Before
	public void initialize() {
		block = new Block(new Point(2, 3), 3, HORIZONTAL);
		player = new Player(new Point(1, 1), 2);
		board = new Board(6, 2);

	}

	/* Block */

	@Test(expected = IllegalArgumentException.class)
	public void testBlockOrientation() {
		block = new Block(null, -1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlockLength() {
		block = new Block(null, -1, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBlockNullPoint() {
		block = new Block(null, 2, HORIZONTAL);
	}

	@Test
	public void testGetPosition() {
		assertEquals(new Point(2, 3), block.getPosition());
	}

	@Test
	public void testGetOrientation() {
		assertEquals(HORIZONTAL, block.getOrientation());
	}

	@Test
	public void testGetLength() {
		assertEquals(3, block.getLength());
	}

	/* Player */

	@Test(expected = IllegalArgumentException.class)
	public void testPlayerLength() {
		player = new Player(null, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPlayerNullPoint() {
		player = new Player(null, 1);
	}

	@Test
	public void testGetPlayerPosition() {
		assertEquals(new Point(1, 1), player.getPosition());
	}

	@Test
	public void testGetPlayerOrientation() {
		assertEquals(HORIZONTAL, player.getOrientation());
	}

	@Test
	public void testGetPlayerLength() {
		assertEquals(2, player.getLength());
	}

	/* Board */

	@Test(expected = IllegalArgumentException.class)
	public void testBoardSize() {
		board = new Board(1, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBoardExit() {
		board = new Board(4, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBoardExitEqualsSize() {
		board = new Board(4, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBoardExitGreaterThanSize() {
		board = new Board(3, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMoveBlock() {
		board.moveBlock(block, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockNull() {
		board.addBlock(null, 2, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockNegativeLength() {
		board.addBlock(new Point(0, 0), -1, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockLengthGreaterThanSize() {
		board.addBlock(new Point(0, 0), 7, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockNegativeCoordinate() {
		board.addBlock(new Point(-1, -1), 4, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockCoordinateGreaterThanSize() {
		board.addBlock(new Point(7, 7), 2, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockOrientation() {
		board.addBlock(new Point(3, 2), 2, 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddBlockOccupied() {
		board.addBlock(new Point(0, 0), 2, HORIZONTAL);
		board.addBlock(new Point(1, 0), 2, HORIZONTAL);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddSecondPlayer() {
		board.addPlayer(1, 2);
		board.addPlayer(4, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPlayerNegativeLength() {
		board.addPlayer(1, -2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPlayerLengthGreaterThanSize() {
		board.addPlayer(0, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPlayerNegativeCoordinate() {
		board.addPlayer(-1, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPlayerCoordinateGreaterThanSize() {
		board.addPlayer(7, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPlayerNotFit() {
		board.addPlayer(5, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddPlayerOccupied() {
		board.addBlock(new Point(0, 2), 2, HORIZONTAL);
		board.addPlayer(0, 3);
	}

}
