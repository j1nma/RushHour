package view;

import javafx.scene.layout.StackPane;

/**
 * MenuManager has four variables of Menu. Different buttons of class MenuButton
 * are assigned according to their function: play a new game, load a game,
 * instructions to play or exit the game.
 * 
 * @authors Juan M. Alonso, Emiliano Vazquez
 *
 */
public class MenuManager extends StackPane {

	public MenuManager() {
		MainMenu mainMenu = new MainMenu();
		PlayMenu playMenu = new PlayMenu();
		InstructionsMenu instructionsMenu = new InstructionsMenu();
		LevelsMenu levelsMenu = new LevelsMenu();

		mainMenu.getPlayButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(playMenu);
		});

		playMenu.getSinglePlayerButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(levelsMenu);
		});

		playMenu.getDoublePlayerButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(levelsMenu);
		});

		mainMenu.getInstructionsButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(instructionsMenu);
		});

		mainMenu.getExitButton().setOnMouseClicked(event -> {
			System.exit(0);
		});

		playMenu.getBackButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(mainMenu);
		});

		instructionsMenu.getBackButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(mainMenu);
		});

		levelsMenu.getBackButton().setOnMouseClicked(event -> {
			this.getChildren().clear();
			this.getChildren().add(playMenu);
		});

		this.getChildren().addAll(mainMenu);
	}
}
