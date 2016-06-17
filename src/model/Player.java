package model;

import java.awt.Point;

public class Player extends Block {

	private static final long serialVersionUID = 3L;

	public Player(Point position, int length) {
		super(position, length, HORIZONTAL);
	}

}
