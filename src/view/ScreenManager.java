package view;

import javafx.scene.Scene;
import view.panes.EditorPane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class ScreenManager implements ViewConstants {

	private Stage stage;
	private StackPane root;
	private Scene scene;

	public ScreenManager(Stage primaryStage, String name) {
		root = new StackPane();
		root.setMinSize(0, 0);
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
		
		InvalidationListener heightListener = new InvalidationListener(){
			public void invalidated(Observable ov) {
				stage.setHeight(pane.getHeight());
			}
		};
		InvalidationListener widthListener = new InvalidationListener(){
			public void invalidated(Observable ov) {
				stage.setWidth(pane.getWidth());
			}
		};
		
		if(pane instanceof EditorPane) {
			pane.heightProperty().addListener(heightListener);
			pane.widthProperty().addListener(widthListener);
		}
		else {
			stage.setHeight(pane.getHeight());
			stage.setWidth(pane.getWidth());
			pane.heightProperty().removeListener(heightListener);
			pane.widthProperty().removeListener(widthListener);
		}
			
	}
}
