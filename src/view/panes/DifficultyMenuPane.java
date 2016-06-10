package view.panes;

import javafx.scene.paint.Color;

import view.MenuButton;

public class DifficultyMenuPane extends GameMenu {
	private MenuButton btnBack;
	private MenuButton btnEasy;
	private MenuButton btnMedium;
	private MenuButton btnHard;
	private MenuButton btnExpert;

	public DifficultyMenuPane(){
		btnBack = new MenuButton("Back");
		btnEasy = new MenuButton("Easy", Color.GREEN);
		btnMedium = new MenuButton("Medium", Color.YELLOW);
		btnHard = new MenuButton("Hard", Color.ORANGE);
		btnExpert = new MenuButton("Expert", Color.RED);

		list.getChildren().addAll(btnEasy, btnMedium, btnHard, btnExpert, btnBack);
	}

	public boolean isEasyPressed() {
		return btnEasy.isPressed();
	}

	public boolean isMediumPressed() {
		return btnMedium.isPressed();
	}

	public boolean isHardPressed() {
		return btnHard.isPressed();
	}

	public boolean isExpertPressed() {
		return btnExpert.isPressed();
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
