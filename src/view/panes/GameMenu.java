package view.panes;

import javafx.geometry.Pos;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import view.ViewConstants;

public abstract class GameMenu extends StackPane implements ViewConstants{
	protected VBox list;
	

	public GameMenu(Node... children) {
		list = new VBox(NODE_SEPARATION, children);
		list.setAlignment(Pos.CENTER);
		list.setPrefWidth(BACKGROUND_SIZE);
		list.setPrefHeight(BACKGROUND_SIZE);

		ImageView menuImage = new ImageView(new Image(BACKGROUND_PATH));
		menuImage.setEffect(new GaussianBlur(BACKGROUND_GAUSSIAN_BLUR));

		this.getChildren().addAll(menuImage, list);
	}
}
