public class PlayMenu extends Menu {
	MenuButton btnBack;
	MenuButton btnSinglePlayer;
	MenuButton btnDoublePlayer;

  public PlayMenu() {
		btnSinglePlayer = new MenuButton("Single Player");
		btnDoublePlayer = new MenuButton("Double Player");
    btnBack = new MenuButton("Back");

    this.getChildren().addAll(btnSinglePlayer, btnDoublePlayer, btnBack);
  }

  public MenuButton getSinglePlayerButton() {
    return btnSinglePlayer;
  }

  public MenuButton getDoublePlayerButton() {
    return btnDoublePlayer;
  }

  public MenuButton getBackButton() {
    return back;
  }
}
