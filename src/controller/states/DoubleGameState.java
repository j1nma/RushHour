package controller.states;

import controller.ControllerConstants;
import controller.GameStateManager;
import controller.Loader;
import controller.handlers.DoubleGameHandler;
import model.Board;
import model.ModelConstants;
import view.panes.GamePane;

/**
 * DoubleGameState is the state for the double player mode.
 *
 */
public class DoubleGameState extends GameState implements ModelConstants, ControllerConstants {
	private Board p1Board;
	private Board p2Board;
	private GamePane p2Pane;
	private GamePane p1Pane;

	public DoubleGameState(GameStateManager gsm, LevelDifficulty difficulty) {
		this(gsm, "games/" + difficulty.toString().toLowerCase() + "/" + difficulty.toString().toLowerCase()
				+ generator.nextInt(PRELOADED_GAMES_AMOUNT) + ".ser");
	}

	/**
	 * This constructor sets the state's board and pane first to player 1
	 * and then calls DoubleGameHandler with them.
	 * 
	 * @param gsm
	 *            the game state manager of the game
	 * @param filePath
	 *            the file path of the game to be loaded
	 */
	public DoubleGameState(GameStateManager gsm, String filePath) {
		super(gsm, filePath);

		Loader boardLoader = new Loader();
		this.p1Board = boardLoader.loadBoard(filePath);
		this.p2Board = boardLoader.loadBoard(filePath);
		this.board = p1Board;

		this.p1Pane = new GamePane(p1Board, "Player 1");
		this.p2Pane = new GamePane(p2Board, "Player 2");
		this.pane = p1Pane;

		this.handler = new DoubleGameHandler(gsm, this);

	}

	/**
	 * Changes the state's board and pane to the other player.
	 */
	public void switchPlayer() {
		if (board == p1Board) {
			board = p2Board;
			pane = p2Pane;
		} else {
			board = p1Board;
			pane = p1Pane;
		}
	}
}
