package controller.states;

import controller.handlers.MainMenuHandler;
import javafx.stage.Stage;
import controller.GameStateManager;
import view.panes.MainMenuPane;

public class MainMenuState extends State {

	public MainMenuState(GameStateManager gsm, Stage primaryStage) {
		super(gsm);
		pane = new MainMenuPane();
		handler = new MainMenuHandler(gsm, this, primaryStage);
	}
}
