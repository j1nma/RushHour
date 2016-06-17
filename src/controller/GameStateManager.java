package controller;

import controller.states.State;

import javafx.scene.layout.StackPane;
import view.ScreenManager;

import java.util.Stack;

public class GameStateManager extends StackPane {

	private Stack<State> states;
	private ScreenManager screenManager;

	public GameStateManager(ScreenManager screenManager) {
		states = new Stack<State>();
		this.screenManager = screenManager;
	}

	public void push(State state) {
		if (!states.isEmpty()) {
			states.peek().leaving();
		}
		states.push(state);
		state.entered();
		screenManager.setPane(state.getPane());
	}

	public State pop() {
		State state = states.pop();
		state.leaving();
		if (!states.isEmpty()) {
			states.peek().entered();
			screenManager.setPane(states.peek().getPane());
		}
		return state;
	}

	public void set(State state) {
		states.pop();
		states.push(state);
	}
}
