package view.panes;

import view.MenuButton;

import java.io.IOException;

public class PlayMenuPane extends GameMenu {
	private MenuButton btnBack;
	private MenuButton btnSinglePlayer;
	private MenuButton btnTwoPlayers;

	public PlayMenuPane() {
		btnSinglePlayer = new MenuButton("Single Player");
		btnTwoPlayers = new MenuButton("Two Players");
		btnBack = new MenuButton("Back");
		
		this.getChildren().addAll(btnSinglePlayer, btnTwoPlayers, btnBack);
	}

	public boolean isSinglePlayerPressed() {
		return btnSinglePlayer.isPressed();
	}

	public boolean isTwoPlayersPressed() {
		return btnTwoPlayers.isPressed();
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
