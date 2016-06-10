package view.panes;

import javafx.geometry.Pos;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import view.ViewConstants;

/**
	Cambiarlo para que sea abstracta y que todas las escenas del juego dependan de una sola clase.
	Esto es bastante primitivo(En el futuro no todo va a ser un menu espero)
	
	GameScene no deberia extender de Vbox sino de Scene <------
 */
public abstract class GameMenu extends StackPane implements ViewConstants{
	VBox list;
	

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
