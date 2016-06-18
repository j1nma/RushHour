package controller.handlers;

import controller.GameStateManager;

import controller.states.State;
import javafx.application.Platform;
import view.panes.EditorPane;

/**
 * Handles EditorPane from EditorState. EditorHandler has three boolean
 * variables because of the amount of times the handle method is executed every
 * second. One short hold on any of the buttons they refer to would execute the
 * method below them many times if they didn't exist.
 *
 */
public class EditorHandler extends Handler<EditorPane> {
	private boolean submitWasPressed = false;
	private boolean addBlockWasPressed = false;
	private boolean saveWasPressed = false;

	public EditorHandler(GameStateManager gsm, State state) {
		super(gsm, state);
	}

	@Override
	public void handle(long now) {

		if (pane.isBackPressed()) {
			gsm.pop();
		}

		if (pane.isSubmitPressed()) {
			if (!submitWasPressed) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						pane.buildBoard();
					}
				});
				submitWasPressed = true;
			}
		} else if (submitWasPressed) {
			submitWasPressed = false;
		}

		if (pane.isAddBlockPressed()) {
			if (!addBlockWasPressed) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						pane.buildBlocks();
					}
				});
				addBlockWasPressed = true;
			}
		} else if (addBlockWasPressed) {
			addBlockWasPressed = false;
		}

		if (pane.isSavePressed()) {
			if (!saveWasPressed) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						pane.save();
					}
				});
				saveWasPressed = true;
			}
		} else if (saveWasPressed) {
			saveWasPressed = false;
		}

	}
}
