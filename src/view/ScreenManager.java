package view;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ScreenManager extends StackPane implements ViewConstants {
	private ImageView imageView;
	private Pane root;

	public ScreenManager(String imagePath) {

		root = new Pane();
		root.setPrefSize(BACKGROUND_SIZE, BACKGROUND_SIZE);

		imageView = new ImageView(new Image(imagePath));
		imageView.setEffect(new GaussianBlur(GAUSSIAN_BLUR));

	}

	public ImageView getImageView() {
		return this.imageView;
	}

	public Pane getRootPane() {
		return this.root;
	}

	public void setScene(GameScene scene) {
		this.getChildren().clear();
		this.getChildren().addAll(imageView, scene);
	}
	
	public void setScene1(GameScene scene) {
		this.getChildren().clear();
		this.getChildren().addAll(scene);
	}
}
