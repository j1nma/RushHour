import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.effect.GaussianBlur;

public class MenuButton extends Button {
  public MenuButton(String text, Paint color) {
    super(text);
    this.setFont(Font.font(20));
    this.setTextFill(color);
    this.setStyle("-fx-base: black;");
    this.setOpacity(0.6);
    this.setEffect(new GaussianBlur(3.5));

    this.setOnMouseEntered(e -> {
      this.setStyle("-fx-base: white;");
      this.setTextFill(Color.BLACK);
    });

    this.setOnMouseEntered(e -> {
      this.setStyle("-fx-base: black;");
      this.setTextFill(Color.WHITE);
    });
  }

  public MenuButton(String text) {
    this(text, Color.WHITE);
  }
}
