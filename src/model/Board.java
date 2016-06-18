package model;

import java.awt.Point;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Board represents the physical board of the game. It has a fixed size and exit
 * on its right side, where the Player car should slide across to win. It also
 * has a set of blocks and a map of blocks with their position as keys to store
 * all of the vehicles of the game. Board can move any of its blocks, add one or
 * add a Player block.
 */
public class Board implements ModelConstants, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int size;
	private int exit;
	private Set<Block> blocks;
	private Map<Point, Block> map;
	private Player redCar;

	/**
	 * Board constructor. Validates parameters and initializes the set and map
	 * of blocks, the latter with Point position with null value.
	 *
	 * @param size
	 *            the size of the board (size by size). Must be greater than 1.
	 * @param exit
	 *            the row of the board that has the exit at the right end; from
	 *            0 to size-1
	 */
	public Board(int size, int exit) {
		if (size < 2) {
			throw new IllegalArgumentException("Size must be greater than 1");
		}

		if (exit < 0 || exit >= size) {
			throw new IllegalArgumentException("Exit must belong to [0," + (size - 1) + "]");
		}

		this.size = size;
		this.exit = exit;
		this.blocks = new HashSet<Block>();
		this.map = new HashMap<Point, Block>();

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				map.put(new Point(x, y), null);
			}
		}
	}

	public boolean positionIsOccupied(int x, int y) {
		return map.get(new Point(x, y)) != null;
	}

	/**
	 * Validates if any position of the map including the position passed as
	 * parameter and the following length - 1 positions point to a block.
	 * 
	 * @param position
	 *            the position of the block to be added
	 * @param length
	 *            the length of the block to be added
	 * @param orientation
	 *            the orientation of the block to be added
	 * @return true if position already points to a block, false if not
	 */
	public boolean isOccupied(Point position, int length, int orientation) {
		Point auxPosition = new Point(position.x, position.y);

		while (length-- > 0) {
			if (positionIsOccupied(auxPosition.x, auxPosition.y)) {
				return true;
			} else if (orientation == VERTICAL) {
				auxPosition.y++;
			} else {
				auxPosition.x++;
			}
		}
		return false;
	}

	public Block getGridBlock(final Point position) {
		return map.get(position);
	}

	private void setGridSquare(Block block, int x, int y) {
		map.put(new Point(x, y), block);
	}

	/**
	 * Attempts to move block in the direction passed as parameter. If the
	 * attempted movement resulted in a change of position the map is reset to
	 * these conditions and the block's position is changed to the new one.
	 * 
	 * @param block
	 *            block to be moved
	 * @param direction
	 *            direction of movement
	 */
	public void moveBlock(Block block, int direction) {
		if (direction != FORWARD && direction != BACKWARD) {
			throw new IllegalArgumentException("Illegal direction.");
		}

		Point position = nextPosition(block, direction);
		if (position != block.getPosition()) {
			eraseBlock(block);
			block.setPosition(position);
			placeBlock(block, position);
		}
	}

	/**
	 * Spans through the map according to the blocks orientation and length. If
	 * the block can't move (isOccupied returns true or board limit is in the
	 * way) the current position is returned. If it can, the following position
	 * on the board is returned.
	 * 
	 * @param block
	 *            block to be moved
	 * @param direction
	 *            direction of movement (forward or backward)
	 * @return the next position according to direction if block can move.
	 *         Current position otherwise.
	 */
	private Point nextPosition(Block block, int direction) {
		Point current = block.getPosition();
		Point next = new Point(current);
		int x = current.x;
		int y = current.y;
		int length = block.getLength();

		if (direction == FORWARD) {
			if (block.getOrientation() == VERTICAL) {
				if (y + length < size && !positionIsOccupied(x, y + length)) {
					next.setLocation(x, y + 1);
				}
			} else if (x + length < size && !positionIsOccupied(x + length, y)) {
				next.setLocation(x + 1, y);
			}
		} else {
			if (block.getOrientation() == VERTICAL) {
				if (y - 1 >= 0 && !positionIsOccupied(x, y - 1)) {
					next.setLocation(x, y - 1);
				}
			} else if (x - 1 >= 0 && !positionIsOccupied(x - 1, y)) {
				next.setLocation(x - 1, y);
			}
		}
		return next;
	}

	/**
	 * Sets positions in map to point to block. (As many positions as the
	 * block's length).
	 * 
	 * @param block
	 *            block to be placed
	 * @param position
	 *            position of the block in map
	 */
	private void placeBlock(Block block, final Point position) {
		int length = block.getLength();
		int x = position.x;
		int y = position.y;

		while (length-- > 0) {
			setGridSquare(block, x, y);
			if (block.getOrientation() == VERTICAL) {
				y++;
			} else {
				x++;
			}
		}
	}

	/**
	 * Sets value of positions pointing to block to null
	 * 
	 * @param block
	 */
	private void eraseBlock(Block block) {
		int length = block.getLength();
		int x = block.getPosition().x;
		int y = block.getPosition().y;

		while (length-- > 0) {
			setGridSquare(null, x, y);
			if (block.getOrientation() == VERTICAL) {
				y++;
			} else {
				x++;
			}
		}
	}

	/**
	 * Validates parameters, verifying that no other blocks occupy the places
	 * the block being added is intended to occupy. Adds block to the set and
	 * map.
	 *
	 * @param position
	 *            the position that refers to the block
	 * @param length
	 *            the length of the block
	 * @param orientation
	 *            the orientation of the block
	 */
	public Block addBlock(final Point position, int length, int orientation) {
		if (position == null) {
			throw new IllegalArgumentException("Position is null");
		}

		if (length > size || length < 1) {
			throw new IllegalArgumentException("Length must belong to [1,size]");
		}

		if (position.x < 0 || position.y < 0 || position.x >= size || position.y >= size) {
			throw new IllegalArgumentException("Coordiantes must belong to [0,size-1]");
		}

		if (orientation == HORIZONTAL) {
			if (position.x + length > size) {
				throw new IllegalArgumentException("Horizontal block doesn't fit the grid");
			}
		} else if (orientation == VERTICAL) {
			if (position.y + length > size) {
				throw new IllegalArgumentException("Vertical block doesn't fit the grid");
			}
		} else {
			throw new IllegalArgumentException("Illegal orientation");
		}

		if (isOccupied(position, length, orientation)) {
			throw new IllegalArgumentException("One or all of the block's positions are occupied");
		}

		Block block = new Block(position, length, orientation);
		blocks.add(block);
		placeBlock(block, position);
		return block;
	}

	/**
	 * Similar to addBlock, but a Player's orientation is always HORIZONTAL and
	 * its position on the y axis always equal to Board's exit.
	 *
	 * @param x
	 *            the column index of the red car. Y coordinate is always equal
	 *            to exit and orientation to HORIZONTAL
	 * @param length
	 *            the length of the block
	 * @see #addBlock
	 */
	public Player addPlayer(final int x, int length) {
		if (redCar != null) {
			throw new IllegalArgumentException("Player already exists.");
		}

		if (length > size || length < 1) {
			throw new IllegalArgumentException("Length must belong to [1," + size + "]");
		}

		if (x < 0 || x >= size) {
			throw new IllegalArgumentException("Coordinate x must belong to [0," + (size - 1) + "]");
		}
		if (x + length > size) {
			throw new IllegalArgumentException("Red car doesn't fit the grid");
		}

		if (isOccupied(new Point(x, exit), length, HORIZONTAL)) {
			throw new IllegalArgumentException("One of the block's positions is occupied");
		}

		Point playerPosition = new Point(x, exit);
		Player player = new Player(playerPosition, length);

		blocks.add(player);
		placeBlock(player, playerPosition);
		redCar = player;

		return player;
	}

	public Player getRedCar() {
		return redCar;
	}

	public int getSize() {
		return size;
	}

	public Set<Block> getBlocksSet() {
		return blocks;
	}

	public int getExit() {
		return exit;
	}
}