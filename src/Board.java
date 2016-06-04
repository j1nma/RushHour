import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board implements Direction,Movement {
	private int size;
	private int exit;
	private final Set<Block> blocks;
	private Map<Point, Block> map;
	private Player redCar;
	
	/**
	 * CONSTRUCTOR BOARD
	 */

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

	/**
	 * METODOS PARA VER SI UNA POSICION ESTA OCUPADA
	 */


	private boolean isOccupied(Point position) {
		return map.get(position) != null;
	}

	private boolean isOccupied(int x, int y){
		Point position= new Point(x,y);
		return isOccupied(position);
	}

	/**
	 * METODO PARA MOVER UN BLOQUE( SE MUEVE DE A UNA POSICION PARA ADELANTE O PARA ATRAS)
	 */

	private void moveBlock(Block block, int direction) {
		Point position = new Point();

		if (direction != FORWARD && direction != BACKWARD ) {
			throw new IllegalArgumentException();
		}
		position = nextPosition(block, direction);
		eraseBlock(block);
		block.setPosition(position);
		placeBlock(block, position);
	}
	
	/**
	 * METODO PARA VERIFICAR SI  EL MOVIMIENTO ES VALIDO O SE CONSERVA LA POSICION ACTUAL
	 */

	private Point nextPosition(Block block, int direction){
		Point nextPosition = new Point();
		double y = block.getPosition().getY();
		double x = block.getPosition().getX();
		
		if (direction == FORWARD){
			if (block.getOrientation() == VERTICAL ) {
				if (y+1+block.getLength() < size && isOccupied((int)x,(int)y+1)){
						nextPosition.setLocation(x, y+1);
				} else {
					nextPosition=position;
				}
			} else {
			    if (x+1+block.getLength() < size && isOccupied((int)x+1,(int)y)){
					nextPosition.setLocation(x+1, y);
				} else {
					nextPosition=position;
				}
			}
		} else {
			if (block.getOrientation() == VERTICAL ) {
				if (y-1 < size && isOccupied((int)x,(int)y-1)){
						nextPosition.setLocation(x, y-1);
				} else {
					nextPosition=position;
				}
			} else {
				if (x-1 < size && isOccupied((int)x-1,(int)y)){
					nextPosition.setLocation(x-1, y);
				} else {
					nextPosition=position;
				}
			}
		}
		return nextPosition;
	}
	
	/**
	 * METODO PARA ACTUALIZAR LA POSICION DEL BLOQUE
	 */ 
	 
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

	/**
	 * METODO PARA BORRAR LA POSICION ANTERIOR DEL BLOQUE (Tenemos que hacer una sola funcion para placeBlock y eraseBlock)
	 */

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
	
	/**
	 * METODO PARA AGREGAR UN NUEVO BLOQUE AL TABLERO
	 */

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
				throw new RuntimeException(); // TODO: Buscar una excepcion como la gente;
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
	}

}
