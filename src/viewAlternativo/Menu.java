import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.Node;

/**
 * Menu creates a vertical box of commands or options.
 * @author JuanmaAlonso
 *
 */
public class Menu extends VBox{
	public Menu(Node... children) {
		super(10, children);
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(280);
		this.setPrefHeight(280);
	}
}
