package controller.states;

import controller.GameStateManager;

import controller.handlers.EditorHandler;
import view.panes.EditorPane;

public class EditorState extends State {

	public EditorState(GameStateManager gsm) {
		super(gsm);
		pane = new EditorPane();
		handler = new EditorHandler(gsm, this);
	}
}
