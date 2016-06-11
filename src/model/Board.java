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
public class Board implements Direction, Serializable {
	private final int size;
	private final Point exit = new Point();

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
	 *            the row of the board that has the exit at the right end
	 */
	public Board(int size, int exit) {
		// El tamaño del tablero no puede ser menor a 2, ya que el auto mide 2
		// posiciones de largo
		if (size < 2 || exit < 0 || exit > size) {
			throw new IllegalArgumentException();
		}
		this.size = size;
		this.exit.setLocation(size-1,exit);
		this.blocks = new HashSet<Block>();
		this.map = new HashMap<Point, Block>();

		// Inicializacion de la grilla del tablero.
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				Point position = new Point(x, y);
				map.put(position, null);
			}
		}
	}

	public boolean isOccupied(Point position) {
		return map.get(position) != null;
	}

	public boolean isOccupied(int x, int y) {
		Point position = new Point(x, y);
		return isOccupied(position);
	}

	public Block getGridSquare(int x, int y) {
		Point position = new Point(x, y);
		return getGridSquare(position);
	}

	public Block getGridSquare(final Point position) {
		return map.get(position);
	}

	private void setGridSquare(Block block, int x, int y) {
		Point position = new Point(x, y);
		setGridSquare(block, position);
	}

	private void setGridSquare(Block block, final Point position) {
		map.put(position, block);
	}

	public void moveBlock(Block block, int direction) {
		if (direction != FORWARD && direction != BACKWARD) {
			throw new IllegalArgumentException();
		}

		Point position = nextPosition(block, direction);
		eraseBlock(block);
		block.setPosition(position);
		placeBlock(block, position);
	}

	private Point nextPosition(Block block, int direction) {
		Point nextPosition = new Point();
		Point currentPosition = block.getPosition();
		Integer y = currentPosition.y;
		Integer x = currentPosition.x;
		Integer length = block.getLength();

		if (direction == FORWARD) {
			if (block.getOrientation() == VERTICAL) {
				if (y + length < size && !isOccupied(x, y + length)) {
					nextPosition.setLocation(x, y + 1);
				} else {
					nextPosition = currentPosition;
				}
			} else {
				if (x + length < size && !isOccupied(x + length, y)) {
					nextPosition.setLocation(x + 1, y);
				} else {
					nextPosition = currentPosition;
				}
			}
		} else {
			if (block.getOrientation() == VERTICAL) {
				if (y - 1 >= 0 && !isOccupied(x, y - 1)) {
					nextPosition.setLocation(x, y - 1);
				} else {
					nextPosition = currentPosition;
				}
			} else {
				if (x - 1 >= 0 && !isOccupied(x - 1, y)) {
					nextPosition.setLocation(x - 1, y);
				} else {
					nextPosition = currentPosition;
				}
			}
		}
		return nextPosition;
	}

	private void placeBlock(Block block, final Point position) {
		Integer length = block.getLength();
		Integer orientation = block.getOrientation();
		Integer x = position.x;
		Integer y = position.y;

		while (length-- > 0) {
			setGridSquare(block, x, y);
			if (orientation == VERTICAL) {
				y++;
			} else {
				x++;
			}
		}
	}

	private void eraseBlock(Block block) {
		Integer x = block.getPosition().x;
		Integer y = block.getPosition().y;
		Integer length = block.getLength();
		Integer orientation = block.getOrientation();

		while (length-- > 0) {
			setGridSquare(null, x, y);
			if (orientation == VERTICAL) {
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
		// Chequeo de parametros
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

		Integer x = position.x;
		Integer y = position.y;
		Integer counter = length;
		
		verifyAdd(length,x,y,orientation);
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
	 * @see addBlock
	 */
	public void addPlayer(final Point position, int length) {
		// Chequeo de parametros
		if (length > size || length < 1) {
			throw new IllegalArgumentException();
		}
		if (position.x < 0 || position.x >= size || position.y != exit.y || position.x + length > size) {
			throw new IllegalArgumentException();
		}

		Integer x = position.x;
		Integer y = position.y;
		Integer counter = length;
		
		verifyAdd(length,x,y,HORIZONTAL);
		Player player = new Player(position, length);
		blocks.add(player);
		placeBlock(player, position);
		redCar = player;
	}

	// BoardView lo usa
	public int getSize() {
		return this.size;
	}

	// BoardView lo usa
	public Set<Block> getBlocksSet() {
		return this.blocks;
	}

	public void verifyAdd(int counter, int x, int y, int orientation){
		while (counter-- > 0) {
			if (isOccupied(x, y)) {
				throw new IlegalArgumentException();
			}
			if (orientation == VERTICAL) {
				y++;
			} else {
				x++;
			}
		}
	}
}
// TODO: Ver que hacer con el RedCar y la implementacion en AddBlock.
// TODO: Ver si se puede sacar el loop while(counter( y ponerlo en una funcion
// separada
// para no repetir codigo(posibles cambios para que ambas sean la misma
// funcion
// 3. Junio
// Ya no es final debido a una inconsistencia de diseno
// El metodo de addblock tiene que poder agregar los bloques al set, sin embargo
// el set es final.
