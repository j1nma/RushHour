package controller.states;

import controller.handlers.PlayMenuHandler;
import controller.GameStateManager;
import view.PlayMenuScene;

public class PlayMenuState extends State{

    public PlayMenuState(GameStateManager gsm){
        super(gsm);
        scene = new PlayMenuScene();
        handler = new PlayMenuHandler(gsm, this);
    }
}
