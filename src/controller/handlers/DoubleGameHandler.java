package controller.handlers;

import controller.GameStateManager;
import controller.states.DoubleGameState;
import javafx.application.Platform;
import javafx.scene.control.Alert.AlertType;
import view.panes.GamePane;

/**
 * Handles the double player mode.
 *
 */
public class DoubleGameHandler extends GameHandler {

	public DoubleGameHandler(GameStateManager gsm, DoubleGameState state) {
		super(gsm, state);
		this.grid = pane.getGrid();
	}

	@Override
	public void handle(long now) {
		if (pane.isSurrenderPressed()) {
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					createAlert(AlertType.INFORMATION, "YOU SURRENDER? BYE BYE", "NOOB");
				}
			});
			gsm.pop();
		}

		if (pane.isMousePressedOnGrid()) {
			processMouse();
		}

		if (!pane.isMousePressedOnGrid() && mouseWasPressed) {
			mouseWasPressed = false;
			if (hasMoved()) {
				try {
					//Pause for 1.5 seconds
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				checkWinCondition();
				switchPlayer();
			}
		}

		pane.refresh();

	}

	/**
	 * Switches between players. Makes the state to switch the player and updates the pane.
	 */
	public void switchPlayer() {
		DoubleGameState state = (DoubleGameState) this.state;
		state.switchPlayer();
		this.board = state.getBoard();
		this.pane = (GamePane) state.getPane();
		this.grid = pane.getGrid();
		gsm.updatePane();
	}
}