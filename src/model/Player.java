package model;

import java.awt.Point;

public class Player extends Block,Direction {

	public Player(Point position, int length) {
		super(position, length, HORIZONTAL);
	}

}
