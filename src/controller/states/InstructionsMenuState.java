package controller.states;

import controller.GameStateManager;

import controller.handlers.InstructionsMenuHandler;
import view.panes.InstructionsMenuPane;

public class InstructionsMenuState extends State {

	public InstructionsMenuState(GameStateManager gsm) {
		super(gsm);
		pane = new InstructionsMenuPane();
		handler = new InstructionsMenuHandler(gsm, this);
	}
}
