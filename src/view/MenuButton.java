
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MenuButton extends StackPane {
	private Text text;

	public MenuButton(String name, Paint color) {
		text = new Text(name);
		text.getFont();
		text.setFont(Font.font(20));
		text.setFill(color);

		Rectangle buttonBackground = new Rectangle(175, 30);
		buttonBackground.setOpacity(0.6);
		buttonBackground.setFill(Color.BLACK);
		buttonBackground.setEffect(new GaussianBlur(3.5));
		buttonBackground.setArcWidth(20);
		buttonBackground.setArcHeight(20);
		
		getChildren().addAll(buttonBackground, text);

		setOnMouseEntered(event -> {
			buttonBackground.setFill(Color.WHITE);
			text.setFill(Color.BLACK);
		});

		setOnMouseExited(event -> {
			buttonBackground.setFill(Color.BLACK);
			text.setFill(color);
		});
	}

	public MenuButton(String name) {
		this(name, Color.WHITE);
	}
}
