package view;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;

public class EditorInput extends TextField implements ViewConstants {

	public EditorInput(String promptText) {
		this.setPromptText(promptText);
		this.setFocusTraversable(false);
		this.setFont(Font.font(FONT_SIZE_EDITOR));
		this.setPrefSize(INPUT_WIDTH, INPUT_HEIGHT);
		this.addEventFilter(KeyEvent.KEY_TYPED, numericValidation());
	}

	private EventHandler<KeyEvent> numericValidation() {
		return new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if (!e.getCharacter().matches("[0-9]")) {
					e.consume();
				}
			}
		};
	}
}
