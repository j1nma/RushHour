package controller.handlers;

import controller.GameStateManager;


import controller.states.State;
import javafx.application.Platform;
import view.panes.EditorPane;

public class EditorHandler extends Handler<EditorPane> {
	private boolean submitWasPressed = false;
	private boolean addBlockWasPressed = false;
	private boolean saveWasPressed = false;

	public EditorHandler(GameStateManager gsm, State state) {
		super(gsm, state);
	}

	@Override
	public void handle(long now) {
		
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
		
		

		if (pane.isBackPressed()) {
			gsm.pop();
		}

	}
}
