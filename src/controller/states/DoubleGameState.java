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

public class DoubleGameState extends DoubleState implements ModelConstants, ControllerConstants {
	private Board board;
	private Board opponentBoard;
	private static final Random generator = new Random();

	public DoubleGameState(GameStateManager gsm, LevelDifficulty difficulty) {
		super(gsm);

		String filePath = "games/" + difficulty.toString().toLowerCase() + "/" + difficulty.toString().toLowerCase()
				+ generator.nextInt(PRELOADED_GAMES_CANT) + ".ser";

		Loader boardLoader = new Loader();
		this.board = boardLoader.loadBoard(filePath);
		this.opponentBoard = boardLoader.loadBoard(filePath);

		this.pane = new GamePane(board);
		this.opponentPane = new GamePane(this.opponentBoard);

		this.handler = new DoubleGameHandler(gsm, this, board, opponentBoard);
	}

	public DoubleGameState(GameStateManager gsm, Board board, Board opponentBoard, Pane pane, GamePane opponentPane) {
		super(gsm);

		this.board = board;
		this.opponentBoard = opponentBoard;

		this.pane = pane;
		this.opponentPane = opponentPane;

		this.handler = new DoubleGameHandler(gsm, this, this.board, this.opponentBoard);

	}
}
