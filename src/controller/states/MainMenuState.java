package controller.states;

import controller.handlers.MainMenuHandler;
import controller.GameStateManager;
import view.panes.MainMenuPane;

public class MainMenuState extends State{

    public MainMenuState(GameStateManager gsm) {
        super(gsm);
        pane = new MainMenuPane();
        handler = new MainMenuHandler(gsm,this);
    }

    public void entered(){
        super.entered();
    }
}
