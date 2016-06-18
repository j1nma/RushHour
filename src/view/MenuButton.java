package view;

import javafx.scene.control.Button;

import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Especially styled button for game menus.
 *
 */
public class MenuButton extends Button implements ViewConstants {

	public MenuButton(String text, Paint color) {
		super(text);
		this.setFont(Font.font(FONT_SIZE_MENU));
		this.setTextFill(color);
		this.setStyle(BUTTON_STYLE_DEFAULT);
		this.setOpacity(BUTTON_OPACITY);

		this.setOnMouseEntered(e -> {
			this.setStyle(BUTTON_STYLE_ENTERED);
			this.setTextFill(Color.BLACK);
		});

		this.setOnMouseExited(e -> {
			this.setStyle(BUTTON_STYLE_DEFAULT);
			this.setTextFill(color);
		});
	}

	public MenuButton(String text) {
		this(text, Color.WHITE);
	}
}
