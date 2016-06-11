package model;

import java.awt.Point;

public class Block implements ModelConstants {
	private int orientation;
	private int length;
	private Point position;

	public Block(final Point position, int length, int orientation) {
		if (orientation != VERTICAL && orientation != HORIZONTAL) {
			throw new IllegalArgumentException();
		}
		if (length < 1) {
			throw new IllegalArgumentException();
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
