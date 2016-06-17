package controller.handlers;

import controller.ControllerConstants;
import controller.GameStateManager;
import controller.states.State;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public abstract class Handler<T extends Pane> extends AnimationTimer implements ControllerConstants {

	protected GameStateManager gsm;
	protected State state;
	protected T pane;

	public Handler(GameStateManager gsm, State state) {
		this.gsm = gsm;
		this.state = state;
		this.pane = (T) state.getPane();
	}
}
