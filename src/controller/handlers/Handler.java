package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public abstract class Handler<T extends Pane> extends AnimationTimer {

	protected GameStateManager gsm;
	protected State state;
	protected T pane;

	Handler(GameStateManager gsm, State state) {
		this.gsm = gsm;
		this.state = state;
		pane = (T) state.getPane();
	}
}
