package controller.states;

import controller.handlers.PlayMenuHandler;

import controller.GameStateManager;
import view.panes.PlayMenuPane;

public class PlayMenuState extends State {

	public PlayMenuState(GameStateManager gsm) {
		super(gsm);
		pane = new PlayMenuPane();
		handler = new PlayMenuHandler(gsm, this);
	}
}
