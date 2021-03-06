import controller.GameStateManager;

import controller.states.MainMenuState;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ScreenManager;

/**
 * Game sets the primary stage: loads the background image, creates a game
 * state manager and a screen manager. MainMenuState is pushed as the first state.
 * 
 */
public class Game extends Application {
	private GameStateManager gsm;
	private ScreenManager screenManager;

	@Override
	public void start(Stage primaryStage) throws Exception {

		screenManager = new ScreenManager(primaryStage, "RushHour");
		gsm = new GameStateManager(screenManager);
		gsm.push(new MainMenuState(gsm, primaryStage));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
