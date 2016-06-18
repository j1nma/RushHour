package model;

import java.awt.Point;
import java.io.Serializable;

/**
 * Block represents a physical vehicle of the board. It has an orientation
 * (horizontal or vertical), a length (positive) and a position. Starting from
 * this position, the block will also occupy in the board as many positions as
 * length-1 with its orientation. For example, if a block has position (0,0),
 * length 3 and orientation horizontal the board will put in its map positions
 * (0,0), (1,0) and (2,0) pointing to the block.
 * 
 */
public class Block implements ModelConstants, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private int orientation;
	private int length;
	private Point position;

	public Block(final Point position, int length, int orientation) {
		if (orientation != VERTICAL && orientation != HORIZONTAL) {
			throw new IllegalArgumentException("Illegal orientation");
		}
		if (length < 1) {
			throw new IllegalArgumentException("Length must be positive.");
		}
		if (position == null) {
			throw new IllegalArgumentException("Position is null");
		}
		this.orientation = orientation;
		this.length = length;
		this.position = new Point();
		setPosition(position);
	}

	public void setPosition(final Point position) {
		this.position.setLocation(position);
	}

	public Point getPosition() {
		return position;
	}

	public int getOrientation() {
		return orientation;
	}

	public int getLength() {
		return length;
	}
}

