package view.panes;

import javafx.scene.paint.Color;

import view.MenuButton;

public class DifficultyMenuPane extends GameMenuPane {
	private MenuButton btnBack;
	private MenuButton btnEasy;
	private MenuButton btnMedium;
	private MenuButton btnHard;
	private MenuButton btnExpert;

	public DifficultyMenuPane() {
		btnBack = new MenuButton("Back");
		btnEasy = new MenuButton("Beginner", Color.GREEN);
		btnMedium = new MenuButton("Intermediate", Color.YELLOW);
		btnHard = new MenuButton("Advanced", Color.ORANGE);
		btnExpert = new MenuButton("Expert", Color.RED);

		list.getChildren().addAll(btnEasy, btnMedium, btnHard, btnExpert, btnBack);
	}

	public boolean isBeginnerPressed() {
		return btnEasy.isPressed();
	}

	public boolean isIntermediatePressed() {
		return btnMedium.isPressed();
	}

	public boolean isAdvancedPressed() {
		return btnHard.isPressed();
	}

	public boolean isExpertPressed() {
		return btnExpert.isPressed();
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
