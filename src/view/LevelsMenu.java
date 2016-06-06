package view;

import javafx.scene.paint.Color;

public class LevelsMenu extends Menu {
	MenuButton btnBack;
	MenuButton btnEasy;
	MenuButton btnMedium;
	MenuButton btnHard;
	MenuButton btnExpert;

	public LevelsMenu() {
		btnBack = new MenuButton("Back");
		btnEasy = new MenuButton("Easy", Color.GREEN);
		btnMedium = new MenuButton("Medium", Color.YELLOW);
		btnHard = new MenuButton("Hard", Color.ORANGE);
		btnExpert = new MenuButton("Expert", Color.RED);

		this.getChildren().addAll(btnEasy, btnMedium, btnHard, btnExpert, btnBack);
	}

	public MenuButton getEasyButton() {
		return btnEasy;
	}

	public MenuButton getMediumButton() {
		return btnMedium;
	}

	public MenuButton getHardButton() {
		return btnHard;
	}

	public MenuButton getExpertButton() {
		return btnExpert;
	}

	public MenuButton getBackButton() {
		return btnBack;
	}
}
