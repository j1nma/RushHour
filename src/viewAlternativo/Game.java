import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Game sets the primary stage: loads the background image and creates
 * a menu manager.
 * @author JuanmaAlonso
 *
 */
public class Game extends Application {
	private MenuManager gameMenu;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();
		root.setPrefSize(280, 280);

		ImageView imgView = new ImageView("res/images/rh_background.jpg");
		imgView.setEffect(new GaussianBlur(5));

		gameMenu = new MenuManager();

		root.getChildren().addAll(imgView, gameMenu);

		Scene scene = new Scene(root);

		gameMenu.setVisible(true);

		primaryStage.setTitle("RushHour");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
