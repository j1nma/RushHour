
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * Menu creates a vertical box of commands or options.
 * @author JuanmaAlonso
 *
 */
public class Menu {
	private VBox menu;

	//TODO 280 ES MAGIC NUMBER??
	public Menu() {
		this.menu = new VBox(10);
		this.menu.setAlignment(Pos.CENTER);
		this.menu.setPrefWidth(280);
		this.menu.setPrefHeight(280);
	}

	public VBox getMenu() {
		return menu;
	}
}
