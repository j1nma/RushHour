package view.panes;

import view.MenuButton;

public class InstructionsMenuPane extends GameMenu {
	private MenuButton btnBack;

	public InstructionsMenuPane() {
		btnBack = new MenuButton("Back");
		
		this.getChildren().add(btnBack);
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
