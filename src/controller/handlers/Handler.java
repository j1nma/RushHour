package controller.handlers;

import controller.ControllerConstants;
import controller.GameStateManager;
import controller.states.State;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

/**
 * Handler extends AnimationTimer thus creating a timer and overriding handle
 * method, which will span through all of the conditions inside it for every
 * timer iteration.
 */
public abstract class Handler<T extends Pane> extends AnimationTimer implements ControllerConstants {

	protected GameStateManager gsm;
	protected State state;
	protected T pane;

	@SuppressWarnings("unchecked")
	public Handler(GameStateManager gsm, State state) {
		this.gsm = gsm;
		this.state = state;
		this.pane = (T) state.getPane();
	}
}
