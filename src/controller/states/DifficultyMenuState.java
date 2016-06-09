package controller.states;

import controller.GameStateManager;
import controller.handlers.DifficultyMenuHandler;
import view.DifficultyMenuScene;

public class DifficultyMenuState extends State{

    public DifficultyMenuState(GameStateManager gsm) {
        super(gsm);
        scene = new DifficultyMenuScene();
        handler = new DifficultyMenuHandler(gsm, this);
    }
}
