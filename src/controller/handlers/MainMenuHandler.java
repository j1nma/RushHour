package controller.handlers;

import java.io.File;

import controller.GameStateManager;

import controller.states.EditorState;
import controller.states.GameState;
import controller.states.InstructionsMenuState;
import controller.states.PlayMenuState;
import controller.states.State;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.panes.MainMenuPane;

public class MainMenuHandler extends Handler<MainMenuPane> {
	private Stage primaryStage;

	public MainMenuHandler(GameStateManager gsm, State state, Stage primaryStage) {
		super(gsm, state);
		this.primaryStage = primaryStage;
	}

	@Override
	public void handle(long now) {
		if (pane.isPlayPressed()) {
			gsm.push(new PlayMenuState(gsm));
		}

		if (pane.isLoadPressed()) {
			String filePath = chooseFile();
			if (filePath != null) {
				gsm.push(new GameState(gsm, filePath));
			}
		}

		if (pane.isCreatePressed()) {
			gsm.push(new EditorState(gsm));
		}

		if (pane.isInstructionsPressed()) {
			gsm.push(new InstructionsMenuState(gsm));
		}
		if (pane.isExitPressed()) {
			System.exit(0);
		}

	}

	/**
	 * Prompts a window for the user to select the game file on the application
	 * directory.
	 * 
	 * @return the file path of the game if there is any, if not null
	 */
	private String chooseFile() {
		FileChooser filechooser = new FileChooser();
		filechooser.setTitle("RushHour");
		filechooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		File filePath = filechooser.showOpenDialog(primaryStage);
		if (filePath == null) {
			return null;
		} else {
			return filePath.getPath();
		}
	}
}
