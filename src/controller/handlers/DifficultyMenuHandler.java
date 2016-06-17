package controller.handlers;

import controller.GameStateManager;
import controller.LevelDifficulty;
import controller.states.DoubleGameState;
import controller.states.GameState;
import controller.states.State;
import view.panes.DifficultyMenuPane;

public class DifficultyMenuHandler extends Handler<DifficultyMenuPane> {
	private int mode;

	public DifficultyMenuHandler(GameStateManager gsm, State state, int mode) {
		super(gsm, state);
		this.mode = mode;
	}

	@Override
	public void handle(long now) {
		if (pane.isBeginnerPressed()) {
			if (mode == SINGLE_PLAYER) {
				gsm.push(new GameState(gsm, LevelDifficulty.BEGINNER));
			} else {
				gsm.push(new DoubleGameState(gsm, LevelDifficulty.BEGINNER));
			}
		}

		if (pane.isIntermediatePressed()) {
			if (mode == SINGLE_PLAYER) {
				gsm.push(new GameState(gsm, LevelDifficulty.INTERMEDIATE));
			} else {
				gsm.push(new DoubleGameState(gsm, LevelDifficulty.INTERMEDIATE));
			}
		}

		if (pane.isAdvancedPressed()) {
			if (mode == SINGLE_PLAYER) {
				gsm.push(new GameState(gsm, LevelDifficulty.ADVANCED));
			} else {
				gsm.push(new DoubleGameState(gsm, LevelDifficulty.ADVANCED));
			}
		}

		if (pane.isExpertPressed()) {
			if (mode == SINGLE_PLAYER) {
				gsm.push(new GameState(gsm, LevelDifficulty.EXPERT));
			} else {
				gsm.push(new DoubleGameState(gsm, LevelDifficulty.EXPERT));
			}
		}

		if (pane.isBackPressed()) {
			gsm.pop();
		}
	}
}
