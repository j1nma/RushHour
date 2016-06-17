package view.panes;

import view.MenuButton;

public class PlayMenuPane extends GameMenu {
	private MenuButton btnBack;
	private MenuButton btnSinglePlayer;
	private MenuButton btnDoublePlayer;

	public PlayMenuPane() {
		btnSinglePlayer = new MenuButton("Single Player");
		btnDoublePlayer = new MenuButton("Double Player");
		btnBack = new MenuButton("Back");
		
		list.getChildren().addAll(btnSinglePlayer, btnDoublePlayer, btnBack);
	}

	public boolean isSinglePlayerPressed() {
		return btnSinglePlayer.isPressed();
	}

	public boolean isDoublePlayerPressed() {
		return btnDoublePlayer.isPressed();
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
