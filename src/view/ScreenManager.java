package view;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.Scene;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.panes.GameMenu;

public class ScreenManager implements ViewConstants {

    //Esto va a ir en assets.
	private ImageView menuImage;

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
