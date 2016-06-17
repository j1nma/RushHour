package view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ScreenManager implements ViewConstants {

	private Stage stage;
	private StackPane root;
	private Scene scene;

	public ScreenManager(Stage primaryStage, String name) {
		root = new StackPane();
		scene = new Scene(root);
		stage = primaryStage;
		stage.setTitle(name);
		stage.setResizable(true);
		stage.getIcons().add(new Image("res/images/GameIcon.png"));
		stage.setScene(scene);

		root.setVisible(true);
	}

	public void setPane(Pane pane) {
		root.getChildren().clear();
		root.getChildren().add(pane);
		stage.setHeight(pane.getHeight());
		stage.setWidth(pane.getWidth());
	}
}
