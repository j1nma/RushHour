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

	private void moveBlock(Block b, Point position) {
		Integer length = b.getLength() - 1;
		Integer orientation = b.getOrientation();

		if (position.x < 0 || position.y < 0) {
			throw new IllegalArgumentException();
		} else if (b.getOrientation() == VERTICAL && position.y + length >= size) {
			throw new IllegalArgumentException();
		} else if (b.getOrientation() == HORIZONTAL && position.x + length >= size) {
			throw new IllegalArgumentException();
		}
		b.setPosition(position);
		while (length > 0) {
			map.put(position, b);
			if (orientation == VERTICAL) {
				position.move(position.x, ++position.y);
			} else {
				position.move(++position.x, position.y);
			}
			length--;
		}
	}

	// TODO: Ver si se puede sacar el ciclo y ponerlo en una funcion separada
	// para no repetir codigo(posibles cambios para que ambas sean la misma
	// funcion
	private void eraseBlock(Block b) {
		Point position = b.getPosition();
		Point current = new Point(position.x, position.y);
		Integer length = b.getLength() - 1;
		Integer orientation = b.getOrientation();

		while (length > 0) {
			map.put(current, null);
			if (orientation == VERTICAL) {
				current.move(current.x, ++current.y);
			} else {
				current.move(++current.x, current.y);
			}
			length--;
		}
	}

	private void addBlock(Block b) {

	}

}
