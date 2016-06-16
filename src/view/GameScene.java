package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {

    private Pane root;

    public GameScene(Pane root) {
        super(root);
        this.root = root;
    }

    public Pane getPane() {
        return root;
    }
}
