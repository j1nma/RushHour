package controller.handlers;

import controller.GameStateManager;

import controller.states.State;
import view.panes.InstructionsMenuPane;

/**
 * Handles InstructionsMenuPane from InstructionsMenuState.
 */
public class InstructionsMenuHandler extends Handler<InstructionsMenuPane> {

	public InstructionsMenuHandler(GameStateManager gsm, State state) {
		super(gsm, state);
	}

	@Override
	public void handle(long now) {
		if (pane.isBackPressed()) {
			gsm.pop();
		}
	}
}
