package view;

import javafx.scene.Scene;
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
        stage.setResizable(false);
		stage.setScene(scene);

		root.setVisible(true);
	}

	public void setPane(Pane pane) {
		root.getChildren().clear();
		root.getChildren().add(pane);
	}
}
