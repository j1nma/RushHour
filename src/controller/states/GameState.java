package controller.states;

import java.util.Random;

import controller.ControllerConstants;
import controller.LevelDifficulty;
import controller.GameStateManager;
import controller.Loader;
import controller.handlers.GameHandler;
import model.Board;
import model.ModelConstants;
import view.panes.GamePane;

public class GameState extends State implements ModelConstants, ControllerConstants {
	protected Board board;
	protected static final Random generator = new Random();

	/**
	 * Constructor for loading an existing game.
	 */
	public GameState(GameStateManager gsm, String filePath) {
		super(gsm);

		board = new Loader().loadBoard(filePath);
		pane = new GamePane(board);
		handler = new GameHandler(gsm, this);
	}

	/**
	 * Constructor for loading an existing game in the games folder of the
	 * project. A random game will be chosen according to the difficulty level set by DifficultyMenuHandler.
	 */
	public GameState(GameStateManager gsm, LevelDifficulty difficulty) {

		this(gsm, "games/" + difficulty.toString().toLowerCase() + "/" + difficulty.toString().toLowerCase()
				+ generator.nextInt(PRELOADED_GAMES_CANT) + ".ser");
	}

	public Board getBoard(){
		return board;
	}
}
