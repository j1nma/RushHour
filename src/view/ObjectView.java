package view;

import model.Direction;
import model.Entity;

public abstract class ObjectView<T extends Entity> implements ViewConstants, Direction {
	protected T object;

	public ObjectView(T object) {
		this.object = object;
	}

}
