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

//        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            public void handle(KeyEvent e) {
//                String code = e.getCode().toString();
//                input.add(code);
//            }
//        });
//
//        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
//            public void handle(KeyEvent e){
//                String code = e.getCode().toString();
//                input.remove(code);
//            }
//        });
        System.out.println("WEA CARGADA");
    }

    public boolean keyIsPressed(String key){
        return input.contains(key);
    }

}
