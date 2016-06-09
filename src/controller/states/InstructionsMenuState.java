package controller.states;

import controller.GameStateManager;
import controller.handlers.InstructionsMenuHandler;
import view.InstructionsMenuScene;

public class InstructionsMenuState extends State{
    public InstructionsMenuState(GameStateManager gsm) {
        super(gsm);
        scene = new InstructionsMenuScene();
        handler = new InstructionsMenuHandler(gsm,this);
    }
}
