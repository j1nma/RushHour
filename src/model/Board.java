package model;

import java.awt.Point;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Board class represents the physical board of the game. It has a fixed size
 * and exit, where the Player car should slide across to win. It also contains a
 * set of blocks and a map of blocks with their position as keys to store all of
 * the vehicles of the game. Board can move any of its blocks, add one or add a
 * Player block.
 */
public class Board implements ModelConstants, Serializable {
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
	 *            the size of the board (size by size)
	 * @param exit
	 *            the row of the board that has the exit at the right end; from
	 *            0 to size-1
	 */
	public Board(int size, int exit) {
		// El tamaño del tablero no puede ser menor a 2, ya que el auto mide 2
		// posiciones de largo
		// Size must belong to [0,size-1]
		if (size < 2 || exit < 0 || exit >= size) {
			throw new IllegalArgumentException();
		}
		this.size = size;
		this.exit = exit;
		this.blocks = new HashSet<Block>();
		this.map = new HashMap<Point, Block>();

		// Inicializacion de la grilla del tablero.
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				map.put(new Point(x, y), null);
			}
		}
	}

	public boolean isOccupied(int x, int y) {
		return map.get(new Point(x, y)) != null;
	}

	public boolean isOccupied(Point position, int length, int orientation) {
		Point auxPosition = new Point(position.x, position.y);

		while (length-- > 0) {
			if (map.get(auxPosition) != null) {
				return true;
			} else if (orientation == VERTICAL) {
				auxPosition.y++;
			} else {
				auxPosition.x++;
			}
		}
		return false;
	}

	public Block getGridSquare(int x, int y) {
		return getGridSquare(new Point(x, y));
	}

	public Block getGridSquare(final Point position) {
		return map.get(position);
	}

	private void setGridSquare(Block block, int x, int y) {
		map.put(new Point(x, y), block);
	}

	public void moveBlock(Block block, int direction) {
		if (direction != FORWARD && direction != BACKWARD) {
			throw new IllegalArgumentException();
		}

		Point position = nextPosition(block, direction);
		if (position != block.getPosition()) {
			eraseBlock(block);
			block.setPosition(position);
			placeBlock(block, position);
		}
	}

	private Point nextPosition(Block block, int direction) {
		Point next = new Point();
		Point current = block.getPosition();
		int x = current.x;
		int y = current.y;
		int length = block.getLength();

		if (direction == FORWARD) {
			if (block.getOrientation() == VERTICAL) {
				if (y + length < size && !isOccupied(x, y + length)) {
					next.setLocation(x, y + 1);
				} else {
					next = current;
				}
			} else {
				if (x + length < size && !isOccupied(x + length, y)) {
					next.setLocation(x + 1, y);
				} else {
					next = current;
				}
			}
		} else {
			if (block.getOrientation() == VERTICAL) {
				if (y - 1 >= 0 && !isOccupied(x, y - 1)) {
					next.setLocation(x, y - 1);
				} else {
					next = current;
				}
			} else {
				if (x - 1 >= 0 && !isOccupied(x - 1, y)) {
					next.setLocation(x - 1, y);
				} else {
					next = current;
				}
			}
		}
		return next;
	}

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

	public void addBlock(final Point position, int length, int orientation) {
		if (length > size || length < 1) {
			throw new IllegalArgumentException();
		}
		if (position.x < 0 || position.y < 0 || position.x >= size || position.y >= size) {
			throw new IllegalArgumentException();
		}
		if (orientation == HORIZONTAL) {
			if (position.x + length > size) {
				throw new IllegalArgumentException();
			}
		} else {
			if (position.y + length > size) {
				throw new IllegalArgumentException();
			}
		}

		if (isOccupied(position, length, orientation)) {
			// TODO: Buscar una excepcion como la gente;
			throw new IllegalArgumentException();
		}

		Block block = new Block(position, length, orientation);
		blocks.add(block);
		placeBlock(block, position);

		// TODO: Agregar getters de estado si son necesarios.

	}

	/**
	 * Similar to addBlock, but a Player's orientation is always HORIZONTAL and
	 * its position on the y axis always equal to Board's exit.
	 *
	 * @param position
	 *            the position that refers to the block
	 * @param length
	 *            the length of the block
	 * @see #addBlock
	 */
	public void addPlayer(final int x, int length) {
		if (redCar != null) {
			throw new IllegalArgumentException("Player already exists.");
		}

		if (length > size || length < 1) {
			throw new IllegalArgumentException();
		}
		if (x < 0 || x + length > size) {
			throw new IllegalArgumentException();
		}

		if (isOccupied(new Point(x, exit), length, HORIZONTAL)) {
			// TODO: Buscar una excepcion como la gente;
			throw new IllegalArgumentException();
		}

		Point playerPosition = new Point(x, exit);
		Player player = new Player(playerPosition, length);
		
		blocks.add(player);
		placeBlock(player, playerPosition);
		redCar = player;
	}

	public Player getRedCar() {
		return redCar;
	}

	public int getSize() {
		return this.size;
	}

	public Set<Block> getBlocksSet() {
		return this.blocks;
	}

}
// TODO: Ver que hacer con el RedCar y la implementacion en AddBlock.
