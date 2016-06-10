package view;

import model.Direction;

public abstract class ObjectView<T> implements ViewConstants, Direction {
	protected T object;

	public ObjectView(T object) {
		this.object = object;
	}

}
