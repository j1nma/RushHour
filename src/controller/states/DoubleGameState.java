package controller.states;

import java.util.Random;

import controller.ControllerConstants;
import controller.GameStateManager;
import controller.LevelDifficulty;
import controller.Loader;
import controller.handlers.DoubleGameHandler;
import javafx.scene.layout.Pane;
import model.Board;
import model.ModelConstants;
import view.panes.GamePane;

public class DoubleGameState extends GameState implements ModelConstants, ControllerConstants {
	private Board p1Board;
	private Board p2Board;
	private GamePane p2Pane;
	private GamePane p1Pane;

	public DoubleGameState(GameStateManager gsm, LevelDifficulty difficulty) {
		this(gsm,"games/" + difficulty.toString().toLowerCase() + "/" + difficulty.toString().toLowerCase()
				+ generator.nextInt(PRELOADED_GAMES_CANT) + ".ser");
	}

	public DoubleGameState(GameStateManager gsm, String filePath) {
		super(gsm,filePath);

		Loader boardLoader = new Loader();
		this.p1Board = boardLoader.loadBoard(filePath);
		this.p2Board = boardLoader.loadBoard(filePath);
		this.board = p1Board;

		this.p1Pane = new GamePane(p1Board);
		this.p2Pane = new GamePane(p2Board);
		this.pane = p1Pane;

		this.handler = new DoubleGameHandler(gsm, this);

	}

	public void switchPlayer(){
		if(board == p1Board){
			board = p2Board;
			pane = p2Pane;
		}else{
			board = p1Board;
			pane = p1Pane;
		}
	}
}
