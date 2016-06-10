package view;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import view.ViewConstants;

public class MenuButton extends Button implements ViewConstants {

	public MenuButton(String text, Paint color) {
		super(text);
		this.setFont(Font.font(FONT_SIZE));
		this.setTextFill(color);
		this.setStyle(BUTTON_STYLE_0);
		this.setOpacity(BUTTON_OPACITY);

		this.setOnMouseEntered(e -> {
			this.setStyle(BUTTON_STYLE_1);
			this.setTextFill(Color.BLACK);
		});

		this.setOnMouseExited(e -> {
			this.setStyle(BUTTON_STYLE_0);
			this.setTextFill(color);
		});
	}

	public MenuButton(String text) {
		this(text, Color.WHITE);
	}
}
