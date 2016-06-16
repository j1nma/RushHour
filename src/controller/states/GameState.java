package controller.states;

import java.util.Random;


import controller.GameStateManager;
import controller.Loader;
import controller.handlers.GameHandler;
import model.Board;
import model.ModelConstants;
import view.panes.GamePane;

public class GameState extends State implements ModelConstants {
	private Board board;
	private Loader boardLoader;
	private String filePath;
	private static final Random generator = new Random();

	public GameState(GameStateManager gsm) {
		super(gsm);
		
		boardLoader = new Loader();
		
		board = boardLoader.loadBoard("games/chico.ser");

		pane = new GamePane(board);

		handler = new GameHandler(gsm, this, board);

	}
	
	public GameState(GameStateManager gsm, LevelDifficulty difficulty) {
		super(gsm);
		filePath = "games/";
		filePath += difficulty.toString().toLowerCase() + "/" + difficulty.toString().toLowerCase() + generator.nextInt(3) + ".ser";
		
		boardLoader = new Loader();
		
		board = boardLoader.loadBoard(filePath);

		pane = new GamePane(board);

		handler = new GameHandler(gsm, this, board);

	}
}
