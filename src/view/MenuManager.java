
import javafx.scene.Parent;
import javafx.scene.paint.Color;

/**
 * MenuManager has four variables of Menu. Different buttons of class
 * MenuButton are assigned according to its function: play a new game, load a game, instructions 
 * to play or exit the game.
 * @author Juan M. Alonso
 *
 */
public class MenuManager extends Parent {

	public MenuManager() {

		Menu mainMenu = new Menu();
		Menu playMenu = new Menu();
		Menu instructionsMenu = new Menu();
		Menu levelsMenu = new Menu();

		MenuButton btnPlay = new MenuButton("Play");
		MenuButton btnLoad = new MenuButton("Load");
		MenuButton btnInstructions = new MenuButton("Instructions");
		MenuButton btnExit = new MenuButton("Exit");
		MenuButton btnBackfromPlay = new MenuButton("Back");
		MenuButton btnBackfromInstructions = new MenuButton("Back");
		MenuButton btnBackfromLevels = new MenuButton("Back");
		MenuButton btnSinglePlayer = new MenuButton("Single Player");
		MenuButton btnDoublePlayer = new MenuButton("Double Player");
		MenuButton btnEasy = new MenuButton("Easy", Color.GREEN);
		MenuButton btnMedium = new MenuButton("Medium", Color.YELLOW);
		MenuButton btnHard = new MenuButton("Hard", Color.ORANGE);
		MenuButton btnExpert = new MenuButton("Expert", Color.RED);

		btnPlay.setOnMouseClicked(event -> {
			getChildren().remove(mainMenu.getMenu());
			getChildren().add(playMenu.getMenu());
		});

		//TODO: agrupar todos los BACK BUTTONS como uno???
		btnSinglePlayer.setOnMouseClicked(event -> {
			getChildren().remove(playMenu.getMenu());
			getChildren().add(levelsMenu.getMenu());
		});

		btnDoublePlayer.setOnMouseClicked(event -> {
			getChildren().remove(playMenu.getMenu());
			getChildren().add(levelsMenu.getMenu());
		});

		btnInstructions.setOnMouseClicked(event -> {
			getChildren().remove(mainMenu.getMenu());
			getChildren().add(instructionsMenu.getMenu());

		});

		btnExit.setOnMouseClicked(event -> {
			System.exit(0);
		});

		btnBackfromPlay.setOnMouseClicked(event -> {
			getChildren().remove(playMenu.getMenu());
			getChildren().add(mainMenu.getMenu());
		});

		btnBackfromInstructions.setOnMouseClicked(event -> {
			getChildren().remove(instructionsMenu.getMenu());
			getChildren().add(mainMenu.getMenu());
		});

		btnBackfromLevels.setOnMouseClicked(event -> {
			getChildren().remove(levelsMenu.getMenu());
			getChildren().add(playMenu.getMenu());
		});

		mainMenu.getMenu().getChildren().addAll(btnPlay, btnLoad, btnInstructions, btnExit);
		playMenu.getMenu().getChildren().addAll(btnBackfromPlay, btnSinglePlayer, btnDoublePlayer);
		instructionsMenu.getMenu().getChildren().addAll(btnBackfromInstructions);
		levelsMenu.getMenu().getChildren().addAll(btnBackfromLevels, btnEasy, btnMedium, btnHard, btnExpert);

		getChildren().addAll(mainMenu.getMenu());
	}
}
