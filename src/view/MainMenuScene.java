package view;

public class MainMenuScene extends GameScene {
	private MenuButton btnPlay;
    private MenuButton btnLoad;
    private MenuButton btnInstructions;
    private MenuButton btnExit;

    public MainMenuScene() {
		btnPlay = new MenuButton("Play");
		btnLoad = new MenuButton("Load");
		btnInstructions = new MenuButton("Instructions");
		btnExit = new MenuButton("Exit");

		this.getChildren().addAll(btnPlay, btnLoad, btnInstructions, btnExit);
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

	public boolean isExitPressed() {
		return btnExit.isPressed();
	}
}
