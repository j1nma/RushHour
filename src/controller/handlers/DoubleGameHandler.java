package controller.handlers;

import controller.GameStateManager;
import controller.states.DoubleGameState;
import model.ModelConstants;
import view.panes.GamePane;

public class DoubleGameHandler extends GameHandler implements ModelConstants {
	public DoubleGameHandler(GameStateManager gsm, DoubleGameState state) {
		super(gsm, state);
		this.grid = pane.getGrid();
	}

	@Override
	public void handle(long now) {
		if (pane.isSurrenderPressed()) {
			gsm.pop();
		}

		if (pane.isMousePressedOnGrid()) {
			processMouse();
		}
		if (!pane.isMousePressedOnGrid() && mouseWasPressed) {
			mouseWasPressed = false;
			if(hasMoved()){
				checkWinCondition();
				switchPlayer();
			}
		}

		pane.refresh();

	}

	public void switchPlayer(){
		DoubleGameState state = (DoubleGameState) this.state;
		state.switchPlayer();
		this.board = state.getBoard();
		this.pane = (GamePane)state.getPane();
		this.grid = pane.getGrid();
		gsm.updatePane();
	}
}