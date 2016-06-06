package view;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

//RETOQUES GRAFICOS
public class MenuButton extends Button {

	public MenuButton(String text, Paint color) {
		super(text);
		this.setFont(Font.font(20));
		this.setTextFill(color);
		this.setStyle("-fx-base: black;-fx-focus-color: transparent;");
		this.setOpacity(0.6);

		this.setOnMouseEntered(e -> {
			this.setStyle("-fx-base: white;-fx-focus-color: transparent;");
			this.setTextFill(Color.BLACK);
		});

		this.setOnMouseExited(e -> {
			this.setStyle("-fx-base: black;-fx-focus-color: transparent;");
			this.setTextFill(color);
		});
	}

	public MenuButton(String text) {
		this(text, Color.WHITE);
	}
}
