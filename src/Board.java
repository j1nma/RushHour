import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board implements Direction {
	private int size;
	private int exit;
	private final Set<Block> blocks;
	private Map<Point, Block> map;
	private Player redCar;

	public Board(int size, int exit, Set<Block> blocks) {
		// El tamaño del tablero no puede ser menor a 2, ya que el auto mide 2
		// posiciones de largo
		if (size < 2 || exit < 0 || exit > size) {
			throw new IllegalArgumentException();
		}
		this.size = size;
		this.exit = exit;
		this.blocks = blocks;
		this.map = new HashMap<Point, Block>();
	}

	private boolean isOccupied(Point position) {
		return map.get(position) != null;
	}

	private void moveBlock(Block block, Point position) {
		Integer length = block.getLength();
		Integer orientation = block.getOrientation();

		if (position.x < 0 || position.y < 0) {
			throw new IllegalArgumentException();
		} else if (orientation == VERTICAL && position.y + length >= size) {
			// throw new IllegalArgumentException();
		} else if (orientation == HORIZONTAL && position.x + length >= size) {
			// throw new IllegalArgumentException();
		}

		eraseBlock(block);
		block.setPosition(position);
		placeBlock(block, position);
	}

	// Posiblemente se puede cambiar para recibir length y orientation en la
	// llamada)
	private void placeBlock(Block block, Point position) {
		Integer length = block.getLength();
		Integer orientation = block.getOrientation();
		while (length-- > 0) {
			map.put(position, block);
			if (orientation == VERTICAL) {
				position.move(position.x, ++position.y);
			} else {
				position.move(++position.x, position.y);
			}
		}
	}

	// TODO: Ver si se puede sacar el ciclo y ponerlo en una funcion separada
	// para no repetir codigo(posibles cambios para que ambas sean la misma
	// funcion
	private void eraseBlock(Block block) {
		Point position = block.getPosition();
		Point current = new Point(position.x, position.y);
		Integer length = block.getLength();
		Integer orientation = block.getOrientation();

		while (length-- > 0) {
			map.put(current, null);
			if (orientation == VERTICAL) {
				current.move(current.x, ++current.y);
			} else {
				current.move(++current.x, current.y);
			}
		}
	}

	private void addBlock(Point position, int length, int orientation) {
		if (length > size || length < 1) {
			throw new IllegalArgumentException();
		}
		if (position.x < 0 || position.y < 0 || position.x > size || position.y > size) {
			throw new IllegalArgumentException();
		}
		if (orientation == HORIZONTAL) {
			if (position.x > size - length) {
				throw new IllegalArgumentException();
			}
		}
		if (orientation == VERTICAL) {
			if (position.x > size - length) {
				throw new IllegalArgumentException();
			}
		}

		Point current = new Point(position);
		int counter = length;

		// Chequeo de si todo el espacio a donde va a estar el bloque este vacio
		// Posiblemente puede ser una funcion. (El controler puede necesitarlo
		// al hacer el move)
		while (counter-- > 0) {
			if (isOccupied(current)) {
				// TODO: Buscar una excepcion como la gente;
			}
			if (orientation == VERTICAL) {
				current.move(current.x, ++current.y);
			} else {
				current.move(++current.x, current.y);
			}
		}

		Block block = new Block(position, length, orientation);
		blocks.add(block);
		placeBlock(block, position);

		// TODO: Agregar getters de estado si son necesarios.

	}

}
