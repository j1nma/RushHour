package controller.states;

import controller.handlers.MainMenuHandler;
import controller.GameStateManager;
import view.MainMenuScene;

public class MainMenuState extends State{

    public MainMenuState(GameStateManager gsm) {
        super(gsm);
        scene = new MainMenuScene();
        handler = new MainMenuHandler(gsm,this);
    }
}
