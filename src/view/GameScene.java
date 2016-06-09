package view;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
/*
	Cambiarlo para que sea abstracta y que todas las escenas del juego dependan de una sola clase.
	Esto es bastante primitivo(En el futuro no todo va a ser un menu espero)
 */
public class GameScene extends VBox {

	public GameScene(Node... children) {
		super(10, children);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(280);
		this.setPrefHeight(280);
	}
}
