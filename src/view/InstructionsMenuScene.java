package view;

public class InstructionsMenuScene extends GameScene {
	private MenuButton btnBack;

	public InstructionsMenuScene() {
		btnBack = new MenuButton("Back");
		
		this.getChildren().add(btnBack);
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
