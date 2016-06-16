package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.panes.GamePane;

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
		double previousSize = stage.getHeight();
		System.out.println(previousSize);
//		if (pane instanceof GamePane) {
//			previousSize = stage.getHeight();
//			stage.setHeight(720);
//			// System.out.println(((GamePane) pane).getButton().getWidth());
//			//// }
//			//// stage.sizeToScene();
//		} else {
//			stage.setHeight(previousSize);
//		}
	}
}
