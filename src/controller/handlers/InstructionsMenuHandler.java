package controller.handlers;

import controller.GameStateManager;
import controller.states.State;
import view.InstructionsMenuScene;

public class InstructionsMenuHandler extends Handler{

    private InstructionsMenuScene scene;

    public InstructionsMenuHandler(GameStateManager gsm, State state) {
        super(gsm, state);
        scene = (InstructionsMenuScene) state.getScene();
    }

    @Override
    public void handle(long now) {
        if(scene.isBackPressed()){
            gsm.pop();
        }
    }
}
