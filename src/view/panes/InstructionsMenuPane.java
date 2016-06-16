package view.panes;

import view.MenuButton;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Font;

public class InstructionsMenuPane extends GameMenu {
	private MenuButton btnBack;
	Canvas canvas;
	GraphicsContext gc;

	public InstructionsMenuPane() {
		btnBack = new MenuButton("Back");
		canvas = new Canvas(500, 400);
		gc = canvas.getGraphicsContext2D();
		gc.setFont(new Font(24));
		gc.fillText(INSTRUCTIONS, 0, 0);
		
		list.getChildren().addAll(btnBack,canvas);
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
