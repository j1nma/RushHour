package view.panes;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.Board;
import view.BoardView;
import view.MenuButton;
import java.util.HashSet;
import java.util.Set;

public class GamePane extends BorderPane{
    private BoardView boardView;
    private MenuButton backButton;
    private Set<String> input;

    public GamePane(Board board){
        backButton = new MenuButton("Back");
        boardView = new BoardView(board);
        this.setCenter(boardView.getGrid());
        this.setTop(backButton);

        input = new HashSet<String>();

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                String code = e.getCode().toString();
                input.add(code);
            }
        });

        this.setOnKeyReleased(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent e){
                String code = e.getCode().toString();
                input.remove(code);
            }
        });
    }

    public boolean isBackPressed(){
        return backButton.isPressed();
    }

    public boolean isKeyPressed(String key){
        return input.contains(key);
    }

    public void refresh(){
        boardView.refresh();
    }
}
