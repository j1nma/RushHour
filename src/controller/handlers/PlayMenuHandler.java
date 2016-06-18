package controller.handlers;

import controller.GameStateManager;
import controller.ControllerConstants;
import controller.states.DifficultyMenuState;
import controller.states.State;
import view.panes.PlayMenuPane;

/**
 * Handles PlayMenuPane from PlayMenuState.
 */
public class PlayMenuHandler extends Handler<PlayMenuPane> implements ControllerConstants {

	public PlayMenuHandler(GameStateManager gsm, State state) {
		super(gsm, state);
	}

	@Override
	public void handle(long now) {
		if (pane.isBackPressed()) {
			gsm.pop();
		}

		if (pane.isSinglePlayerPressed()) {
			gsm.push(new DifficultyMenuState(gsm, SINGLE_PLAYER));
		}

		if (pane.isDoublePlayerPressed()) {
			gsm.push(new DifficultyMenuState(gsm, DOUBLE_PLAYER));
		}
	}
}
