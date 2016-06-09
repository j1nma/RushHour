package view;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class ScreenManager extends StackPane implements ViewConstants {
	private ImageView imageView;
	private Pane root;

	public ScreenManager(String imgPath) throws IOException {

		root = new Pane();
		root.setPrefSize(BACKGROUND_SIZE, BACKGROUND_SIZE);

		InputStream is = Files.newInputStream(Paths.get(imgPath));
		Image img = new Image(is);
		is.close();

		imageView = new ImageView(img);
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
}
