package view;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

/**
	Cambiarlo para que sea abstracta y que todas las escenas del juego dependan de una sola clase.
	Esto es bastante primitivo(En el futuro no todo va a ser un menu espero)
	
	GameScene no deberia extender de Vbox sino de Scene <------
 */
public abstract class GameScene extends VBox implements ViewConstants {

	public GameScene(Node... children) {
		super(NODE_SEPARATION, children);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(BACKGROUND_SIZE);
		this.setPrefHeight(BACKGROUND_SIZE);

	}
}
