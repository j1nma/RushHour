package view;

public class InstructionsMenu extends Menu {
	MenuButton btnBack;

	public InstructionsMenu() {
		btnBack = new MenuButton("Back");
		
		this.getChildren().add(btnBack);
	}

	public MenuButton getBackButton() {
		return btnBack;
	}
}
