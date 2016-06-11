package view;

import model.ModelConstants;

public abstract class ObjectView<T> implements ViewConstants, ModelConstants {
	protected T object;

	public ObjectView(T object) {
		this.object = object;
	}

}
