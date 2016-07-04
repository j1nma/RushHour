package view.panes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import view.MenuButton;

public class MainMenuPane extends GameMenuPane {
	ImageView logo;
	private MenuButton btnPlay;
	private MenuButton btnLoad;
	private MenuButton btnCreate;
	private MenuButton btnInstructions;
	private MenuButton btnExit;

	public MainMenuPane() {
		logo = new ImageView(new Image(LOGO_PATH));

		logo.setFitWidth(LOGO_WIDTH);
		btnPlay = new MenuButton("Play");
		btnLoad = new MenuButton("Load");
		btnCreate = new MenuButton("Create");
		btnInstructions = new MenuButton("Instructions");
		btnExit = new MenuButton("Exit");

		list.getChildren().addAll(logo, btnPlay, btnLoad, btnCreate, btnInstructions, btnExit);
	}

	public boolean isPlayPressed() {
		return btnPlay.isPressed();
	}

	public boolean isLoadPressed() {
		return btnLoad.isPressed();
	}

	public boolean isInstructionsPressed() {
		return btnInstructions.isPressed();
	}

	public boolean isCreatePressed() {
		return btnCreate.isPressed();
	}

	public boolean isExitPressed() {
		return btnExit.isPressed();
	}
}
