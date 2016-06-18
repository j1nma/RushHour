package controller.states;

import controller.handlers.Handler;
import controller.GameStateManager;
import javafx.scene.layout.Pane;

/**
 * State represents the conditions in which the game is at the moment of its
 * handling. These conditions are dealt with the handler and the pane is the
 * state's graphical representation.
 *
 */
public abstract class State {
	protected GameStateManager gsm;
	protected Handler handler;
	protected Pane pane;

	public State(GameStateManager gsm) {
		this.gsm = gsm;
	}

	public void entered() {
		handler.start();
	}

	public void leaving() {
		handler.stop();
	}

	public Pane getPane() {
		return pane;
	}

}
