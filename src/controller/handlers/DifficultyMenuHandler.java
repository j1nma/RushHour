package controller.handlers;

import controller.GameStateManager;
import controller.states.GameState;
import controller.states.LevelDifficulty;
import controller.states.State;
import view.panes.DifficultyMenuPane;

public class DifficultyMenuHandler extends Handler<DifficultyMenuPane> {

	public DifficultyMenuHandler(GameStateManager gsm, State state) {
		super(gsm, state);
	}

	@Override
	public void handle(long now) {
		if (pane.isBeginnerPressed()) {
			gsm.push(new GameState(gsm,LevelDifficulty.BEGINNER));
		}
		
		if (pane.isIntermediatePressed()) {
			gsm.push(new GameState(gsm,LevelDifficulty.INTERMEDIATE));
		}
		
		if (pane.isAdvancedPressed()) {
			gsm.push(new GameState(gsm,LevelDifficulty.ADVANCED));
		}
		
		if (pane.isExpertPressed()) {
			gsm.push(new GameState(gsm,LevelDifficulty.EXPERT));
		}
		
		if (pane.isBackPressed()) {
			gsm.pop();
		}
	}
}
