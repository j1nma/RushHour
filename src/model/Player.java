package model;

import java.awt.Point;

/**
 * Player represents the red car. It is unique in the game. Its orientation is
 * always horizontal and its position is always on the exit's row.
 *
 */
public class Player extends Block {

	private static final long serialVersionUID = 3L;

	public Player(Point position, int length) {
		super(position, length, HORIZONTAL);
	}

}
