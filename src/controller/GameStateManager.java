package controller;

import controller.states.State;
import javafx.scene.layout.StackPane;

import java.util.Stack;

public class GameStateManager extends StackPane {

	private Stack<State> states;

	public GameStateManager() {
		states = new Stack<State>();
	}

	public void push(State state) {
		if (!states.isEmpty()) {
			states.peek().leaving();
		}
		states.push(state);
		this.getChildren().clear();
		this.getChildren().add(state.getScene());
		state.entered();
	}

	public State pop() {
		State state = states.pop();
		state.leaving();
		this.getChildren().clear();
		this.getChildren().add(states.peek().getScene());
		if (!states.isEmpty()) {
			states.peek().entered();
		}
		return state;
	}

	public void set(State state) {
		states.pop();
		states.push(state);
	}
}
