package view.panes;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;

public class TestPane extends Pane {

    private Set<String> input;

    public TestPane(){

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

    public boolean keyIsPressed(String key){
        return input.contains(key);
    }

}
