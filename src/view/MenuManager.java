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

        /*
        * 07/06/16
        * Comentario de Edu:
        *
        * Deberian considerar mover todos los settings de aca abajo a MainMenu, PlayMenu, LevelsMenu, etc. Para reducir
        * el clutter en el codigo. Queda un poco chocante que esten todos estos settings aca a mi parecer.
        *
        * Es probable que esto tal vez pueda llegar a terminar siendo de controller, tambien, considerando que lidia con
        * listeners de eventos.
        * */

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
