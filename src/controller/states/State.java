package controller.states;

import controller.handlers.Handler;
import controller.GameStateManager;
import javafx.scene.layout.Pane;

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
