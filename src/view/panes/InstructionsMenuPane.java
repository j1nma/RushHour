package view.panes;

import view.MenuButton;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Font;

public class InstructionsMenuPane extends GameMenu {
	private MenuButton btnBack;
	private Canvas canvas;
	private GraphicsContext gc;

	public InstructionsMenuPane() {
		btnBack = new MenuButton("Back");
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		gc.setFont(new Font(FONT_SIZE_INSTRUCTIONS));
		gc.fillText(INSTRUCTIONS, 0, 0);

		list.getChildren().addAll(btnBack, canvas);
	}

	public boolean isBackPressed() {
		return btnBack.isPressed();
	}
}
