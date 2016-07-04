package view;

import view.panes.EditorPane;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 * Manages the UI of the game by setting a pane to the root after each state. A
 * scene will be set with this root and in the same way a stage with the scene.
 *
 */
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
		stage.getIcons().add(new Image("res/images/GameIconsMedium.png"));
		stage.setScene(scene);
		stage.show();

		root.setVisible(true);
	}

	public void setPane(Pane pane) {
		root.getChildren().clear();
		root.getChildren().add(pane);

		/*
		 * InvalidationListeners are used to resize the window of the game
		 * accordingly
		 */
		InvalidationListener heightListener = new InvalidationListener() {
			public void invalidated(Observable ov) {
				stage.setHeight(pane.getHeight());
			}
		};
		InvalidationListener widthListener = new InvalidationListener() {
			public void invalidated(Observable ov) {
				stage.setWidth(pane.getWidth());
			}
		};

		if (pane instanceof EditorPane) {
			pane.heightProperty().addListener(heightListener);
			pane.widthProperty().addListener(widthListener);
		} else {
			stage.setHeight(pane.getHeight());
			stage.setWidth(pane.getWidth());
			pane.heightProperty().removeListener(heightListener);
			pane.widthProperty().removeListener(widthListener);
		}
		
		//Line repeated because getIcons uses the stage's size at every given moment
		stage.getIcons().add(new Image("res/images/GameIconsMedium.png"));
	}
}
