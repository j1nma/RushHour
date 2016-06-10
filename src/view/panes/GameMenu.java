package view.panes;

import javafx.geometry.Pos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import view.ViewConstants;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
	Cambiarlo para que sea abstracta y que todas las escenas del juego dependan de una sola clase.
	Esto es bastante primitivo(En el futuro no todo va a ser un menu espero)
	
	GameScene no deberia extender de Vbox sino de Scene <------
 */
public abstract class GameMenu extends VBox implements ViewConstants{

	public GameMenu(Node... children) {
		super(NODE_SEPARATION, children);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(BACKGROUND_SIZE);
		this.setPrefHeight(BACKGROUND_SIZE);

		Image img = new Image("http://www.arisoftecuador.com/blog/wp-content/uploads/preguntas-test-examen-teorico.png");

		ImageView menuImage = new ImageView(img);
		menuImage.setEffect(new GaussianBlur(GAUSSIAN_BLUR));

		this.getChildren().add(menuImage);
	}
}
