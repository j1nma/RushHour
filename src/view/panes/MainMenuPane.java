package view.panes;

import view.MenuButton;

public class MainMenuPane extends GameMenu {
	private MenuButton btnPlay;
    private MenuButton btnLoad;
    private MenuButton btnCreate;
    private MenuButton btnInstructions;
    private MenuButton btnExit;

    public MainMenuPane() {
		btnPlay = new MenuButton("Play");
		btnLoad = new MenuButton("Load");
		btnCreate = new MenuButton("Create");
		btnInstructions = new MenuButton("Instructions");
		btnExit = new MenuButton("Exit");

		list.getChildren().addAll(btnPlay, btnLoad, btnCreate, btnInstructions, btnExit);
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
