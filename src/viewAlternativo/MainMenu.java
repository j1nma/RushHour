public class MainMenu extends Menu {
	MenuButton btnPlay;
	MenuButton btnLoad;
	MenuButton btnInstructions;
	MenuButton btnExit;

  public MainMenu() {
	  btnPlay = new MenuButton("Play");
    btnLoad = new MenuButton("Load");
		btnInstructions = new MenuButton("Instructions");
		btnExit = new MenuButton("Exit");

		this.getChildren().addAll(btnPlay, btnLoad, btnInstructions, btnExit);
  }

  public MenuButton getPlayButton() {
    return btnPlay;
  }

  public MenuButton getLoadButton() {
    return btnLoad;
  }

  public MenuButton getInstructionsButton() {
    return btnInstructions;
  }

  public MenuButton getExitButton() {
    return btnExit;
  }
}
