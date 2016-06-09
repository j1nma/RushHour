package view;

import controller.GameStateManager;
import controller.states.MainMenuState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Game sets the primary stage: loads the background image and creates a menu
 * manager.
 * 
 * @author Juan M. Alonso, Emiliano Vazquez
 *
 */

// GAME PODRIA NO ESTAR EN VIEW?
public class Game extends Application implements ViewConstants {
	private GameStateManager gsm;
	private ScreenManager screenManager;

	@Override
	public void start(Stage primaryStage) throws Exception {

		screenManager = new ScreenManager("res/images/rh_background.jpg");

		gsm = new GameStateManager();
		gsm.push(new MainMenuState(gsm));

		// CUANDO ESTE BIEN IMPLEMENTADO SERA
		// screenManager.getRootPane().getChildren().addAll(screenManager.getImageView());
		screenManager.getRootPane().getChildren().addAll(screenManager.getImageView(), gsm);

		Scene scene = new Scene(screenManager.getRootPane());

		// CUANDO ESTE BIEN IMPLEMENTADO SERA
		// screenManager.setVisible(true);
		gsm.setVisible(true);

		primaryStage.setTitle("RushHour");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
