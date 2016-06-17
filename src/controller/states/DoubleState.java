package controller.states;

import controller.GameStateManager;
import view.panes.GamePane;

public class DoubleState extends State {

	protected GamePane opponentPane;

	public DoubleState(GameStateManager gsm) {
		super(gsm);
	}

	public GamePane getOpponentPane() {
		return opponentPane;
	}

}
