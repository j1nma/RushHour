package controller.states;

import controller.GameStateManager;
import controller.handlers.DifficultyMenuHandler;
import view.panes.DifficultyMenuPane;

public class DifficultyMenuState extends State {

	public DifficultyMenuState(GameStateManager gsm, int mode) {
		super(gsm);
		pane = new DifficultyMenuPane();
		handler = new DifficultyMenuHandler(gsm, this, mode);
	}
}
